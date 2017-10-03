package com.medplus.departmentinfo.service.impl;

import java.util.List;

import com.medplus.departmentinfo.beans.DepartmentBean;
import com.medplus.departmentinfo.beans.EmployeeBean;
import com.medplus.departmentinfo.dao.DepartmentDAO;
import com.medplus.departmentinfo.dao.impl.DepartmentDAOImpl;
import com.medplus.departmentinfo.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	DepartmentDAO dao = new DepartmentDAOImpl();

	@Override
	public List<DepartmentBean> getALLDepartment() {
		List<DepartmentBean> deptList = null;
		deptList = dao.getALLDepartment();
		return deptList;
	}

	@Override
	public String updateDepartment(DepartmentBean departmentBean) {
		String status = "updation failed !!";
		int rows = dao.updateDepartment(departmentBean);
		if (rows > 0)
			status = "updated successfully !!";

		return status;
	}

	@Override
	public String addDepartment(DepartmentBean departmentBean) {
		String status = "registration  failed !!";
		int rows = dao.addDepartment(departmentBean);
		if (rows > 0)
			status = "registered successfully !!";

		return status;

	}

	@Override
	public DepartmentBean getDepartmentByID(int deptNo) {
		DepartmentBean departmentBean = null;
		departmentBean = dao.getDepartmentByID(deptNo);
		return departmentBean;
	}

	@Override
	public List<EmployeeBean> getALLEmployeeByDeptNo(int deptNo) {
		List<EmployeeBean> emplist = null;
		emplist = dao.getALLEmployeeByDeptNo(deptNo);
		return emplist;
	}

}
