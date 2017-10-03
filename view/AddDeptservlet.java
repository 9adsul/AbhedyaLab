package com.medplus.departmentinfo.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.departmentinfo.beans.DepartmentBean;
import com.medplus.departmentinfo.service.DepartmentService;
import com.medplus.departmentinfo.service.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class AddDeptservlet
 */
@WebServlet("/adddepartment")
public class AddDeptservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DepartmentService service = new DepartmentServiceImpl();
	DepartmentBean bean = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bean = new DepartmentBean();
		bean.setDeptNo(Integer.parseInt(request.getParameter("deptno")));
		bean.setDeptName(request.getParameter("deptname"));
		bean.setLocation(request.getParameter("location"));
		//System.out.println("add");
		String status = service.addDepartment(bean);
		//System.out.println(status);
		request.setAttribute("status", status);
		request.getRequestDispatcher("viewdepartment").forward(request, response);
		
	}

}
