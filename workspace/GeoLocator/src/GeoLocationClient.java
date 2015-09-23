
public class GeoLocationClient {
	
	private static GeoLocation stash = new GeoLocation(34.988889, -106.614444);
	private static GeoLocation studio = new GeoLocation(34.989978, -106.614357);
	private static GeoLocation fbi = new GeoLocation(35.131281, -106.61263);
	
	public static void main(String[] args) {
		
		System.out.println("the stash is at "+ stash.toString());
		System.out.println("ABQ studio is at "+ studio.toString());
		System.out.println("FBI building is at "+ fbi.toString());
		System.out.println("distance in miles between:");
		
		System.out.println("    stash/studio = "+stash.distanceFrom(studio));
		System.out.println("    stash/fbi = "+stash.distanceFrom(fbi));
		
	}
}
