package com.project.darkhorsestd.instagramloger.data.network.res.followers;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class UserFollowersRes{

	@SerializedName("data")
	private List<DataItem> data;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"UserFollowersRes{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}