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

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.IdentifierType;
import org.openmrs.PatientIdentifierType;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.namibia.api.NamibiaPMTCTService;
import org.openmrs.module.namibia.api.db.NamibiaPMTCTDAO;
import org.openmrs.Patient;
import org.openmrs.api.PatientService;
import org.openmrs.PatientIdentifier;
import org.openmrs.Person;
import org.openmrs.api.PersonService;
import org.openmrs.api.context.Context;
import org.openmrs.module.namibia.api.NamibiaPMTCTService;
import org.openmrs.module.namibia.api.db.NamibiaPMTCTDAO;
import org.openmrs.module.namibia.metadata.PatientIdentifierTypes;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * It is a default implementation of {@link NamibiaPMTCTService}.
 */
public class NamibiaPMTCTServiceImpl extends BaseOpenmrsService implements NamibiaPMTCTService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private NamibiaPMTCTDAO dao;

	@Autowired
	private PatientService patientService;
	
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
		List<PatientIdentifierType> identifierTypes = patientService.getPatientIdentifierTypes(null, null, null, null);
		PatientIdentifier patientIdentifier = new PatientIdentifier();
		Patient patient = patientService.getPatient(patient_id);

		for (int i = 7  ; i < 14 ; i++) /* 8 new ptracker id types TODO: optimize the iteration to be durable instead of hardcoding */ {

			try {
				if (!patient.getIdentifiers().toString().contains(ptracker_id) && patient.getPatientIdentifier(identifierTypes.get(i-1)) == null) {
					log.debug("Creating a new pregnancy PTracker ID " + patient_id + " for patient ID " + ptracker_id);
					patientIdentifier.setIdentifier(ptracker_id); // identifier
					patientIdentifier.setIdentifierType(patientService.getPatientIdentifierTypeByUuid(identifierTypes.get(i-1).getUuid())); // OpenMRS ID with check digit
					patientIdentifier.setPreferred(false);
					patientIdentifier.setCreator(Context.getUserService().getUser(1));
					patientIdentifier.setDateCreated(new Date());
					patientIdentifier.setVoided(false);
					patientIdentifier.setUuid(UUID.randomUUID().toString());
					patient.addIdentifier(patientIdentifier);
					patientService.savePatient(patient);
					break;
				}
			} catch (NullPointerException e) {
				System.out.print("Caught NullPointerException");
			}
		}
	}
}