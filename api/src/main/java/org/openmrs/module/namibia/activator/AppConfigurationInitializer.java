package org.openmrs.module.namibia.activator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.GlobalProperty;
import org.openmrs.PatientIdentifierType;
import org.openmrs.api.AdministrationService;
import org.openmrs.api.context.Context;
import org.openmrs.module.Module;
import org.openmrs.module.ModuleFactory;
import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.module.emrapi.EmrApiConstants;
import org.openmrs.module.metadatamapping.MetadataTermMapping;
import org.openmrs.module.metadatamapping.api.MetadataMappingService;
import org.openmrs.module.namibia.NamibiaConstants;
import org.openmrs.module.namibia.metadata.PatientIdentifierTypes;
import org.openmrs.module.registrationcore.RegistrationCoreConstants;
import org.openmrs.scheduler.SchedulerService;
import org.openmrs.scheduler.TaskDefinition;

/**
 * Custom application configurations
 */
public class AppConfigurationInitializer implements Initializer {
	
	protected Log log = LogFactory.getLog(getClass());
	
	@Override
	public void started() {
		log.info("Setting administrative configurations for " + NamibiaConstants.MODULE_ID);
		
		AdministrationService administrationService = Context.getAdministrationService();
		AppFrameworkService appFrameworkService = Context.getService(AppFrameworkService.class);
		SchedulerService schedulerService = Context.getSchedulerService();
		
		try {
			// disable elements not needed on the home screen
			appFrameworkService.disableApp("coreapps.activeVisits");
			// disable the reference app registration page and add one for Namibia
			appFrameworkService.disableApp("referenceapplication.registrationapp.registerPatient");
			// no vitals will be collected in PTracker at the start
			appFrameworkService.disableApp("referenceapplication.vitals");
			
			// disable form entry app on the home page
			appFrameworkService.disableApp("xforms.formentry");
			// disable form entry extension in active visits
			appFrameworkService.disableExtension("xforms.formentry.cfpd");
			// Sticky Note
			appFrameworkService.disableExtension("org.openmrs.module.coreapps.patientHeader.secondLineFragments.stickyNote");
			// disable the default find patient app to provide one which allows searching for patients at the footer of the search for patients page
			appFrameworkService.disableApp("coreapps.findPatient");
			
			// disable apps on the Clinican facing dashboard
			appFrameworkService.disableApp("coreapps.mostRecentVitals");
			appFrameworkService.disableApp("coreapps.diagnoses");
			appFrameworkService.disableApp("coreapps.latestObsForConceptList");
			appFrameworkService.disableApp("coreapps.obsAcrossEncounters");
			appFrameworkService.disableApp("coreapps.obsGraph");
			appFrameworkService.disableApp("coreapps.visitByEncounterType");
			appFrameworkService.disableApp("coreapps.visits");

			// set defined global properties
			administrationService.saveGlobalProperties(configureGlobalProperties());
			
			// start the Auto Close Visits task
			TaskDefinition autoCloseVisitsTask = (TaskDefinition) schedulerService.getTaskByName("Auto Close Visits Task");
			if (autoCloseVisitsTask != null) {
				autoCloseVisitsTask.setStartOnStartup(true);
				schedulerService.saveTaskDefinition(autoCloseVisitsTask);
			}
		}
		catch (Exception e) {
			Module mod = ModuleFactory.getModuleById(NamibiaConstants.MODULE_ID);
			ModuleFactory.stopModule(mod);
			throw new RuntimeException("failed to setup the module configuration ", e);
		}
		
	}
	
	@Override
	public void stopped() {
		
	}
	
	/**
	 * Configure the global properties for the expected functionality
	 *
	 * @return
	 */
	private List<GlobalProperty> configureGlobalProperties() {
		List<GlobalProperty> properties = new ArrayList<GlobalProperty>();
		
		// disable the appointmentshedulingui which is needed but not very usable at this point
		properties.add(new GlobalProperty("appointmentschedulingui.started", "false"));
		
		// set the name of the application
		properties.add(new GlobalProperty("application.name", "Namibia PTracker"));
		
		// mapping for creating visits without encounters to the default facility visit type
		properties.add(new GlobalProperty("emrapi.EmrApiVisitAssignmentHandler.encounterTypeToNewVisitTypeMap", "default:7b0f5697-27e3-40c4-8bae-f4049abfb4ed"));
		
		// Remove validation for names
		properties.add(new GlobalProperty("patient.nameValidationRegex", ""));
		
		// the search mode for patients to enable searching any part of names rather than the beginning
		properties.add(new GlobalProperty("patientSearch.matchMode", "ANYWHERE"));
		
		// enable searching on parts of the patient identifier
		// the prefix and suffix provide a % round the entered search term with a like
		properties.add(new GlobalProperty("patient.identifierPrefix", "%"));
		properties.add(new GlobalProperty("patient.identifierSuffix", "%"));
		
		// the RegeX and Search patterns should be empty so that the prefix and suffix matching above can work
		properties.add(new GlobalProperty("patient.identifierRegex", ""));
		properties.add(new GlobalProperty("patient.identifierSearchPattern", ""));
		
		// attributes being displayed on the search widget
		properties.add(new GlobalProperty("patient.listingAttributeTypes", "Telephone Number"));
		
		// do not allow overlapping visits
		properties.add(new GlobalProperty("visits.allowOverlappingVisits", "false"));
		
		// Set estimated dates of birth at registration to be computed from July
		properties.add(new GlobalProperty(RegistrationCoreConstants.GP_BIRTHDATE_ESTIMATION_START_MONTH, "6"));
		
		//HTML Form Entry Settings
		properties.add(new GlobalProperty("htmlformentry.showDateFormat", "false")); //Disable date format display on form
		
		// The OpenMRS ID with a check digit
		MetadataMappingService metadataMappingService = Context.getService(MetadataMappingService.class);
		MetadataTermMapping primaryIdentifierTypeMapping = metadataMappingService.getMetadataTermMapping(EmrApiConstants.EMR_METADATA_SOURCE_NAME, EmrApiConstants.PRIMARY_IDENTIFIER_TYPE);
		PatientIdentifierType ptrackerId = Context.getPatientService().getPatientIdentifierTypeByUuid(PatientIdentifierTypes.PTRACKER_NUMBER.uuid());
		
		//overwrite if not set yet or if null
		if(ptrackerId != null & primaryIdentifierTypeMapping != null){
			if (!ptrackerId.getUuid().equals(primaryIdentifierTypeMapping.getMetadataUuid())) {
				primaryIdentifierTypeMapping.setMappedObject(ptrackerId);
				metadataMappingService.saveMetadataTermMapping(primaryIdentifierTypeMapping);
			}
		}
		
		// primary
		properties.add(new GlobalProperty(EmrApiConstants.PRIMARY_IDENTIFIER_TYPE, PatientIdentifierTypes.PTRACKER_NUMBER.uuid() ));
		// other identifiers that can be used
		properties.add(new GlobalProperty(EmrApiConstants.GP_EXTRA_PATIENT_IDENTIFIER_TYPES, PatientIdentifierTypes.ART_UNIQUE_NUMBER.uuid() ));
		
		// disable the appointmentshedulingui which will confuse users
		properties.add(new GlobalProperty("appointmentschedulingui.started", "false"));
		
		return properties;
	}
}
