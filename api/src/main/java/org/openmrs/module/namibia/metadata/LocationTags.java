package org.openmrs.module.namibia.metadata;

import org.openmrs.module.metadatadeploy.descriptor.LocationTagDescriptor;

/**
 * Location tags
 */
public class LocationTags {
	
	public static LocationTagDescriptor DELIVERY_LOCATION_TAG = new LocationTagDescriptor() {
		
		@Override
		public String name() {
			return "Delivery Location";
		}
		
		@Override
		public String description() {
			return "A location that provides maternity services";
		}
		
		@Override
		public String uuid() {
			return "c9a8fa19-5001-4e17-9917-fb855e877fa8";
		}
	};
}
