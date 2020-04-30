package L16_StackQueue;

public class Student {

	private String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void fun(int age) throws Exception {

		System.out.println("hi fun");

		// try {
		setAge(age);
		// } catch (Exception e) {
		// System.out.println("in catch");
		// }

		System.out.println("bye fun");
	}

	public void setAge(int age) throws Exception {

		System.out.println("hii set age");

		// try {
		if (age < 0) {
			throw new Exception("Invalid Age."); // generate an exception
		}

		this.age = age;
		//
		// } catch (Exception e) {
		// System.out.println("in catch");
		// }

		System.out.println("bye set age");
	}

}
