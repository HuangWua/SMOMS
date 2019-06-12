<%@page import="com.offcn.bean.Bill"%>
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
<body>
	<div class="menu" style="font-size:14px;">
		<form method="post" action="BillServlet.do">
			商品名称： <input type="hidden" name="method" value="findBillsBycondition" />
			<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
			是否付款：<select name="payStatus">
				<option value="">请选择</option>
				<option value="1">已付款</option>
				<option value="0">未付款</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="submit"
				value="组合查询" class="button" />
		</form>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em> <input value="导出Excel" class="input-button"
				onClick="window.location='providerAdd.jsp'" type="button">&nbsp;&nbsp;
				<input value="批量删除(逻辑删除)" class="input-button" onClick="deleteAll()"
				type="button">&nbsp;&nbsp; <input type="button"
				name="button" value="添加数据" class="input-button"
				onclick="location.href='ProvideServlet.do?method=findAllProvider'" />
			</em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;<input id="ck" onclick="change()"
						type="checkbox" />&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>编号</td>
					<td>商品名称</td>
					<td>商品数量</td>
					<td>交易金额</td>
					<td>是否付款</td>
					<td>供应商名称</td>
					<td>商品描述</td>
					<td>账单时间</td>
					<td>操作</td>
				</tr>

				<% 
			
				List<Bill> list=(List)request.getAttribute("list");
				
				int i=0;
				
				for(Bill b:list){
				i++;

			%>

				<tr>
					<td><input name="cks" value="<%=b.getB_id() %>"
						type="checkbox" />
					</td>
					<td><%=i %></td>
					<td><%=b.getB_name() %></td>
					<td><%=b.getB_num() %></td>
					<td><%=b.getB_price() %></td>
					<td><%="1".equals(b.getB_isPay())?"是":"否" %></td>
					<td><%=b.getPro_name() %></td>
					<td><%=b.getB_desc() %></td>
					<td><%=b.getB_time() %></td>
					<td><a
						href="BillServlet.do?method=delete&id=<%=b.getB_id() %>">删除</a>&nbsp;<a
						href="BillServlet.do?method=findBillById&id=<%=b.getB_id() %>">更新</a>
					</td>
				</tr>

				<%
				} 
			%>

				<tr>
					<td colspan="10" style="text-align: center;"><a
						style="text-decoration: none;" href="#"> 首页 上一页 ... 7 8 9 10
							11 12 ... 下一页 尾页 共1234条 每页显示 10/23 </a></td>
				</tr>

			</table>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
	
	function change(){
	
		var ck = document.getElementById("ck");
		var arr = document.getElementsByName("cks");
		
		if(ck.checked == true){
			for(var i=0;i<=arr.length;i++){
				arr[i].checked=true;
			}
		}else{
			for(var i=0;i<=arr.length;i++){
				arr[i].checked=false;
			}
		}
	}
	
	function deleteAll(){
	
		var ids="";
		
		var arr = document.getElementsByName("cks");
		for(var i=0;i<arr.length;i++){
			
			if (arr[i].checked == true) {
				ids += arr[i].value+",";
			}
		}
		
		if (confirm("确认删除选中项吗？") == true){
			
			location.href="BillServlet.do?method=deleteAll&ids="+ids;
			
		}
	
	}

</script>
