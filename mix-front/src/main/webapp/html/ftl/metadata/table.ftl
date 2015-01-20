<#escape x as x!"">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>mix</title>
<link href="${request.contextPath}/html/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="${request.contextPath}/html/css/theme.css" rel="stylesheet" media="screen">
<link href="${request.contextPath}/html/css/mix.css" rel="stylesheet" media="screen">
</head>
<body>
	
	<div class="navbar-wrapper">
		
		<div class="container">
			
			<#include "../navigator.ftl">
			
			<div class="row">
				<div class="table-list">
					<table class="table table-striped" id="resTree">
						<thead>
							<tr>
								<th>表ID</th>
								<th>表名</th>
								<th>表描述</th>
								<th>表类型</th>
								<th>操作人</th>
							</tr>
						</thead>
						<tbody>

							<#if allMetadataTables??>
								<#list allMetadataTables as table>
									<tr>
										<td>${table.tableId!''}</td>
										<td>${table.tableName!''}</td>
										<td>${table.tableDesc!''}</td>
										<td>${table.tableType!''}</td>
										<td>${table.operator!''}</td>
									</tr>
								</#list>
							</#if>
	
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
		
	</div>
</body>
</html>
</#escape>