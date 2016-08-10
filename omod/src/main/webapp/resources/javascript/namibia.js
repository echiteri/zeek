/**
 * Custom Javascript functions for Namibia Implementation
 *
 */
jq(document).ready(function () {

    /* Add validation rule for Namibia phone numbers, once applied to an element will validate the format and show a message
     */
    jq.validator.addMethod("namibiaphone", function( phone_number, element ) {
        phone_number = phone_number.replace( /\(|\)|\s+|-/g, "" );
        return this.optional( element ) || phone_number.length == 10 &&
                                           phone_number.match( /^[0-9]{1,10}$/ );
    }, "Please specify a valid mobile number with 10 digits without any spaces" );

    /* Set validaton to the registration form */
    jq('#registration').validate();
});


