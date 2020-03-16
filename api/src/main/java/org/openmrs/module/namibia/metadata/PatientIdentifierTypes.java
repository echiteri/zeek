package org.openmrs.module.namibia.metadata;

import org.openmrs.module.metadatadeploy.descriptor.PatientIdentifierTypeDescriptor;

/**
 * Definition of patient identifiers
 */
public class PatientIdentifierTypes {
	
	public static PatientIdentifierTypeDescriptor ART_UNIQUE_NUMBER = new PatientIdentifierTypeDescriptor() {
		
		@Override
		public String name() {
			return "ART Unique Number";
		}
		
		@Override
		public String description() {
			return "Unique ART number for patients on ART";
		}
		@Override
		public String format() {
			return "[0-9]{3}[0,1][0-9]{8}";
		}

		@Override
		public String formatDescription() {
			return "Should be 3 digits then digit 0 or 1 lastly 8 digits. E.g. (333033333333)";
		}

		@Override
		public String uuid() {
			return "9d6d1eec-2cd6-4637-a981-4a46b4b8b41f";
		}
	};
	
	public static PatientIdentifierTypeDescriptor PREGNANCY_NUMBER = new PatientIdentifierTypeDescriptor() {
		
		@Override
		public String name() {
			return "Pregnancy Number";
		}
		
		@Override
		public String description() {
			return "Pregnancy Number";
		}
		
		@Override
		public String uuid() {
			return "81c94480-d4d0-474a-b61f-69c910509fa9";
		}
	};
	
	public static PatientIdentifierTypeDescriptor PTRACKER_NUMBER = new PatientIdentifierTypeDescriptor() {
		
		@Override
		public String name() {
			return "PTracker Number";
		}
		
		@Override
		public String description() {
			return "PTracker Number";
		}
		
		@Override
		public String uuid() {
			return "4da0a3fe-e546-463f-81fa-084f098ff06c";
		}
	};
	
	public static PatientIdentifierTypeDescriptor PTRACKER_NUMBER_2 = new PatientIdentifierTypeDescriptor() {
		
		@Override
		public String name() {
			return "PTracker Number 2";
		}
		
		@Override
		public String description() {
			return "PTracker Number 2";
		}
		
		@Override
		public String uuid() {
			return "4da0a3fe-e546-463f-81fa-084f098ff06d";
		}
	};
	
	public static PatientIdentifierTypeDescriptor PTRACKER_NUMBER_3 = new PatientIdentifierTypeDescriptor() {
		
		@Override
		public String name() {
			return "PTracker Number 3";
		}
		
		@Override
		public String description() {
			return "PTracker Number 3";
		}
		
		@Override
		public String uuid() {
			return "4da0a3fe-e546-463f-81fa-084f098ff06e";
		}
	};
	
	public static PatientIdentifierTypeDescriptor PTRACKER_NUMBER_4 = new PatientIdentifierTypeDescriptor() {
		
		@Override
		public String name() {
			return "PTracker Number 4";
		}
		
		@Override
		public String description() {
			return "PTracker Number 4";
		}
		
		@Override
		public String uuid() {
			return "4da0a3fe-e546-463f-81fa-084f098ff06f";
		}
	};
	
	public static PatientIdentifierTypeDescriptor PTRACKER_NUMBER_5 = new PatientIdentifierTypeDescriptor() {
		
		@Override
		public String name() {
			return "PTracker Number 5";
		}
		
		@Override
		public String description() {
			return "PTracker Number 5";
		}
		
		@Override
		public String uuid() {
			return "4da0a3fe-e546-463f-81fa-084f098ff06g";
		}
	};
	
	public static PatientIdentifierTypeDescriptor PTRACKER_NUMBER_6 = new PatientIdentifierTypeDescriptor() {
		
		@Override
		public String name() {
			return "PTracker Number 6";
		}
		
		@Override
		public String description() {
			return "PTracker Number 6";
		}
		
		@Override
		public String uuid() {
			return "4da0a3fe-e546-463f-81fa-084f098ff06h";
		}
	};
	
	public static PatientIdentifierTypeDescriptor PTRACKER_NUMBER_7 = new PatientIdentifierTypeDescriptor() {
		
		@Override
		public String name() {
			return "PTracker Number 7";
		}
		
		@Override
		public String description() {
			return "PTracker Number 7";
		}
		
		@Override
		public String uuid() {
			return "4da0a3fe-e546-463f-81fa-084f098ff06i";
		}
	};
	
	public static PatientIdentifierTypeDescriptor PTRACKER_NUMBER_8 = new PatientIdentifierTypeDescriptor() {
		
		@Override
		public String name() {
			return "PTracker Number 8";
		}
		
		@Override
		public String description() {
			return "PTracker Number 8";
		}
		
		@Override
		public String uuid() {
			return "4da0a3fe-e546-463f-81fa-084f098ff06j";
		}
	};
	
	public static PatientIdentifierTypeDescriptor PTRACKER_NUMBER_9 = new PatientIdentifierTypeDescriptor() {
		
		@Override
		public String name() {
			return "PTracker Number 9";
		}
		
		@Override
		public String description() {
			return "PTracker Number 9";
		}
		
		@Override
		public String uuid() {
			return "4da0a3fe-e546-463f-81fa-084f098ff06k";
		}
	};
	
}
