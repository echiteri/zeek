package org.openmrs.module.namibia.htmlformentry;

import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.PatientProgram;
import org.openmrs.Program;
import org.openmrs.api.ProgramWorkflowService;
import org.openmrs.api.context.Context;
import org.openmrs.module.htmlformentry.CustomFormSubmissionAction;
import org.openmrs.module.htmlformentry.FormEntryContext;
import org.openmrs.module.htmlformentry.FormEntrySession;
import org.openmrs.module.namibia.metadata.EncounterTypes;
import org.openmrs.module.namibia.metadata.Programs;

/**
 * Enrolls mothers into the MCH program. The enrollment is done at the following
 *
 * a) First ANC visit recorded
 * b) Labor and Delivery visit
 *
 * The program is exited at the following:
 * a) Labor and Delivery
 * b) The first PNC visit and none other after that
 */
public class MCHProgramManagementPostSubmissionAction implements CustomFormSubmissionAction {
	
	@Override
	public void applyAction(FormEntrySession session) {
		//enroll or exit only on initial form submission
		if (!session.getContext().getMode().equals(FormEntryContext.Mode.ENTER)) {
			return;
		}
		
		ProgramWorkflowService service = Context.getService(ProgramWorkflowService.class);
		Program mchProgram = service.getProgramByUuid(Programs.MCH_PROGRAM.uuid());
		Encounter encounter = session.getEncounter();
		Patient patient = encounter.getPatient();
		
		// Process program outcomes
		for (PatientProgram patientProgram : service.getPatientPrograms(patient, mchProgram, null, null, null, null,
				false)) {
			if (patientProgram.getActive()) {
				// patient is enrolled in a program - so exit them in PNC or L&D
				if (encounter.getEncounterType().getUuid().equals(EncounterTypes.MOTHER_PNC_ENCOUNTER_TYPE.uuid()) || encounter.getEncounterType().getUuid().equals(EncounterTypes.LABOR_AND_DELIVERY_ENCOUNTER_TYPE.uuid())) {
					patientProgram.setDateCompleted(encounter.getEncounterDatetime());
					service.savePatientProgram(patientProgram);
				}
				return;
			}
		}
		// Enrollment during the ANC or L&D visit
		if (session.getEncounter().getEncounterType().getUuid().equals(EncounterTypes.ANC_ENCOUNTER_TYPE.uuid())) {
			PatientProgram enrollment = new PatientProgram();
			enrollment.setProgram(mchProgram);
			enrollment.setPatient(patient);
			enrollment.setDateEnrolled(encounter.getEncounterDatetime());
			service.savePatientProgram(enrollment);
		}
	}
}
