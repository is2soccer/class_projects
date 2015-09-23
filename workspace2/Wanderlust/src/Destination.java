
public class Destination implements Comparable<Destination> {
	private String attraction;
	private String city;
	private String country;
	private double distance;

	public Destination(String attraction, String city, String country, double distance){
		this.attraction = attraction;
		this.city = city;
		this.country = country;
		this.distance = distance;
	}
	public String getAttraction(){
		return attraction;
	}
	public String getCity(){
		return city;
	}
	public String getCountry(){
		return country;
	}
	public double getDistance(){
		return distance;
	}
	@Override
	public int compareTo(Destination des) {
		int at = this.attraction.toUpperCase().compareTo(des.attraction.toUpperCase());
		return at;
	}
	
}
