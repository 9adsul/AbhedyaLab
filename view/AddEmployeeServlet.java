package com.medplus.departmentinfo.view;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.departmentinfo.beans.EmployeeBean;
import com.medplus.departmentinfo.service.EmployeeService;
import com.medplus.departmentinfo.service.impl.EmployeeServiceImpl;

@WebServlet("/addemployee")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeService service = new EmployeeServiceImpl();
	EmployeeBean bean = new EmployeeBean();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String status = null;
		String empCode = request.getParameter("empcode");

		bean.setEmpCode(request.getParameter("empcode"));
		bean.setDeptNo(Integer.parseInt(request.getParameter("deptno")));
		bean.setFirstName(request.getParameter("firstname"));
		bean.setLastName(request.getParameter("lastname"));
		bean.setJob(request.getParameter("job"));
		bean.setDate(Date.valueOf(request.getParameter("date")));
		bean.setSalary(Double.parseDouble(request.getParameter("salary")));
		status = service.addEmployee(bean, request.getParameter("role"));
		request.setAttribute("status", status);
		request.getRequestDispatcher("viewemployee").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
