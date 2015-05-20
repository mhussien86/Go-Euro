
package com.goeuro.searchform.common.dto;

public class Trip{
   	private Number _id;
   	private boolean coreCountry;
   	private String country;
   	private String countryCode;
   	private String distance;
   	private String fullName;
   	private GeoPosition geo_position;
   	private String iata_airport_code;
   	private boolean inEurope;
   	private String key;
   	private Number locationId;
   	private String name;
   	private String type;

 	public Number get_id(){
		return this._id;
	}
	public void set_id(Number _id){
		this._id = _id;
	}
 	public boolean getCoreCountry(){
		return this.coreCountry;
	}
	public void setCoreCountry(boolean coreCountry){
		this.coreCountry = coreCountry;
	}
 	public String getCountry(){
		return this.country;
	}
	public void setCountry(String country){
		this.country = country;
	}
 	public String getCountryCode(){
		return this.countryCode;
	}
	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}
 	public String getDistance(){
		return this.distance;
	}
	public void setDistance(String distance){
		this.distance = distance;
	}
 	public String getFullName(){
		return this.fullName;
	}
	public void setFullName(String fullName){
		this.fullName = fullName;
	}
 	public GeoPosition getGeo_position(){
		return this.geo_position;
	}
	public void setGeo_position(GeoPosition geo_position){
		this.geo_position = geo_position;
	}
 	public String getIata_airport_code(){
		return this.iata_airport_code;
	}
	public void setIata_airport_code(String iata_airport_code){
		this.iata_airport_code = iata_airport_code;
	}
 	public boolean getInEurope(){
		return this.inEurope;
	}
	public void setInEurope(boolean inEurope){
		this.inEurope = inEurope;
	}
 	public String getKey(){
		return this.key;
	}
	public void setKey(String key){
		this.key = key;
	}
 	public Number getLocationId(){
		return this.locationId;
	}
	public void setLocationId(Number locationId){
		this.locationId = locationId;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type;
	}
}
