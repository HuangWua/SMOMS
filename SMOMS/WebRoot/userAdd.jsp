﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"><title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
function checkit()
{
	//判断是否是数字的正则表达式
	return true;
}
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="user.do" onSubmit="return checkit();">
<input type="hidden" name="flag" value="doAdd">
		<div class="content">
			<table class="box"><font color="red"></font>
			<tr>
					<td class="field">用户名称：</td>
					<td><input type="text" name="username" class="text" id="textfield2" /> <font color="red">验证用户名是否可用</font></td>
				</tr>
                <tr>
					<td class="field">用户头像：</td>
					<td><input type="file" name="photo"/></td>
				</tr>
				<tr>
					<td class="field">用户密码：</td>

					<td><input type="password" name="password" class="text" id="textfield2" /> <font color="red">*</font></td>
				</tr>
			<tr>
					<td class="field">确认密码：</td>
					<td><input type="password" name="password1" class="text"/> <font color="red">*</font></td>
				</tr>

				<tr>
					<td class="field">用户性别：</td>
					<td><select name="sex" id="select">
    <option value="0">女</option>
    <option value="1">男</option>
  </select></td>
				</tr>
				<tr>
					<td class="field">用户年龄：</td>
					<td><input type="text" name="age" class="text" id="textfield2"/> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="mobile" class="text" id="textfield2"/> <font color="red">*</font></td>

				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><textarea name="address" id="textarea" class="text" cols="45" rows="5"></textarea></td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>

					<td><input type="radio" name="auth" id="auth" value="0" checked="checked"/>普通用户
					<input type="radio" name="auth" id="auth" value="1" />经理</td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="button" id="button" value="数据提交" class="input-button"/>
			  <input type="button" name="button" id="button" onClick="window.location='user.do';" value="返回" class="input-button"/> 
		</div>

	</form>
</div>
</body>
</html>
