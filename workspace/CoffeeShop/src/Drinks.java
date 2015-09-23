public class Drinks {
	private String name = "Water";
	protected double price_per_oz = 0.10;
	private String size = "Small";

	public Drinks(String s) {
		size = s;

	}

	public String toString() {
		String s = String.format(name + ", size: " + size + ", cost: $%.2f",
				getPrice());
		return s;
	}

	public double getPrice() {
		if (size.equals("Small")) {
			return 6 * price_per_oz;
		} else if (size.equals("Medium")) {
			return 12 * price_per_oz;
		} else {
			return 16 * price_per_oz;
		}
	}

	public String getSize() {
		return size;
	}
}
