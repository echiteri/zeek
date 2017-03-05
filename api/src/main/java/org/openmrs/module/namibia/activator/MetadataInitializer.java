package org.openmrs.module.namibia.activator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.Module;
import org.openmrs.module.ModuleFactory;
import org.openmrs.module.emrapi.utils.MetadataUtil;
import org.openmrs.module.metadatadeploy.api.MetadataDeployService;
import org.openmrs.module.namibia.NamibiaConstants;
import org.openmrs.module.namibia.deploy.bundle.LocationMetadataBundle;
import org.openmrs.module.namibia.deploy.bundle.LocationTagMetadataBundle;
import org.openmrs.module.namibia.deploy.bundle.NamibiaAddressBundle;
import org.openmrs.module.namibia.deploy.bundle.NamibiaPatientIdentifierTypeBundle;
import org.openmrs.module.namibia.deploy.bundle.NamibiaPersonAttributeTypeBundle;

/**
 * Initializer for metadata
 */
public class MetadataInitializer implements Initializer {
	
	protected static final Log log = LogFactory.getLog(MetadataInitializer.class);
	
	public void started() {
		MetadataDeployService deployService = Context.getService(MetadataDeployService.class);
		
		try {
			log.info("Installing patient identifiers");
			deployService.installBundle(Context.getRegisteredComponents(NamibiaPatientIdentifierTypeBundle.class).get(0));
			log.info("Patient identifiers installed");
			
			log.info("Installing person attribute types");
			deployService.installBundle(Context.getRegisteredComponents(NamibiaPersonAttributeTypeBundle.class).get(0));
			log.info("Person attribute types installed");
			
			// install Metadata sharing paclages
			log.info("Installing standard metadata using the packages.xml file");
			MetadataUtil.setupStandardMetadata(getClass().getClassLoader());
			log.info("Standard metadata installed");
			
			// install locations
			log.info("installing tags");
			deployService.installBundle(Context.getRegisteredComponents(LocationTagMetadataBundle.class).get(0));
			log.info("location tags installed");
			
			// install locations
			log.info("installing locations");
			deployService.installBundle(Context.getRegisteredComponents(LocationMetadataBundle.class).get(0));
			log.info("locations installed");
			
			// install address hierarchy
			log.info("installing address hierarchy");
			deployService.installBundle(Context.getRegisteredComponents(NamibiaAddressBundle.class).get(0));
			log.info("Address hierarchy installed");
			
		}
		catch (Exception e) {
			Module mod = ModuleFactory.getModuleById(NamibiaConstants.MODULE_ID);
			ModuleFactory.stopModule(mod);
			throw new RuntimeException("failed to install metadata ", e);
		}
		
	}
	
	public void stopped() {
		
	}
}
