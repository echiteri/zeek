/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.namibia.tasks;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

import java.util.List;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.namibia.api.NamibiaPMTCTService;
import org.openmrs.scheduler.tasks.AbstractTask;

/**
 * Implementation of a task that writes "Hello World" to a log file.
 * 
 */
public class AutoCreateNewPTrackerID extends AbstractTask {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * Public constructor.
	 */
	public AutoCreateNewPTrackerID() {
		log.debug("Auto Create New PTracker ID created at " + new Date());
	}
	
	public void execute() {
		try {
			log.info("Running task to Auto Create New PTracker ID for new pregnancies");

			String queryString = String.format("SELECT o.encounter.patient.patientId, o.valueText FROM Obs o " +
					"WHERE o.concept.conceptId = 164951 " +
					"AND o.concept.conceptId = (SELECT MAX(oo.concept.conceptId) FROM Obs oo WHERE oo.concept.conceptId = 164951) " +
					"AND DATE(o.dateCreated) = CURDATE()" +
					"AND o.voided = 0");
			Query query = getSession().createQuery(queryString);
			log.info("Attempting to Create " + query.getFetchSize() + " new pregnancy PTracker IDs ");
			List idList = query.list();
			Iterator results = idList.iterator();
			NamibiaPMTCTService namibiaPMTCTService = Context.getService(NamibiaPMTCTService.class);
			while(results.hasNext()){
				Object o[] = (Object[])results.next();
				namibiaPMTCTService.createNewPregnancyPTrackerID((Integer)o[0]/*Patient ID*/, (String)o[1]/* PTracker ID*/);
			}

		} catch (Exception e) {
			log.error("error executing AutoCreateNewPTrackerID : " + e.toString() + getStackTrace(e));
		}
	}

	/**
	 * A Session instance used by sub-classes
	 * @return
	 */
	public Session getSession() {
		return Context.getRegisteredComponent("sessionFactory", SessionFactory.class).getCurrentSession();
	}
	
	public void shutdown() {
		log.debug("shutting down Auto Create New PTracker ID task");
		this.stopExecuting();
	}
}
