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
import org.openmrs.module.emrapi.EmrApiConstants;
import org.openmrs.module.namibia.NamibiaConstants;
import org.openmrs.module.namibia.metadata.NamibiaPatientIdentifierTypes;

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
			
			// disable form entry app on the home page
			appFrameworkService.disableApp("xforms.formentry");
			// disable form entry extension in active visits
			appFrameworkService.disableExtension("xforms.formentry.cfpd");
			
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
		
		// Remove validation for names
		properties.add(new GlobalProperty("patient.nameValidationRegex", ""));
		
		// the search mode for patients to enable searching any part of names rather than the beginning
		properties.add(new GlobalProperty("patientSearch.matchMode", "ANYWHERE"));
		
		// enable searching on parts of the patient identifier
		// the prefix and suffix provide a % round the entered search term with a like
		properties.add(new GlobalProperty("patient.identifierPrefix", "%"));
		properties.add(new GlobalProperty("patient.identifierSuffix", "%"));
		
		// the RegeX and Search patterns should be empty so that the prefix and suffix matching above can work
		properties.add(new GlobalProperty("patient.identifierRegex", ""));
		properties.add(new GlobalProperty("patient.identifierSearchPattern", ""));
		
		// do not allow overlapping visits
		properties.add(new GlobalProperty("visits.allowOverlappingVisits", "false"));
		
		//HTML Form Entry Settings
		properties.add(new GlobalProperty("htmlformentry.showDateFormat", "false")); //Disable date format display on form
		
		// The ART unique as the primary identifier that needs to be displayed
		properties.add(new GlobalProperty(EmrApiConstants.PRIMARY_IDENTIFIER_TYPE, NamibiaPatientIdentifierTypes.ART_UNIQUE_NUMBER.uuid()));
		
		// other identifiers that can be used
		properties.add(new GlobalProperty(EmrApiConstants.GP_EXTRA_PATIENT_IDENTIFIER_TYPES, NamibiaPatientIdentifierTypes
				.NATIONAL_ID.uuid()));
		
		// disable the appointmentshedulingui which will confuse users
		properties.add(new GlobalProperty("appointmentschedulingui.started", "false"));
		
		return properties;
	}
}
