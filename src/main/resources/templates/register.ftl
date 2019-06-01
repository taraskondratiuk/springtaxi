<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form Data Binding and Validation</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<h2>Form Data Binding and Validation</h2>

<@spring.bind "client"/>
<#if login_error??>
    this login is already taken
</#if>
<#if client?? && noErrors??>
    Your submitted data<br>
    First name: ${client.login}<br>
    Last name: ${client.password}<br>
    Email: ${client.socialStatus}<br>
<#else>
    <form action="/register" method="post">
        login<br>
        <@spring.formInput "client.login"/>
        <@spring.showErrors "<br>"/>
        <br><br>
        pw<br>
        <@spring.formInput "client.password"/>
        <@spring.showErrors "<br>"/>
        <br><br>
        socialStatus<br>
        <@spring.formInput "client.socialStatus"/>
        <@spring.showErrors "<br>"/>
        <br><br>
        <button type="submit" value="Submit">
    </form>
</#if>


</body>
</html>