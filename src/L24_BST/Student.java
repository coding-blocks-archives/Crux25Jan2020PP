package L24_BST;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class Student {

	String name;
	int rollNo;
	static int noOfStudents;

	public Student(String name) {
		// name update
		this.name = name;

		// rollNo update
		noOfStudents++;
		this.rollNo = noOfStudents;

	}

	// can i use a static variable in non static fxn ? yes
	// can i use a non static variable in non static fxn ? yes
	// can i call a static fxn from non static fxn ? yes
	// can i call a non static fxn from a non static fxn ? yes
	public void introduceYourself() {

		System.out.println(this.name + " has roll no as " + this.rollNo);
	}

	// you cant use this in static fxn
	// can i use a non static variable/instance variable inside static fxn ? no
	// can i use a static variable inside static fxn ? yes
	// can i call a non static fxn inside a static fxn ? no
	// can i call a static fxn from a static fxn ? yes
	public static void getNoOfStudents() {
		System.out.println(noOfStudents);
	}

}
