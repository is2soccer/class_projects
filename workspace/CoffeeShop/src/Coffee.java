public class Coffee extends CaffeinatedDrinks {
	private String name = "Coffee";
	private String type = "Drip";
	private double price_surcharge_med = 0.50;
	private double price_surcharge_lar = 1.00;

	public Coffee(String s, String t) {
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
		if (super.getSize().equals("Medium")) {
			return super.getPrice() + price_surcharge_med;
		} else if (super.getSize().equals("Large")) {
			return super.getPrice() + price_surcharge_lar;
		} else {
			return super.getPrice();
		}
	}
}
