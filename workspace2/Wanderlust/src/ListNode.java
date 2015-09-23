public class ListNode {
	public int data;       // data stored in this node
	public String attraction;
	public String city;
	public String country;
	public double distance;
    public ListNode next;  // link to next node in the list
    public ListNode next2;

    // post: constructs a node with data 0 and null link
    public ListNode() {
        this(0, null);
    }

    // post: constructs a node with given data and null link
    public ListNode(int data) {
        this(data, null);
    }

    // post: constructs a node with given data and given link
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
    public ListNode(String attraction, String city, String country, double distance){
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
}
