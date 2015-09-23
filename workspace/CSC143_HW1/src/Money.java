public class Money {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = {"1","2","3","4","5","6"};
		method(a);

	}

	public static void method(String[] a) {
		for (int i = 1; i <= (a.length) / 2; i++) {
			String flip1 = a[i - 1];
			String flip2 = a[a.length - i];
			a[i - 1] = flip2;
			a[a.length - i] = flip1;
		}
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[3]);
		System.out.println(a[4]);
		System.out.println(a[5]);

	}

}
