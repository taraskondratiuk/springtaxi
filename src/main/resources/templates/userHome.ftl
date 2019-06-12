<#import "parts/common.ftl" as c/>

<@c.page>
    <#if success??>
        success

    <#elseif cancel>
        cancel
    </#if>
    <a href="/user/order">${rca.getMessage("message.order")}</a>
    <a href="/user/history">${rca.getMessage("message.history")}</a>
</@c.page>
