package com.gcu.business;

import java.util.List;
import com.gcu.model.ListingModel;

public interface ListingsBusinessServiceInterface 
{
	public void test();
	public List<ListingModel> getListings();
	public ListingModel getOne(int id);
	public List<ListingModel> searchListings(String searchTerm);
	public int addOne(ListingModel newOrder);
	public boolean deleteOne(long l);
	public ListingModel updateOne(long idToUpdate, ListingModel updateOrder);
	public void init();
	public void destroy();
}
