public class NonCaffeinatedDrinks extends Drinks {

	public NonCaffeinatedDrinks(String s) {
		super(s);
	}

	public String toString() {
		return super.toString();

	}

	public double getPrice() {
		return super.getPrice() * 2;

	}
}
