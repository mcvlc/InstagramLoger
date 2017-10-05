package com.project.darkhorsestd.instagramloger.data.network.res;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
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