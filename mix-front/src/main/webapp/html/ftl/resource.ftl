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
<link href="${request.contextPath}/html/css/treetable/jquery.treetable.theme.default.css" rel="stylesheet" type="text/cs">
</head>
<body>
	
	<div class="navbar-wrapper">
		
		<div class="container">
			
			<#include "navigator.ftl">
			
			<div class="row">
				<div class="table-list">
					<table class="table table-striped" id="resTree">
						<thead>
							<tr>
								<th>资源描述</th>
								<th>资源类型</th>
								<th>URL路径</th>
								<th>权限字符串</th>
								<th>资源ID</th>
								<th>父节点ID</th>
								<@shiro.hasRole name="admin"><th>操作</th></@shiro.hasRole>
							</tr>
						</thead>
						<tbody>
							<#if allResources??>
								<#list allResources as resource>
									<#if 0 != resource.parentId>
										<tr data-tt-id='${resource.resId?default(0)}' data-tt-parent-id='${resource.parentId?default(0)}'>
											<td>${resource.resDesc!''}</td>
											<td>
												<#if (resource.resType)??>
													<#if MixConstants.RES_TYPE_URL == resource.resType>
														URL地址
													<#elseif MixConstants.RES_TYPE_FORM == resource.resType>
														表单元素
													<#elseif MixConstants.RES_TYPE_DATA == resource.resType>
														数据
													</#if>
												</#if>
											</td>
											<td>${resource.url!''}</td>
											<td>${resource.permission!''}</td>
											<td>${resource.resId?default(0)}</td>
											<td>${resource.parentId?default(0)}</td>
											<@shiro.hasRole name="admin">
												<td style="text-align:left;">
													<button class="btn btn-xs btn-primary" type="button" onclick="create(${resource.resId!''});"> 新增子节点  </button>
													<button class="btn btn-xs btn-success btn-space" type="button" onclick="update(${resource.resId!''});"> 修  改 </button>
													<#if (resource.isLeaf)?? && MixConstants.IS_LEAF_YES == resource.isLeaf>
														<button class="btn btn-xs btn-danger btn-space" type="button"> 删  除  </button>
													</#if>
												</td>
											</@shiro.hasRole>
										</tr>
									</#if>
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
		
		function create(parentId) {
        	if(parentId) {
				location.href = "${request.contextPath}/resource/" + parentId + "/create.html";
        	}
        }
        
		function update(resId) {
        	if(resId) {
				location.href = "${request.contextPath}/resource/" + resId + "/update.html";
        	}
        }
	</script>
</body>
</html>
</#escape>