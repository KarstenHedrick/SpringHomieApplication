package com.gcu.business;

import java.util.List;

import com.gcu.model.LoginModel;

public interface SecurityServiceInterface 
{
	public boolean isAuthenticated(LoginModel loginModel);
	public List<LoginModel> getLogins();
	public int addNewLogin(LoginModel loginModel);
}
