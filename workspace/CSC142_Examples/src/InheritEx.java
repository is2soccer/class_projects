
public class InheritEx {
	public static void main(String [] args){
//		var1.method2();
//		var2.method2();
//		var3.method2();
//		var4.method2();
//		var5.method2();
//		var6.method2();
		var1.method3();
		var2.method3();
//		var5.method3();
//		var6.method3();
		((First) var5).method3();
//		((Second) var6).method1();

	}
	static First var1 = new Second();
	static First var2 = new Third();
	static First var3 = new Fourth();
	static Second var4 = new Third();
	static Object var5 = new Fourth();
	static Object var6 = new Second();
}