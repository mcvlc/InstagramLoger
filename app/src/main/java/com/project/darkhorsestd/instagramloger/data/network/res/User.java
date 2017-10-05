package com.project.darkhorsestd.instagramloger.data.network.res;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class User{

	@SerializedName("profile_picture")
	private String profilePicture;

	@SerializedName("id")
	private String id;

	@SerializedName("username")
	private String username;

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
			"User{" + 
			"profile_picture = '" + profilePicture + '\'' + 
			",id = '" + id + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}