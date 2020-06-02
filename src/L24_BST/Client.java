package L24_BST;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class Client {

	public static void main(String[] args) {

		Student s = new Student("A");
		Student s1 = new Student("B");

		System.out.println(s.name);
		System.out.println(s1.name);

		System.out.println(Student.noOfStudents);

		// non static fxn : context
		s.introduceYourself();

		// static fxn : context wont be passed
		Student.getNoOfStudents();

	}
}
