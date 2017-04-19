package org.openmrs.module.namibia.htmlformentry;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.Person;
import org.openmrs.Relationship;
import org.openmrs.api.PatientService;
import org.openmrs.api.context.Context;
import org.openmrs.module.htmlformentry.FormEntryContext;
import org.openmrs.module.htmlformentry.FormEntrySession;
import org.openmrs.module.htmlformentry.FormSubmissionActions;
import org.openmrs.web.test.BaseModuleWebContextSensitiveTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test for automatically registering infants whose data is captured at Labor and Delivery
 */
public class InfantRegistrationAtLaborAndDeliverySubmissionActionTest extends BaseModuleWebContextSensitiveTest {
	
	private FormEntrySession mockFormEntrySession;
	
	private FormEntryContext mockFormEntryContext;
	
	private FormSubmissionActions mockFormSubmissionActions;
	
	private PatientService mockPatientService;
	
	private InfantRegistrationAtLaborAndDeliverySubmissionAction infantRegistrationAtLaborAndDeliverySubmissionAction;
	
	private SimpleDateFormat sdf;
	
	@Before
	public void setup() throws Exception {
		executeDataSet("baseTestData.xml");
		executeDataSet("metadata/CustomConcepts-1.xml");
		executeDataSet("infantRegistrationAtLandD.xml");
		mockFormEntrySession = mock(FormEntrySession.class);
		mockFormEntryContext = mock(FormEntryContext.class);
		mockFormSubmissionActions = mock(FormSubmissionActions.class);
		mockPatientService = mock(PatientService.class);
		infantRegistrationAtLaborAndDeliverySubmissionAction = new InfantRegistrationAtLaborAndDeliverySubmissionAction();
		
		when(mockFormEntrySession.getSubmissionActions()).thenReturn(mockFormSubmissionActions);
		when(mockFormEntrySession.getContext()).thenReturn(mockFormEntryContext);
		when(mockFormEntrySession.getContext().getMode()).thenReturn(FormEntryContext.Mode.ENTER);
		
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}
	
	@Test
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void testWithOneChildAlive() throws Exception {
		Encounter e = Context.getEncounterService().getEncounter(1001);
		when(mockFormEntrySession.getEncounter()).thenReturn(e);
		
		infantRegistrationAtLaborAndDeliverySubmissionAction.applyAction(mockFormEntrySession);
		
		// infant details
		List<Relationship> children = Context.getPersonService().getRelationshipsByPerson(e.getPatient().getPerson());
		// there must be only one child
		Assert.assertEquals(1, children.size());
		Person infant = children.get(0).getPersonB();
		
		// check the DOB and Gender
		Assert.assertEquals("DOB 2017-04-12 - actual " + infant.getBirthdate(), sdf.parse("2017-04-12"), infant.getBirthdate());
		Assert.assertEquals("Gender F actual " + infant.getGender(), "F", infant.getGender());
		
		// check the PTrackerID
		Patient p = Context.getPatientService().getPatient(infant.getPersonId());
		PatientIdentifier pid = p.getPatientIdentifier(Context.getPatientService().getPatientIdentifierTypeByUuid("4da0a3fe-e546-463f-81fa-084f098ff06c"));
		Assert.assertEquals("PTracker ID PT23456 - actual " + pid.getIdentifier(), "PT23456", pid.getIdentifier());
		
	}
}
