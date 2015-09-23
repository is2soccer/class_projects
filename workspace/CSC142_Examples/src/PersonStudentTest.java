/**
 * A test of the Person and Student classes
 * 
 * @author CSC 142
 * 
 */
public class PersonStudentTest {
	public static void main(String[] args) {
		Student s = new Student("Sara", 29, 3.9);
		// since a person can speak, so can a student.
		s.speak(); // if there is no speak in Student, executes
		// speak from Person
		// or if speak is overridden in Student, executes speak in
		// Student

		Person p = s;
		// p has a static type = Person -> it is defined when
		// the variable p is declared and it never changes.
		// p has dynamic type = Student -> the dynamic may change
		// (e.g. p = new Person("Huy", 25); the dynamic would be
		// Person), or it may not be defined (e.g. p = null)
		p.speak();
		// this line compiles because there is a speak method
		// in Person (this is because the compiler only looks at
		// static types)
		// at execution, the JVM looks for speak in the class
		// that defines the dynamic type of p -> here Student
		// if not found (which is not the case here), the JVM
		// goes up the hierarchy of classes until it finds speak
		// -> it will be found for sure since the compiler assured
		// that speak was available in the static type (here Person)

		String[] name = { "Aaron", "Xiaomei", "Kawin", "Brad" };
		Person[] a = new Person[name.length];

		for (int i = 0; i < a.length; i++) {
			int age = (int) (Math.random() * 10 + 20);
			if (Math.random() < 0.5) { // person
				a[i] = new Person(name[i], age);
			} else { // student
				double gpa = 3.5 + Math.random() * 0.5;
				a[i] = new Student(name[i], age, gpa);
			}
		}

		for (Person e : a) {
			e.speak();
			System.out.println();
		}

	}

}
