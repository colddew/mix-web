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
	<form action="${request.contextPath}/login.html" method="post">
		Username: <input type="text" name="userName"/><br/>
		Password: <input type="password" name="password"/><br/>
		<!--<input type="checkbox" name="rememberMe" value="true"/>Remember Me?<br/>-->
		<input type="submit" value="登录">
		<br/>
		<#--
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
		-->
		<script src="${request.contextPath}/html/js/jquery-1.11.1.js"></script>
		<script src="${request.contextPath}/html/js/bootstrap.js"></script>
	</form>
</body>
</html>
</#escape>