<%
    ui.includeFragment("appui", "standardEmrIncludes")
    ui.includeCss("referenceapplication", "login.css")
%>

<!DOCTYPE html>
<html>
<head>
    <title>${ui.message("referenceapplication.login.title")}</title>
    <link rel="shortcut icon" type="image/ico" href="/${ui.contextPath()}/images/openmrs-favicon.ico"/>
    <link rel="icon" type="image/png\" href="/${ui.contextPath()}/images/openmrs-favicon.png"/>
    ${ui.resourceLinks()}
</head>

<body>
<script type="text/javascript">
    var OPENMRS_CONTEXT_PATH = '${ ui.contextPath() }';
</script>

<script type="text/javascript">
    jQuery(function () {
        updateSelectedOption = function () {
            jQuery('#sessionLocation li').removeClass('selected');

            var sessionLocationVal = jQuery('#sessionLocationInput').val();
            if (sessionLocationVal != null && sessionLocationVal != "" && sessionLocationVal != 0) {
                jQuery('#sessionLocation li[value|=' + sessionLocationVal + ']').addClass('selected');
            }
        };

        updateSelectedOption();

        jQuery('#sessionLocation').change(function () {
            jQuery('#sessionLocationInput').val(jQuery(this).find(":selected").val());
            alert("The elected option is " + jQuery('#sessionLocationInput').val());
            updateSelectedOption();
        });

        jQuery('#login-form').submit(function (e) {
            var sessionLocationVal = jQuery('#sessionLocationInput').val();

            if (!sessionLocationVal) {
                jQuery('#sessionLocationError').show();
                e.preventDefault();
            }
        });

        jQuery('#username').focus();

        var cannotLoginController = emr.setupConfirmationDialog({
                                                                    selector: '#cannotLoginPopup',
                                                                    actions: {
                                                                        confirm: function () {
                                                                            cannotLoginController.close();
                                                                        }
                                                                    }
                                                                });

        jQuery('a#cantLogin').click(function () {
            cannotLoginController.show();
        });

        pageReady = true;
    });
</script>

<header>
    <div class="logo">
        <a href="${ui.pageLink("referenceapplication", "home")}">
            <img src="${ui.resourceLink("namibia", "/images/namibia_coat_of_arms.png")}"/>
        </a>
    </div>
</header>

<div id="body-wrapper">
    <div id="content">
        <form id="login-form" method="post" autocomplete="off">
            <fieldset>

                <legend>
                    <i class="icon-lock small"></i>
                    ${ui.message("referenceapplication.login.loginHeading")}
                </legend>

                <p class="left">
                    <label for="username">
                        ${ui.message("referenceapplication.login.username")}:
                    </label>
                    <input id="username" type="text" name="username"
                           placeholder="${ui.message("referenceapplication.login.username.placeholder")}"/>
                </p>

                <p class="left">
                    <label for="password">
                        ${ui.message("referenceapplication.login.password")}:
                    </label>
                    <input id="password" type="password" name="password"
                           placeholder="${ui.message("referenceapplication.login.password.placeholder")}"/>
                </p>

                <p class="clear">
                    <label for="sessionLocation">
                        ${ui.message("namibia.login.sessionLocation")}: <span class="location-error"
                                                                              id="sessionLocationError"
                                                                              style="display: none">${ui.message("namibia.login.error.locationRequired")}</span>
                    </label>
                    <span class="select-arrow left">
                        <select id="sessionLocation" class="select">
                            <option value="">Select One</option>
                    <% locations.sort { ui.format(it) }.each { %>
                            <option value="${it.id}">${ui.format(it)}</option>
                    <% } %>
                        </select>
                    </span>
            </p>
                ${ui.includeFragment("referenceapplication", "infoAndErrorMessages")}

                <input type="hidden" id="sessionLocationInput" name="sessionLocation"
                    <% if (lastSessionLocation != null) { %> value="${lastSessionLocation.id}" <% } %>/>

                <p>
                    <input id="loginButton" class="confirm" type="submit"
                           value="${ui.message("referenceapplication.login.button")}"/>
                </p>

                <p>
                    <a id="cantLogin" href="javascript:void(0)">
                        <i class="icon-question-sign small"></i>
                        ${ui.message("referenceapplication.login.cannotLogin")}
                    </a>
                </p>

            </fieldset>

            <input type="hidden" name="redirectUrl" value="${redirectUrl}"/>

        </form>

    </div>
</div>

<div id="cannotLoginPopup" class="dialog" style="display: none">
    <div class="dialog-header">
        <i class="icon-info-sign"></i>

        <h3>${ui.message("referenceapplication.login.cannotLogin")}</h3>
    </div>

    <div class="dialog-content">
        <p class="dialog-instructions">${ui.message("referenceapplication.login.cannotLoginInstructions")}</p>

        <button class="confirm">${ui.message("referenceapplication.okay")}</button>
    </div>
</div>

</body>
</html>
