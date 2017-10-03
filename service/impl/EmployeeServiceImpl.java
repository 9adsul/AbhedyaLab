package com.medplus.departmentinfo.service.impl;

import java.util.List;

import com.medplus.departmentinfo.beans.EmployeeBean;
import com.medplus.departmentinfo.beans.LoginBean;
import com.medplus.departmentinfo.dao.EmployeeDAO;
import com.medplus.departmentinfo.dao.LoginDAO;
import com.medplus.departmentinfo.dao.impl.EmployeeDAOImpl;
import com.medplus.departmentinfo.dao.impl.LoginDAOImpl;
import com.medplus.departmentinfo.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO dao = new EmployeeDAOImpl();
	LoginDAO logDAO = new LoginDAOImpl();
	LoginBean loginBean = new LoginBean();

	@Override
	public List<EmployeeBean> getALLEmployee() {
		List<EmployeeBean> empList = null;
		empList = dao.getALLEmployee();
		return empList;
	}

	@Override
	public String updateEmployee(EmployeeBean employeeBean) {
		String status = "updation failed !!";
		int rows = dao.updateEmployee(employeeBean);
		if (rows > 0)
			status = "updated successfully !!";

		return status;
	}

	@Override
	public String addEmployee(EmployeeBean employeeBean, String role) {
		String status = "registration  failed !!";
		String pwd = "Test@123";
		int rows = dao.addEmployee(employeeBean);
		if (rows > 0) {
			loginBean.setPassword(pwd);
			loginBean.setUserId(employeeBean.getEmpCode());
			loginBean.setRole(role);
			int r = logDAO.addUserLogin(loginBean);
			if (r > 0) {
				status = "UserID: " + employeeBean.getEmpCode() + " password :"
						+ pwd;
			} else {
				status = "for userId and password Contact admin";
			}

		}
		return status;

	}

	@Override
	public EmployeeBean getEmployeeById(String empCode) {
		EmployeeBean employeeBean = null;
		employeeBean = dao.getEmployeeById(empCode);
		return employeeBean;
	}

	@Override
	public String deleteEmployee(String empCode) {
		String status = "deletion  failed !!";
		int rows = dao.deleteEmployee(empCode);
		if (rows > 0)

			status = "deletion successfully !!";

		return status;
	}

}
