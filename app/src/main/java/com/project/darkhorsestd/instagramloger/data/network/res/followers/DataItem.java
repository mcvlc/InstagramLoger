package com.project.darkhorsestd.instagramloger.data.network.res.followers;


import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("full_name")
	private String fullName;

	@SerializedName("profile_picture")
	private String profilePicture;

	@SerializedName("id")
	private String id;

	@SerializedName("username")
	private String username;

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
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
			"DataItem{" + 
			"full_name = '" + fullName + '\'' + 
			",profile_picture = '" + profilePicture + '\'' + 
			",id = '" + id + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}