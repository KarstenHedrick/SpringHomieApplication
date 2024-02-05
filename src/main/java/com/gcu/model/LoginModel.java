package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel 
{
	@NotNull(message="User Name is Required")
	@Size(min=4, max=16, message="User name must be between 1 and 32 characters")
	private String username;
	
	@NotNull(message="Password is Required")
	@Size(min=4, max=16, message="Password must be between 1 and 32 characters")
	private String password;
	
	public LoginModel() 
	{
		super();
		
	}
	
	public LoginModel(String username, String password) 
	{
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	@Override
	public String toString()
	{
		return "LoginModel [username=" + username + ", password=" + password + "]";
	}
}
