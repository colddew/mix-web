<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>mix</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/theme.css" rel="stylesheet" media="screen">
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

			<div>
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
			
			<br/>
						
			<div style="text-align:center;">
				<p>
					<button class="btn btn-large btn-primary" type="button"> 确  定 </button>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="btn btn-large btn-primary" type="button"> 取  消 </button>
				</p>
			</div>
			
		</div>
		
	</div>
	
	<script src="js/jquery-1.11.1.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>