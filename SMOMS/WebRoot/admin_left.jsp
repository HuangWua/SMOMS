<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body class="frame-bd">
<ul class="left-menu">
	<li><a href="BillServlet.do?method=showBills" target="mainFrame"><img src="images/btn_bill.gif" /></a></li>
	<li><a href="ProvideServlet.do?method=showProviders" target="mainFrame"><img src="images/btn_suppliers.gif" /></a></li>
	<li><a href="userAdmin.jsp" target="mainFrame"><img src="images/btn_users.gif" /></a></li>
	<li><a href="LoginServlet.do?method=esc" onClick="javaScript:alert('这里实现退出操作！')"><img src="images/btn_exit.gif" /></a></li>
</ul>
</body>
</html>
