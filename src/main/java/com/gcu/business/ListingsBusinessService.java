package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ListingsDataAccessInterface;
import com.gcu.model.ListingModel;

public class ListingsBusinessService implements ListingsBusinessServiceInterface 
{
	@Autowired
	ListingsDataAccessInterface listingsDAO;
	
	@Override
	public void test() 
	{
		System.out.println("The test method of the ListingsBusinessService appears to be working if you can see this text.");

	}

	@Override
	public List<ListingModel> getListings() 
	{
		return listingsDAO.getListings();
	}

	@Override
	public void init() 
	{
		System.out.println("Init method of ListingsBusinessService was just called");
	}

	@Override
	public void destroy() 
	{
		System.out.println("Destroy method of ListingsBusinessService was just called.");
	}

	@Override
	public ListingModel getOne(int id) 
	{
		return listingsDAO.getById(id);
	}

	@Override
	public List<ListingModel> searchListings(String searchTerm) 
	{
		return listingsDAO.searchListings(searchTerm);
	}

	@Override
	public int addOne(ListingModel newOrder) 
	{
		return listingsDAO.addListing(newOrder);
	}

	@Override
	public boolean deleteOne(long id) 
	{
		return listingsDAO.deleteListing(id);
	}

	@Override
	public ListingModel updateOne(long idToUpdate, ListingModel updateOrder) 
	{
		return listingsDAO.updateListing(idToUpdate, updateOrder);
	}

}
