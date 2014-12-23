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
				   <ul id="orgTree" class="ztree"></ul>
				</div>
				<div class="org-list">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>名称</th>
								<th>描述</th>
								<th>等级</th>
								<th>父节点ID</th>
							</tr>
						</thead>
						<tbody>	
							<#if allOrganizations??>
								<#list allOrganizations as organization>
									<tr>
										<td>${organization.orgId!''}</td>
										<td>${organization.orgName!''}</td>
										<td>${organization.orgDesc!''}</td>
										<td>${organization.orgLevel!''}</td>
										<td>${organization.parentId!''}</td>
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
	<script src="${request.contextPath}/html/js/jquery.ztree.core-3.5.js"></script>
	<script src="${request.contextPath}/html/js/bootstrap.js"></script>
	<script language="javascript">
		var setting = {
			data: {
				simpleData: {
					enable: true,
					idKey: "id",
					pIdKey: "pId",
					rootPId: 0
				}
			}, 
			callback: {
	        	onClick: function(event, treeId, treeNode) {
	                    //location.href = "${request.contextPath}/organization/"+treeNode.id+"/maintain";
						alert(treeNode.tId + ", " + treeNode.name);;
	                }
	            }
		};
		
		var zNodes = [
			<#if allOrganizations??>
				<#list allOrganizations as organization>
					{	id:${organization.orgId}, 
						pId:${organization.parentId}, 
						name:"${organization.orgName}", 
						open:<#if 0 == organization.parentId>true<#else>false</#if>
					},
				</#list>
			</#if>
		];
		
		$(document).ready(function(){
			$.fn.zTree.init($("#orgTree"), setting, zNodes);
		});
	</script>
</body>
</html>
</#escape>