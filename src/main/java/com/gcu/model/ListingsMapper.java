package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ListingsMapper implements RowMapper<ListingModel>
{
	public ListingModel mapRow(ResultSet resultSet, int i) throws SQLException 
	{
		ListingModel listing = new ListingModel(
				resultSet.getLong("ID"),
				resultSet.getString("LOCATION"),
				resultSet.getString("ADDRESS"),
				resultSet.getFloat("PRICE"),
				resultSet.getInt("BEDROOMS"),
				resultSet.getInt("SQUAREFEET"),
				resultSet.getInt("BATHROOMS"),
				resultSet.getInt("FLOORS"),
				resultSet.getString("DESCRIPTION")
				);
		
		return listing;
	}
}