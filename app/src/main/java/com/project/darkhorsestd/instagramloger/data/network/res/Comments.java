package com.project.darkhorsestd.instagramloger.data.network.res;

import com.google.gson.annotations.SerializedName;

public class Comments{

	@SerializedName("count")
	private int count;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	@Override
 	public String toString(){
		return 
			"Comments{" + 
			"count = '" + count + '\'' + 
			"}";
		}
}