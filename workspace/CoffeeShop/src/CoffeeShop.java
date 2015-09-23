public class CoffeeShop {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();

	}

	public static void test() {
		Drinks d = new Drinks("Medium");
		Coffee c1 = new Coffee("Small", "Mocha");
		Tea t = new Tea("Medium", "Choco");
		Tea t1 = new Tea("Large", "Green");

		double totalCost = d.getPrice() + c1.getPrice() + t.getPrice()
				+ t1.getPrice();

		System.out.println("Your order consists of:\n");
		System.out.println(d.toString());
		System.out.println(c1.toString());
		System.out.println(t.toString());
		System.out.println(t1.toString());

		System.out.println(String.format(
				"\nThe total cost of your order is: $%.2f", totalCost));
	}
}
