<#escape x as x!"">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>mix</title>
<link href="${request.contextPath}/html/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="${request.contextPath}/html/css/theme.css" rel="stylesheet" media="screen">
<link href="${request.contextPath}/html/css/mix.css" rel="stylesheet" media="screen">
<link href="${request.contextPath}/html/css/treetable/jquery.treetable.css" rel="stylesheet" type="text/cs">
<link href="${request.contextPath}/html/css/treetable/jquery.treetable.theme.css" rel="stylesheet" type="text/cs">
</head>
<body>
	
	<div class="navbar-wrapper">
		
		<div class="container">
			
			<#include "navigator.ftl">
			
			<div class="row">
				<div class="res-list">
					<table class="table table-striped" id="resTree">
						<thead>
							<tr>
								<th>资源名称</th>
								<th>类型</th>
								<th>URL</th>
								<th>权限</th>
								<th>等级</th>
								<th>资源ID</th>
								<th>父节点ID</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<#if allResources??>
								<#list allResources as resource>
									<tr data-tt-id='${resource.resId?default(0)}' <#if 0 != resource.parentId>data-tt-parent-id='${resource.parentId?default(0)}'</#if>>
										<td>${resource.resDesc!''}</td>
										<td>${resource.resType!''}</td>
										<td></td>
										<td>${resource.permission!''}</td>
										<td>${resource.resLevel!''}</td>
										<td>${resource.resId?default(0)}</td>
										<td>${resource.parentId?default(0)}</td>
										<td>
											<button class="btn btn-xs btn-primary" type="button"> 新增子节点  </button>
											&nbsp;&nbsp;
											<button class="btn btn-xs btn-success" type="button"> 修  改 </button>
											&nbsp;&nbsp;
											<button class="btn btn-xs btn-danger" type="button"> 删  除  </button>
										</td>
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
	<script src="${request.contextPath}/html/js/jquery.treetable.js"></script>
	<script language="javascript">
		$(function() {
			//$("#resTree").treetable({expandable: true}).treetable("expandNode", 1);
			$("#resTree").treetable({expandable: true}).treetable("expandAll");
		});
	</script>
</body>
</html>
</#escape>