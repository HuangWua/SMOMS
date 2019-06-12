<%@page import="com.offcn.bean.Provider"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"><title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">供应商管理&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="ProvideServlet.do" onsubmit="return checkit();">
		<div class="content">
		<font color="red"></font>
<input name="flag" value="doAdd" type="hidden">

			<%
			
				Provider p=(Provider)request.getAttribute("findProvider");
			
			 %>

			<table class="box">

			<tbody><tr>
					<td class="field">供应商编号：</td>
					<td>
					<input type="hidden" name="method" value="updateProvider" >
					<input name="proId" id="textfield" class="text" type="text" value="<%=p.getPro_id() %>" readonly="readonly"> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">供应商名称：</td>
					<td><input name="proName" id="textfield2" class="text" type="text" value="<%=p.getPro_name() %>"> <font color="red">*</font></td>

				</tr>
			<tr>
					<td class="field">供应商描述：</td>
					<td><textarea name="proDesc" id="textarea" cols="45" rows="5"><%=p.getPro_desc() %></textarea></td>
				</tr>
				<tr>
					<td class="field">供应商联系：</td>

					<td><input name="contact" id="textfield2" class="text" type="text" value="<%=p.getPro_linkman() %>"></td>
				</tr>
				<tr>
					<td class="field">供应商电话：</td>
					<td><input name="phone" id="textfield2" value="<%=p.getPro_phone() %>" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">供应商传真：</td>

					<td><input name="fax" id="textfield2" class="text" type="text" value="<%=p.getPro_tel() %>"></td>
				</tr>
				<tr>
					<td class="field">供应商地址：</td>
					<td><input name="address" id="textfield2" value="<%=p.getPro_addr() %>" class="text" type="text"></td>
				</tr>
			</tbody></table>
		</div>

		<div class="buttons">
			<input name="button" id="button" value="提交" class="input-button" type="submit"> 
			<input name="button" id="button" onclick="history.back()" value="返回" class="input-button" type="button"> 
		</div>
	</form>
</div>
</body>
</html>
