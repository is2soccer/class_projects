
public class e {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mystery_code(2,2,2);
	}
	public static int mystery_code(int a, int b, int c){
		int result = 0;
		if(a<b){
			for(int i=a; i<=b; i++){
				result +=c;
				c++;
			}
		}
		else if(a<=c){
			result +=a;
			a=c-a;
		}
		else{
			result -= (a-b-c);
			a= 2*b;
		}
		System.out.println(result + a + b + c);
		return (result + a + b + c);
	}

}
