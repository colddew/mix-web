<#escape x as x!"">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>mix</title>
<link href="${request.contextPath}/html/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="${request.contextPath}/html/css/theme.css" rel="stylesheet" media="screen">
</head>
<body>
	
	Username: <input type="text" name="username"/><br/>
	Password: <input type="password" name="password"/>
	<input type="checkbox" name="rememberMe" value="true"/>Remember Me?<br/>
	
	<@shiro.guest>guest</@shiro.guest><br/>
	<@shiro.user>user</@shiro.user><br/>
	<@shiro.authenticated>authenticated</@shiro.authenticated><br/>
	<@shiro.notAuthenticated>notAuthenticated</@shiro.notAuthenticated><br/>
	hello, <@shiro.principal/><br/>
	hello, <@shiro.principal property="name" /><br/>
	<@shiro.hasRole name="admin">hasRole</@shiro.hasRole><br/>
	<@shiro.lacksRole name="admin">lacksRole</@shiro.lacksRole><br/>
	<@shiro.hasAnyRoles name="admin,">hasAnyRoles</@shiro.hasAnyRoles><br/>
	<@shiro.hasPermission name="user:create">hasPermission</@shiro.hasPermission><br/>
	<@shiro.lacksPermission name="user:delete">lacksPermission</@shiro.lacksPermission><br/>
	
	<script src="${request.contextPath}/html/js/jquery-1.11.1.js"></script>
	<script src="${request.contextPath}/html/js/bootstrap.js"></script>
</body>
</html>
</#escape>