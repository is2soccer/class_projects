import java.util.ArrayList;

public class RemoveInRange {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("to");
		list.add("be");
		list.add("or");
		list.add("not");
		list.add("to");
		list.add("be");
		list.add("that");
		list.add("is");
		list.add("the");
		list.add("question");
		String a = "free";
		String b = "rich";
		System.out.println("Now: "+list);
		removelnRange(list,a,b);
		System.out.println("Result: "+list);
	}
	public static void removelnRange(ArrayList<String> list, String a, String b ){
		char startC = a.charAt(0);
		char lastC = b.charAt(0);
		for (int i = 0; i < list.size(); i++){
			char first = list.get(i).charAt(0);
			for (char c = startC; c<= lastC; c++ ){
				if(first == c){
					list.remove(i);
					i--;
				}
			}
		}
	}
}
