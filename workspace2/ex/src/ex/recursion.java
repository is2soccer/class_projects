package ex;

public class recursion {
	static int a = 0;
	public static void main(String[] args) {
		System.out.println(recur(27));
		System.out.println(a);

	}
	public static int recur(int n){
		a++;
		if(n<=10){
			return n*2;
		}else{
			return recur(recur(n/3));
		}
	}

}
