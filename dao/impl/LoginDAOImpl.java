package com.medplus.departmentinfo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.medplus.departmentinfo.beans.LoginBean;
import com.medplus.departmentinfo.dao.LoginDAO;
import com.medplus.departmentinfo.utils.DBQueries;
import com.medplus.departmentinfo.utils.DatabaseConnection;

public class LoginDAOImpl implements LoginDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	LoginBean loginBean = null;

	@Override
	public int addUserLogin(LoginBean loginBean) {
		int rows = 0;
		conn = DatabaseConnection.getConnection();
		try {
			// FIRSTNAME =?, LASTNAME=? , JOB=?,SALARY=?, DEPTNO=? WHERE
			// EMPCODE=? "
			pst = conn.prepareStatement(DBQueries.ADD_USER_TO_LOGIN_QRY);
			pst.setString(1, loginBean.getUserId());
			pst.setString(2, loginBean.getPassword());
			pst.setString(3, loginBean.getRole());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error in adduserlogin() ");

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
	public LoginBean validateUser(String userId) {
		conn = DatabaseConnection.getConnection();
		try {
			// FIRSTNAME =?, LASTNAME=? , JOB=?,SALARY=?, DEPTNO=? WHERE
			// EMPCODE=? "
			pst = conn.prepareStatement(DBQueries.VALIDATE_USER_QRY);
			pst.setString(1, userId);
			// //System.out.println("done 1");
			rs = pst.executeQuery();
			// System.out.println("done 2");
			rs.next();
			// System.out.println("done 3");
			loginBean = new LoginBean();
			loginBean.setUserId(rs.getString("UserId"));
			loginBean.setPassword(rs.getString("Password"));
			loginBean.setRole(rs.getString("Role"));
		} catch (SQLException e) {
			System.out.println("Error in validate() ");

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
		return loginBean;
	}

	@Override
	public int updatePassword(String userId, String newPwd) {
		int rows = 0;
		conn = DatabaseConnection.getConnection();
		try {
			// FIRSTNAME =?, LASTNAME=? , JOB=?,SALARY=?, DEPTNO=? WHERE
			// EMPCODE=? "
			pst = conn.prepareStatement(DBQueries.UPDATE_PASSWORD_QRY);
			pst.setString(2, userId);
			pst.setString(1, newPwd);
			rows = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error in updatepassword() ");

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
	public int deleteUser(String UserId) {
		int rows = 0;
		conn = DatabaseConnection.getConnection();
		try {
			// FIRSTNAME =?, LASTNAME=? , JOB=?,SALARY=?, DEPTNO=? WHERE
			// EMPCODE=? "
			pst = conn.prepareStatement(DBQueries.DELETE_USER_QRY);
			pst.setString(1, UserId);
			// //System.out.println("done 1");
			rows = pst.executeUpdate();
			// System.out.println("done 2");

		} catch (SQLException e) {
			System.out.println("Error in validate() ");

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
