<#import "parts/common.ftl" as c/>
<#import "spring.ftl" as spring/>
<@c.page>

    <div class="container">
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


    <a href="/admin/cars">${rca.getMessage("message.cars")}</a>
    <a href="/admin/clients">${rca.getMessage("message.clients")}</a>
    <a href="/admin/changepw">${rca.getMessage("message.changepw")}</a>
</@c.page>
