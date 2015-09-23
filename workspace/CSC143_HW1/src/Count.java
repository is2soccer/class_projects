
public class Count {
	public static void main(String[] args) {
		countChar("aaa", 'a');

	}
	public static int countChar(String s, char c){
		int count = 0;
		for (int i=0; i<s.length(); i++){
			char n = s.charAt(i);
			if (n==c){
				count++;
			}
		}
		System.out.println(count);
		return count;
		
	}

}
