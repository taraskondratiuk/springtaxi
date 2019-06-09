

<#--
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Yourapp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<#if logout>
    logout
</#if>
<#if error>
    error
</#if>
<form method="post">
    <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
    <input type="text" id="username" placeholder="Username" name="username">
    <br/>
    <input type="password" id="password" placeholder="Password" name="password">
<br/>
    <button type="submit" >zavadi</button>
</form>
</body>
</html>-->
<#import "parts/common.ftl" as c>
<@c.page>
    login page

    <form action="/login" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Sign In"/></div>
    </form>
</@c.page>
