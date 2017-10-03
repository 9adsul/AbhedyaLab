package com.medplus.departmentinfo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.departmentinfo.beans.DepartmentBean;
import com.medplus.departmentinfo.beans.EmployeeBean;
import com.medplus.departmentinfo.dao.DepartmentDAO;
import com.medplus.departmentinfo.utils.DBQueries;
import com.medplus.departmentinfo.utils.DatabaseConnection;

public class DepartmentDAOImpl implements DepartmentDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	DepartmentBean departmentBean = null;

	@Override
	public List<DepartmentBean> getALLDepartment() {
		// TODO Auto-generated method stub

		List<DepartmentBean> deptList = new ArrayList<DepartmentBean>();
		conn = DatabaseConnection.getConnection();
		try {
			pst = conn.prepareStatement(DBQueries.GET_ALL_DEPARTMENT_QRY);
			rs = pst.executeQuery();
			while (rs.next()) {

				departmentBean = new DepartmentBean();
				departmentBean.setDeptNo(rs.getInt("DEPTNO"));
				departmentBean.setDeptName(rs.getString("DEPTNAME"));
				departmentBean.setLocation(rs.getString("LOCATION"));
				deptList.add(departmentBean);
			}
		} catch (SQLException e) {
			System.out.println("Error in getALLDepartment() ");

		} finally {
			try {
				rs.close();
				pst.close();
				DatabaseConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deptList;
	}

	@Override
	public int updateDepartment(DepartmentBean departmentBean) {
		int rows = 0;
		conn = DatabaseConnection.getConnection();
		try {
			pst = conn.prepareStatement(DBQueries.UPDATE_DEPARTMENT_QRY);
			pst.setString(1, departmentBean.getDeptName());
			pst.setString(2, departmentBean.getLocation());
			pst.setInt(3, departmentBean.getDeptNo());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error in updateDepartment() ");

		} finally {
			try {

				pst.close();
				DatabaseConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
	}

	@Override
	public int addDepartment(DepartmentBean departmentBean) {
		int rows = 0;
		conn = DatabaseConnection.getConnection();
		try {
			pst = conn.prepareStatement(DBQueries.ADD_DEPTARTMENT_QRY);
			pst.setString(2, departmentBean.getDeptName());
			pst.setString(3, departmentBean.getLocation());
			pst.setInt(1, departmentBean.getDeptNo());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error in addDepartment() ");

		} finally {
			try {
				pst.close();
				DatabaseConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
	}

	@Override
	public DepartmentBean getDepartmentByID(int deptNo) {

		conn = DatabaseConnection.getConnection();
		try {
			pst = conn.prepareStatement(DBQueries.GET_DEPARTMENT_BY_ID_QRY);
			pst.setInt(1, deptNo);
			rs = pst.executeQuery();
			rs.next();

			departmentBean = new DepartmentBean();
			departmentBean.setDeptNo(rs.getInt("DEPTNO"));
			departmentBean.setDeptName(rs.getString("DEPTNAME"));
			departmentBean.setLocation(rs.getString("LOCATION"));

		} catch (SQLException e) {
			System.out.println("Error in getALLDepartment() ");

		} finally {
			try {
				rs.close();
				pst.close();
				DatabaseConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return departmentBean;
	}

	@Override
	public List<EmployeeBean> getALLEmployeeByDeptNo(int deptNo) {
		List<EmployeeBean> empList = new ArrayList<EmployeeBean>();
		EmployeeBean employeeBean = null;
		conn = DatabaseConnection.getConnection();
		try {
			pst = conn
					.prepareStatement(DBQueries.GET_ALL_EMPLOYEE_FROM_DEPT_QRY);
			pst.setInt(1, deptNo);
			// System.out.println("done 1");
			rs = pst.executeQuery();

			while (rs.next()) {

				employeeBean = new EmployeeBean();
				employeeBean.setEmpCode(rs.getString("EMPCODE"));
				employeeBean.setFirstName(rs.getString("FIRSTNAME"));
				employeeBean.setLastName(rs.getString("LASTNAME"));
				employeeBean.setJob(rs.getString("JOB"));
				employeeBean.setSalary(rs.getDouble("SALARY"));
				employeeBean.setDate(rs.getDate("DateOfJoin"));
				employeeBean.setDeptNo(rs.getInt("DEPTNO"));
				empList.add(employeeBean);
				// System.out.println("done 2");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error in getALLEMployeeFromDEPT() ");

		} finally {
			try {
				rs.close();
				pst.close();
				DatabaseConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return empList;
	}

}
