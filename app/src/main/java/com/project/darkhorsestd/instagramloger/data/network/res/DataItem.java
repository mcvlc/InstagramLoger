package com.project.darkhorsestd.instagramloger.data.network.res;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DataItem{
	@SerializedName("created_time")
	private String createdTime;

	@SerializedName("images")
	private Images images;

	@SerializedName("comments")
	private Comments comments;

	@SerializedName("users_in_photo")
	private List<Object> usersInPhoto;

	@SerializedName("link")
	private String link;

	@SerializedName("caption")
	private Caption caption;

	@SerializedName("type")
	private String type;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("filter")
	private String filter;

	@SerializedName("location")
	private Location location;

	@SerializedName("id")
	private String id;

	@SerializedName("user")
	private User user;

	@SerializedName("likes")
	private Likes likes;

	public void setCreatedTime(String createdTime){
		this.createdTime = createdTime;
	}

	public String getCreatedTime(){
		return createdTime;
	}

	public void setImages(Images images){
		this.images = images;
	}

	public Images getImages(){
		return images;
	}

	public void setComments(Comments comments){
		this.comments = comments;
	}

	public Comments getComments(){
		return comments;
	}

	public void setUsersInPhoto(List<Object> usersInPhoto){
		this.usersInPhoto = usersInPhoto;
	}

	public List<Object> getUsersInPhoto(){
		return usersInPhoto;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setCaption(Caption caption){
		this.caption = caption;
	}

	public Caption getCaption(){
		return caption;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	public void setFilter(String filter){
		this.filter = filter;
	}

	public String getFilter(){
		return filter;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setLikes(Likes likes){
		this.likes = likes;
	}

	public Likes getLikes(){
		return likes;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"created_time = '" + createdTime + '\'' + 
			",images = '" + images + '\'' + 
			",comments = '" + comments + '\'' + 
			",users_in_photo = '" + usersInPhoto + '\'' + 
			",link = '" + link + '\'' + 
			",caption = '" + caption + '\'' + 
			",type = '" + type + '\'' + 
			",tags = '" + tags + '\'' + 
			",filter = '" + filter + '\'' + 
			",location = '" + location + '\'' + 
			",id = '" + id + '\'' + 
			",user = '" + user + '\'' + 
			",likes = '" + likes + '\'' + 
			"}";
		}
}