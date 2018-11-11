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
		install(PatientIdentifierTypes.PTRACKER_NUMBER_2);
		install(PatientIdentifierTypes.PTRACKER_NUMBER_3);
		install(PatientIdentifierTypes.PTRACKER_NUMBER_4);
		install(PatientIdentifierTypes.PTRACKER_NUMBER_5);
		install(PatientIdentifierTypes.PTRACKER_NUMBER_6);
		install(PatientIdentifierTypes.PTRACKER_NUMBER_7);
		install(PatientIdentifierTypes.PTRACKER_NUMBER_8);
		install(PatientIdentifierTypes.PTRACKER_NUMBER_9);
		install(PatientIdentifierTypes.PREGNANCY_NUMBER);
		
		log.info("PatientIdentifierTypes installed");
	}
	
}
