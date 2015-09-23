// This class stores information about your interested place.
// THe name of the place, address, tag, latitude and longitude.
public class PlaceInformation {
	
	private String name;
	private String address;
	private String tag;
	private double lat;
	private double lon;
	
	// constructs a place information object with given name, address, tag, latitude, and longitude.
	public PlaceInformation(String name, String address, String tag, double latitude, double longitude) {
		this.name = name;
		this.address = address;
		this.tag = tag;
		lat = latitude;
		lon = longitude;
		
	}
	
	// return the name of the place
	public String getName(){
		return name;
	}
	
	// return the address of the place
	public String getAddress(){
		return address;
	}
	
	// return the tag of the place
	public String getTag(){
		return tag;
	}
	
	// return the string that contains the name followed by the location details inside parentheses.
	// using method getLocation() to get GeoLocation object and store latitude and longitude.
	public String toString(){
		GeoLocation yourPlace = getLocation();
		return name+"("+address+", "+tag+", " +yourPlace.toString()+")";
	}
	
	// return GeoLocation object regarding to the latitude and longitude of the place.
	public GeoLocation getLocation(){
		GeoLocation a = new GeoLocation(lat,lon);
		return a;
		
	}
	
	// return the distance between the place you are interested in and the spot.
	// using method getLocation() to get GeoLocation object about your place and
	// use distanceFrom() method in GeoLocation class to get a distance.
	public double distanceFrom(GeoLocation spot){
		GeoLocation yourPlace = getLocation();
		return yourPlace.distanceFrom(spot);
		
	}

}
