<#macro getResourceNames role>
	<#if (role.resources)?? && role.resources?size gt 0>
		<#list role.resources as resource>
			${resource.resDesc}<#t>
			<#if resource_has_next>,<#t></#if>
			<#t>
		</#list>
	</#if>
</#macro>