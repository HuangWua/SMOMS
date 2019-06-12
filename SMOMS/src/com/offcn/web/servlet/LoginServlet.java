package com.offcn.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.offcn.bean.User;
import com.offcn.service.LoginService;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		String method = req.getParameter("method");

		if ("login".equals(method)) {
			login(req, resp);
		}else if ("esc".equals(method)) {
			esc(req, resp);
		}

	}

	public void login(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String vocde=req.getParameter("vocde");
		HttpSession session=req.getSession();
		String code=(String)session.getAttribute("check_code");
		if (vocde.equals(code)) {
			
			String userName = req.getParameter("userName");
			String passWord = req.getParameter("passWord");
			System.out.print("页面传值：" + userName + "\t" + passWord + "\n");

			User user = new User();
			user.setU_name(userName);
			user.setU_pwd(passWord);

			LoginService ls = new LoginService();
			User u = ls.login(user);

			if (u == null) {
				// 重定向
				// resp.sendRedirect("login.jsp");
				req.setAttribute("message", "用户名或密码错误！");
				req.getRequestDispatcher("login.jsp").forward(req, resp);

			} else {

				HttpSession ss = req.getSession();
				ss.setAttribute("username", u.getU_name());
				req.getRequestDispatcher("admin_index.jsp").forward(req, resp);
			}
		}else {
			
			req.setAttribute("message", "验证码错误!!!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

	}

	public void esc(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.getSession().invalidate();
		
		PrintWriter pw = response.getWriter();
		String url="<script>window.parent.location.href=('";
		url+=request.getContextPath();
		url+="/login.jsp')</script>";
		pw.print(url);
		
	}

}
