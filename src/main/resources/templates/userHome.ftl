<#import "parts/common.ftl" as c/>
<#import "spring.ftl" as spring/>
<@c.page>

    <div class="container">
        <div class="paddingtop col-lg-12">

        </div>
        <div class="row">
            <div class="col-lg-offset-2 col-lg-8 ">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-lg-5 ">
                            <img src="<@spring.url '/sources/profile-pic.png'/>" alt="profile-pic" class="img-rounded img-responsive profile-img" />
                        </div>
                        <div class="col-lg-offset-1 col-lg-6">
                            <br />
                            <h4>
                                ${client.login}</h4>
                            <br />
                            <p>
                                ${rca.getMessage("message.role")} : ${client.role}
                                <br />
                                ${rca.getMessage("message.totalspent")} : ${client.totalSpentValue}
                                <br />
                                ${rca.getMessage("message.personaldiscount")} : ${client.personalDiscount}%
                                <br />
                                ${rca.getMessage("message.specialdiscount")} : ${specialdiscount}%
                                <br />
                            ${rca.getMessage("message.socialstatus")} : ${client.socialStatus}
                            <br />
                            ${rca.getMessage("message.orders")} : ${numRides}</p>

                            <!-- Split button -->
                            <#--<div class="btn-group">
                                <button type="button" class="btn btn-primary">
                                    Social</button>
                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                                    <span class="caret"></span><span class="sr-only">Social</span>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Twitter</a></li>
                                    <li><a href="https://plus.google.com/+Jquery2dotnet/posts">Google +</a></li>
                                    <li><a href="https://www.facebook.com/jquery2dotnet">Facebook</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Github</a></li>
                                </ul>
                            </div>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#if success??>
        success

    <#elseif cancel>
        cancel
    </#if>
<div class="col-lg-offset-2 col-lg-8 ">
    <a href="/user/order"><button type="button" class="btn-lg btn-info">${rca.getMessage("message.order")}</button></a>
    <a href="/user/history"><button type="button" class="btn-lg btn-info">${rca.getMessage("message.history")}</button></a>
    <a href="/user/changepw"><button type="button" class="btn-lg btn-info">${rca.getMessage("message.changepw")}</button></a>
</div>
</@c.page>
