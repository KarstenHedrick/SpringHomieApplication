package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LoginsMapper implements RowMapper<LoginModel>
{
	public LoginModel mapRow(ResultSet resultSet, int i) throws SQLException 
	{
		LoginModel login = new LoginModel(
				resultSet.getString("USERNAME"),
				resultSet.getString("PASSWORD")
				);
		
		return login;
	}
}
