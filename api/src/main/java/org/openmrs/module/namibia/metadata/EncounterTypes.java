package org.openmrs.module.namibia.metadata;

import org.openmrs.module.metadatadeploy.descriptor.EncounterTypeDescriptor;

/**
 * Definitions for Encounter Types
 */
public class EncounterTypes {
	public static EncounterTypeDescriptor ANC_ENCOUNTER_TYPE = new EncounterTypeDescriptor() {
		@Override
		public String name() {
			return "Antenatal";
		}
		
		@Override
		public String description() {
			return "ANC visit by a mother";
		}
		
		public String uuid() {
			return "2549af50-75c8-4aeb-87ca-4bb2cef6c69a";
		}
	};
	
	public static EncounterTypeDescriptor LABOR_AND_DELIVERY_ENCOUNTER_TYPE = new EncounterTypeDescriptor() {
		@Override
		public String name() {
			return "Labor and Delivery";
		}
		
		@Override
		public String description() {
			return "Labor and delivery visit by a mother";
		}
		
		public String uuid() {
			return "2678423c-0523-4d76-b0da-18177b439eed";
		}
	};
	
	public static EncounterTypeDescriptor MOTHER_PNC_ENCOUNTER_TYPE = new EncounterTypeDescriptor() {
		@Override
		public String name() {
			return "Mother Postnatal";
		}
		
		@Override
		public String description() {
			return "Post natal visit by a mother";
		}
		
		public String uuid() {
			return "269bcc7f-04f8-4ddc-883d-7a3a0d569aad";
		}
	};
	
	public static EncounterTypeDescriptor INFANT_PNC_ENCOUNTER_TYPE = new EncounterTypeDescriptor() {
		@Override
		public String name() {
			return "Infant Postnatal";
		}
		
		@Override
		public String description() {
			return "PNC visit by infant after birth";
		}
		
		public String uuid() {
			return "af1f1b24-d2e8-4282-b308-0bf79b365584";
		}
	};
}
