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
<link href="${request.contextPath}/html/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<div class="navbar-wrapper">
		<div class="container">
			
			<#include "../navigator.ftl">
			
			<div class="row">
				<div class="form-normal">
					<form id="roleForm" name="roleForm" method="post" action="#">
						
						<input type="hidden" id="roleId" name="roleId" value="${role.roleId!''}" />
						
						<div class="row-normal">
							<label>角色名称：</label>
							<input type="text" id="roleName" name="roleName" value="${role.roleName!''}" />
						</div>
						
						<div class="row-normal">
							<label>角色描述：</label>
							<input type="text" id="roleDesc" name="roleDesc" value="${role.roleDesc!''}" />
						</div>
						
						<div class="row-normal">
							<label>拥有的资源列表：</label>
							<input type="hidden" id="resourceIds" name="resourceIds" />
						    <input type="text" id="resourceName" name="resourceName" value="<@getResourceNames role=role />" readonly />
						    <a id="menuBtn" href="#">选择</a>
						</div>
						
						<div class="row-normal">
							<label style="width:110px;">
								<button class="btn btn-xs btn-primary" type="button" onclick="save();"> 保  存 </button>
							</label>
						</div>
						
						<div id="menuContent" class="menuContent row-normal" style="display:none;position:absolute;">
							<label></label>
						    <ul id="resTree" class="ztree" style="margin-top:0;width:160px;"></ul>
						</div>
					</form>
				</div>
			</div>
			
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
                    enable: true,
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
								checked:${hadResourceIds?seq_contains('${resource.resId}')?string("true","false")}
							},
						</#if>
					</#list>
				</#if>
			];
			
            function onCheck(e, treeId, treeNode) {
            	
            	//alert(treeNode.tId + ", " + treeNode.name + "," + treeNode.checked);
                
                var zTree = $.fn.zTree.getZTreeObj("resTree"),
                        nodes = zTree.getCheckedNodes(true),
                        id = "",
                        name = "";
               
                nodes.sort(function compare(a,b){return a.id-b.id;});
                
                for (var i=0, l=nodes.length; i<l; i++) {
                    id += nodes[i].id + ",";
                    name += nodes[i].name + ",";
                }
                
                if(id.length > 0 ) {
                	id = id.substring(0, id.length-1);
                }
				
                if(name.length > 0 ) {
                	name = name.substring(0, name.length-1);
                }
                
                $("#resourceIds").val(id);
                $("#resourceName").val(name);
                
                //hideMenu();
            }
			
            function hideMenu() {
                $("#menuContent").fadeOut("fast");
                $("body").unbind("mousedown", onBodyDown);
            }
            
            function showMenu() {
                //var cityObj = $("#resourceName");
                //var cityOffset = $("#resourceName").offset();
                //$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
                $("#menuContent").css({left:"130px", top:"150px"}).slideDown("fast");
				
                $("body").bind("mousedown", onBodyDown);
            }
            
            function onBodyDown(event) {
                if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
                    hideMenu();
                }
            }
			
            $.fn.zTree.init($("#resTree"), setting, zNodes);
            $("#menuBtn").click(showMenu);
        });
        
        function save() {
        	<#if (role.roleId)??>
        		$.ajax({
					type: "POST",
					url: "${request.contextPath}/role/${role.roleId}/update.html",
					data: $("#roleForm").serialize(),
					//dataType: "json",
					async: false,
					success: function(data,textStatus){
						alert("update success");
					},
					error: function(data,textstatus){
						alert("update fail");
					}
				});
			<#else>
				$.ajax({
					type: "POST",
					url: "${request.contextPath}/role/create.html",
					data: $("#roleForm").serialize(),
					//dataType: "json",
					async: false,
					success: function(data,textStatus){
						alert("create success");
					},
					error: function(data,textstatus){
						alert("create fail");
					}
				});
        	</#if>
        	location.href = "${request.contextPath}/role/index.html";
        }
	</script>
</body>
</html>
</#escape>