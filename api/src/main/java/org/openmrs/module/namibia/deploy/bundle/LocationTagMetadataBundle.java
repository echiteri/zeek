package org.openmrs.module.namibia.deploy.bundle;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.namibia.metadata.LocationTags;
import org.springframework.stereotype.Component;

/**
 * Deploys location tags
 */
@Component
public class LocationTagMetadataBundle extends AbstractMetadataBundle {
	
	@Override
	public void install() throws Exception {
		// location tags
		install(LocationTags.DELIVERY_LOCATION_TAG);
	}
}
