
<%
    ui.decorateWith("uicommons", "html5")
    ui.includeCss("uicommons", "styleguide/index.css")
    ui.includeCss("uicommons", "styleguide/jquery.toastmessage.css")
    ui.includeCss("uicommons", "styleguide/jquery-ui-1.9.2.custom.min.css")
    ui.includeJavascript("uicommons", "jquery-1.12.4.min.js");
    ui.includeJavascript("uicommons", "bootstrap-scrollspy.js");
    ui.includeJavascript("uicommons", "typeahead.js");
    ui.includeJavascript("uicommons", "script.js");
    ui.decorateWith("appui", "standardEmrPage", [ title: ui.message("Frequently Asked Questions") ])
%>
<script type="text/javascript"> var breadcrumbs = [ {icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm'}, {label: "Frequently Asked Questions"} ] </script>
<div class="content">
    <div class="header"><h1> PTracker Job Aids and Frequently Asked Questions</h1></div>
        <table>
            <tr><td style="width: 450px"><h4>Job Aids</h4></td><td style="width: 450px"><h4> Other Resources </h4></td></tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/1.4_How_to_Login_to_PTracker_May2018.pdf")}" target="_blank"> How to Login </a></td>
                <td><a href="${ui.resourceLink("namibia", "/faq/0_Introduction_Coverpage_May2018.pdf")}" target="_blank"> General Information on PTracker System </a></td></tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/2_How_to_Register_or_Create_a_New_Client_Record_May2018.pdf")}" target="_blank"> How to Register New Patient </a></td>
                <td><a href="${ui.resourceLink("namibia", "/faq/9_PTracker_User_Access_Request_Form.pdf")}" target="_blank"> PTracker User Access Request Form</a></td>
            </tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/3_How_to_Record_a_First_ANC_visit_in_PTracker_May2018.pdf")}" target="_blank"> How to Complete First ANC Visit </a></td>
                <td><a href="${ui.resourceLink("namibia", "/faq/Appendix_a_Facility codes.pdf")}"  target="_blank"> Facility Codes</a></td>
            </tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/4_How_to_Record_a_Follow_up_ANC_visit_in_PTracker_May2018.pdf")}" target="_blank"> How to Complete Followup ANC Visit </a></td>
                <td><a href="${ui.resourceLink("namibia", "/faq/1.1_SOP_DataEntry-Hardware_PTracker_May2018.pdf")}" target="_blank"> Data Entry and Submission in PTracker </a></td>
            </tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/5_How_to_Record_a_L&D_visit_May2018.pdf")}" target="_blank"> How to Complete Labor and Delivery Visit </a></td>
                <td><a href="${ui.resourceLink("namibia", "/faq/1.2_ODK_Collect_KS_May2018.pdf")}" target="_blank"> How to use ODK Collect </a></td>
            </tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/6_How_to_Record_a_Mother_PNC_May2018.pdf")}" target="_blank"> How to Complete Mother PNC Visit </a></td>
                <td><a href="${ui.resourceLink("namibia", "/faq/1.3_PTracker_SOP_Equipment_Use_Guidelines_May_2018.pdf")}" target="_blank"> Guiding Principles for PTracker Equipment </a></td></tr>
            </tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/7_How_to_Record_an_Infant_PNC_visit_May2018.pdf")}" target="_blank"> How to Complete Infant PNC Visit</a></td>
                <td></td>
            </tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/8_How_to_link_an_HIV_Exposed_Infant_May2018.pdf")}" target="_blank"> How to Link Infant to a Mother in Infant PNC Visit </a></td>
                <td></td>
            </tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/9_How_to_view_or_edit_a_record_in_PTracker_may2018.pdf")}" target="_blank"> How To Edit Or View a Previously Captured Encounter In PTracker </a></td>
                <td></td>
            </tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/10_How_to_generate_a_PTracker_ID_May2018.pdf")}" target="_blank"> How to Generate PTracker ID </a></td><td></td></tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/Revised_Namibia_PMTCT_Tracker_User_Guide_May2018.pdf")}"  target="_blank"> Complete PTracker User guide Version 1.0 </a></td><td></td></tr>
            <tr><td colspan="2"><h4> Release Notes </h4></td></tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/6.9_PTracker_1.2_Release_Notes_Oct_2017.pdf")}" target="_blank">PTracker Version 1.2 Release Notes </a></td><td></td></tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/PTracker-Release-notes-version-1.3.pdf")}" target="_blank">PTracker Version 1.3 Release Notes </a></td><td></td></tr>
            <tr><td colspan="2"><h4> FAQ </h4></td></tr>
            <tr><td><a href="${ui.resourceLink("namibia", "/faq/11_Frequently_Asked_Questions_May2018.pdf")}" target="_blank">Frequenty Asked Questions </a></td><td></td></tr>
        </table>
    <br/>
        <div class="footer" style="color: #848484;font-size: 0.8em;float: left; width: 100%; text-align: center;">
            PTracker Powered by OpenMRS | &#169;<a href="http://www.mhss.gov.na/" target="_blank" title="Ministry of Health and Social Services">MoHSS Namibia</a> | Contact : (+264 814673349 / +264 814673343) | Developed by the <a href="http://globalhealthsciences.ucsf.edu/" target="_blank" title="Institute of Global Health Sciences">University of California, San Francisco.</a>
        </div><br/>
</div>
