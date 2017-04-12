package org.openmrs.module.namibia.metadata;


import org.openmrs.module.metadatadeploy.descriptor.ProgramDescriptor;

/**
 * Metadata to setup programs
 *
 */

public class Programs {
	
	public static ProgramDescriptor MCH_PROGRAM = new ProgramDescriptor() {
		
		@Override
		public String conceptUuid() {
			return "159937AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String name() {
			return "MCH Program";
		}
		
		@Override
		public String description() {
			return "The program which deals with the health issues of mother and children.";
		}
		
		@Override
		public String uuid() {
			return "5e8c094c-0a36-11e7-b779-507b9dc4c741";
		}
	};
	
}
