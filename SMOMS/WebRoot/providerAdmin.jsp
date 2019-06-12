<%@page import="com.offcn.bean.Provider"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function doit(flag, id) {
		if (flag == "del") {
			if (confirm("确认删除吗？") != true)
				return;
		}
		window.location = "provider.do?id=" + id + "&flag=" + flag;
	}
</script>
</head>
<body>
	<div class="menu">

		<table style="color:#FFFFFF;">
			<tbody>
				<tr>
					<td>
						<form method="post" action="ProvideServlet.do">
							<input name="flag" value="search" type="hidden"> 
							供应商名称：<input type="hidden" name="method" value="findProvidersBycondition" />
							<input name="providerName" class="input-text" type="text">
							&nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input name="providerDesc"
								class="input-text" type="text"> &nbsp;&nbsp;&nbsp;&nbsp;<input
								value="组 合 查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em> <input value="导出Excel" class="input-button"
				onClick="window.location='providerAdd.jsp'" type="button">&nbsp;&nbsp;
				<input value="批量删除(逻辑删除)" class="input-button"
				onClick="deleteAll()" type="button"> <input
				value="添加数据" class="input-button"
				onClick="window.location='providerAdd.jsp'" type="button">
			</em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>

		<div class="content">
			<table class="list">
				<tbody>
					<tr>

						<td width="70" height="29"><div class="STYLE1" align="center">
								<input id="check" onclick="change()" type="checkbox">
							</div>
						</td>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">供应商名称</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">供应商描述</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">联系人</div>
						</td>

						<td width="100"><div class="STYLE1" align="center">电话</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">地址</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">操作</div>
						</td>
					</tr>

					<%
						List<Provider> list=(List)request.getAttribute("list");
						
						int i=0;
						
						for(Provider p:list){
							i++;
					%>

					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">
								<input name="checks" value="<%=p.getPro_id() %>" type="checkbox">
							</div>
						</td>
						<td width="70" height="29"><div class="STYLE1" align="center"><%=i%></div>
						</td>
						<td width="80"><div class="STYLE1" align="center"><%=p.getPro_name()%></div>
						</td>
						<td width="100"><div class="STYLE1" align="center"><%=p.getPro_desc()%></div>
						</td>
						<td width="100"><div class="STYLE1" align="center"><%=p.getPro_linkman()%></div>
						</td>

						<td width="100"><div class="STYLE1" align="center"><%=p.getPro_phone()%></div>
						</td>
						<td width="100"><div class="STYLE1" align="center"><%=p.getPro_addr()%></div>
						</td>
						<td><span class="STYLE1"><a
								href="ProvideServlet.do?method=delete&id=<%=p.getPro_id()%>">删除</a>&nbsp;<a
								href="ProvideServlet.do?method=findProviderById&id=<%=p.getPro_id()%>">更新</a>
						</span>
						</td>
					</tr>


					<%
						}
					%>


					<tr>
						<td colspan="8" style="text-align: center;"><a
							style="text-decoration: none;" href="#"> 首页 上一页 ... 7 8 9 10
								11 12 ... 下一页 尾页 共1234条 每页显示 10/23 </a></td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
	function change() {

		var ck = document.getElementById("check");
		var arr = document.getElementsByName("checks");

		if (ck.checked == true) {
			for ( var i = 0; i <= arr.length; i++) {
				arr[i].checked = true;
			}
		} else {
			for ( var i = 0; i <= arr.length; i++) {
				arr[i].checked = false;
			}
		}

	}
	
	function deleteAll(){
	
		var ids="";
		
		var arr = document.getElementsByName("checks");
		for(var i=0;i<arr.length;i++){
			
			if (arr[i].checked == true) {
				ids += arr[i].value+",";
			}
		}
		if (confirm("确认删除选中项吗？") == true){
			
			location.href="ProvideServlet.do?method=deleteAll&ids="+ids;
			
		}
	
	}
</script>