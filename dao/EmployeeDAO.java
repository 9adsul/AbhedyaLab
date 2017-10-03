package com.medplus.departmentinfo.dao;

import java.util.List;

import com.medplus.departmentinfo.beans.EmployeeBean;

public interface EmployeeDAO {
	public List<EmployeeBean> getALLEmployee();

	public int updateEmployee(EmployeeBean employeeBean);

	public int addEmployee(EmployeeBean employeeBean);

	public EmployeeBean getEmployeeById(String empCode);

	public int deleteEmployee(String empCode);

}
