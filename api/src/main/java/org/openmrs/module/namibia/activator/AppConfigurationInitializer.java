package org.openmrs.module.namibia.activator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.GlobalProperty;
import org.openmrs.api.AdministrationService;
import org.openmrs.api.context.Context;
import org.openmrs.module.Module;
import org.openmrs.module.ModuleFactory;
import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.module.namibia.NamibiaConstants;

/**
 * Custom application configurations
 */
public class AppConfigurationInitializer implements Initializer {
	
	protected Log log = LogFactory.getLog(getClass());
	
	@Override
	public void started() {
		log.info("Setting administrative configurations for " + NamibiaConstants.MODULE_ID);
		
		AdministrationService administrationService = Context.getAdministrationService();
		AppFrameworkService appFrameworkService = Context.getService(AppFrameworkService.class);
		
		try {
			// disable elements not needed on the home screen
			appFrameworkService.disableApp("coreapps.activeVisits");
			// disable the reference app registration page and add one for Namibia
			appFrameworkService.disableApp("referenceapplication.registrationapp.registerPatient");
			
			// set defined global properties
			administrationService.saveGlobalProperties(configureGlobalProperties());
		}
		catch (Exception e) {
			Module mod = ModuleFactory.getModuleById(NamibiaConstants.MODULE_ID);
			ModuleFactory.stopModule(mod);
			throw new RuntimeException("failed to setup the module configuration ", e);
		}
		
	}
	
	@Override
	public void stopped() {
		
	}
	
	/**
	 * Configure the global properties for the expected functionality
	 *
	 * @return
	 */
	private List<GlobalProperty> configureGlobalProperties() {
		List<GlobalProperty> properties = new ArrayList<GlobalProperty>();
		
		// disable the appointmentshedulingui which is needed but not very usable at this point
		properties.add(new GlobalProperty("appointmentschedulingui.started", "false"));
		
		// set the name of the application
		properties.add(new GlobalProperty("application.name", "Namibia PMTCT Tracker"));
		
		return properties;
	}
}
