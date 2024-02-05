package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.SecurityServiceInterface;
import com.gcu.data.ListingsDataAccessInterface;
import com.gcu.data.ListingsDataSQL;
import com.gcu.data.LoginsDataSQL;

@Configuration
public class SpringConfig 
{
	@Bean(name="listingsDAO")
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	@SessionScope
	public ListingsDataAccessInterface getDataSource() 
	{
		return new ListingsDataSQL();
	}
	
	@Bean(name ="securityService")
	public SecurityServiceInterface getSecurityService()
	{
		return new LoginsDataSQL();
	}
}


