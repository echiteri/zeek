package org.openmrs.module.namibia.htmlformentry;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.PersonName;
import org.openmrs.Relationship;
import org.openmrs.api.PatientService;
import org.openmrs.api.PersonService;
import org.openmrs.api.context.Context;
import org.openmrs.module.htmlformentry.CustomFormSubmissionAction;
import org.openmrs.module.htmlformentry.FormEntryContext;
import org.openmrs.module.htmlformentry.FormEntrySession;
import org.openmrs.module.idgen.IdentifierSource;
import org.openmrs.module.idgen.service.IdentifierSourceService;

/**
 * Automatically register infants at Labor and Delivery
 */
public class InfantRegistrationAtLaborAndDeliverySubmissionAction implements CustomFormSubmissionAction {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	private PatientService patientService;
	private PersonService personService;
	private IdentifierSourceService identifierSourceService;
	
	public InfantRegistrationAtLaborAndDeliverySubmissionAction() {
		this.personService = Context.getPersonService();
		this.patientService = Context.getPatientService();
		this.identifierSourceService = Context.getService(IdentifierSourceService.class);
	}
	
	@Override
	public void applyAction(FormEntrySession formEntrySession) {
		// only do this the first time the form is entered
		// TODO: Find a way of pushing updates to edit mode
		if (!formEntrySession.getContext().getMode().equals(FormEntryContext.Mode.ENTER)) {
			return;
		}
		
		// find the number of babies born
		for (Obs obs : formEntrySession.getEncounter().getObsAtTopLevel(false)) {
			if (obs.hasGroupMembers()) {
				// this obs has some registration information for the infant
				Iterator i = obs.getGroupMembers(false).iterator();
				// find out if the infant is alive
				while(i.hasNext()) {
					Obs o = (Obs)i.next();
					if(o.getConcept().getUuid().equals("159917AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")) {
						if (o.getValueCoded().getId().intValue() == 151849) {
							// the child status is alive so will be registered
							Patient baby = new Patient();
							log.debug("Registering infant for obsgroup " + obs.getValueGroupId() + " from encounterId " + formEntrySession.getEncounter().getEncounterId());
							Iterator j = obs.getGroupMembers(false).iterator();
							while(j.hasNext()) {
								Obs regData = (Obs) j.next();
								if (regData.getConcept().getUuid().equals("164802AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")) {
									// date of Birth
									baby.setBirthdate(regData.getValueDate());
								}
								if (regData.getConcept().getUuid().equals("1587AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")) {
									// gender
									if (regData.getValueCoded().getId().intValue() == 1535) {
										baby.setGender("F");
									} else {
										baby.setGender("M");
									}
								}
								if (regData.getConcept().getUuid().equals("164803AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")) {
									if (StringUtils.isNotBlank(regData.getValueText())) {
										// create a new PTracker ID for the baby
										PatientIdentifier infantPtrackerID = new PatientIdentifier();
										infantPtrackerID.setIdentifierType(patientService.getPatientIdentifierTypeByUuid("4da0a3fe-e546-463f-81fa-084f098ff06c"));
										// TODO: what location should be here?
										infantPtrackerID.setLocation(formEntrySession.getEncounter().getLocation());
										infantPtrackerID.setIdentifier(regData.getValueText());
										
										baby.addIdentifier(infantPtrackerID);
									}
								}
							}
							
							// add names - XX for now
							baby.addName(new PersonName("TBD", "TBD", "TBD"));
							
							// get the preferred Identifier
							PatientIdentifier patientIdentifier = new PatientIdentifier();
							patientIdentifier.setIdentifierType(patientService.getPatientIdentifierTypeByUuid("05a29f94-c0ed-11e2-94be-8c13b969e334")); // OpenMRS ID with check digit
							patientIdentifier.setPreferred(true); // this is the preferred Identifier
							// TODO: what location should be here?
							patientIdentifier.setLocation(formEntrySession.getEncounter().getLocation());
							
							// Set the string
							IdentifierSource idSource = identifierSourceService.getIdentifierSource(1);
							patientIdentifier.setIdentifier(identifierSourceService.generateIdentifier(idSource, null));
							
							baby.addIdentifier(patientIdentifier);
							
							// save the baby
							baby = patientService.savePatient(baby);
							
							// add a relationship to the mother who is the current patient in the encounter
							Relationship parentChild = new Relationship();
							parentChild.setRelationshipType(personService.getRelationshipTypeByUuid("8d91a210-c2cc-11de-8d13-0010c6dffd0f"));
							parentChild.setPersonA(formEntrySession.getEncounter().getPatient().getPerson()); // the mother
							parentChild.setPersonB(baby);
							personService.saveRelationship(parentChild);
						}
					}
				}
				
			}
		}
	}
}