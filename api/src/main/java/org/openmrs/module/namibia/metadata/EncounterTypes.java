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

	public static EncounterTypeDescriptor VIRAL_LOAD_TEST_ENCOUNTER_TYPE = new EncounterTypeDescriptor() {
		@Override
		public String name() {
			return "Viral Load Test";
		}

		@Override
		public String description() {
			return "Viral load test done by NIP";
		}

		public String uuid() {
			return "9b392edc-074f-439c-9660-f468978069a2";
		}
	};

	public static EncounterTypeDescriptor EARLY_INFANT_DIAGNOSIS_TEST_ENCOUNTER_TYPE = new EncounterTypeDescriptor() {
		@Override
		public String name() {
			return "EID Test";
		}

		@Override
		public String description() {
			return "EID PCR Test by NIP";
		}

		public String uuid() {
			return "604a061a-d753-4114-a62f-30d8ca86f6d9";
		}
	};
}
