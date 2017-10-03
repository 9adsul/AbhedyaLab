package com.medplus.departmentinfo.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medplus.departmentinfo.beans.LoginBean;
import com.medplus.departmentinfo.service.LoginService;
import com.medplus.departmentinfo.service.impl.LoginServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginService service = new LoginServiceImpl();
	LoginBean bean = null;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		bean = service.validateUser(userId);
		if (bean.getPassword() != null && bean.getPassword().equals(pwd)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("role", bean.getRole());
			session.setAttribute("user", bean.getUserId());
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			System.out.println("esle in login servlet");
			request.setAttribute("status", "Invalid Username or Password");
			request.getRequestDispatcher("login.jsp")
					.include(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
