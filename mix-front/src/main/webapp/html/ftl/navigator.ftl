<#escape x as x!"">
<div class="navbar navbar-inverse">
	<div class="navbar-inner">
		<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="brand" href="${request.contextPath}/index.html">XX管理系统</a>
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
						<li><a href="${request.contextPath}/organization/index.html">机构管理</a></li>
						<li class="divider"></li>
						<li><a href="#">用户管理</a></li>
						<li class="divider"></li>
						<li><a href="#">角色管理</a></li>
						<li class="divider"></li>
						<li><a href="${request.contextPath}/resource/index.html">资源管理</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav" style="float:right;">
				<li><a href="#logout">退出</a></li>
			</ul>
		</div>
	</div>
</div>
</#escape>