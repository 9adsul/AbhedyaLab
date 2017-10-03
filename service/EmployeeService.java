package com.medplus.departmentinfo.service;

import java.util.List;

import com.medplus.departmentinfo.beans.EmployeeBean;

public interface EmployeeService {

	public List<EmployeeBean> getALLEmployee();

	public String updateEmployee(EmployeeBean employeeBean);

	public String addEmployee(EmployeeBean employeeBean, String role);

	public EmployeeBean getEmployeeById(String empCode);

	public String deleteEmployee(String empCode);
}
