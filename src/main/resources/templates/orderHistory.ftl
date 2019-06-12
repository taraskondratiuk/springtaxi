<#import "parts/common.ftl" as c>

<@c.page>


    <div>
        <p>${rca.getMessage("message.history")}</p>

    </div>
    <div>


        <table class="table">
            <thead>
            <tr>
                <td class="col-lg-2"><b>${rca.getMessage("message.initial")}</b></td>
                <td class="col-lg-2"><b>${rca.getMessage("message.dest")}</b></td>
                <td class="col-lg-2"><b>${rca.getMessage("message.cartype")}</b></td>
                <td class="col-lg-2"><b>${rca.getMessage("message.make")}</b></td>
                <td class="col-lg-2"><b>${rca.getMessage("message.time")}</b></td>
                <td class="col-lg-2"><b>${rca.getMessage("message.price")}</b></td>


            </tr>
            </thead>
            <tbody>
            <#list details as d>
                <tr>
                    <td>
                        ${d.initPlace}
                    </td>
                    <td>
                        ${d.destPlace}
                    </td>
                    <td>
                        ${d.carType}
                    </td>
                    <td>
                        ${d.carMake}
                    </td>
                    <td>
                        ${d.time}
                    </td>
                    <td>
                        ${d.price}
                    </td>

                </tr>
                <#else >
                    ${rca.getMessage("message.noorders")}
            </#list>

            </tbody>
        </table>


    </div>
    <div>
        <a href="/user/home">${rca.getMessage("message.home")}</a>
    </div>
</@c.page>