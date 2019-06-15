<#import "parts/common.ftl" as c>

<@c.page>

    <#if !cars??>
    <div><h3>${rca.getMessage("message.discount")} : ${discount}%</h3></div>
        <div  ng-app="selectboxApp" ng-controller="selectboxCtrl">
    <form action="/user/order" method="post" >
        <div>
            <label> ${rca.getMessage("message.initial")} <select name="initPlace" ng-model="placeStart" >
                    <option value="">choose 1 street</option>
                    <#list streets as s >
                        <option  value="${s}">
                            ${s}
                        </option>
                    </#list>
                </select></label></div>
        <div>
            <div>
                <label> ${rca.getMessage("message.dest")} <select name="destPlace"  ng-model="placeEnd"  >
                        <option value="">choose 2 street</option>
                        <#list streets as s >
                            <option value="${s}">
                                ${s}
                            </option>
                        </#list>
                    </select></label></div>
            <div>
                <label> ${rca.getMessage("message.type")} <select name="carType"  ng-model="typeCar" >
                        <option value="">type</option>
                        <#list types as t >
                            <option value="${t}" >
                                ${t}
                            </option>
                        </#list>
                    </select></label></div>
            <span style="color:red">{{msg}}</span><br />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div>
                <input type="submit" id="mysubmit"/>
                <input type="button" value="${rca.getMessage("message.confirm")}"  ng-click="checkselection()"/>

            </div>
    </form>


        </div>
<#--
        <body  ng-app="selectboxApp" ng-controller="selectboxCtrl"
        <div>
            <h3>AngularJS Select Box / Dropdown List Validation Example</h3>
            <select name="users" ng-model="userSelect">
                <option value="">--Select User--</option>
                <option ng-repeat="option in arrlist" value="{{option.userid}}">{{option.name}}</option>
            </select>
        </div><br /><br />
        <input type="button" value="Submit" ng-click="checkselection()" /><br /><br />
        <span style="color:red">{{msg}}</span><br />
        </body>
-->


    <#elseif cars?? && !car??>

        <form action="/user/order" method="post">
            <div>
                <label> ${rca.getMessage("message.car")} </label>
                        <table class="table">
                            <thead>
                                <tr>
                                    <td><b>${rca.getMessage("message.make")}</b></td>
                                    <td><b>${rca.getMessage("message.place")}</b></td>

                                    <td hidden></td>
                                </tr>
                            </thead>
                            <tbody>
                                <#list cars as car>
                                    <tr>
                                        <td>
                                            ${car.make}
                                        </td>
                                        <td>
                                            ${car.place}
                                        </td>

                                        <td>
                                            <input type="radio" name="carId" value="${car.idcars}"  />



                                        </td>
                                    </tr>
                                </#list>
                            </tbody>
                        </table>
                    </div>
            <input type="hidden" name="carType" value="${RequestParameters.carType}" />
            <input type="hidden" name="initPlace" value="${RequestParameters.initPlace}" />
            <input type="hidden" name="destPlace" value="${RequestParameters.destPlace}" />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="submit" value="${rca.getMessage("message.choose")}" />
        </form>

<#else>
    <br>

    chosen car: ${car.type} ${car.make}
    order time: ${rideTime}
    price: ${price}
        w8 time: ${waitTime}

    <form action="/user/history" method="post">
        <input type="hidden" name="carId" value="${RequestParameters.carId}" />
        <input type="hidden" name="timeId" value="${timeId.id}" />
        <input type="hidden" name="price" value="${price}" />
        <input type="hidden" name="waitTime" value="${waitTime}" />
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="${rca.getMessage("message.confirm")}"/>
    </form>
</#if>

    <form action="/user/home" method="get">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />

        <div>
            <input type="hidden" name="cancel" value="cancel" />
            <input type="submit" value="${rca.getMessage("message.cancel")}" />

        </div>
    </form>


</@c.page>