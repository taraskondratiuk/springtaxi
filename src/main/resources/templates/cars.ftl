<#import "parts/common.ftl" as c>
<#import "parts/pager.ftl" as p>
<@c.page>




    <div>
        <p>${rca.getMessage("message.cars")}</p>

    </div>
    <div>

            <table class="table">
                <thead>
                <tr>
                    <td class="col-lg-2"><b>${rca.getMessage("message.id")}</b></td>
                    <td class="col-lg-2"><b>${rca.getMessage("message.make")}</b></td>
                    <td class="col-lg-2"><b>${rca.getMessage("message.cartype")}</b></td>
                    <td class="col-lg-2"><b>${rca.getMessage("message.numrides")}</b></td>
                    <td class="col-lg-2"><b>${rca.getMessage("message.totalearned")}</b></td>
                    <td class="col-lg-2"><b>${rca.getMessage("message.totaltime")}</b></td>
                </tr>
                </thead>
                <tbody>

                <#list page.content as d>
                    <tr>
                        <td>
                            ${d.id}
                        </td>
                        <td>
                            ${d.carMake}
                        </td>
                        <td>
                            ${d.carType}
                        </td>
                        <td>
                            ${d.numRides}
                        </td>
                        <td>
                            <#if d.totalEarned??>
                                ${d.totalEarned}
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