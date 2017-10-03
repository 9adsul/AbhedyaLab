package com.medplus.departmentinfo.service;

import com.medplus.departmentinfo.beans.LoginBean;

public interface LoginService {
	public String addUserLogin(LoginBean loginBean);

	public LoginBean validateUser(String userId);

	public String updatePassword(String userId, String newPwd);
	public String deleteUser(String userId);

}
