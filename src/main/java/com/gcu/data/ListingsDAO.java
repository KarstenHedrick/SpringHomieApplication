package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.gcu.model.ListingModel;

@Repository
public class ListingsDAO implements ListingsDataAccessInterface
{
	private List<ListingModel> listings = new ArrayList<ListingModel>();
	
	public ListingsDAO()
	{
		listings = new ArrayList<ListingModel>();
		listings.add(new ListingModel(0L, "California", "10 West", 11000000.00f, 6, 10416, 9, 2, "Beautiful Home with expensive value!"));
		listings.add(new ListingModel(1L, "New York", "1010 North East", 7325000.00f, 5, 8000, 6, 4, "Neil Patrick Harris and David Burtka listed this home."));
		listings.add(new ListingModel(2L, "California", "CA 8265 Drive", 70000000.00f, 9, 33000, 6, 3, "The Weeknd Purchased this home."));
	}

	@Override
	public ListingModel getById(int id) 
	{
		return listings.stream()
				.filter(listing -> listing.getId() == id)
				.findFirst()
				.get();
	}

	@Override
	public List<ListingModel> getListings() 
	{
		return listings;
	}

	@Override
	public List<ListingModel> searchListings(String searchTerm) 
	{
		List<ListingModel> foundListings = listings
				.stream()
				.filter(order -> order.getLocation().toLowerCase()
						.contains(searchTerm.toString().toLowerCase()))
				.collect(Collectors.toList());
		
		System.out.println("I searched for " + searchTerm + " and found " + foundListings.size() + " listings.");
		return foundListings;
	}

	@Override
	public int addListing(ListingModel newListing) 
	{
		boolean success = listings.add(newListing);
		
		System.out.println("I added one item. Now there are " + listings.size() + " items in the list");
		if (success)
		{
			return 1;
		}
		return 0;
	}

	@Override
	public boolean deleteListing(long id) 
	{
		listings.removeIf(listing -> listing.getId() == id);
		
		System.out.println("I removed one item. Now there are " + listings.size() + " items in the list");
		
		return true;
	}

	@Override
	public ListingModel updateListing(long idToUpdate, ListingModel updateListing) 
	{
		listings.stream().forEach(listing -> {
			if (listing.getId() == idToUpdate) {
				listing.setLocation(updateListing.getLocation());
				listing.setAddress(updateListing.getAddress());
				listing.setDescription(updateListing.getDescription());
				listing.setPrice(updateListing.getPrice());
				listing.setBedrooms(updateListing.getBedrooms());
				listing.setSquareFeet(updateListing.getSquareFeet());
				listing.setBathrooms(updateListing.getBathrooms());
				System.out.println("Updated listing " + updateListing);
			}
		});
		
		System.out.println("You asked me to update listing number " + idToUpdate + ". The updated listing is" +
		updateListing.toString());
		
		System.out.println("I tried to find listing number " + idToUpdate + " but couldn't find one that matches");
		
		return null;
	}
}
