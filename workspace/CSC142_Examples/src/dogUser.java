
public class dogUser {
	/**
	 * tests the Dog class
	 */
	public static void main(String[] args) {
		Dog d = new Dog("Fido");
		d.rollOver(); // too hungry to play
		d.fetch(); // too hungry to play
		d.bark();
		d.eat("Chicken"); // the dog should eat
		d.eat("Chicken"); // the dog is not hungry and doesn't eat
		d.bark();
		// the dog can play 5 times
		d.fetch();
		d.rollOver();
		d.fetch();
		d.fetch();
		d.rollOver();
		d.fetch(); // the dog is too hungry
		d.eat("Chicken"); // the dog doesn't eat
		d.eat("Beef"); // the dog eats
	}
}
