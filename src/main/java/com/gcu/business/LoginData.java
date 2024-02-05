package com.gcu.business;

import java.util.List;

import com.gcu.model.LoginModel;

public class LoginData implements SecurityServiceInterface 
{
	String[][] validLogins;

	@Override
	public boolean isAuthenticated(LoginModel loginModel) 
	{
		validLogins = new String[][]
		{
			{"Karsten","Hedrick"},
			{"admin", "root"},
			{"Dylan", "Ogle"}
		};
		
		boolean success = false;
		
		for (int i = 0; i < validLogins.length; i++)
		{
			if (loginModel.getUsername().equals(validLogins[i][0]) && loginModel.getPassword().equals(validLogins[i][1]))
			{
				success = true;
			}
		}
		
		// If valid login, return true
		
		if (success)
			return true;
		else
			return false;
	}
	

	@Override
	public int addNewLogin(LoginModel loginModel) 
	{
		int i = validLogins.length + 1;
		
		validLogins[i][0] = loginModel.getUsername();
		validLogins[i][1] = loginModel.getPassword();
		
		return 1;
	}


	@Override
	public List<LoginModel> getLogins() {
		// TODO Auto-generated method stub
		return null;
	}

}
