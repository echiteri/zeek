<%
    ui.decorateWith("appui", "standardEmrPage")
    ui.includeCss("reportingui", "reportsapp/home.css")

    def appFrameworkService = context.getService(context.loadClass("org.openmrs.module.appframework.service.AppFrameworkService"))
    def facility = appFrameworkService.getExtensionsForCurrentUser("org.openmrs.module.namibia.reports.facility")
    def monthly = appFrameworkService.getExtensionsForCurrentUser("org.openmrs.module.namibia.reports.monthly")

    def contextModel = [:]
%>

<script type="text/javascript">
    var breadcrumbs = [
        {icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm'},
        {
            label: "${ ui.message("reportingui.reportsapp.home.title") }", link: "${ ui.pageLink("namibia",
        "reports")
}"
        }
    ];
</script>
<style>
.dashboard .info-container {
    width:45%;
}
</style>
<h2>Reports</h2>
<div class="dashboard clear">
    <div class="info-container column">
        <% if (facility) { %>
        <div class="info-section">
            <div class="info-header"><h3>Facility Reports</h3></div>

            <div class="info-body">
                <ul>
                    <% facility.each { %>
                    <li>
                        ${ui.includeFragment("uicommons", "extension", [extension: it, contextModel: contextModel])}
                    </li>
                    <% } %>
                </ul>
            </div>
        </div>
        <% } %>
    </div>

    <div class="info-container column">
        <% if (monthly) { %>
        <div class="info-section">
            <div class="info-header"><h3>Monthly Reports</h3></div>

            <div class="info-body">
                <ul>
                    <% monthly.each { %>
                    <li>
                        ${ui.includeFragment("uicommons", "extension", [extension: it, contextModel: contextModel])}
                    </li>
                    <% } %>
                </ul>
            </div>
        </div>
        <% } %>
    </div>
</div>