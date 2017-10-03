package com.medplus.departmentinfo.service.impl;

import com.medplus.departmentinfo.beans.LoginBean;
import com.medplus.departmentinfo.dao.LoginDAO;
import com.medplus.departmentinfo.dao.impl.LoginDAOImpl;
import com.medplus.departmentinfo.service.LoginService;

public class LoginServiceImpl implements LoginService {
	LoginDAO dao = new LoginDAOImpl();

	@Override
	public String addUserLogin(LoginBean loginBean) {
		String status = "failed";
		int rows = dao.addUserLogin(loginBean);
		if (rows > 0)
			status = "added successfully !!";

		return status;
	}

	@Override
	public LoginBean validateUser(String userId) {
		LoginBean loginBean = null;
		loginBean = dao.validateUser(userId);
		return loginBean;
	}

	@Override
	public String updatePassword(String userId, String newPwd) {
		int rows = dao.updatePassword(userId, newPwd);
		String status = "Password Updation Failed !!";
		if (rows > 0)
			status = "Password Updated !!";
		return status;
	}

	@Override
	public String deleteUser(String userId) {
		String status = "fail";
		int row = dao.deleteUser(userId);
		if (row > 0)
			status = "success";
		return status;
	}

}
