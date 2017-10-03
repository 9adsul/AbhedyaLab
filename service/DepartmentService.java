package com.medplus.departmentinfo.service;

import java.util.List;

import com.medplus.departmentinfo.beans.DepartmentBean;
import com.medplus.departmentinfo.beans.EmployeeBean;

public interface DepartmentService {
	public List<DepartmentBean> getALLDepartment();

	public String updateDepartment(DepartmentBean departmentBean);

	public String addDepartment(DepartmentBean departmentBean);

	public DepartmentBean getDepartmentByID(int deptNo);

	public List<EmployeeBean> getALLEmployeeByDeptNo(int deptNo);
}
