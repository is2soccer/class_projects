public class Tea extends CaffeinatedDrinks {
	private String name = "Tea";
	private String type = "English Breakfast";

	public Tea(String s, String t) {
		super(s);
		type = t;
	}

	public String toString() {
		String s = String.format(
				name + ", type: " + type + ", size: " + super.getSize()
						+ ", cost: $%.2f", getPrice());
		return s;
	}

	public double getPrice() {
		if (super.getSize().equals("Large")) {
			return super.getPrice() - (4 * 3 * price_per_oz);
		} else {
			return super.getPrice();
		}
	}
}
