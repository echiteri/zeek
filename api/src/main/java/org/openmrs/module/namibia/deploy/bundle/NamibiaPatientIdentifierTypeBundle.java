package org.openmrs.module.namibia.deploy.bundle;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.namibia.metadata.NamibiaPatientIdentifierTypes;
import org.springframework.stereotype.Component;

/**
 * Bundle installation for Patient Identifier Types
 */
@Component
public class NamibiaPatientIdentifierTypeBundle extends AbstractMetadataBundle {
	
	@Override
	public void install() throws Exception {
		
		log.info("Installing NamibiaPatientIdentifierTypes");
		
		install(NamibiaPatientIdentifierTypes.ART_UNIQUE_NUMBER);
		install(NamibiaPatientIdentifierTypes.CHILD_PMTCT_NUMBER);
		install(NamibiaPatientIdentifierTypes.EDT_ART_NUMBER);
		
		log.info("NamibiaPatientIdentifierTypes installed");
	}
	
}
