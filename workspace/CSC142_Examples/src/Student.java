/**
 * A Student is a Person with a gpa
 * 
 * @author CSC 142
 * 
 */
public class Student extends Person {
	// the gpa of the student
	private double gpa;

	/**
	 * Creates a student given a name, an age and a gpa
	 * 
	 * @param name
	 *            the name of the student
	 * @param age
	 *            the age of the student
	 * @param gpa
	 *            the gpa of the student
	 */
	public Student(String name, int age, double gpa) {
		// Build the Person part of the Student
		// -> MUST be done first
		super(name, age);
		this.gpa = gpa;
	}

	/**
	 * Prints the name, age and gpa of the student (overrides speak inherited
	 * from Person)
	 */
	public void speak() { // exactly the same signature as in Person
		super.speak();
		System.out.println("gpa = " + gpa);
	}
}
