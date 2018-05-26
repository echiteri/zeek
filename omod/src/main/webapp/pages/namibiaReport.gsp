
<%
    /*ui.decorateWith("uicommons", "html5")
    ui.includeCss("uicommons", "styleguide/index.css")
    ui.includeCss("uicommons", "styleguide/jquery.toastmessage.css")
    ui.includeCss("uicommons", "styleguide/jquery-ui-1.9.2.custom.min.css")
    ui.includeJavascript("uicommons", "jquery-1.12.4.min.js");
    ui.includeJavascript("uicommons", "bootstrap-scrollspy.js");
    ui.includeJavascript("uicommons", "typeahead.js");
    ui.includeJavascript("uicommons", "script.js");*/
    ui.includeFragment("appui", "standardEmrIncludes")
    ui.includeCss("referenceapplication", "login.css")
    ui.decorateWith("appui", "standardEmrPage", [ title: ui.message("PTracker Reports") ])
%>
<script type="text/javascript"> var breadcrumbs = [ {icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm'}, {label: "PTracker Reports"} ] </script>
    <div id="body-wrapper" class="style-guide">

        <div id="content" class="container column">
            <div class="info-container column">
                <h2> Monthly Summary Reports </h2>
                <ul>
                    <li>
                        <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports&reportUnit=%2Freports%2FANC_summary_report&standAlone=true#" target="_blank"> -- ANC summary report</a>
                    </li>
                    <li>
                        <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports&reportUnit=%2Freports%2FLabor_and_Delivery_Monthly_Summary_Report&standAlone=true#" target="_blank"> -- Labor and Delivery summary report</a>
                    </li>
                    <li>
                        <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports&reportUnit=%2Freports%2FMBFU_Monthly_Summary_Report&standAlone=true#" target="_blank"> -- Mother Baby Followup summary report</a>
                    </li>
                </ul>
                <h2> Dashboards </h2>
                <ul>
                    <li>
                        <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports&reportUnit=%2Freports%2FPMTCT_Outcome_Dashboard&standAlone=true#" target="_blank"> -- PMTCT Outcome</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>