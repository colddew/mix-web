<%
/**
 * Copyright (c) 2004-2011 Wang Jinbao(Julian Wong), http://www.ralasafe.com
 * Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php
 */
%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="org.ralasafe.util.StringUtil"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Locale"%>
<%@page import="org.ralasafe.demo.DemoUtil"%><html>
<head>
<%
	Locale locale = request.getLocale();
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="../favicon.ico"> 
<link rel="stylesheet" type="text/css" media="screen" href="../css/ralasafe.css" />
<title>��¼��Ralasafe DEMOӦ��ϵͳ</title>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>



<div class="smallContainer"/>
<h1 class="title">Login</h1>
<%
	String denyMessage = (String) session.getAttribute("denyMessage");
	if (!StringUtil.isEmpty(denyMessage)) {
%>
<p><font color="red"><%=URLDecoder.decode(denyMessage, "UTF-8")%></font></p>
<%
	}
%> <%
 	String gotoPage = (String) session.getAttribute("gotoPage");
 	if (StringUtil.isEmpty(gotoPage)) {
 		gotoPage = "main.jsp";
 	}
 %>
<form name="" action="<%=gotoPage%>" method="post">
<label>�û���</label> 
<input name="loginName" type="text" class="username">
<label>����</label>
<input name="password" type="password" class="password"
			value="password">
<br/>			
<input type="submit" value="��¼" />
</form>
<p>���������û�����¼���ֺ����� ��ʤ���� ����</p>
</div>

<jsp:include page="../footer.jsp"></jsp:include>




</body>
</html>