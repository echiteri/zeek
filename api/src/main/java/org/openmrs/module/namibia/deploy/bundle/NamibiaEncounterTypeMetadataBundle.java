package org.openmrs.module.namibia.deploy.bundle;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.namibia.metadata.EncounterTypes;
import org.springframework.stereotype.Component;

/**
 * Deploys encounter types
 */
@Component
public class NamibiaEncounterTypeMetadataBundle extends AbstractMetadataBundle {
	
	@Override
	public void install() throws Exception {
		install(EncounterTypes.ANC_ENCOUNTER_TYPE);
		install(EncounterTypes.LABOR_AND_DELIVERY_ENCOUNTER_TYPE);
		install(EncounterTypes.MOTHER_PNC_ENCOUNTER_TYPE);
		install(EncounterTypes.INFANT_PNC_ENCOUNTER_TYPE);
		install(EncounterTypes.VIRAL_LOAD_TEST_ENCOUNTER_TYPE);
		install(EncounterTypes.EARLY_INFANT_DIAGNOSIS_TEST_ENCOUNTER_TYPE);
	}
}
