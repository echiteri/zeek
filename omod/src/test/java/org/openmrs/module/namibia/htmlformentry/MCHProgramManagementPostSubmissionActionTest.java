package org.openmrs.module.namibia.htmlformentry;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.EncounterType;
import org.openmrs.Patient;
import org.openmrs.PatientProgram;
import org.openmrs.Program;
import org.openmrs.api.ProgramWorkflowService;
import org.openmrs.api.context.Context;
import org.openmrs.module.htmlformentry.FormEntryContext;
import org.openmrs.module.htmlformentry.FormEntrySession;
import org.openmrs.module.namibia.metadata.EncounterTypes;
import org.openmrs.module.namibia.metadata.Programs;
import org.openmrs.web.test.BaseModuleWebContextSensitiveTest;

/**
 * Test cases for Program enrollment
 */
public class MCHProgramManagementPostSubmissionActionTest extends BaseModuleWebContextSensitiveTest {
	
	private Patient patient;
	private Encounter encounter;
	private EncounterType encounterType;
	private SimpleDateFormat sdf;
	private MCHProgramManagementPostSubmissionAction postSubmissionAction;
	private FormEntrySession formEntrySession;
	private FormEntryContext formEntryContext;
	private ProgramWorkflowService programWorkflowService;
	private Program mchProgram;
	
	@Before
	public void setup() throws Exception {
		patient = new Patient(2);
		
		encounter = new Encounter();
		encounter.setEncounterDatetime(new Date());
		
		encounterType = mock(EncounterType.class);
		
		encounter.setPatient(patient);
		encounter.setEncounterType(encounterType);
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		postSubmissionAction = new MCHProgramManagementPostSubmissionAction();
		
		formEntrySession = mock(FormEntrySession.class);
		formEntryContext = mock(FormEntryContext.class);
		
		when(formEntrySession.getContext()).thenReturn(formEntryContext);
		when(formEntrySession.getPatient()).thenReturn(patient);
		when(formEntrySession.getEncounter()).thenReturn(encounter);
		
		programWorkflowService = Context.getService(ProgramWorkflowService.class);
		mchProgram = new Program(Programs.MCH_PROGRAM.name());
		mchProgram.setConcept(new Concept(3));
		mchProgram.setUuid(Programs.MCH_PROGRAM.uuid());
		programWorkflowService.saveProgram(mchProgram);
	}
	
	@Test
	public void shouldNotEnrollPatientInMCHProgramForEditAndViewModes() {
		List<PatientProgram> programs = programWorkflowService.getPatientPrograms(patient, mchProgram, null, null, null,
				null, false);
		Assert.assertEquals(0, programs.size());
		
		//try enroll in vew mode
		when(formEntrySession.getContext().getMode()).thenReturn(FormEntryContext.Mode.VIEW);
		postSubmissionAction.applyAction(formEntrySession);
		programs = programWorkflowService.getPatientPrograms(patient, mchProgram, null, null, null, null, false);
		Assert.assertEquals(0, programs.size()); //should not enroll in view mode
		
		//try enroll in edit mode
		when(formEntrySession.getContext().getMode()).thenReturn(FormEntryContext.Mode.EDIT);
		postSubmissionAction.applyAction(formEntrySession);
		programs = programWorkflowService.getPatientPrograms(patient, mchProgram, null, null, null, null, false);
		Assert.assertEquals(0, programs.size()); //should not enroll in edit mode
		
		//try enroll in enter mode for PNC
		when(formEntrySession.getContext().getMode()).thenReturn(FormEntryContext.Mode.ENTER);
		when(encounterType.getUuid()).thenReturn(EncounterTypes.MOTHER_PNC_ENCOUNTER_TYPE.uuid());
		postSubmissionAction.applyAction(formEntrySession);
		programs = programWorkflowService.getPatientPrograms(patient, mchProgram, null, null, null, null, false);
		Assert.assertEquals(0, programs.size()); //should not enroll
		
		//try enroll again for the same patient and program in enter mode
		postSubmissionAction.applyAction(formEntrySession);
		programs = programWorkflowService.getPatientPrograms(patient, mchProgram, null, null, null, null, false);
		Assert.assertEquals(0, programs.size()); //still no enrollment
	}
	
