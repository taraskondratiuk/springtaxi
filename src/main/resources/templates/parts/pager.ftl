<#macro pager url page>
          <#assign body = 1..page.getTotalPages()>

   <#-- <div class="mt-3">-->
        <ul class="pagination">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">${rca.getMessage("message.page")}</a>
            </li>
            <#list body as p>
                <#if (p - 1) == page.getNumber()>
                    <li class="page-item active">
                        <a class="page-link" href="#" tabindex="-1">${p}</a>
                    </li>

                <#else>
                    <li class="page-item">
                        <a class="page-link" href="${url}?page=${p - 1}" tabindex="-1">${p}</a>
                    </li>
                </#if>
            </#list>
        </ul>

</#macro>