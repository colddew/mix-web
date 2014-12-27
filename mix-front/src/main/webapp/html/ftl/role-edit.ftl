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
			
			<#include "navigator.ftl">
			
			
<div class="form-group">
拥有的资源列表：
    <hidden path="resourceIds"/>
    <input type="text" id="resourceName" name="resourceName" readonly />
    <a id="menuBtn" href="#">选择</a>
</div>
<div id="menuContent" class="menuContent" style="display:none; position:absolute;">
    <ul id="roleTree" class="ztree" style="margin-top:0; width:160px;"></ul>
</div>
<#--			
			<div class="row">
				<div class="res-list">
					<table class="table table-striped" id="resTree">
						<thead>
							<tr>
								<th>资源名称</th>
								<th>类型</th>
								<th>URL</th>
								<th>权限</th>
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
-->			
		</div>
		
	</div>
	
	<script src="${request.contextPath}/html/js/jquery-1.11.1.js"></script>
	<script src="${request.contextPath}/html/js/jquery.ztree.core-3.5.js"></script>
	<script src="${request.contextPath}/html/js/jquery.ztree.excheck-3.5.js"></script>
	<script src="${request.contextPath}/html/js/bootstrap.js"></script>
	<script language="javascript">
		$(function () {
            var setting = {
                check: {
                    enable: true ,
                    chkboxType: { "Y": "", "N": "" }
                },
                view: {
                    dblClickExpand: true
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                callback: {
                    onCheck: onCheck
                }
            };
			 
            var zNodes = [
				<#if allResources??>
					<#list allResources as resource>
						<#if 0 != resource.parentId>
							{	
								id:${resource.resId}, 
								pId:${resource.parentId}, 
								name:"${resource.resDesc}", 
								checked:true
							},
						</#if>
					</#list>
				</#if>
			];
			
            function onCheck(e, treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree"),
                        nodes = zTree.getCheckedNodes(true),
                        id = "",
                        name = "";
                nodes.sort(function compare(a,b){return a.id-b.id;});
                for (var i=0, l=nodes.length; i<l; i++) {
                    id += nodes[i].id + ",";
                    name += nodes[i].name + ",";
                }
                if (id.length > 0 ) id = id.substring(0, id.length-1);
                if (name.length > 0 ) name = name.substring(0, name.length-1);
                $("#resourceIds").val(id);
                $("#resourceName").val(name);
//                hideMenu();
            }
			
            function showMenu() {
                var cityObj = $("#resourceName");
                var cityOffset = $("#resourceName").offset();
                $("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

                $("body").bind("mousedown", onBodyDown);
            }
            
            function hideMenu() {
                $("#menuContent").fadeOut("fast");
                $("body").unbind("mousedown", onBodyDown);
            }
            
            function onBodyDown(event) {
                if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
                    hideMenu();
                }
            }
			
            $.fn.zTree.init($("#roleTree"), setting, zNodes);
            $("#menuBtn").click(showMenu);
        });
	</script>
</body>
</html>
</#escape>