package com.medplus.departmentinfo.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.departmentinfo.service.DepartmentService;
import com.medplus.departmentinfo.service.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class DeleteDeptServlet
 */
@WebServlet("/deletedepartment")
public class DeleteDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DepartmentService service = new DepartmentServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
