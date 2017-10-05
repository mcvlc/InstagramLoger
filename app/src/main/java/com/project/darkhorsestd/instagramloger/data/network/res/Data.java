package com.project.darkhorsestd.instagramloger.data.network.res;

import com.google.gson.annotations.SerializedName;


public class Data{

	@SerializedName("website")
	private String website;

	@SerializedName("full_name")
	private String fullName;

	@SerializedName("counts")
	private Counts counts;

	@SerializedName("bio")
	private String bio;

	@SerializedName("profile_picture")
	private String profilePicture;

	@SerializedName("id")
	private String id;

	@SerializedName("username")
	private String username;

	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}

	public void setCounts(Counts counts){
		this.counts = counts;
	}

	public Counts getCounts(){
		return counts;
	}

	public void setBio(String bio){
		this.bio = bio;
	}

	public String getBio(){
		return bio;
	}

	public void setProfilePicture(String profilePicture){
		this.profilePicture = profilePicture;
	}

	public String getProfilePicture(){
		return profilePicture;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"website = '" + website + '\'' + 
			",full_name = '" + fullName + '\'' + 
			",counts = '" + counts + '\'' + 
			",bio = '" + bio + '\'' + 
			",profile_picture = '" + profilePicture + '\'' + 
			",id = '" + id + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}