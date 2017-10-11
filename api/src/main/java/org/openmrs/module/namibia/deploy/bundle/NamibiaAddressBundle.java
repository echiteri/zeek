package org.openmrs.module.namibia.deploy.bundle;

import java.util.ArrayList;
import java.util.List;

import org.openmrs.module.addresshierarchy.AddressField;
import org.springframework.stereotype.Component;

/**
 * Installs the Namibia address hierarchy
 */
@Component
public class NamibiaAddressBundle extends AddressBundle {
	
	@Override
	public List<AddressComponent> getAddressComponents() {
		List<AddressComponent> l = new ArrayList<AddressComponent>();
		l.add(new AddressComponent(AddressField.COUNTRY, "Country", 10, "Namibia", true));
		l.add(new AddressComponent(AddressField.COUNTY_DISTRICT, "District", 20, null, true));
		l.add(new AddressComponent(AddressField.ADDRESS_1, "Location", 255, null, false));
		l.add(new AddressComponent(AddressField.ADDRESS_2, "Address", 255, null, false));
		
		return l;
	}
	
	@Override
	public List<String> getLineByLineFormat() {
		List<String> l = new ArrayList<String>();
		l.add("country");
		l.add("countyDistrict"); // District
		l.add("address1"); // Town
		l.add("address2"); // House Address
		return l;
	}
	
	@Override
	public String getAddressHierarchyEntryPath() {
		return "metadata/address_hierarchy_" + getVersion() + ".csv";
	}
	
	@Override
	public int getVersion() {
		return 3;
	}
}
