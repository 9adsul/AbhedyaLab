package com.medplus.departmentinfo.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.departmentinfo.service.EmployeeService;
import com.medplus.departmentinfo.service.LoginService;
import com.medplus.departmentinfo.service.impl.EmployeeServiceImpl;
import com.medplus.departmentinfo.service.impl.LoginServiceImpl;

@WebServlet("/deleteemployee")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService service = new EmployeeServiceImpl();
	LoginService logService = new LoginServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String empCode = request.getParameter("empcode");
		logService.deleteUser(empCode);
		String status = service.deleteEmployee(empCode);
		request.setAttribute("status", status);
		request.getRequestDispatcher("viewemployee").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
