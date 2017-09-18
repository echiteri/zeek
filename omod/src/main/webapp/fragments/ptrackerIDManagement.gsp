<script>
    jq(function() {
        /* hide all ptrackerId fields with the class hidden */
        jq(".hidden").attr("disabled", true);
        for (var i = 0; i < 9; i++) {
            /* only enable the other fields when the largest one has text */
            if (jq("input[name='ptrackerId" + i + "'").val() == '') {
                // the first field to match this will be enabled and the loop will be broken
                jq("input[name='ptrackerId" + i + "'").attr("disabled", false);
                return;
            } else {
                // enable this field
                jq("input[name='ptrackerId" + i + "'").attr("disabled", false);
            }
        }
    });
</script>