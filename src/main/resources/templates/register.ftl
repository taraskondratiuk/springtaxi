<#import "parts/common.ftl" as c>


<@c.page>
    Add new user
    <#if message??>
        ${message}
    </#if>

    <form action="/register" method="post">
        <div><label> User Name : <input type="text" name="login"/> </label></div>
        <div><label> Password : <input type="password" name="password"/> </label></div>
        <div><label> Social Status : <select name="socialStatus">
                <#list statuses as s >
                    <option>
                        ${s}
                    </option>
                </#list>
                </select></label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Sign In"/></div>
    </form>
</@c.page>
