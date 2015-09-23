
public class Point implements Comparable<Point> {
	
	private int x;
	private int y;
	
	public Point(int i, int j){
		x = i;
		y = j;
	}

	public int compareTo(Point p) {
		if(y<p.y){
			return -1;
		}else if(y==p.y){
			if(x<p.x){
				return -1;
			}else if(x>p.x){
				return 1;
			}else
				return 0;
		}else
			return 1;
	}
	public String toString(){
		return "("+x+","+y+")";
	}
}
