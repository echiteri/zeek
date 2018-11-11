package tasks;

import org.junit.Assert;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.openmrs.Patient;
import org.openmrs.api.PatientService;
import org.openmrs.PatientIdentifier;
import org.openmrs.PatientIdentifierType;
import org.openmrs.PersonName;
import org.openmrs.Location;
import org.openmrs.api.context.Context;
import org.openmrs.module.namibia.metadata.PatientIdentifierTypes;
import org.openmrs.module.namibia.validator.NamibiaPersonValidator;
import org.openmrs.module.namibia.api.NamibiaPMTCTService;
import org.openmrs.module.namibia.tasks.AutoCreateNewPTrackerID;
import org.openmrs.module.namibia.api.impl.NamibiaPMTCTServiceImpl;
import org.openmrs.web.test.BaseModuleWebContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

import java.util.Calendar;
import java.util.Date;

/**
 * Tests the additional validation rules for Namibia
 */
public class AutoCreateNewPTrackerIDTest extends BaseModuleWebContextSensitiveTest{
	
	@Autowired
	protected NamibiaPersonValidator namibiaPersonValidator;
	private PatientService patientService;

	@Test
	public void testAssertNull() {
		Assert.assertNull("should be null", null);
	}
	@Test
	public void newPtrackerIDShouldBeAdded() throws Exception {
		NamibiaPMTCTService namibiaPMTCTService = Context.getService(NamibiaPMTCTService.class);
		Patient p = new Patient(1232);
		Integer identifierSize1;
		Integer identifierSize2;


		/* Create a few identifier type */
		PatientIdentifierType patientIdentifierType = new PatientIdentifierType();
		/*for (int i=5; i<14 ; i++) {
			patientIdentifierType.setId(i);
			patientIdentifierType.setCreator(Context.getUserService().getUser(1));
			patientIdentifierType.setUuid("926d1cec-2cd6-4637-a981-4av6b4b8b41"+i);
			patientIdentifierType.setDateCreated(new Date());
			patientIdentifierType.setDescription("PREGNANCY_NUMBER_"+i);
			patientIdentifierType.setName("PREGNANCY_NUMBER_1"+i);
			patientIdentifierType.setRequired(false);
			patientIdentifierType.setRetired(false);
			Context.getPatientService().savePatientIdentifierType(patientIdentifierType);
		}*/

		/* create patient identifier
		PatientIdentifier pa1 = new PatientIdentifier();

		pa1.setIdentifier("10319A171261");
		pa1.setIdentifierType(new PatientIdentifierType(5));
		pa1.setDateCreated(new Date());
		pa1.setVoided(false);
		p.addIdentifier(pa1);*/


		//Assert.assertNotNull("Patient Identifiers must not be null", p.getIdentifiers());
		// Assert.assertEquals("Size: " + p.getIdentifiers().size() + " Equal to 7", p.getIdentifiers().size(), 9);
		//Assert.assertNull(p.getPatientId());
		// identifierSize1 = p.getIdentifiers().size();
		// namibiaPMTCTService.createNewPregnancyPTrackerID(p.getPatientId(), "10319A181261");

		// identifierSize2 = p.getIdentifiers().size();
		// Assert.assertNotEquals("Size: " + identifierSize1 + " OF Patient ID "+p.getPatientId()+  " is Equal to " + identifierSize2, identifierSize1, identifierSize2);
		// Assert.assertEquals("Size: " + identifierSize1 + "Equal to" + identifierSize2, identifierSize1, identifierSize2);

		// Assert.assertEquals(identifierSize1+1, identifierSize2, 0);

	}
	
}
