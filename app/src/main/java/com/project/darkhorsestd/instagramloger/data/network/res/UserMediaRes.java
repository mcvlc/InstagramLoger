package com.project.darkhorsestd.instagramloger.data.network.res;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class UserMediaRes{

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
			"UserMediaRes{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}