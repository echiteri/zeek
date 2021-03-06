<%
    ui.includeFragment("appui", "standardEmrIncludes")
    ui.includeCss("referenceapplication", "login.css")
%>

<!DOCTYPE html>
<html>
<head>

<!-- Start Open Web Analytics Tracker -->
<script type="text/javascript">
//<![CDATA[
var owa_baseUrl = 'https://ptracker.mhss.gov.na/analytics/';
var owa_cmds = owa_cmds || [];
owa_cmds.push(['setSiteId', '0527abaff3c10798e904ad5bcd627243']);
owa_cmds.push(['trackPageView']);
owa_cmds.push(['trackClicks']);
owa_cmds.push(['trackDomStream']);

(function() {
	var _owa = document.createElement('script'); _owa.type = 'text/javascript'; _owa.async = true;
	owa_baseUrl = ('https:' == document.location.protocol ? window.owa_baseSecUrl || owa_baseUrl.replace(/http:/, 'https:') : owa_baseUrl );
	_owa.src = owa_baseUrl + 'modules/base/js/owa.tracker-combined-min.js';
	var _owa_s = document.getElementsByTagName('script')[0]; _owa_s.parentNode.insertBefore(_owa, _owa_s);
}());
//]]>
</script>
<!-- End Open Web Analytics Code -->

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
    <div style="float: left;margin: 25px 0 10px 20px; color: #EFEF;width: 350px;">
        <div style="padding-bottom: 10px;">
            <span style="font-size: 1.2em; text-align: left;color: #FFFFFF;">Ministry of Health and
            Social
            Services</span>
        </div>
        <span style="color: #848484;font-size: 0.9em;float: left; width: 100%; text-align: center;">PMTCT Tracker</span>
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
                    <br/>
                    <a href="${ui.resourceLink("namibia", "/faq/1.4_How_to_Login_to_PTracker_May2018.pdf")}" target="_blank">
                        <i class="icon-question-sign small"></i>
                        ${ui.message("How do I login?")}
                    </a>
                </p>

            </fieldset>

            <input type="hidden" name="redirectUrl" value="${redirectUrl}"/>
            <div class="footer" style="color: #848484;font-size: 0.8em;float: left; width: 100%; text-align: center;">
                &#169; 2017 All Rights Reserved | <a href="http://www.mhss.gov.na/" target="_blank" title="Ministry of Health and Social Services">MoHSS Namibia</a> | Developed by the <a href="http://globalhealthsciences.ucsf.edu/" target="_blank" title="Institute of Global Health Sciences">University of California, San Francisco.</a>
                <br/>
                ${ui.message("namibia.version.label")} &nbsp; &nbsp; Powered by OpenMRS | Contact : (+264 814673349 / +264 814673343)
            </div>

        </form>

    </div>
</div>

<div id="cannotLoginPopup" class="dialog" style="display: none">
    <div class="dialog-header">
        <i class="icon-info-sign"></i>

        <h3>${ui.message("referenceapplication.login.cannotLogin")}</h3>
    </div>

    <div class="dialog-content">
        <p class="dialog-instructions">${ui.message("Please contact: +264 814673349 / +264 814673343")}</p>

        <button class="confirm">${ui.message("referenceapplication.okay")}</button>
    </div>
</div>


</body>
</html>
