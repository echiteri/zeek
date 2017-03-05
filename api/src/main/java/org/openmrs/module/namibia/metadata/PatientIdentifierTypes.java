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
	
}
