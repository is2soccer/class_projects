public class CaffeinatedDrinks extends Drinks {

	public CaffeinatedDrinks(String s) {
		super(s);
	}

	public String toString() {
		return super.toString();

	}

	public double getPrice() {
		return super.getPrice() * 3;

	}
}
