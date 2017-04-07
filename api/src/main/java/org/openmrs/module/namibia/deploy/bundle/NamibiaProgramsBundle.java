package org.openmrs.module.namibia.deploy.bundle;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.namibia.metadata.Programs;
import org.springframework.stereotype.Component;

/**
 * Bundle installation for Programs
 */
@Component
public class NamibiaProgramsBundle extends AbstractMetadataBundle {
	
	@Override
	public void install() throws Exception {
		
		log.info("Installing Programs");
		
		install(Programs.MCH_PROGRAM);
		
		log.info("Programs installed");
	}
	
}
