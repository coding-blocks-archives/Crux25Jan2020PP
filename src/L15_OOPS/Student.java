package L15_OOPS;

public class Student {

	// data members
	String name = "Yash";
	int age = 40;

	// constructor
	public Student() {

		System.out.println("no argument constructor");
		this.name = "Rohit";
		this.age = 30;

	}

	public Student(String name, int age) {

		this.name = name;
		this.age = age;
	}

	public void introduceYourself() {
		System.out.println(name + " is " + age + " years old.");
	}

	public void sayHi(String name) {
		System.out.println(this.name + " says hi to " + name);
	}

	public void test(Student s) {
		s.introduceYourself();
		// this.introduceYourself();
	}

}
