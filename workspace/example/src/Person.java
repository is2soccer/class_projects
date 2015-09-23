/**
 * A simple model of a person
 * 
 * @author CSC 142
 * 
 */
public class Person {
	// a person is defined by his/her name and age
	private String name;
	private int age;

	/**
	 * Creates a person given a name and an age
	 * 
	 * @param name
	 *            the name of person
	 * @age the age of the person
	 */
	public Person(String n, int a) {
		name = n;
		age = a;
	}

	/**
	 * Prints the name and age of the person
	 */
	public void speak() {
		System.out.println("My name is " + name + ". My age is " + age + ".");
	}
}
