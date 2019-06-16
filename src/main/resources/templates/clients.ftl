<#import "parts/common.ftl" as c>
<#import "parts/pager.ftl" as p>
<@c.page>




    <div>
        <p>${rca.getMessage("message.clients")}</p>

    </div>
    <div>

        <table class="table">
            <thead>
            <tr>
                <td class="col-lg-2"><b>${rca.getMessage("message.login")}</b></td>
                <td class="col-lg-2"><b>${rca.getMessage("message.socialstatus")}</b></td>
                <td class="col-lg-2"><b>${rca.getMessage("message.numrides")}</b></td>
                <td class="col-lg-2"><b>${rca.getMessage("message.totalspent")}</b></td>
                <td class="col-lg-2"><b>${rca.getMessage("message.time")}</b></td>
                <td class="col-lg-2"><b>${rca.getMessage("message.mostcommon")}</b></td>
            </tr>
            </thead>
            <tbody>

            <#list page.content as d>
                <tr>
                    <td>
                        ${d.login}
                    </td>
                    <td>
                        ${d.socialStatus}
                    </td>
                    <td>
                        ${d.numRides}
                    </td>
                    <td>
                        <#if d.totalSpentValue??>
                            ${d.totalSpentValue}
                        <#else >
                            0
                        </#if>

                    </td>
                    <td>
                        <#if d.totalTime??>
                            ${d.totalTime}
                        <#else >
                            0
                        </#if>

                    </td>
                    <td>
                        <#if d.mostCommonCarType??>
                            ${d.mostCommonCarType}
                        <#else >
                            -
                        </#if>
                    </td>

                </tr>

            <#--${rca.getMessage("message.noorders")}-->
            </#list>

            </tbody>
        </table>

        <@p.pager url page/>


    </div>

    <div>
        <a href="/admin/home">${rca.getMessage("message.home")}</a>
    </div>

</@c.page>