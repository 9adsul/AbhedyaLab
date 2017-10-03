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

@WebServlet("/updatedepartment")
public class UpdateDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DepartmentService service = new DepartmentServiceImpl();
	DepartmentBean bean = null;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//bean.setDeptName(request.getParameter("deptno"));
		bean = service.getDepartmentByID(Integer.parseInt(request
				.getParameter("deptno")));
		request.setAttribute("dept", bean);
		request.getRequestDispatcher("updatedept.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		bean = new DepartmentBean();
		bean.setDeptNo(Integer.parseInt(request.getParameter("deptno")));
		bean.setDeptName(request.getParameter("deptname"));
		bean.setLocation(request.getParameter("location"));
		String status = service.updateDepartment(bean);
		request.setAttribute("status", status);
		request.getRequestDispatcher("viewdepartment").forward(request, response);
	}

}
