package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.business.SecurityServiceInterface;
import com.gcu.model.LoginModel;
import com.gcu.model.LoginsMapper;

@Repository
public class LoginsDataSQL implements SecurityServiceInterface
{
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	List<LoginModel> logins = new ArrayList<>();
	
	@Override
	public boolean isAuthenticated(LoginModel loginModel) 
	{
		boolean success = false;
		
		for (LoginModel login : logins) 
		{
			if (loginModel.getUsername().equals(login.getUsername())
				&& (loginModel.getPassword().equals(login.getPassword()))) 
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
	public List<LoginModel> getLogins() 
	{
		logins = jdbcTemplate.query("select * from accounts", new LoginsMapper());
		return logins;
	}

	@Override
	public int addNewLogin(LoginModel loginModel) 
	{
		return jdbcTemplate.update("insert into accounts (USERNAME, PASSWORD) values (?,?)",
				loginModel.getUsername(),
				loginModel.getPassword());
	}

}
