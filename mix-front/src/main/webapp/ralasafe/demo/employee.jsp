<%
/**
 * Copyright (c) 2004-2011 Wang Jinbao(Julian Wong), http://www.ralasafe.com
 * Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php
 */
%>
<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator,java.text.SimpleDateFormat"%>
<%@page	import="org.ralasafe.demo.Employee,org.ralasafe.demo.Privilege,org.ralasafe.demo.Company,org.ralasafe.WebRalasafe"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">



<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<link rel="shortcut icon" href="../favicon.ico"> 
<link rel="stylesheet" type="text/css" media="screen" href="../css/ralasafe.css" />

<title>Ա������</title>
</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>

<%
Collection employees = (Collection) request.getAttribute("employees");
SimpleDateFormat shortSdf=new SimpleDateFormat( "yyyy-MM-dd" );
%>

<div class="smallContainer">
<h1>Ա������</h1>

<p>
<font color="green">Ralasafe���Կ�������������������ʾ����</font>
</p>

<label>��˾</label>
<select id="companyId" name="companyId">
	<%
		// get company list through ralasafe
		Collection companies = WebRalasafe.query(request, Privilege.QUERY_COMPANY);
		for (Iterator iter = companies.iterator(); iter.hasNext();) {
			Company company = (Company) iter.next();
			out.println("<option value='" + company.getId() + "'>"
					+ company.getName() + "</option>");
		}
	%>
</select> 

<p>&nbsp;</p>
<p>
<font color="green">Ralasafe�����Կ������ݿ���������</font>
</p>

<label>Ա���б�</label>
<table class="ralaTable">
	<thead>
		<tr>
			<th >����</th>
			<th >Ƹ������</th>
			<th >��˾</th>
			<th >����</th>
			<th >�Ƿ���</th>
		</tr>
	</thead>
	<tbody>
		<%
			for (Iterator iter = employees.iterator(); iter.hasNext();) {
				Employee employee = (Employee) iter.next();
		%>

		<tr >
			<td><%=(employee.getName()==null?"":employee.getName())%></td>
			<td><%=(employee.getHireDate()==null?"":shortSdf.format(employee.getHireDate()))%></td>
			<td><%=(employee.getCompanyName()==null?"":employee.getCompanyName())%></td>
			<td><%=(employee.getDepartmentName()==null?"":employee.getDepartmentName())%></td>
			<td><%=(employee.getIsManager()==1?"��":"��")%></td>
		</tr>
		<%
			}
		%>
		</tbdoy>
</table>
</div>
<jsp:include page="../footer.jsp"></jsp:include>


</body>

</html>
