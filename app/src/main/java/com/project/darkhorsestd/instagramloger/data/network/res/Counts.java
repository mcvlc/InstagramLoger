package com.project.darkhorsestd.instagramloger.data.network.res;

import com.google.gson.annotations.SerializedName;

public class Counts{

	@SerializedName("followed_by")
	private int followedBy;

	@SerializedName("follows")
	private int follows;

	@SerializedName("media")
	private int media;

	public void setFollowedBy(int followedBy){
		this.followedBy = followedBy;
	}

	public int getFollowedBy(){
		return followedBy;
	}

	public void setFollows(int follows){
		this.follows = follows;
	}

	public int getFollows(){
		return follows;
	}

	public void setMedia(int media){
		this.media = media;
	}

	public int getMedia(){
		return media;
	}

	@Override
 	public String toString(){
		return 
			"Counts{" + 
			"followed_by = '" + followedBy + '\'' + 
			",follows = '" + follows + '\'' + 
			",media = '" + media + '\'' + 
			"}";
		}
}