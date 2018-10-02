/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.namibia.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.namibia.api.NamibiaPMTCTService;
import org.openmrs.module.namibia.api.db.NamibiaPMTCTDAO;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.Person;

/**
 * It is a default implementation of {@link NamibiaPMTCTService}.
 */
public class NamibiaPMTCTServiceImpl extends BaseOpenmrsService implements NamibiaPMTCTService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private NamibiaPMTCTDAO dao;
	
	/**
	 * @return the dao
	 */
	public NamibiaPMTCTDAO getDao() {
		return dao;
	}
	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(NamibiaPMTCTDAO dao) {
		this.dao = dao;
	}

	public void createNewPregnancyPTrackerID (Integer patient_id, String ptracker_id) {
		log.debug("Creating a new pregnancy PTracker ID " + patient_id + " for patient ID " + ptracker_id);
		// find the mother by identifier
		/*List<Patient> mothers = patientService.getPatients(null, // name of the person
				motherARTNumber, //mother ART number
				Arrays.asList(Context.getPatientService().getPatientIdentifierTypeByUuid(
						PatientIdentifierTypes.HIV_CARE_NUMBER.uuid())), // ART Number Identifier type
				true); // match Identifier exactly
		if (mothers.size() != 0) {
			Person potentialMother = mothers.get(0).getPerson();
			// mothers have to be female and above 12 years of age
			if (potentialMother.getAge() > 12 & potentialMother.getGender().equals("F")) {
				Relationship relationship = new Relationship();
				relationship.setRelationshipType(
						personService.getRelationshipTypeByUuid("8d91a210-c2cc-11de-8d13-0010c6dffd0f"));
				relationship.setPersonA(potentialMother);
				relationship.setPersonB(infant);
				personService.saveRelationship(relationship);
				log.debug("Infant with ID " + infant.getPersonId() + " linked to mother with ID " + potentialMother.getPersonId());
			}
		}*/
	}
}