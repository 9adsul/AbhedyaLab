package com.medplus.departmentinfo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.departmentinfo.beans.EmployeeBean;
import com.medplus.departmentinfo.dao.EmployeeDAO;
import com.medplus.departmentinfo.utils.DBQueries;
import com.medplus.departmentinfo.utils.DatabaseConnection;

public class EmployeeDAOImpl implements EmployeeDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	EmployeeBean employeeBean = null;

	@Override
	public List<EmployeeBean> getALLEmployee() {

		List<EmployeeBean> empList = new ArrayList<EmployeeBean>();
		conn = DatabaseConnection.getConnection();
		try {
			pst = conn.prepareStatement(DBQueries.GET_ALL_EMPLOYEE_QRY);
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
				//System.out.println("done 2");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error in getALLEMployee() ");

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

	@Override
	public int updateEmployee(EmployeeBean employeeBean) {
		int rows = 0;
		conn = DatabaseConnection.getConnection();
		try {
			// FIRSTNAME =?, LASTNAME=? , JOB=?,SALARY=?, DEPTNO=? WHERE
			// EMPCODE=? "
			pst = conn.prepareStatement(DBQueries.UPDATE_EMPLOYEE_QRY);
			pst.setString(1, employeeBean.getFirstName());
			pst.setString(2, employeeBean.getLastName());
			pst.setString(3, employeeBean.getJob());
			pst.setString(6, employeeBean.getEmpCode());
			pst.setDouble(4, employeeBean.getSalary());
			pst.setInt(5, employeeBean.getDeptNo());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error in updateEmployee() ");

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
	public int addEmployee(EmployeeBean employeeBean) {
		int rows = 0;
		conn = DatabaseConnection.getConnection();
		try {
			pst = conn.prepareStatement(DBQueries.ADD_EMPLOYEE_QRY);
			// EMPCODE, FIRSTNAME, LASTNAME,JOB ,DateOfJoin,SALARY,DEPTNO)
			pst.setString(1, employeeBean.getEmpCode());
			pst.setString(2, employeeBean.getFirstName());
			pst.setString(3, employeeBean.getLastName());
			pst.setString(4, employeeBean.getJob());
			pst.setDate(5, employeeBean.getDate());
			pst.setDouble(6, employeeBean.getSalary());
			pst.setInt(7, employeeBean.getDeptNo());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error in addemployee() ");

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
	public EmployeeBean getEmployeeById(String empCode) {

		conn = DatabaseConnection.getConnection();
		try {
			pst = conn.prepareStatement(DBQueries.GET_EMPLOYEE_BY_ID_QRY);
			pst.setString(1, empCode);
			rs = pst.executeQuery();
			rs.next();

			employeeBean = new EmployeeBean();
			employeeBean.setEmpCode(rs.getString("EMPCODE"));
			employeeBean.setFirstName(rs.getString("FIRSTNAME"));
			employeeBean.setLastName(rs.getString("LASTNAME"));
			employeeBean.setJob(rs.getString("JOB"));
			employeeBean.setSalary(rs.getDouble("SALARY"));
			employeeBean.setDate(rs.getDate("DateOfJoin"));
			employeeBean.setDeptNo(rs.getInt("DEPTNO"));

		} catch (SQLException e) {
			System.out.println("Error in getALLEMployeeByid() ");

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
		return employeeBean;
	}

	@Override
	public int deleteEmployee(String empCode) {
		int rows = 0;
		conn = DatabaseConnection.getConnection();
		try {
			pst = conn.prepareStatement(DBQueries.DELETE_EMPLOYEE_QRY);
			// EMPCODE, FIRSTNAME, LASTNAME,JOB ,DateOfJoin,SALARY,DEPTNO)
			pst.setString(1, empCode);
			System.out.println(empCode);
			rows = pst.executeUpdate();
			System.out.println(empCode);
		} catch (SQLException e) {
			System.out.println("Error in deleteEmployee() ");
			e.printStackTrace();

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
}
