package com.gcu;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.data.ListingsDataAccessInterface;
import com.gcu.model.ListingModel;
import com.gcu.model.SearchListingModel;

@Controller
@RequestMapping("/listings")
public class ListingsController 
{
	@Autowired
	private ListingsDataAccessInterface listingsDAO;
	
	// Display All Listings
	@GetMapping("/")
	public String showAllListings(Model model)
	{
		// Get Listings
		List<ListingModel> listings = listingsDAO.getListings();
				
		// Display Listings View
		model.addAttribute("title", "Current Listings");
		model.addAttribute("listings", listings);
		
		return "listings";
	}
	
	// Catalog Page
	@GetMapping("/catalog/")
	public String showCatalog(Model model)
	{
		// Get Listings
		List<ListingModel> listings = listingsDAO.getListings();
				
		// Display Listings View
		model.addAttribute("title", "Current Listings");
		model.addAttribute("listings", listings);
		
		return "catalog";
	}
	
	// Show User Listings
	@GetMapping("/userListings/")
	public String showUserListings()
	{
		return "userListings";
	}
	
	// Search Input Page
	@GetMapping("/search")
	public String searchInput(Model model) 
	{
		model.addAttribute("title", "Search for Listings");
		model.addAttribute("searchListingModel", new SearchListingModel());
		
		return "search.html";
	}
	
	// Post Search
	@PostMapping("/searchResults")
	public String searchListings(SearchListingModel searchModel, Model model)
	{
		
		List<ListingModel> results = listingsDAO.searchListings(searchModel.getSearchTerm());
		
		// Display Listings View
		model.addAttribute("title", "Search Results");
		model.addAttribute("results", results);
		
		return "searchResults.html";
	}
	
	// Add New Listing Get and Post
	@GetMapping("/add")
	public String addListing(Model model)
	{
		ListingModel lm = new ListingModel();
		model.addAttribute("listing", lm);
		return "addListing";
	}
	
	// Post Add Method
	@PostMapping("/postAdd")
	public String postAdd(@Valid ListingModel addListing, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("listing", addListing);
			return "addListing";
		}
		else 
		{
			model.addAttribute("title", "Listing Summary");
			model.addAttribute("listing", addListing);
			listingsDAO.addListing(addListing);
			
			return "listingSummary";
		}
	}
	
	// Delete Listing
	@GetMapping("/delete/{id}")
	public String deleteListing(@PathVariable(name="id") int id, Model model)
	{
		listingsDAO.deleteListing(id);
		return "redirect:/listings/";
	}
	
	// Edit Listing
	@GetMapping("/edit/{id}")
	public String editListing(@PathVariable(value = "id") Integer id, Model model)
	{
		ListingModel listing = listingsDAO.getById(id);
		model.addAttribute("listing", listing);
		
		return "editListing";
	}
	
	// Edit Listing
	@GetMapping("/{id}")
	public String viewListing(@PathVariable(value = "id") Integer id, Model model)
	{
		ListingModel listing = listingsDAO.getById(id);
		model.addAttribute("listing", listing);
			
		return "viewListing.html";
	}
	
	@PostMapping("/postEdit")
	public String postEdit(ListingModel listing)
	{
		listingsDAO.updateListing(listing.getId(), listing);
		return "redirect:/listings/";
	}
}
