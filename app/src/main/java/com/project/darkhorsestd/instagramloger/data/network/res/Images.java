package com.project.darkhorsestd.instagramloger.data.network.res;


import com.google.gson.annotations.SerializedName;

public class Images{

	@SerializedName("thumbnail")
	private Thumbnail thumbnail;

	@SerializedName("low_resolution")
	private LowResolution lowResolution;

	@SerializedName("standard_resolution")
	private StandardResolution standardResolution;

	public void setThumbnail(Thumbnail thumbnail){
		this.thumbnail = thumbnail;
	}

	public Thumbnail getThumbnail(){
		return thumbnail;
	}

	public void setLowResolution(LowResolution lowResolution){
		this.lowResolution = lowResolution;
	}

	public LowResolution getLowResolution(){
		return lowResolution;
	}

	public void setStandardResolution(StandardResolution standardResolution){
		this.standardResolution = standardResolution;
	}

	public StandardResolution getStandardResolution(){
		return standardResolution;
	}

	@Override
 	public String toString(){
		return 
			"Images{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			",low_resolution = '" + lowResolution + '\'' + 
			",standard_resolution = '" + standardResolution + '\'' + 
			"}";
		}
}