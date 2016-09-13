package org.openmrs.module.namibia.deploy.bundle;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.springframework.stereotype.Component;

/**
 * Deploys the locations from CSV source
 */
@Component
public class LocationMetadataBundle extends AbstractMetadataBundle {
	
	@Override
	public void install() throws Exception {
		install(new LocationCSVSource("metadata/health_locations_1.csv"));
	}
}
