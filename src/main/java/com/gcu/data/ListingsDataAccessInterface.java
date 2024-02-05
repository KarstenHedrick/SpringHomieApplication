package com.gcu.data;

import java.util.List;

import com.gcu.model.ListingModel;

public interface ListingsDataAccessInterface 
{
	public ListingModel getById(int id);
	public List<ListingModel> getListings();
	public List<ListingModel> searchListings(String searchTerm);
	public int addListing(ListingModel newListing);
	public boolean deleteListing(long id);
	public ListingModel updateListing(long idToUpdate, ListingModel updateListing);
}