	@Test
	public void shouldEnrollinANCAndExitInLandD() {
		
		List<PatientProgram> programs = programWorkflowService.getPatientPrograms(patient, mchProgram, null, null, null,
				null, false);
		Assert.assertEquals(0, programs.size());
		
		//try enroll in enter mode for ANC
		when(formEntrySession.getContext().getMode()).thenReturn(FormEntryContext.Mode.ENTER);
		when(encounterType.getUuid()).thenReturn(EncounterTypes.ANC_ENCOUNTER_TYPE.uuid());
		postSubmissionAction.applyAction(formEntrySession);
		programs = programWorkflowService.getPatientPrograms(patient, mchProgram, null, null, null, null, false);
		Assert.assertEquals(1, programs.size()); //should enroll
		
		//try enroll again for the same patient and program in enter mode
		postSubmissionAction.applyAction(formEntrySession);
		programs = programWorkflowService.getPatientPrograms(patient, mchProgram, null, null, null, null, false);
		Assert.assertEquals(1, programs.size()); //should not do duplicate enrollment
		
		//try exit via enter mode for L&D
		when(formEntrySession.getContext().getMode()).thenReturn(FormEntryContext.Mode.ENTER);
		when(encounterType.getUuid()).thenReturn(EncounterTypes.LABOR_AND_DELIVERY_ENCOUNTER_TYPE.uuid());
		postSubmissionAction.applyAction(formEntrySession);
		programs = programWorkflowService.getPatientPrograms(patient, mchProgram, null, null, null, null, false);
		Assert.assertEquals(1, programs.size()); //should not duplicate enrollment
		Assert.assertTrue(sdf.format(new Date()).equals(sdf.format(programs.get(0).getDateCompleted())));
		Assert.assertFalse(programs.get(0).getActive());
	}
	@Test
	public void shouldEnrollinANCAndExitInPNC() {
		
		List<PatientProgram> programs = programWorkflowService.getPatientPrograms(patient, mchProgram, null, null, null,
				null, false);
		Assert.assertEquals(0, programs.size());
		
		//try enroll in enter mode for ANC
		when(formEntrySession.getContext().getMode()).thenReturn(FormEntryContext.Mode.ENTER);
		when(encounterType.getUuid()).thenReturn(EncounterTypes.ANC_ENCOUNTER_TYPE.uuid());
		postSubmissionAction.applyAction(formEntrySession);
		programs = programWorkflowService.getPatientPrograms(patient, mchProgram, null, null, null, null, false);
		Assert.assertEquals(1, programs.size()); //should enroll
		
		//try enroll again for the same patient and program in enter mode
		postSubmissionAction.applyAction(formEntrySession);
		programs = programWorkflowService.getPatientPrograms(patient, mchProgram, null, null, null, null, false);
		Assert.assertEquals(1, programs.size()); //should not do duplicate enrollment
		
		//try exit via enter mode for L&D
		when(formEntrySession.getContext().getMode()).thenReturn(FormEntryContext.Mode.ENTER);
		when(encounterType.getUuid()).thenReturn(EncounterTypes.MOTHER_PNC_ENCOUNTER_TYPE.uuid());
		postSubmissionAction.applyAction(formEntrySession);
		programs = programWorkflowService.getPatientPrograms(patient, mchProgram, null, null, null, null, false);
		Assert.assertEquals(1, programs.size()); //should not duplicate enrollment
		Assert.assertTrue(sdf.format(new Date()).equals(sdf.format(programs.get(0).getDateCompleted())));
		Assert.assertFalse(programs.get(0).getActive());
	}
}
