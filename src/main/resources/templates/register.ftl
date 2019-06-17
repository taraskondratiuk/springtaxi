<#import "parts/common.ftl" as c>


<@c.page>
    Add new user
    <#if message??>
        ${message}
    </#if>
<div ng-app="ngpatternApp" ng-controller="ngpatternCtrl">
    <form action="/register" method="post" name="regForm" ng-submit="regForm.$valid  " novalidate >

        <label> User Name : <input type="text" name="login" ng-model="txtlogin" ng-pattern="/^[A-Za-z0-9]{4,15}$/" required /></label>

        <span style="color:Red" ng-show="regForm.login.$touched&&regForm.login.$error.required"> Required! </span>

        <span style="color:Red" ng-show="regForm.login.$touched&&regForm.login.$error.pattern">Wrong login</span>

        <br /><br />
        <label> Password : <input type="password" name="password" ng-model="txtpw" ng-pattern="/^[A-Za-z0-9]{6,15}$/" required /></label>

        <span style="color:Red" ng-show="regForm.password.$touched&&regForm.password.$error.required"> Required! </span>

        <span style="color:Red" ng-show="regForm.password.$touched&&regForm.password.$error.pattern">Wrong pw</span>

        <br /><br />
        <div><label> Social Status : <select name="socialStatus">
                    <#list statuses as s >
                        <option>
                            ${s}
                        </option>
                    </#list>
                </select></label></div>
        <br/>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button ng-disabled="regForm.login.$invalid || regForm.password.$invalid" type="submit" >Submit Form</button><br /><br />



    </form>
</div>
</@c.page>
