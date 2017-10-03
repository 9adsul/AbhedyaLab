package com.medplus.departmentinfo.dao;

import java.util.List;

import com.medplus.departmentinfo.beans.DepartmentBean;
import com.medplus.departmentinfo.beans.EmployeeBean;

public interface DepartmentDAO {
	public List<DepartmentBean> getALLDepartment();

	public int updateDepartment(DepartmentBean departmentBean);

	public int addDepartment(DepartmentBean departmentBean);

	public DepartmentBean getDepartmentByID(int deptNo);

	public List<EmployeeBean> getALLEmployeeByDeptNo(int deptNo);
}
