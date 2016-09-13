package org.openmrs.module.namibia.deploy.bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Location;
import org.openmrs.module.metadatadeploy.bundle.CoreConstructors;
import org.openmrs.module.metadatadeploy.source.AbstractCsvResourceSource;

/**
 * Loads locations from a CSV source
 */
public class LocationCSVSource extends AbstractCsvResourceSource<Location> {
	
	protected static final Log log = LogFactory.getLog(LocationCSVSource.class);
	
	public LocationCSVSource(String csvFile) throws IOException {
		super(csvFile, false);
	}
	
	@Override
	protected Location parseLine(String[] line) throws Exception {
		log.debug("processing location row " + Arrays.toString(line));
		Collection<String> locationTags = new ArrayList<String>();
		if (line[3] != null) {
			locationTags = Arrays.asList(line[3].split(","));
		}
		Location location = CoreConstructors.location(line[0], line[0], line[1], line[2], locationTags);
		return location;
	}
}
