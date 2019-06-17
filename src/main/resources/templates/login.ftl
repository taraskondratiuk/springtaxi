

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
    <h3>login page</h3>

    <#if logout>
        logout
    </#if>
    <#if error>
        error
    </#if>


    <div ng-app="ngpatternApp" ng-controller="ngpatternCtrl">



        <form action="/login" method="post" id="loginForm" name="loginForm" ng-submit="loginForm.$valid" novalidate >

            <label> User Name : <input type="text" name="username" ng-model="txtlogin" ng-pattern="/^[A-Za-z0-9]{4,15}$/" required /></label>

           <span style="color:Red" ng-show="loginForm.username.$touched&&loginForm.username.$error.required"> Required! </span>

            <span style="color:Red" ng-show="loginForm.username.$touched&&loginForm.username.$error.pattern">Wrong login</span>

            <br /><br />
            <label> Password : <input type="password" name="password" ng-model="txtpw" ng-pattern="/^[A-Za-z0-9]{6,15}$/" required /></label>

            <span style="color:Red" ng-show="loginForm.password.$touched&&loginForm.password.$error.required"> Required! </span>

            <span style="color:Red" ng-show="loginForm.password.$touched&&loginForm.password.$error.pattern">Wrong pw</span>

            <br /><br />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button ng-click="submit($event)" ng-disabled="loginForm.username.$invalid || loginForm.password.$invalid" >Submit Form</button><br /><br />



        </form>

    </div>

 <#--   <form action="/login" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Sign In"/></div>
    </form>-->
</@c.page>
