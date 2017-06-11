package org.openmrs.module.namibia.metadata;

import org.openmrs.module.metadatadeploy.descriptor.PersonAttributeTypeDescriptor;

/**
 * Person attribute type definitions
 *
 */
public class PersonAttributeTypes {
	
	public static PersonAttributeTypeDescriptor MOTHER_MAIDEN_NAME = new PersonAttributeTypeDescriptor() {
		@Override
		public double sortWeight() {
			return 0;
		}
		
		@Override
		public String name() {
			return "Mother's maiden name";
		}
		
		@Override
		public String description() {
			return "Maiden name of the mother used in building the Pregnancy ID";
		}
		
		public String uuid() {
			return "8d871f2a-c2cc-11de-8d13-0010c6dffd0f";
		}
		
		@Override
		public boolean searchable() {return true;}
	};
	
	public static PersonAttributeTypeDescriptor PLACE_OF_BIRTH = new PersonAttributeTypeDescriptor() {
		@Override
		public double sortWeight() {
			return 5;
		}
		
		@Override
		public String name() {
			return "Place of birth";
		}
		
		@Override
		public String description() {
			return "Place where the person was born used in building the Pregnancy ID";
		}
		
		public String uuid() {
			return "b01e7d1c-bb4e-4347-9142-5401a8658d96";
		}
		
		@Override
		public boolean searchable() {return true;}
	};
	
	public static PersonAttributeTypeDescriptor PREGNANCY_COUNT = new PersonAttributeTypeDescriptor() {
		@Override
		public double sortWeight() {
			return 10;
		}
		
		@Override
		public Class<?> format() {return Integer.class; }
		
		@Override
		public String name() {
			return "Number of pregnancies";
		}
		
		@Override
		public String description() {
			return "Number of pregnancies which is used in building the Pregnancy ID";
		}
		
		public String uuid() {
			return "782fa156-be08-4fa1-afac-16719afad516";
		}
	};

	public static PersonAttributeTypeDescriptor NAME_OF_NEXT_OF_KIN = new PersonAttributeTypeDescriptor() {
		@Override
		public double sortWeight() {
			return 15;
		}

		@Override
		public String name() {
			return "Name of Next of Kin";
		}

		@Override
		public String description() {
			return "The name of the client's next of kin";
		}

		public String uuid() {
			return "dc0cf7a8-dede-4c3d-9db4-730900aedd1a";
		}
	};

	public static PersonAttributeTypeDescriptor NEXT_OF_KIN_CONTACT_NO = new PersonAttributeTypeDescriptor() {
		@Override
		public double sortWeight() {
			return 20;
		}

		@Override
		public Class<?> format() {return String.class; }

		@Override
		public String name() {
			return "Next of Kin Contact No";
		}

		@Override
		public String description() {
			return "The name of the client's next of kin";
		}

		public String uuid() {
			return "d135bf7c-6ddd-4636-be22-fbd334a8f134";
		}
	};
}
