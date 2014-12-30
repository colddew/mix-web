<#macro getResourceNames role>
	<#if (role.resources)?? && role.resources?size gt 0>
		<#list role.resources as resource>
			${resource.resDesc}<#t>
			<#if resource_has_next>,<#t></#if>
			<#t>
		</#list>
	</#if>
</#macro>

<#assign hadResourceIds=[] />
<#if (role.resources)?? && role.resources?size gt 0>
	<#list role.resources as resource>
		<#assign hadResourceIds = hadResourceIds + ['${resource.resId}'] />
	</#list>
</#if>

<#assign hadRoleIds=[] />
<#if (user.roles)?? && user.roles?size gt 0>
	<#list user.roles as role>
		<#assign hadRoleIds = hadRoleIds + ['${role.roleId}'] />
	</#list>
</#if>





