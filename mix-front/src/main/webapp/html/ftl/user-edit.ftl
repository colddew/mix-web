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
			
			<#include "navigator.ftl">
			
			<div class="row">
				<div class="form-normal">
					<form id="userForm" name="userForm" method="post" action="#">
						
						<input type="hidden" id="userId" name="userId" value="${user.userId!''}" />
						
						<div class="row-normal">
							<label>用户名：</label>
							<input type="text" id="userName" name="userName" value="${user.userName!''}" />
						</div>
						
						<div class="row-normal">
							<label>用户类型：</label>
							<select id="userType" name="userType">
								<option value="${MixConstants.USER_TYPE_COMMON}" <#if (user.userType)?? && MixConstants.USER_TYPE_COMMON == user.userType>selected</#if>>普通用户</option>
								<option value="${MixConstants.USER_TYPE_SUPER}" <#if (user.userType)?? && MixConstants.USER_TYPE_SUPER == user.userType>selected</#if>>超级管理员</option>
							</select>
						</div>
						
						<#if (user.userId)??>
							<div class="row-normal">
								<label>密码：</label>
								<input type="password" id="password" name="password" value="${user.password!''}" />
							</div>
						</#if>
						
						<div class="row-normal">
							<label>所属组织：</label>
							<input type="hidden" id="orgId" name="orgId" value="${organization.orgId!''}" />
							<input type="text" id="orgName" name="orgName" value="${organization.orgName!''}" />
							<a id="menuBtn" href="#">选择</a>
						</div>
						
						<div class="row-normal">
							<label>角色列表：</label>
							<input type="hidden" id="roleIds" name="roleIds" />
							<#if allRoles?? && allRoles?size gt 0>
								<select id="roleNames" name="roleNames"  multiple="multiple" size="${allRoles?size}" onchange="setRoleIds();">
									<#list allRoles as role>
										<option value="${role.roleId!''}" <#if (role.roleId)?? && hadRoleIds?seq_contains('${role.roleId}')>selected</#if>>${role.roleDesc!''}</option>
									</#list>
								</select>
							</#if>
						</div>
						
						<div class="row-normal">
							<label>状态：</label>
							<input type="radio" name="userStatus" value="${MixConstants.USER_STATUS_UNAVAILABLE}" <#if (user.userStatus)?? && MixConstants.USER_STATUS_UNAVAILABLE == user.userStatus>checked</#if>>不可用</input>
							<input type="radio" name="userStatus" value="${MixConstants.USER_STATUS_AVAILABLE}" <#if (user.userStatus)?? && MixConstants.USER_STATUS_AVAILABLE == user.userStatus>checked</#if>>可用</input>
							<input type="radio" name="userStatus" value="${MixConstants.USER_STATUS_LOCKED}" <#if (user.userStatus)?? && MixConstants.USER_STATUS_LOCKED == user.userStatus>checked</#if>>锁定</input>
						</div>
						
						<div class="row-normal">
							<label style="width:110px;">
								<button class="btn btn-xs btn-primary" type="button" onclick="save();"> 保  存 </button>
							</label>
						</div>
						
						<div id="menuContent" class="menuContent row-normal" style="display:none;position:absolute;">
							<label></label>
						    <ul id="orgTree" class="ztree" style="margin-top:0;width:160px;"></ul>
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
                view: {
                    dblClickExpand: false
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                callback: {
                    onClick: onClick
                }
            };
			
            var zNodes = [
				<#if allOrganizations??>
					<#list allOrganizations as organization>
						{
							id:${organization.orgId}, 
							pId:${organization.parentId}, 
							name:"${organization.orgName}", 
							open:<#if 0 == organization.parentId>true<#else>false</#if>
						},
					</#list>
				</#if>
			];
			
            function onClick(e, treeId, treeNode) {
            	
            	//alert(treeNode.tId + ", " + treeNode.name + "," + treeNode.checked);
                
                var zTree = $.fn.zTree.getZTreeObj("orgTree"),
                        nodes = zTree.getSelectedNodes(),
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
                
                $("#orgId").val(id);
                $("#orgName").val(name);
                
                hideMenu();
            }
			
            function hideMenu() {
                $("#menuContent").fadeOut("fast");
                $("body").unbind("mousedown", onBodyDown);
            }
            
            function showMenu() {
                //var cityObj = $("#orgName");
                //var cityOffset = $("#orgName").offset();
                //$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
                $("#menuContent").css({left:"130px", top:"150px"}).slideDown("fast");
				
                $("body").bind("mousedown", onBodyDown);
            }
            
            function onBodyDown(event) {
                if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
                    hideMenu();
                }
            }
			
            $.fn.zTree.init($("#orgTree"), setting, zNodes);
            $("#menuBtn").click(showMenu);
        });
        
        function save() {
        	<#if (user.userId)??>
        		$.ajax({
					type: "POST",
					url: "${request.contextPath}/user/${user.userId}/update.html",
					data: $("#userForm").serialize(),
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
					url: "${request.contextPath}/user/create.html",
					data: $("#userForm").serialize(),
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
        	location.href = "${request.contextPath}/user/index.html";
        }
        
        funcgion setRoleIds() {
        	alert(111);
        }
	</script>
</body>
</html>
</#escape>