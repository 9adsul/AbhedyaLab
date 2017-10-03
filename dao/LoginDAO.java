package com.medplus.departmentinfo.dao;

import com.medplus.departmentinfo.beans.LoginBean;

public interface LoginDAO {
	public int addUserLogin(LoginBean loginBean);

	public LoginBean validateUser(String userId);

	public int updatePassword(String userId, String newPwd);
	public int deleteUser(String UserId);

}
