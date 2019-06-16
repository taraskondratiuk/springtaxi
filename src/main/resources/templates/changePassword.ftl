<#import "parts/common.ftl" as c>
<@c.page>
    <#if error??>
        error
    </#if>
    <#if pwchanged??>
        changed
    </#if>
    <div ng-app="ngpatternApp" ng-controller="ngpatternCtrl">
        <form action="/${role}/changepw" method="post" name="changeForm" novalidate >

            <label>old password : <input type="password" name="oldpassword" ng-model="oldpw" ng-pattern="/^[A-Za-z0-9]{6,15}$/" required /></label>

            <span style="color:Red" ng-show="changeForm.oldpassword.$touched&&changeForm.oldpassword.$error.required"> Required! </span>

            <span style="color:Red" ng-show="changeForm.oldpassword.$touched&&changeForm.oldpassword.$error.pattern">Wrong pw</span>



            <br /><br />
            <label>new password : <input type="password" name="newpassword" ng-model="newpw" compare-to="oldpw" ng-pattern="/^[A-Za-z0-9]{6,15}$/" required /></label>

            <span style="color:Red" ng-show="changeForm.newpassword.$touched&&changeForm.newpassword.$error.required"> Required! </span>

            <span style="color:Red" ng-show="changeForm.newpassword.$touched&&changeForm.newpassword.$error.pattern">Wrong pw</span>



            <br /><br />

            <br/>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button ng-disabled="changeForm.oldpassword.$invalid || changeForm.newpassword.$invalid " type="submit">Submit Form</button><br /><br />



        </form>
    </div>
    <a href="/${role}/home">${rca.getMessage("message.home")}</a>
</@c.page>