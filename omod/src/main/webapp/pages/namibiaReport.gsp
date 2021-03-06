
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
                <h2> Monthly Summary Reports</h2>
                <ul>
                    <li>
                        <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FPTracker_Monthly_Summary_Report&reportUnit=%2Freports%2FPTracker_Monthly_Summary_Report%2FANC_summary_report&standAlone=true" target="_blank"> -- ANC summary report</a>
                    </li>
                    <li>
                        <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FPTracker_Monthly_Summary_Report&reportUnit=%2Freports%2FPTracker_Monthly_Summary_Report%2FLabor_and_Delivery_Monthly_Summary_Report&standAlone=true#" target="_blank"> -- Labor and Delivery summary report</a>
                    </li>
                    <li>
                        <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FPTracker_Monthly_Summary_Report&reportUnit=%2Freports%2FPTracker_Monthly_Summary_Report%2FMBFU_Monthly_Summary_Report&standAlone=true#" target="_blank"> -- Mother Baby Followup summary report</a>
                    </li>
                </ul>
                <h2> Data quality Reports </h2>
                <ul>
                    <li>
                        <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports&reportUnit=%2Freports%2FPTracker_Visit_Count_List_&standAlone=true#" target="_blank"> -- PTracker Visit Count report</a>
                    </li>
                    <li>
                        <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports&reportUnit=%2Freports%2FPTracker_Completeness_List_&standAlone=true#" target="_blank"> -- PTracker Completeness report</a>
                    </li>
                    <li>
                        <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports&reportUnit=%2Freports%2FPTracker_Completeness_List__PNC&standAlone=true#" target="_blank"> -- PTracker Completeness PNC report</a>
                    </li>
                    <li>
                        <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports&reportUnit=%2Freports%2FPTracker_Timeliness_List_&standAlone=true#" target="_blank"> -- PTracker Timeliness report</a>
                    </li>
                </ul>
                <h2> Facility Based Reports </h2>
                     <ul>
                        <li>
                           <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FPTracker_Facility_Based_Reports&reportUnit=%2Freports%2FPTracker_Facility_Based_Reports%2FPTracker_Patient_Duplicate_Identifiers&standAlone=true" target="_blank"> -- PTracker Patient Duplicate Identifier</a>
                        </li>
                        <li>
                           <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FPTracker_Facility_Based_Reports&reportUnit=%2Freports%2FPTracker_Facility_Based_Reports%2FPTracker_Patient_Missing_ART_Number_List_&standAlone=true" target="_blank"> -- PTracker Patient Missing ART Number</a>
                        </li>
                        <li>
                           <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FPTracker_Facility_Based_Reports&reportUnit=%2Freports%2FPTracker_Facility_Based_Reports%2FPTracker_Patient_Missing_ART_Start_Date_List_2&standAlone=true" target="_blank"> -- PTracker Patient Missing ART Start Date</a>
                        </li>
                        <li>
                           <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FPTracker_Facility_Based_Reports&reportUnit=%2Freports%2FPTracker_Facility_Based_Reports%2FPTracker_Patient_Missing_VL_date&standAlone=true" target="_blank"> -- PTracker Patient Missing VL Date</a>
                        </li>
                         <li>
                           <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FPTracker_Facility_Based_Reports&reportUnit=%2Freports%2FPTracker_Facility_Based_Reports%2FPTracker_Patient_Missing_VL_date_or_results&standAlone=true" target="_blank"> -- PTracker Patient Missing VL Date or Results</a>
                        </li>
                        <li>
                            <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FPTracker_Facility_Based_Reports&reportUnit=%2Freports%2FPTracker_Facility_Based_Reports%2FPTracker_Patient_Missing_VL_results&standAlone=true" target="_blank"> -- PTracker Patient Missing VL Results</a>
                        </li>
                        <h3> New </h3>
                        <li>
                            <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FPTracker_Facility_Based_Reports&reportUnit=%2Freports%2FPTracker_Facility_Based_Reports%2FPTracker_Patient_Next_Appointment_List_&standAlone=true" target="_blank"> -- PTracker Next Appointments</a>
                        </li>
                        <li>
                            <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FPTracker_Facility_Based_Reports&reportUnit=%2Freports%2FPTracker_Facility_Based_Reports%2FPTracker_Patient_Missed_Appointment_List_&standAlone=true" target="_blank"> -- PTracker Missed Appointments</a>
                        </li>
                        <li>
                            <a https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FPTracker_Facility_Based_Reports&reportUnit=%2Freports%2FPTracker_Facility_Based_Reports%2FPTracker_Patient_Transfered_in_List_&standAlone=true" target="_blank"> -- PTracker Tranfered In</a>
                        </li>
                        <li>
                            <a https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FPTracker_Facility_Based_Reports&reportUnit=%2Freports%2FPTracker_Facility_Based_Reports%2FPTracker_Patient_Transfered_out_List_&standAlone=true" target="_blank"> -- PTracker Transfered out</a>
                        </li>
                      </ul>
                <h2> Dashboards </h2>
                <!-- <ul>
                    <li>
                        <a href="https://ptracker.mhss.gov.na/jasperserver/flow.html/auth-api?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2Freports&reportUnit=%2Freports%2FPMTCT_Outcome_Dashboard&standAlone=true#" target="_blank"> -- PMTCT Outcome</a>
                    </li>
                </ul> -->
            </div>
        </div>
    </div>