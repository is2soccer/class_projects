
public class Threeheads {

	public static void main(String[] args) {
			int count = 0;
		    String s = "";
		    while (count <3){
		        int i = (int) (Math.random() * 2);
		        if (i == 0){
		            s+="H ";
		            count += 1;
		        }else{
		            s+="T ";
		            count = 0;
		        }
		    }
		    System.out.println(s);
		    System.out.println("Three heads in a row!");
		}
}
