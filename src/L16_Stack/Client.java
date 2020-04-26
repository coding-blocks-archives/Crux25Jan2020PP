package L16_Stack;

public class Client {

	public static void main(String[] args) {

		System.out.println("hi");

		try {
			Student s = new Student();
			s.fun(10);
			System.out.println(s.getAge());
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("in catch");
		} finally {
			System.out.println("in finally");
		}

		System.out.println("bye");

	}
}
