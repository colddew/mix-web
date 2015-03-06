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
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">开放平台 <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="${request.contextPath}/openapi/authorize/top.html">淘宝TOP</a></li>
						<li class="divider"></li>
						<li><a href="${request.contextPath}/openapi/authorize/sina.html">新浪微博</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">数据管理 <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="${request.contextPath}/dictionary/index.html">数据字典</a></li>
						<li class="divider"></li>
						<li><a href="${request.contextPath}/table/index.html">数据库表</a></li>
					</ul>
				</li>
				<#if systemManagementMenus?? && systemManagementMenus?size gt 0>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">系统管理 <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<#list systemManagementMenus as systemManagementMenu>
								<#if (systemManagementMenu.url)?? && (systemManagementMenu.resDesc)??>
									<li><a href="${request.contextPath}${systemManagementMenu.url}">${systemManagementMenu.resDesc}</a></li>
								</#if>
								<#if systemManagementMenu_index + 1 != systemManagementMenus?size>
									<li class="divider"></li>
								</#if>
							</#list>
						</ul>
					</li>
				</#if>
			</ul>
			<ul class="nav" style="float:right;">
				<li><a href="${request.contextPath}/logout.html"><@shiro.principal/> 退出</a></li>
			</ul>
		</div>
	</div>
</div>
</#escape>