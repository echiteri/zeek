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
    disableContainer(container);
}

/**
 * Disable all the fields in the specified container
 * @param container
 */
function disableContainer(container) {
    jq(container + ' :input').attr('disabled', true).fadeTo(250, 0.45);
    jq(container + ' :input').prop('checked', false).fadeTo(250, 0.45);
    // clear field values
    jq(container + ' :input').each(function() {
        switch (this.type) {
            case 'password':
            case 'text':
            case 'textarea':
            case 'file':
            case 'select-one':
            case 'select-multiple':
            case 'date':
            case 'number':
            case 'tel':
            case 'email':
                jq(this).val('');
                break;
            case 'checkbox':
            case 'radio':
                this.checked = false;
                break;
        }
    });
}
/*
 * Show the container, and enable all elements in it
 *
 * @param the Id of the container
 */
function showContainer(container) {
    jq(container).removeClass('hidden');
    enableContainer(container);
}
/**
 * Enable all the fields in the specified container
 * @param container
 */
function enableContainer(container){
    jq(container + ' :input').attr('disabled', false).fadeTo(250, 1);
    jq(container + ' :input').prop('checked', false).fadeTo(250, 1);
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

/**
 * Handle the enabling and disabling of missing fields
 *
 * @param data_field The id of the field with the missing value
 */
function handleMissingSelection(data_field) {
    if (getValue(data_field  + '_missing.value')) {
        disableContainer('#' + data_field);
    } else {
        enableContainer('#' + data_field);
    }
}

