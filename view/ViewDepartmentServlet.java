package com.medplus.departmentinfo.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medplus.departmentinfo.beans.DepartmentBean;
import com.medplus.departmentinfo.service.DepartmentService;
import com.medplus.departmentinfo.service.impl.DepartmentServiceImpl;

@WebServlet("/viewdepartment")
public class ViewDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DepartmentService service = new DepartmentServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<DepartmentBean> deptList = null;
		deptList = service.getALLDepartment();
		//System.out.println("vie1");
		if (!deptList.isEmpty()) {
			HttpSession session = request.getSession(false);
			session.setAttribute("list", deptList);
			request.getRequestDispatcher("viewdept.jsp").forward(request,
					response);
		} else {

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
