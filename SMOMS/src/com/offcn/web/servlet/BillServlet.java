package com.offcn.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.bean.Bill;
import com.offcn.bean.Provider;
import com.offcn.service.BillService;
import com.offcn.service.ProvideService;
import com.offcn.util.DateUtil;

public class BillServlet extends HttpServlet {
	
	BillService bs=new BillService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String method = request.getParameter("method");
		if ("showBills".equals(method)) {
			showBills(request,response);
		}else if ("delete".equals(method)) {
			delete(request,response);
		}else if ("addBill".equals(method)) {
			addBill(request,response);
		}else if ("findBillById".equals(method)) {
			findBillById(request,response);
		}else if ("updateBill".equals(method)) {
			updateBill(request,response);
		}else if ("findBillsBycondition".equals(method)) {
			findBillsBycondition(request,response);
		}else if ("deleteAll".equals(method)) {
			deleteAll(request,response);
		}
		
	}


	
	private void deleteAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String ids = request.getParameter("ids");
		
		bs.deleteAll(ids);
		showBills(request, response);
		
	}

	
	
	private void findBillsBycondition(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 
		String productName= request.getParameter("productName");
		String payStatus=request.getParameter("payStatus");
		
		Bill b = new Bill();
		b.setB_name(productName);
		b.setB_isPay(payStatus);
		
		List<Bill> list = bs.findBillsBycondition(b);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
		
	}

	
	
	
	private void updateBill(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("billNum"));
		String name=request.getParameter("name");
		String num=request.getParameter("num");
		String money=request.getParameter("money");
		String provider=request.getParameter("provider");
		String discription=request.getParameter("discription");
		String isPay=request.getParameter("isPay");
		
		Bill bill=new Bill();
		bill.setB_id(id);
		bill.setB_name(name);
		bill.setB_num(num);
		bill.setB_price(money);
		bill.setB_pro_id(provider);
		bill.setB_desc(discription);
		bill.setB_isPay(isPay);
		
//		bill.setB_status("1");
//		
//		Date date=new Date();
//		bill.setB_time(DateUtil.dateToStr(date));
		
		bs.updateBill(bill);
		showBills(request, response);
		
	}

	private void findBillById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		Bill bill=bs.findBillById(id);
		
		ProvideService ps=new ProvideService();
		List<Provider> list=ps.findAllProvider();
		
		request.setAttribute("list", list);
		request.setAttribute("findBill", bill);
		request.getRequestDispatcher("billUpdate.jsp").forward(request, response);
		
	}

	private void addBill(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String num=request.getParameter("num");
		String money=request.getParameter("money");
		String provider=request.getParameter("provider");
		String discription=request.getParameter("discription");
		String isPay=request.getParameter("isPay");
		
		Bill bill=new Bill();
		bill.setB_name(name);
		bill.setB_num(num);
		bill.setB_price(money);
		bill.setB_pro_id(provider);
		bill.setB_desc(discription);
		bill.setB_isPay(isPay);
		
		bill.setB_status("1");
		
		Date date=new Date();
		bill.setB_time(DateUtil.dateToStr(date));
		
		bs.addBill(bill);
		showBills(request, response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		bs.delete(id);
		showBills(request, response);
	}

	private void showBills(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Bill>list = bs.showBills();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
		
	}


}
