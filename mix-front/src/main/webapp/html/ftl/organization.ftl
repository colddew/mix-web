<#escape x as x!"">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>mix</title>
<link href="${request.contextPath}/html/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="${request.contextPath}/html/css/theme.css" rel="stylesheet" media="screen">
<link href="${request.contextPath}/html/css/mix.css" rel="stylesheet" media="screen">
<link href="${request.contextPath}/html/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<div class="navbar-wrapper">
		
		<div class="container">
			
			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="brand" href="#">XX管理系统</a>
					<div class="nav-collapse collapse">
						<ul class="nav">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">数据管理 <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">数据字典</a></li>
									<li class="divider"></li>
									<li><a href="#">数据库表</a></li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">系统管理 <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">组织管理</a></li>
									<li class="divider"></li>
									<li><a href="#">用户管理</a></li>
									<li class="divider"></li>
									<li><a href="#">角色管理</a></li>
									<li class="divider"></li>
									<li><a href="#">权限管理</a></li>
								</ul>
							</li>
						</ul>
						<ul class="nav" style="float:right;">
							<li><a href="#logout">退出</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="row">
        		<div class="org-tree">
				   <ul id="treeDemo" class="ztree"></ul>
				</div>
				<div class="org-list">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Username</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
							<tr>
								<td>3</td>
								<td>Larry</td>
								<td>the Bird</td>
								<td>@twitter</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
		
	</div>
	
	<script src="${request.contextPath}/html/js/jquery-1.11.1.js"></script>
	<script src="${request.contextPath}/html/js/jquery.ztree.core-3.5.js"></script>
	<script src="${request.contextPath}/html/js/bootstrap.js"></script>
	<script LANGUAGE="JavaScript">
	   var zTreeObj;
	   var setting = {};
	   var zNodes = [
	   {name:"test1", open:true, children:[{name:"test1_1"}, {name:"test1_2"}]},
	   {name:"test2", open:true, children:[{name:"test2_1"}, {name:"test2_2"}]}
	   ];
	   $(document).ready(function(){
	      zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
	   });
	</script>
</body>
</html>
</#escape>