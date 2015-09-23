import java.util.ArrayList;
import java.util.Collections;


public class Client {
	
	public static void main(String[] args) {
		ArrayList<Point> p = new ArrayList<Point>();
		p.add(new Point(1,3));
		p.add(new Point(1,2));
		p.add(new Point(0,2));
		p.add(new Point(1,3));
		Collections.sort(p);
		System.out.print(p);
	}
	

}
