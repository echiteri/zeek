package org.openmrs.module.namibia.deploy.bundle;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.namibia.metadata.PatientIdentifierTypes;
import org.springframework.stereotype.Component;

/**
 * Bundle installation for Patient Identifier Types
 */
@Component
public class NamibiaPatientIdentifierTypeBundle extends AbstractMetadataBundle {
	
	@Override
	public void install() throws Exception {
		
		log.info("Installing PatientIdentifierTypes");
		
		install(PatientIdentifierTypes.ART_UNIQUE_NUMBER);
		install(PatientIdentifierTypes.PTRACKER_NUMBER);
		install(PatientIdentifierTypes.PREGNANCY_NUMBER);
		
		log.info("PatientIdentifierTypes installed");
	}
	
}
