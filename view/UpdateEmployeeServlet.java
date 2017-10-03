package com.medplus.departmentinfo.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.departmentinfo.beans.EmployeeBean;
import com.medplus.departmentinfo.service.EmployeeService;
import com.medplus.departmentinfo.service.impl.EmployeeServiceImpl;

@WebServlet("/updateemployee")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeService service = new EmployeeServiceImpl();
	EmployeeBean bean = new EmployeeBean();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String status = null;
		String empCode = request.getParameter("empcode");
		/*
		 * bean.setEmpCode(request.getParameter("empcode"));
		 * bean.setDeptNo(Integer.parseInt(request.getParameter("deptno")));
		 * bean.setFirstName(request.getParameter("firstname"));
		 * bean.setLastName(request.getParameter("lastname"));
		 * bean.setJob(request.getParameter("job"));
		 * bean.setSalary(Double.parseDouble(request.getParameter("salary")));
		 * service.updateEmployee(bean); request.setAttribute("status", status);
		 * request.getRequestDispatcher("viewemp.jsp").forward(request,
		 * response);
		 */

		bean = service.getEmployeeById(empCode);
		request.setAttribute("emp", bean);
		request.getRequestDispatcher("updateemp.jsp")
				.forward(request, response);
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String status = null;
		String empCode = request.getParameter("empcode");

		bean.setEmpCode(request.getParameter("empcode"));
		bean.setDeptNo(Integer.parseInt(request.getParameter("deptno")));
		bean.setFirstName(request.getParameter("firstname"));
		bean.setLastName(request.getParameter("lastname"));
		bean.setJob(request.getParameter("job"));
		// System.out.println(request.getParameter("salary"));
		bean.setSalary(Double.parseDouble(request.getParameter("salary")));
		status = service.updateEmployee(bean);
		request.setAttribute("status", status);
		request.getRequestDispatcher("viewemployee").forward(request, response);

	}

}
