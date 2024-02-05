package com.gcu.data;

import java.util.List;

import com.gcu.model.LoginModel;

public interface LoginsDataAccessInterface 
{
	public boolean isAuthenticated(LoginModel loginModel);
	public List<LoginModel> getLogins();
	public int addNewLogin(LoginModel loginModel);
}
