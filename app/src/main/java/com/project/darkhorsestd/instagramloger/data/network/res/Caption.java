package com.project.darkhorsestd.instagramloger.data.network.res;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Caption{

	@SerializedName("created_time")
	private String createdTime;

	@SerializedName("from")
	private From from;

	@SerializedName("text")
	private String text;

	@SerializedName("id")
	private String id;

	public void setCreatedTime(String createdTime){
		this.createdTime = createdTime;
	}

	public String getCreatedTime(){
		return createdTime;
	}

	public void setFrom(From from){
		this.from = from;
	}

	public From getFrom(){
		return from;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Caption{" + 
			"created_time = '" + createdTime + '\'' + 
			",from = '" + from + '\'' + 
			",text = '" + text + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}