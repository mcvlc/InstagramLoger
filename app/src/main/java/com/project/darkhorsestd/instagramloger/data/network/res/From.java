package com.project.darkhorsestd.instagramloger.data.network.res;


import com.google.gson.annotations.SerializedName;


public class From{

	@SerializedName("full_name")
	private String fullName;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	@SerializedName("username")
	private String username;

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
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
			"From{" + 
			"full_name = '" + fullName + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}