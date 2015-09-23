package ex;

public class WeekSix {

	public static void main(String[] args) {
		int i = 5;
		long start = System.nanoTime();
		int result =catalanSlow(i);
		long end = System.nanoTime();
		long duration = (end - start);
		System.out.println(duration);
		System.out.println(result);

	}
	public static int catalanSlow(int n){
		
		if(n == 1){
			return 1;
		} else{
			return ((catalanSlow(n-1)*(2*(n-1)+2)*(2*(n-1)+1))/((n)*(n+1)));
		}
		
	}
}
