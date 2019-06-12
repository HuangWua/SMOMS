<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"><title>系统登录 - 超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />

<script type="text/javascript">

	var mess = "<%=request.getAttribute("message")%>";
	if(mess!=="null"){
		alert(mess);
		
	}
	

</script>

</head>
<body class="blue-style">
<div id="login">
	<div class="icon"></div>
	<div class="login-box">
		<form method="post" action="LoginServlet.do">
			<dl>
				<dt>用户名：</dt>
				<dd><input type="text" name="userName" class="input-text" />
					<input type="hidden" name="method" value="login"/></dd>
				<dt>密　码：</dt>
				<dd><input type="password" name="passWord" class="input-text" /></dd>
                <dt>验证码：</dt>
				<dd><input type="password" name="vocde" class="input-text" />
                    <img src="CheckCodeServlet.do" width="70" height="28" /> 
                </dd>
                <dt></dt>
				<dd>
                <select > 
                        <option selected="" value="None">不保存</option> 
                        <option value="">保存1小时</option> 
                        <option value="">保存1天</option> 
                        <option value="">保存1周</option>
                 </select>
                </dd>
			</dl>
			<div class="buttons">
				<input type="submit" name="submit" value="登录系统" class="input-button" />
				<input type="reset" name="reset" value="重　　填" class="input-button" />
			</div>
		</form>
	</div>
</div>
</body>
</html>
