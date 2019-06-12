<#import "parts/common.ftl" as c>
<@c.page>
    ${rca.getMessage("message.welcome")}
    <#if success_reg??>
        successful reg
    </#if>
    <a href="/login">login</a>
    <a href="/register">register</a>
</@c.page>
