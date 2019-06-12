<%@page import="com.offcn.bean.Provider"%>
<%@page import="com.offcn.bean.Bill"%>
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
<div class="menu">
	<form method="get" action="">
		商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select name="payStatus">
			<option value="">请选择</option>
			<option value="1">已付款</option>
			<option value="0">未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="组合查询" class="button" />
	</form>
</div>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<form method="post" action="BillServlet.do">
		<div class="content">
		<%
			Bill bill=(Bill)request.getAttribute("findBill");
		 %>
			<table class="box">
				<tr>
					<td class="field">账单编号：</td>
					<td>
					<input type="hidden" name="method" value="updateBill"/>
					<input type="text" name="billNum" class="text"  value="<%=bill.getB_id() %>" readonly="readonly"/></td>
				</tr>
                <tr>
					<td class="field">商品名称：</td>
					<td><input type="text" name="name" class="text" value="<%=bill.getB_name() %>"/></td>
				</tr>
                <tr>
					<td class="field">商品数量：</td>
					<td><input type="text" name="num" class="text" value="<%=bill.getB_num() %>"/></td>
				</tr>
				<tr>
					<td class="field">交易金额：</td>
					<td><input type="text" name="money" class="text" value="<%=bill.getB_price() %>"/></td>
				</tr>
                <tr>
					<td class="field">供应商：</td>
					<td>
                    <select name="provider">
                    
                    <%
                    	List<Provider> list=(List)request.getAttribute("list");
                    	for(Provider p:list){
                    		if(p.getPro_id()==Integer.parseInt(bill.getB_pro_id())){
                    		%>
                    			<option selected="selected" value="<%=p.getPro_id() %>"><%=p.getPro_name() %></option>
                    		<%
                    		}else{
                    		%>
                    			<option value="<%=p.getPro_id() %>"><%=p.getPro_name() %></option>
                    		<%
                    		}
                    	}
                     %>
                    
					</select></td>
				</tr>
				<tr>
					<td class="field">商品描述：</td>
					<td><textarea name="discription"><%=bill.getB_desc() %></textarea></td>
				</tr>
				<tr>
					<td class="field">是否付款：</td>
					<td>
                    <select name="isPay">
                    	<%
                    		if("1".equals(bill.getB_isPay())){
                    			%>
                    			<option value="1" selected="selected">是</option>
                    			<option value="0">否</option>
                    			<%
                    		}else{
                    		 %>
                    		 <option value="0" selected="selected">否</option>
                    		 <option value="1">是</option>
                    		 <%
                    		 }
                    	 %>
					</select></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="更新" class="input-button" />
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
	</form>
</div>
</body>
</html>
