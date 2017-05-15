package org.openmrs.module.namibia.validator;

import java.util.Calendar;
import java.util.Date;

import org.openmrs.Person;
import org.openmrs.annotation.Handler;
import org.openmrs.util.OpenmrsUtil;
import org.openmrs.validator.PersonValidator;
import org.springframework.validation.Errors;

/**
 * Additional validations
 * 1. No males over 5 years should be registered
 * 2. No females over 60 years
 */
@Handler(supports = { Person.class }, order = 60)
public class NamibiaPersonValidator extends PersonValidator {
	
	@Override
	public void validate(Object target, Errors errors) {
		super.validate(target, errors);
		
		if (target != null) {
			Person person = (Person) target;
			
			if (person.getBirthdate() != null) {
				
				// reject if over 60 years
				rejectDateIfBefore60YearsAgo(errors, person.getBirthdate(), "birthdate");
				if (person.getGender().equals("M")) {
					// no males over 5 years old
					rejectDateIfBefore5YearsAgo(errors, person.getBirthdate(), "birthdate");
				}
			}
		}
	}
	
	/**
	 * Rejects a date if it is before 60 years ago.
	 *
	 * @param errors the error object
	 * @param date the date to check
	 * @param dateField the name of the field
	 */
	private void rejectDateIfBefore60YearsAgo(Errors errors, Date date, String dateField) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, -60);
		if (OpenmrsUtil.compare(date, c.getTime()) < 0) {
			errors.rejectValue(dateField, "The maximum age that is allowed is 60 years");
		}
	}
	
	/**
	 * Rejects a date if it is before 5 years ago.
	 *
	 * @param errors the error object
	 * @param date the date to check
	 * @param dateField the name of the field
	 */
	private void rejectDateIfBefore5YearsAgo(Errors errors, Date date, String dateField) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, -5);
		if (OpenmrsUtil.compare(date, c.getTime()) < 0) {
			errors.rejectValue(dateField, "The maximum age for a male patient is 5 years");
		}
	}
}
