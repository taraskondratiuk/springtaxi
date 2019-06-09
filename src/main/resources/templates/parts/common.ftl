<#macro page>
    <#import "/spring.ftl" as spring/>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Taxi app</title>
        <link rel="stylesheet" type="text/css"
        href="<@spring.url '/css/bootstrap.css'/>"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css"
              href="<@spring.url '/css/styles.css'/>"/>
    </head>
    <body>
    <#include "header.ftl">
    <div class="body-wrapper container col-xl-12 col-md-12 col-lg-12">
        <#nested>
    </div>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
    </script>

    <script type="application/javascript">
    function switchUA() {
        window.location.replace(window.location.origin + window.location.pathname + '?lang=UA');
    }
    function switchUS() {
        window.location.replace(window.location.origin + window.location.pathname + '?lang=US');
    }
</script>
    </html>
</#macro>