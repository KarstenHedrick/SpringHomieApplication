package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ListingModel 
{
	long id = 0L;
	
	@NotNull(message="Location is Required")
	@Size(min=1, max=32, message="Location must be between 1 and 16 characters")
	String location = "";
	
	@NotNull(message="Address is Required")
	@Size(min=4, max=32, message="Address must be between 4 and 16 characters")
	String address = "";
	
	@NotNull(message="Description is Required")
	@Size(min=10, max=64, message="Description must be between 10 and 32 characters")
	String description = "";
	
	float price = 0;
	int bedrooms = 0;
	int squareFeet = 0;
	int bathrooms = 0;
	int floors = 0;
	
	public ListingModel(Long id, String location, String address, float price, int bedrooms, int squareFeet, int bathrooms, int floors, String description)
	{
		this.id = id;
		this.location = location;
		this.address = address;
		this.price = price;
		this.bedrooms = bedrooms;
		this.squareFeet = squareFeet;
		this.bathrooms = bathrooms;
		this.floors = floors;
		this.description = description;
	}
	
	public ListingModel()
	{
		super();
	}
	
	@Override
	public String toString()
	{
		return "OrderModel [id=" + id + ", orderNo=" + location + ", productName=" + address + ", price=" + price
				+ ", bedrooms=" + bedrooms + ", squareFeet" + squareFeet + ", bathrooms=" + bathrooms + ", floors=" + floors + ", description=" + description + "]";
	}
	
	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}


	public String getLocation() 
	{
		return location;
	}

	public void setLocation(String location) 
	{
		this.location = location;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public int getBedrooms() 
	{
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) 
	{
		this.bedrooms = bedrooms;
	}

	public int getSquareFeet() 
	{
		return squareFeet;
	}

	public void setSquareFeet(int squareFeet) 
	{
		this.squareFeet = squareFeet;
	}

	public int getBathrooms() 
	{
		return bathrooms;
	}

	public void setBathrooms(int bathrooms) 
	{
		this.bathrooms = bathrooms;
	}

	public int getFloors() 
	{
		return floors;
	}

	public void setFloors(int floors) 
	{
		this.floors = floors;
	}

	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public String getOrderNo() 
	{
		return location;
	}

	public void setOrderNo(String orderNo) 
	{
		this.location = orderNo;
	}

	public String getProductName() 
	{
		return address;
	}

	public void setProductName(String productName) 
	{
		this.address = productName;
	}

	public float getPrice() 
	{
		return price;
	}

	public void setPrice(float price) 
	{
		this.price = price;
	}
	
}
