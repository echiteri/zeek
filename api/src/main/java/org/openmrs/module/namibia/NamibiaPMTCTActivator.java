/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.namibia;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.GlobalProperty;
import org.openmrs.api.AdministrationService;
import org.openmrs.api.context.Context;
import org.openmrs.module.Module;
import org.openmrs.module.ModuleActivator;
import org.openmrs.module.ModuleFactory;
import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.module.namibia.activator.AppConfigurationInitializer;
import org.openmrs.module.namibia.activator.HtmlFormsInitializer;
import org.openmrs.module.namibia.activator.Initializer;
import org.openmrs.module.namibia.activator.MetadataInitializer;

/**
 * This class contains the logic that is run every time this module is either started or stopped.
 */
public class NamibiaPMTCTActivator implements ModuleActivator {
	
	protected Log log = LogFactory.getLog(getClass());
	
	/**
	 * @see ModuleActivator#willRefreshContext()
	 */
	public void willRefreshContext() {
		log.info("Refreshing Namibia PMTCT Module");
	}
	
	/**
	 * @see ModuleActivator#contextRefreshed()
	 */
	public void contextRefreshed() {
		log.info("Namibia PMTCT Module refreshed");
	}
	
	/**
	 * @see ModuleActivator#willStart()
	 */
	public void willStart() {
		log.info("Starting Namibia PMTCT Module");
	}
	
	/**
	 * @see ModuleActivator#started()
	 */
	public void started() {
		
		log.info("Namibia module started - initializing...");
		
		try {
			// initializers
			for (Initializer initializer : getInitializers()) {
				initializer.started();
			}
			
		}
		catch (Exception e) {
			Module mod = ModuleFactory.getModuleById(NamibiaConstants.MODULE_ID);
			ModuleFactory.stopModule(mod);
			throw new RuntimeException("failed to setup the module ", e);
		}
		
		log.info("Namibia PMTCT Module started");
	}
	
	
	
	public List<Initializer> getInitializers() {
		List<Initializer> l = new ArrayList<Initializer>();
		l.add(new MetadataInitializer());
		l.add(new AppConfigurationInitializer());
		l.add(new HtmlFormsInitializer());
		return l;
	}
	
	/**
	 * @see ModuleActivator#willStop()
	 */
	public void willStop() {
		log.info("Stopping Namibia PMTCT Module");
	}
	
	/**
	 * @see ModuleActivator#stopped()
	 */
	public void stopped() {
		log.info("Namibia PMTCT Module stopped");
	}
	
}
