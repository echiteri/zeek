package org.openmrs.module.namibia.deploy.bundle;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.namibia.metadata.PersonAttributeTypes;
import org.springframework.stereotype.Component;

/**
 * Bundle installation for Person Attribute Types
 */
@Component
public class NamibiaPersonAttributeTypeBundle extends AbstractMetadataBundle {
	
	@Override
	public void install() throws Exception {
		
		log.info("Installing PersonAttributeTypes");
		
		install(PersonAttributeTypes.MOTHER_MAIDEN_NAME);
		install(PersonAttributeTypes.PLACE_OF_BIRTH);
		install(PersonAttributeTypes.PREGNANCY_COUNT);
		
		log.info("PersonAttributeTypes installed");
	}
	
}