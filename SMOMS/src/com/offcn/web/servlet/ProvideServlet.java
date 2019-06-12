package com.offcn.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.bean.Provider;
import com.offcn.service.ProvideService;

public class ProvideServlet extends HttpServlet {

	ProvideService ps = new ProvideService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String method = request.getParameter("method");
		if ("findAllProvider".equals(method)) {
			findAllProvider(request, response);
		}else if ("showProviders".equals(method)) {
			showProviders(request,response);
		}else if ("delete".equals(method)) {
			delete(request, response);
		}else if ("findProviderById".equals(method)) {
			findProviderById(request, response);
		}else if ("updateProvider".equals(method)) {
			updateProvider(request,response);
		}else if ("addProvider".equals(method)) {
			addProvider(request, response);
		}else if ("findProvidersBycondition".equals(method)) {
			findProvidersBycondition(request,response);
		}else if ("deleteAll".equals(method)) {
			deleteAll(request,response);
		}

	}
	
	
	private void deleteAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String ids = request.getParameter("ids");
		
		ps.deleteAll(ids);
		showProviders(request, response);
		
	}

	
	
	private void findProvidersBycondition(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 
		String providerName= request.getParameter("providerName");
		String providerDesc=request.getParameter("providerDesc");
		
		Provider p = new Provider();
		p.setPro_name(providerName);
		p.setPro_desc(providerDesc);
		
		List<Provider> list = ps.findProvidersBycondition(p);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("providerAdmin.jsp").forward(request, response);
		
	}

	
	
	

	private void findAllProvider(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{

		List<Provider> list=ps.findAllProvider();
		request.setAttribute("list", list);
		request.getRequestDispatcher("billAdd.jsp").forward(request, response);

	}
	
	private void updateProvider(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("proId"));
		String name=request.getParameter("proName");
		String desc=request.getParameter("proDesc");
		String linkman=request.getParameter("contact");
		String phone=request.getParameter("phone");
		String tel=request.getParameter("fax");
		String addr=request.getParameter("address");
		
		Provider p=new Provider();
		p.setPro_id(id);
		p.setPro_name(name);
		p.setPro_desc(desc);
		p.setPro_linkman(linkman);
		p.setPro_phone(phone);
		p.setPro_tel(tel);
		p.setPro_addr(addr);
		
		ps.updateProvider(p);
		showProviders(request, response);
		
	}

	private void findProviderById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		Provider provider=ps.findProviderById(id);
		
		request.setAttribute("findProvider", provider);
		request.getRequestDispatcher("providerUpdate.jsp").forward(request, response);
		
	}


	@SuppressWarnings("null")
	private void addProvider(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String idString=request.getParameter("proId");
		
		if (idString!=null && idString.length()!=0) {
			int id=Integer.parseInt(idString);
			String name=request.getParameter("proName");
			String desc=request.getParameter("proDesc");
			String linkman=request.getParameter("contact");
			String phone=request.getParameter("phone");
			String tel=request.getParameter("fax");
			String addr=request.getParameter("address");
			
			Provider p=new Provider();
			p.setPro_id(id);
			p.setPro_name(name);
			p.setPro_desc(desc);
			p.setPro_linkman(linkman);
			p.setPro_phone(phone);
			p.setPro_tel(tel);
			p.setPro_addr(addr);
			
			p.setPro_status(1);
			
			ps.addProvider(p);
			showProviders(request, response);
		}else {
			
			showProviders(request, response);
		}
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		ps.delete(id);
		showProviders(request, response);
	}

	private void showProviders(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Provider>list = ps.showProviders();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("providerAdmin.jsp").forward(request, response);
		
	}


}
