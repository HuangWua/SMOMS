﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<frameset rows="100,*" cols="*" frameborder="no" border="0" framespacing="0">
	<frame src="admin_top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
	<frameset cols="200,*" frameborder="no" border="0" framespacing="0">
		<frame src="admin_left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" />
		<frame src="BillServlet.do?method=showBills" name="mainFrame" id="mainFrame" />
	</frameset>
</frameset>
<noframes><body>
</body></noframes>
</html>
