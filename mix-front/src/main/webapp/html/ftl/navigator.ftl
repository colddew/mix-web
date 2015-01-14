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
						<#if systemManagementMenus??>
							<#list systemManagementMenus as systemManagementMenu>
								<#if (systemManagementMenu.url)?? && (systemManagementMenu.resDesc)??>
									<li><a href="${request.contextPath}${systemManagementMenu.url}">${systemManagementMenu.resDesc}</a></li>
								</#if>
								<#if systemManagementMenu_index + 1 != systemManagementMenus?size>
									<li class="divider"></li>
								</#if>
							</#list>
						</#if>
					</ul>
				</li>
			</ul>
			<ul class="nav" style="float:right;">
				<li><a href="${request.contextPath}/logout.html"><@shiro.principal/> 退出</a></li>
			</ul>
		</div>
	</div>
</div>
</#escape>