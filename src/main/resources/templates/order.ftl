<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Yourapp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<#--
<@spring.formMultiSelect path ="from" options="">
    from :
    <#list streets as item>
        <@spring.formMultiSelect "from" "${item}" "text"/>
    </#list>
</@spring.formMultiSelect>-->


<#--<#list streets as item>
<@spring.formMultiSelect "ride.initialPlace" "${item}" />
</#list>-->
<#if chosenStreets??>

    from : ${ride.initialPlace}
    <br/>
    to : ${ride.destinationPlace}

<br/>
    ${car.type}
    <br/>
    <#list availableCars as item>
        <br/>
        ${item.make}
    </#list>

    <br/>
    <form name="" action="" method="POST">
        <@spring.formInput "ride.car_id" "" "text"/>
        <input type="submit" value="Create" />
    </form>
<#else>
<fieldset>
    <legend>Add Person</legend>
    <form name="" action="" method="POST">

        <select>
        <#list streets as item>
        <option>${item}</option>


        </#list>
            </select>
        from: <@spring.formInput "ride.initialPlace" "" "text"/>    <br/>
        to: <@spring.formInput "ride.destinationPlace" "" "text"/>    <br/>
        car type: <@spring.formInput "car.type" "" "text"/>    <br/>

        <input type="submit" value="Create" />
    </form>
</fieldset>
    <br/>
</#if>



</body>
</html>