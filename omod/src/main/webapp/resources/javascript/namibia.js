/**
 * Custom Javascript functions for Namibia Implementation
 *
 */
/*
 * Hide the container, and disable all elements in it
 *
 * @param the Id of the container
 */
function hideContainer(container) {
    jq(container).addClass('hidden');
    jq(container + ' :input').attr('disabled', true);
    jq(container + ' :input').prop('checked', false);
}
/*
 * Show the container, and enable all elements in it
 *
 * @param the Id of the container
 */
function showContainer(container) {
    jq(container).removeClass('hidden');
    jq(container + ' :input').attr('disabled', false);
    jq(container + ' :input').prop('checked', false);
}

/**
 + * Changes a field date in the format yy-mm-dd to dd/mm/yy which eas
 + * @param dateValue
 + */
function changeFieldDateToJavascriptDate(dateValue) {
    return jq.datepicker.formatDate('mm/dd/yy', jq.datepicker.parseDate('yy-mm-dd', dateValue));
}

/* Custom Javascript running on page load */
jq(document).ready(function(){
    // change the text of the primary identifier to PTrackerID
    jq('em:contains("Patient ID")').text("PTracker ID");

})

