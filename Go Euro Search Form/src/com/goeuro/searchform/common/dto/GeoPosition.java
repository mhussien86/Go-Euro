package com.goeuro.searchform.common.dto;

public class GeoPosition{
   	private Number latitude;
   	private Number longitude;

 	public Number getLatitude(){
		return this.latitude;
	}
	public void setLatitude(Number latitude){
		this.latitude = latitude;
	}
 	public Number getLongitude(){
		return this.longitude;
	}
	public void setLongitude(Number longitude){
		this.longitude = longitude;
	}
}
