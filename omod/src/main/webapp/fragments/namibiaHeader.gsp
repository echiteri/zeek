<%
    def addContextPath = {
        if (!it)
            return null
        if (it.startsWith("/")) {
            it = "/" + org.openmrs.ui.framework.WebConstants.CONTEXT_PATH + it
        }
        return it
    }

    def logoIconUrl = addContextPath(configSettings?."logo-icon-url") ?: ui.resourceLink("namibia", "images/namibia_coat_of_arms.png")
    def logoLinkUrl = addContextPath(configSettings?."logo-link-url") ?: "/${org.openmrs.ui.framework.WebConstants.CONTEXT_PATH}"

    def multipleLoginLocations = (loginLocations.size > 1);

    def enableUserAccountExt = userAccountMenuItems.size > 0;

%>
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
<script type="text/javascript">

    var sessionLocationModel = {
        id: ko.observable(),
        text: ko.observable()
    };

    jq(function () {

        ko.applyBindings(sessionLocationModel, jq('.change-location').get(0));
        sessionLocationModel.id(${ sessionContext.sessionLocationId });
        sessionLocationModel.text("${ ui.format(sessionContext.sessionLocation) }");

        // we only want to activate the functionality to change location if there are actually multiple login locations
        <% if (multipleLoginLocations) { %>

        jq(".change-location a").click(function () {
            jq('#session-location').show();
            jq(this).addClass('focus');
            jq(".change-location a i:nth-child(3)").removeClass("icon-caret-down");
            jq(".change-location a i:nth-child(3)").addClass("icon-caret-up");
        });

        jq('#session-location').mouseleave(function () {
            jq('#session-location').hide();
            jq(".change-location a").removeClass('focus');
            jq(".change-location a i:nth-child(3)").addClass("icon-caret-down");
            jq(".change-location a i:nth-child(3)").removeClass("icon-caret-up");
        });

        jq("#session-location ul.select li").click(function (event) {
            var element = jq(event.target);
            var locationId = element.attr("locationId");
            var locationName = element.attr("locationName");

            var data = {locationId: locationId};

            jq("#spinner").show();

            jq.post(emr.fragmentActionLink("appui", "session", "setLocation", data), function (data) {
                sessionLocationModel.id(locationId);
                sessionLocationModel.text(locationName);
                jq('#session-location li').removeClass('selected');
                element.addClass('selected');
                jq("#spinner").hide();
                jq(document).trigger("sessionLocationChanged");
            })

            jq('#session-location').hide();
            jq(".change-location a").removeClass('focus');
            jq(".change-location a i:nth-child(3)").addClass("icon-caret-down");
            jq(".change-location a i:nth-child(3)").removeClass("icon-caret-up");
        });

        <% if (enableUserAccountExt) { %>
        jq('.identifier').hover(
                function () {
                    jq('.appui-toggle').show();
                    jq('.appui-icon-caret-down').hide();
                },
                function () {
                    jq('.appui-toggle').hide();
                    jq('.appui-icon-caret-down').show();
                }
        );
        jq('.identifier').css('cursor', 'pointer');
        <% } %>
        <% } %>
    });



</script>
<header>
    <div class="logo">
        <a href="${logoLinkUrl}">
            <img src="${logoIconUrl}" style="height: 70px; width: 70px; background: whitesmoke; padding: 5px;"/>
        </a>
    </div>

    <div style="float: left;margin: 25px 0 10px 20px; color: #EFEF;width: 350px;">
        <div style="padding-bottom: 10px;">
            <span style="font-size: 1.2em; text-align: left;color: #FFFFFF;">Ministry of Health and
            Social
            Services</span>
        </div>
        <span style="color: #848484;font-size: 0.9em;float: left; width: 100%; text-align: center;">PMTCT Tracker</span><br/><br/>
        <span style="float: left; width: 100%; text-align: center;"><a href="${ui.pageLink("namibia", "faqDialog")}">${ui.message("Help")}</a></span>
    </div>

    <% if (context.authenticated) { %>
    <ul class="user-options" style="padding: 20px;">
        <li class="identifier">
            <i class="icon-user small"></i>
            ${context.authenticatedUser.username ?: context.authenticatedUser.systemId}
            <% if (enableUserAccountExt) { %>
            <i class="icon-caret-down appui-icon-caret-down link"></i><i class="icon-caret-up link appui-toggle"
                                                                         style="display: none;"></i>
            <ul id="user-account-menu" class="appui-toggle">
                <% userAccountMenuItems.each { menuItem -> %>
                <li>
                    <a id="" href="/${contextPath}/${menuItem.url}">
                        ${ui.message(menuItem.label)}
                    </a>
                </li>
                <% } %>
            </ul>
            <% } %>
        </li>
        <li class="change-location">
            <a href="javascript:void(0);">
                <i class="icon-map-marker small"></i>
                <span data-bind="text: text"></span>
                <% if (multipleLoginLocations) { %>
                <i class="icon-caret-down link"></i>
                <% } %>
            </a>
        </li>
        <li class="logout">
            <a href="/${contextPath}/logout">
                ${ui.message("emr.logout")}
                <i class="icon-signout small"></i>
            </a>
        </li>
    </ul>

    <div id="session-location">
        <div id="spinner" style="position:absolute; display:none">
            <img src="${ui.resourceLink("uicommons", "images/spinner.gif")}">
        </div>
        <ul class="select">
            <% loginLocations.sort { ui.format(it) }.each {
                def selected = (it == sessionContext.sessionLocation) ? "selected" : ""
            %>
            <li class="${selected}" locationId="${it.id}" locationName="${ui.format(it)}">${ui.format(it)}</li>
            <% } %>
        </ul>
    </div>
    <% } %>
</header>