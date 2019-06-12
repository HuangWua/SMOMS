<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true)
			return;
	}
}
</script>
</head><body>




<div class="menu">

<table style="color:#FFF">
<tbody><tr><td>
<form method="post" action="user.do">
<input name="flag" value="search" class="input-text" type="hidden">
用户名称：<input name="userName" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp; <input value="查 询" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">

<div class="optitle clearfix">
<em><input value="批量删除" class="input-button" onClick="window.location='userAdd.jsp'" type="button">&nbsp;&nbsp;
<input value="添加数据" class="input-button" onClick="window.location='userAdd.jsp'" type="button">
</em>
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<div class="content">
<table class="list">
  <tbody><tr>
    <td width="70" height="29"><div class="STYLE1" align="center"><input type="checkbox"/></div></td> 
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">用户名称</div></td>
    <td width="100"><div class="STYLE1" align="center">性别</div></td>
    <td width="100"><div class="STYLE1" align="center">年龄</div></td>

    <td width="150"><div class="STYLE1" align="center">电话 </div></td>
    <td width="150"><div class="STYLE1" align="center">地址 </div></td>
    <td width="150"><div class="STYLE1" align="center">权限 </div></td>
    <td width="150"><div class="STYLE1" align="center">操作 </div></td>
  </tr>
  
  <tr>
    <td width="70" height="29"><div class="STYLE1" align="center"><input type="checkbox"/></div></td> 
    <td height="23"><span class="STYLE1">1</span></td>
    <td><span class="STYLE1"><a href="#" onClick="doit('mod',1)">admin</a></span></td>

    <td><span class="STYLE1">
    	女
    </span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1">北京</span></td>
    <td><span class="STYLE1">管理员</span></td>
    <td><span class="STYLE1"><a href="#">删除</a>&nbsp;<a href="userUpdate.jsp">更新</a>&nbsp;<a href="userUpdate.jsp">下载</a></span></td>
  </tr>
  <tr>
    <td width="70" height="29"><div class="STYLE1" align="center"><input type="checkbox"/></div></td> 
    <td height="23"><span class="STYLE1">2</span></td>
    <td><span class="STYLE1"><a href="#" onClick="doit('mod',1)">admin</a></span></td>

    <td><span class="STYLE1">
    	女
    </span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1">北京</span></td>
    <td><span class="STYLE1">管理员</span></td>
     <td><span class="STYLE1"><a href="#">删除</a>&nbsp;<a href="#">更新</a>&nbsp;<a href="userUpdate.jsp">下载</a></span></td>
  </tr>
  <tr>
    <td width="70" height="29"><div class="STYLE1" align="center"><input type="checkbox"/></div></td> 
    <td height="23"><span class="STYLE1">3</span></td>
    <td><span class="STYLE1"><a href="#" onClick="doit('mod',1)">admin</a></span></td>

    <td><span class="STYLE1">
    	女
    </span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1">北京</span></td>
    <td><span class="STYLE1">经理
    </span></td>
     <td><span class="STYLE1"><a href="#">删除</a>&nbsp;<a href="userUpdate.jsp">更新</a>&nbsp;<a href="userUpdate.jsp">下载</a></span></td>
  </tr>
   <tr>
    <td width="70" height="29"><div class="STYLE1" align="center"><input type="checkbox"/></div></td> 
    <td height="23"><span class="STYLE1">4</span></td>
    <td><span class="STYLE1"><a href="#" onClick="doit('mod',1)">admin</a></span></td>

    <td><span class="STYLE1">
    	女
    </span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1">北京</span></td>
    <td><span class="STYLE1">经理
    </span></td>
    <td><span class="STYLE1"><a href="#">删除</a>&nbsp;<a href="userUpdate.jsp">更新</a>&nbsp;<a href="userUpdate.jsp">下载</a></span></td>
  </tr>
   <tr>
    <td width="70" height="29"><div class="STYLE1" align="center"><input type="checkbox"/></div></td> 
    <td height="23"><span class="STYLE1">5</span></td>
    <td><span class="STYLE1"><a href="#" onClick="doit('mod',1)">admin</a></span></td>

    <td><span class="STYLE1">
    	女
    </span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1">北京</span></td>
    <td><span class="STYLE1">经理
    </span></td>
     <td><span class="STYLE1"><a href="#">删除</a>&nbsp;<a href="userUpdate.jsp">更新</a>&nbsp;<a href="userUpdate.jsp">下载</a></span></td>
  </tr>
   <tr>
    <td width="70" height="29"><div class="STYLE1" align="center"><input type="checkbox"/></div></td> 
    <td height="23"><span class="STYLE1">6</span></td>
    <td><span class="STYLE1"><a href="#" onClick="doit('mod',1)">admin</a></span></td>

    <td><span class="STYLE1">
    	女
    </span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1">北京</span></td>
    <td><span class="STYLE1">经理
    </span></td>
    <td><span class="STYLE1"><a href="#">删除</a>&nbsp;<a href="userUpdate.jsp">更新</a>&nbsp;<a href="userUpdate.jsp">下载</a></span></td>
  </tr>
  <tr>
    <td colspan="9" style="text-align: center;">						
        <a style="text-decoration: none;" href="#">
            首页 上一页  ... 7 8 9 10 11 12 ... 下一页 尾页 共1234条 每页显示 10/23 </a>
    </td>

  </tr>
</tbody>
</table>
</div>
</div>
</body></html>