package com.project.darkhorsestd.instagramloger.data.network.res;

import com.google.gson.annotations.SerializedName;


public class UserInfoRes{

	@SerializedName("data")
	private Data data;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}
}