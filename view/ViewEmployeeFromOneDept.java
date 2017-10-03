package com.medplus.departmentinfo.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medplus.departmentinfo.beans.EmployeeBean;
import com.medplus.departmentinfo.service.DepartmentService;
import com.medplus.departmentinfo.service.impl.DepartmentServiceImpl;

@WebServlet("/vieemployeefromdept")
public class ViewEmployeeFromOneDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DepartmentService service = new DepartmentServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<EmployeeBean> empList = null;
		empList = service.getALLEmployeeByDeptNo(Integer.parseInt(request
				.getParameter("deptno")));
		if (!empList.isEmpty()) {
			HttpSession session = request.getSession(false);
			session.setAttribute("list", empList);
			request.getRequestDispatcher("viewemp.jsp").forward(request,
					response);
		} else {
			System.out.println("not exist");
		}

	}

}
