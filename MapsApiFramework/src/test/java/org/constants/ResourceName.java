package org.constants;

public enum ResourceName {
	
	GetPlaceAPI("/maps/api/place/get/json"),
	AddPlaceAPI("/maps/api/place/add/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	
	private String resourse;
	
	ResourceName(String resource){
		this.resourse = resource;
	}
	
	public String getResource() {
		return resourse;
	}

}
