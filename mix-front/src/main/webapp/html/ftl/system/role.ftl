<#escape x as x!"">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>mix</title>
<link href="${request.contextPath}/html/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="${request.contextPath}/html/css/theme.css" rel="stylesheet" media="screen">
<link href="${request.contextPath}/html/css/mix.css" rel="stylesheet" media="screen">
</head>
<body>
	
	<div class="navbar-wrapper">
		
		<div class="container">
			
			<#include "../navigator.ftl">
			
			<div class="row">
				<div class="table-list">
					<table class="table table-striped" id="resTree">
						<thead>
							<tr>
								<th>角色ID</th>
								<th>角色名称</th>
								<th>角色描述</th>
								<th>拥有的资源</th>
								<@shiro.hasRole name="admin">
									<th>
										操作<a href="${request.contextPath}/role/create.html" class="a-space"> 新 增 </a>
									</th>
								</@shiro.hasRole>
							</tr>
						</thead>
						<tbody>

							<#if allRoles??>
								<#list allRoles as role>
									<tr>
										<td>${role.roleId!''}</td>
										<td>${role.roleName!''}</td>
										<td>${role.roleDesc!''}</td>
										<td>
											<#if (role.resources)?? && role.resources?size gt 0>
												<#list role.resources as resource>
													${resource.resDesc}
													<#if resource_has_next>/</#if>
												</#list>
											</#if>
										</td>
										<@shiro.hasRole name="admin">
											<td>
												<button class="btn btn-xs btn-success" type="button" onclick="updateRole(${role.roleId!''});"> 修  改 </button>
												<button class="btn btn-xs btn-danger btn-space" type="button" onclick="deleteRole(${role.roleId!''});"> 删  除  </button>
											</td>
										</@shiro.hasRole>
									</tr>
								</#list>
							</#if>
	
						</tbody>
					</table>
				</div>
			</div>
						
		</div>
		
	</div>
	
	<script src="${request.contextPath}/html/js/jquery-1.11.1.js"></script>
	<script src="${request.contextPath}/html/js/bootstrap.js"></script>
	<script language="javascript">
        function updateRole(roleId) {
        	if(roleId) {
				location.href = "${request.contextPath}/role/" + roleId + "/update.html";
        	}
        }
        
        function deleteRole(roleId) {
        	if(roleId) {
				location.href = "${request.contextPath}/role/" + roleId + "/delete.html";
        	}
        }
	</script>
</body>
</html>
</#escape>