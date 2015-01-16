<#escape x as x!"">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>mix</title>
<link rel="icon" href="${request.contextPath}/html/img/mix.ico">
<link href="${request.contextPath}/html/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${request.contextPath}/html/css/signin.css" rel="stylesheet">
</head>
<body>
	<div class="container">
      <form class="form-signin" action="${request.contextPath}/login.html" method="post">
        <h2 class="form-signin-heading"></h2>
        <label for="userName" class="sr-only">用户名</label>
        <input type="text" id="userName" name="userName" class="form-control" placeholder="用户名" required autofocus>
        <label for="password" class="sr-only">密码</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
    </div>
    
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
</body>
</html>
</#escape>