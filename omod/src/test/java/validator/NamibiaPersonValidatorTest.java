package validator;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.Patient;
import org.openmrs.module.namibia.validator.NamibiaPersonValidator;
import org.openmrs.web.test.BaseModuleWebContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

/**
 * Tests the additional validation rules for Namibia
 */
public class NamibiaPersonValidatorTest extends BaseModuleWebContextSensitiveTest{
	
	@Autowired
	protected NamibiaPersonValidator namibiaPersonValidator;
	
	@Test
	public void validate_shouldFailForMoreThan60Years() throws Exception {
		Patient pa = new Patient();
		pa.setGender("F");
		Calendar birth = Calendar.getInstance();
		birth.setTime(new Date());
		birth.add(Calendar.YEAR, -61);
		pa.setBirthdate(birth.getTime());
		Errors errors = new BindException(pa, "patient");
		namibiaPersonValidator.validate(pa, errors);
		
		Assert.assertTrue(errors.hasFieldErrors("birthdate"));
	}
	
	@Test
	public void validate_shouldFailForMalesMoreThan2Years() throws Exception {
		Patient pa = new Patient();
		pa.setGender("M");
		Calendar birth = Calendar.getInstance();
		birth.setTime(new Date());
		birth.add(Calendar.YEAR, -3);
		pa.setBirthdate(birth.getTime());
		Errors errors = new BindException(pa, "patient");
		namibiaPersonValidator.validate(pa, errors);
		
		Assert.assertTrue(errors.hasFieldErrors("birthdate"));
	}
	
	@Test
	public void validate_shouldNotFailForNullBirthDate() throws Exception {
		Patient pa = new Patient();
		Errors errors = new BindException(pa, "patient");
		namibiaPersonValidator.validate(pa, errors);
		
		Assert.assertFalse(errors.hasFieldErrors("birthdate"));
	}
	
}
