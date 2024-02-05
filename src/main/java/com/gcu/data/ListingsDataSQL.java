package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.model.ListingModel;
import com.gcu.model.ListingsMapper;

@Repository
public class ListingsDataSQL  implements ListingsDataAccessInterface 
{
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public ListingModel getById(int id) 
	{
		return jdbcTemplate.queryForObject("select * from listings where id = ?", new ListingsMapper(),
				new Object[] {id});
	}

	@Override
	public List<ListingModel> getListings() 
	{
		List<ListingModel> listings = jdbcTemplate.query("select * from listings", new ListingsMapper());
		return listings;
	}

	@Override
	public List<ListingModel> searchListings(String searchTerm) 
	{
		return jdbcTemplate.query("select * from listings where LOCATION LIKE ?",
				new ListingsMapper(),
				new Object[] {"%" + searchTerm + "%"});
	}

	@Override
	public int addListing(ListingModel newListing) 
	{
		return jdbcTemplate.update("insert into listings (ID, LOCATION, ADDRESS, PRICE, BEDROOMS, SQUAREFEET, BATHROOMS, FLOORS, DESCRIPTION) values (?,?,?,?,?,?,?,?,?)",
				newListing.getId(),
				newListing.getLocation(),
				newListing.getAddress(),
				newListing.getPrice(),
				newListing.getBedrooms(),
				newListing.getSquareFeet(),
				newListing.getBathrooms(),
				newListing.getFloors(),
				newListing.getDescription());
	}

	@Override
	public boolean deleteListing(long id) 
	{
		int updateResult = jdbcTemplate.update("delete from listings where id = ?",
				new Object[] {id});
		
		return (updateResult > 0);
	}

	@Override
	public ListingModel updateListing(long idToUpdate, ListingModel updateListing) 
	{
		int updateResult = jdbcTemplate.update("update listings set LOCATION = ?, ADDRESS = ?, PRICE = ?, BEDROOMS = ?, SQUAREFEET = ?, BATHROOMS = ?, FLOORS = ?, DESCRIPTION = ? where ID = ?",
				updateListing.getLocation(),
				updateListing.getAddress(),
				updateListing.getPrice(),
				updateListing.getBedrooms(),
				updateListing.getSquareFeet(),
				updateListing.getBathrooms(),
				updateListing.getFloors(),
				updateListing.getDescription(),
				updateListing.getId());
		
		if (updateResult > 0)
			return updateListing;
		
		return null;
	}
	
}
