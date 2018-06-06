
<%
    ui.decorateWith("uicommons", "html5")
    ui.includeCss("uicommons", "styleguide/index.css")
    ui.includeCss("uicommons", "styleguide/jquery.toastmessage.css")
    ui.includeCss("uicommons", "styleguide/jquery-ui-1.9.2.custom.min.css")
    ui.includeJavascript("uicommons", "jquery-1.12.4.min.js");
    ui.includeJavascript("uicommons", "bootstrap-scrollspy.js");
    ui.includeJavascript("uicommons", "typeahead.js");
    ui.includeJavascript("uicommons", "script.js");
    //ui.decorateWith("appui", "standardEmrPage", [ title: ui.message("Frequently Asked Questions") ])
%>
<script type="text/javascript"> var breadcrumbs = [ {icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm'}, {label: "Frequently Asked Questions"} ] </script>
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
        <br/><br/>
        <span style="float: left; width: 100%; text-align: center;"><a href="${ui.pageLink("namibia", "faqDialog")}">${ui.message("Help")}</a></span>
    </div>
</header>
<div id="body-wrapper" class="style-guide">

    <div id="content" style=" margin: 20px;  ">
        <div id="header">
            <h1 style="align-content: center"> PTracker Job Aids and Frequently Asked Questions</h1>
            </div>
                <table style="width: auto">
                    <tr><td><h4>Job Aids</h4></td><td><h4> Other Resources </h4></td></tr>
                    <tr><td><a href="${ui.resourceLink("namibia", "/faq/6.1_Login_Job_Aid.pdf")}" target="_blank"> How to Login </a></td>
                        <td><a href="${ui.resourceLink("namibia", "/faq/8_Faciity_codes.pdf")}"  target="_blank"> Facility Codes</a></td></tr>
                    <tr><td><a href="${ui.resourceLink("namibia", "/faq/6.2_New_Patient_Registration_Job_Aid.pdf")}" target="_blank"> How to Register New Patient </a></td>
                        <td><a href="${ui.resourceLink("namibia", "/faq/9_PTracker_User_Access_Request_Form.pdf")}" target="_blank"> PTracker User Access Request Form</a></td>
                    </tr>
                    <tr><td><a href="${ui.resourceLink("namibia", "/faq/6.3_FirstANC_Job_Aid.pdf")}" target="_blank"> How to Complete First ANC Visit </a></td>
                        <td><a href="${ui.resourceLink("namibia", "/faq/1_General_Information_on_PTracker_System.pdf")}" target="_blank"> General Information on PTracker System </a></td>
                    </tr>
                    <tr><td><a href="${ui.resourceLink("namibia", "/faq/6.4_Followup_ANC_Job_Aid.pdf")}" target="_blank"> How to Complete Followup ANC Visit </a></td>
                        <td><a href="${ui.resourceLink("namibia", "/faq/1.2_PTracker_User_Access_Roles_&_Management.pdf")}" target="_blank">PTracker User Access Roles and Management </a></td>
                    </tr>
                    <tr><td><a href="${ui.resourceLink("namibia", "/faq/6.5_L&D_Visit_ Job_Aid.pdf")}" target="_blank"> How to Complete Labor and Delivery Visit </a></td>
                        <td><a href="${ui.resourceLink("namibia", "/faq/2_Data_Entry_and_Submission_in_PTracker.pdf")}" target="_blank"> Data Entry and Submission in PTracker </a></td>
                    </tr>
                    <tr><td><a href="${ui.resourceLink("namibia", "/faq/6.6_Mother_PNC_Job_Aid.pdf")}" target="_blank"> How to Complete Mother PNC Visit </a></td>
                        <td><a href="${ui.resourceLink("namibia", "/faq/3_PTracker_Support_and_Numbers.pdf")}" target="_blank"> PTracker Support and Numbers </a></td>
                    </tr>
                    <tr><td><a href="${ui.resourceLink("namibia", "/faq/6.7_Infant_PNC_Visit_ Job_Aid.pdf")}" target="_blank"> How to Complete Infant PNC Visit</a></td>
                        <td><a href="${ui.resourceLink("namibia", "/faq/4_How_to_use_ODK_Collect.pdf")}" target="_blank"> How to use ODK Collect </a></td>
                    </tr>
                    <tr><td><a href="${ui.resourceLink("namibia", "/faq/6.8_How_to_Link_Mother_infant_in_PNC_Job_Aid.pdf")}" target="_blank"> How to Link Infant to a Mother in Infant PNC Visit </a></td>
                        <td><a href="${ui.resourceLink("namibia", "/faq/5_Guiding_Principles_for_PTracker_Equipment.pdf")}" target="_blank"> Guiding Principles for PTracker Equipment </a></td></tr>
                    <tr><td><a href="${ui.resourceLink("namibia", "/faq/7_How_to_generate_PTracker_ID.pdf")}" target="_blank"> How to Generate PTracker ID </a></td><td></td></tr>
                    <tr><td><a href="${ui.resourceLink("namibia", "/faq/Namibia_PMTCT_Tracker_User_Guide_August2017.pdf")}"  target="_blank"> Complete PTracker User guide Version 0.02 </a></td><td></td></tr>
                    <tr><td colspan="2"><h4> Release Notes </h4></td></tr>
                    <tr><td><a href="${ui.resourceLink("namibia", "/faq/6.9_PTracker_1.2_Release_Notes_Oct_2017.pdf")}" target="_blank">PTracker Version 1.2 Release Notes </a></td><td></td></tr>
                    <tr><td><a href="${ui.resourceLink("namibia", "/faq/PTracker-Release-notes-version-1.3.pdf")}" target="_blank">PTracker Version 1.3 Release Notes </a></td><td></td></tr>
                    <tr><td colspan="2"><h4> FAQ </h4></td></tr>
                    <tr><td><a href="${ui.resourceLink("namibia", "/faq/Frequently_Asked_Questions.pdf")}" target="_blank">Frequenty Asked Questions </a></td><td></td></tr>
                </table>
            <div id="footer" style="color: #848484;font-size: 0.7em;float: left; width: 100%; text-align: center;">
                PTracker Powered by OpenMRS | MoHSS Namibia Copyrighted | Contact : (+264 814673349 / +264 814673343)
            </div>
        </div>
    </div>
