<#import "/spring.ftl" as spring/>
<section class="section-1 head_wrapper">
    <header class="header container">
        <div class="headline row ">
            <div class="logo col-lg-2">
                <img class="logo-img" src="<@spring.url '/sources/taxi-logo.png'/>" alt="logo">
            </div>
            <div class="head_info col-lg-8">
                <h2>${rca.getMessage("message.taxi")}</h2>
            </div>
            <div class = "col-lg-2 lang-images">
                <input type="image" src="<@spring.url '/sources/ua-flag.png'/>" alt="UA" onclick="switchUA();" />
                <input type="image" src="<@spring.url '/sources/us-flag.png'/>" alt="US" onclick="switchUS();" />
            </div>




        </div>










    </header>
</section>
