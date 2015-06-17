<%@page import="csphere.xc.dao.user_select"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
user_select select = new user_select();
String name1 = select.select();
request.setAttribute("name", name1);
%>
<html>
<body>
<h2>Hello <%=name1 %> !</h2>
</body>
</html>
