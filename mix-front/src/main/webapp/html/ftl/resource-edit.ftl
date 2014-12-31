<#escape x as x!"">
<#include "utils.ftl">
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
			
			<#include "navigator.ftl">
			
			<div class="row">
				<div class="form-normal">
					<form id="resForm" name="resForm" method="post" action="#">
						
						<input type="hidden" id="resId" name="resId" value="${resource.resId!''}" />
						<input type="hidden" id="parentId" name="parentId" <#if parent??>value="${parent.resId!''}"</#if> />
						
						<#if parent??>
							<div class="row-normal">
								<label>父资源描述：</label>
								<span>${parent.resDesc!''} &nbsp;</span>
							</div>
						</#if>
												
						<div class="row-normal">
							<label>资源名称：</label>
							<input type="text" id="resName" name="resName" value="${resource.resName!''}" />
						</div>
						
						<div class="row-normal">
							<label>资源描述：</label>
							<input type="text" id="resDesc" name="resDesc" value="${resource.resDesc!''}" />
						</div>
						
						<div class="row-normal">
							<label>资源类型：</label>
							<select id="resType" name="resType">
								<option value="${MixConstants.RES_TYPE_URL}" <#if (resource.resType)?? && MixConstants.RES_TYPE_URL == resource.resType>selected</#if>>URL地址</option>
								<option value="${MixConstants.RES_TYPE_FORM}" <#if (resource.resType)?? && MixConstants.RES_TYPE_FORM == resource.resType>selected</#if>>表单元素</option>
								<option value="${MixConstants.RES_TYPE_DATA}" <#if (resource.resType)?? && MixConstants.RES_TYPE_DATA == resource.resType>selected</#if>>数据</option>
							</select>
						</div>
						
						<div class="row-normal">
							<label>URL路径：</label>
							<input type="text" id="url" name="url" value="${resource.url!''}" />
						</div>
						
						<div class="row-normal">
							<label>权限字符串：</label>
							<input type="text" id="permission" name="permission" value="${resource.permission!''}" />
						</div>
						
						<div class="row-normal">
							<label style="width:110px;">
								<button class="btn btn-xs btn-primary" type="button" onclick="save();"> 保  存 </button>
							</label>
						</div>
					</form>
				</div>
			</div>
			
		</div>
	</div>
	
	<script src="${request.contextPath}/html/js/jquery-1.11.1.js"></script>
	<script src="${request.contextPath}/html/js/bootstrap.js"></script>
	<script language="javascript">
        function save() {
        	<#if (resource.resId)??>
        		$.ajax({
					type: "POST",
					url: "${request.contextPath}/resource/${resource.resId}/update.html",
					data: $("#resForm").serialize(),
					//dataType: "json",
					async : false,
					success: function(data,textStatus){
						alert("update success");
					},
					error : function(data,textstatus){
						alert("update fail");
					}
				});
			<#else>
				$.ajax({
					type: "POST",
					url: "${request.contextPath}/resource/${parent.resId}/create.html",
					data: $("#resForm").serialize(),
					//dataType: "json",
					async : false,
					success: function(data,textStatus){
						alert("create success");
					},
					error : function(data,textstatus){
						alert("create fail");
					}
				});
        	</#if>
        	location.href = "${request.contextPath}/resource/index.html";
        }
	</script>
</body>
</html>
</#escape>