package org.openmrs.module.namibia.page.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Override the Create and Find Patient functionality links on the legacy UI forwarding them to the new UI
 */
@Controller
public class UserManagementLegacyUIOverridePageController {
	protected final Log log = LogFactory.getLog(getClass());

	@RequestMapping({"admin/patients/index.htm", "/findPatient.htm"})
	public String overrideHomepage() {
		return "forward:/coreapps/findpatient/findPatient.page?app=coreapps.findPatient";
	}
}
