<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="java.util.*" %>
   <%@page import="colin.com.student.po.DepartmentExt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
</head>
<body>
<%

List<DepartmentExt> list=(List)request.getAttribute("list");
String str=(String)request.getAttribute("tests");

%>
<%
for(DepartmentExt ext:list)
{

%>
<%= ext.getDepartmentName()%><br>
<% }%>
<%=str%>
</body>
</html>