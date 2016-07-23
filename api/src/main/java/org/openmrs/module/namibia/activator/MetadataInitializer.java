package org.openmrs.module.namibia.activator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.Module;
import org.openmrs.module.ModuleFactory;
import org.openmrs.module.emrapi.utils.MetadataUtil;
import org.openmrs.module.metadatadeploy.api.MetadataDeployService;
import org.openmrs.module.namibia.NamibiaConstants;

/**
 * Initializer for metadata
 */
public class MetadataInitializer implements Initializer {
	
	protected static final Log log = LogFactory.getLog(MetadataInitializer.class);
	
	public void started() {
		MetadataDeployService deployService = Context.getService(MetadataDeployService.class);
		
		try {
			// install concepts
			log.info("Installing standard metadata using the packages.xml file");
			MetadataUtil.setupStandardMetadata(getClass().getClassLoader());
			log.info("Standard metadata installed");
			
		}
		catch (Exception e) {
			Module mod = ModuleFactory.getModuleById(NamibiaConstants.MODULE_ID);
			ModuleFactory.stopModule(mod);
			throw new RuntimeException("failed to install the common metadata ", e);
		}
		
	}
	
	public void stopped() {
		
	}
}
