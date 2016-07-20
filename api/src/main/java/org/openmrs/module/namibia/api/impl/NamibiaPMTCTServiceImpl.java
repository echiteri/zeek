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

import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.namibia.api.NamibiaPMTCTService;
import org.openmrs.module.namibia.api.db.NamibiaPMTCTDAO;

/**
 * It is a default implementation of {@link NamibiaPMTCTService}.
 */
public class NamibiaPMTCTServiceImpl extends BaseOpenmrsService implements NamibiaPMTCTService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private NamibiaPMTCTDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(NamibiaPMTCTDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public NamibiaPMTCTDAO getDao() {
	    return dao;
    }
}