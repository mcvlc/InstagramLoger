package com.project.darkhorsestd.instagramloger.data.network.res;


import com.google.gson.annotations.SerializedName;

public class Location{

	@SerializedName("street_address")
	private String streetAddress;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("longitude")
	private double longitude;

	public void setStreetAddress(String streetAddress){
		this.streetAddress = streetAddress;
	}

	public String getStreetAddress(){
		return streetAddress;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"street_address = '" + streetAddress + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}