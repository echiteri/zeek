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

/* Registration form - PTrackerID functions - put here due to the edit section not loading content from the register patient page */
jq(function() {
    if (jq("#registration").length) {
        /* hide all ptrackerId fields with the class hidden */
        jq(".ptrackerId").parent().hide();
        var showEditableId = true;
        /* only enable the other fields when the largest one has text */
        if (jq("input[name='ptrackerId1'").val() == '') {
            /* no need to show others */
            showEditableId = false;
        }
        for (var i = 2; i < 10; i++) {
            if (showEditableId) {
                if (jq("input[name='ptrackerId" + i + "'").val() == '') {
                    alert('Showing ptrackerId' + i);
                    // the first field to match this will be enabled and the loop will be broken
                    jq("input[name='ptrackerId" + i + "'").prev("p").show();
                    showEditableId = false;
                } else {
                    alert('Showing ptrackerId' + i + " because its value is " + jq("input[name='ptrackerId" + i + "'").val());
                    // enable this field
                    jq("input[name='ptrackerId" + i + "'").prev("p").show();
                    showEditableId = false;
                }
            }
        }
    }
});

