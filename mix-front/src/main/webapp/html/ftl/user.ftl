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
			
			<#include "navigator.ftl">
			
			<div class="row">
				<div class="table-list">
					<table class="table table-striped" id="resTree">
						<thead>
							<tr>
								<th>用户ID</th>
								<th>用户名</th>
								<th>用户类型</th>
								<th>所属组织</th>
								<th>角色列表</th>
								<th>状态</th>
								<@shiro.hasRole name="admin">
									<th>
										操作
										<@shiro.hasPermission name="user:add">
											<a href="${request.contextPath}/user/create.html" class="a-space"> 新 增 </a>
										</@shiro.hasPermission>
									</th>
								</@shiro.hasRole>
							</tr>
						</thead>
						<tbody>

							<#if allUsers??>
								<#list allUsers as user>
									<tr>
										<td>${user.userId!''}</td>
										<td>${user.userName!''}</td>
										<td>
											<#if (user.userType)??>
												<#if MixConstants.USER_TYPE_SUPER == user.userType>
													超级管理员
												<#elseif MixConstants.USER_TYPE_COMMON == user.userType>
													普通用户
												</#if>
											</#if>
										</td>
										<td>${(user.org.orgDesc)!''}</td>
										<td>
											<#if (user.roles)?? && user.roles?size gt 0>
												<#list user.roles as role>
													${role.roleDesc}
													<#if role_has_next>/</#if>
												</#list>
											</#if>
										</td>
										<td>
											<#if (user.userStatus)??>
												<#if MixConstants.USER_STATUS_UNAVAILABLE == user.userStatus>
													不可用
												<#elseif MixConstants.USER_STATUS_AVAILABLE == user.userStatus>
													可用
												<#elseif MixConstants.USER_STATUS_LOCKED == user.userStatus>
													锁定
												</#if>
											</#if>
										</td>
										<@shiro.hasRole name="admin">
											<td>
												<@shiro.hasPermission name="user:modify">
												<button class="btn btn-xs btn-success" type="button" onclick="update(${user.userId!''});"> 修  改 </button>
												</@shiro.hasPermission>
												<@shiro.hasPermission name="user:delete">
													<button class="btn btn-xs btn-danger btn-space" type="button"> 删  除  </button>
												</@shiro.hasPermission>
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
		function update(userId) {
        	if(userId) {
				location.href = "${request.contextPath}/user/" + userId + "/update.html";
        	}
        }
	</script>
</body>
</html>
</#escape>