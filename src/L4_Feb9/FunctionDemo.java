package L4_Feb9;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Feb-2020
 *
 */

public class FunctionDemo {

	static int val = 1000;

	public static void main(String[] args) {

		System.out.println("hi");

		System.out.println("----------- Case 1 -----------");
		// fxn call
		addition();
		subtraction();

		System.out.println("----------- Case 2 -----------");
		int c = 10;
		int d = 15;
		additionParams(c, d);

		System.out.println("----------- Case 3 -----------");
		c = 10;
		d = 15;
		System.out.println(additionReturn(c, d));

		System.out.println("----------- Case 4 -----------");
		int one = 10, two = 20;
		int sum = demoScopes(one, two);
		System.out.println(sum);

		System.out.println("----------- Case 5 -----------");
		System.out.println(one + ", " + two);
		swap(one, two);
		System.out.println(one + ", " + two);

		System.out.println("----------- Case 6 -----------");
		System.out.println(val);
		int val = 100;
		System.out.println(val);
		System.out.println(FunctionDemo.val);

		val++;
		FunctionDemo.val++;

		System.out.println(val);
		System.out.println(FunctionDemo.val);

		System.out.println(demoGlobalScopes(10));
		System.out.println(FunctionDemo.val);

		System.out.println("bye");
	}

	public static int demoGlobalScopes(int one) {

		int val = 600;
		val++;

		FunctionDemo.val += one;

		return val;
	}

	public static void swap(int one, int two) {

		System.out.println(one + ", " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + ", " + two);
	}

	public static int demoScopes(int one, int another) {

		int sum = one + another;
		return sum;

	}

	public static int additionReturn(int a, int b) {

		int sum = a + b;

		return sum;

	}

	public static void additionParams(int a, int b) {

		int sum = a + b;
		System.out.println(sum);
	}

	// fxn definition
	public static void addition() {

		int a = 100;
		int b = 20;

		int sum = a + b;

		subtraction();

		System.out.println(sum);
	}

	public static void subtraction() {

		int a = 100;
		int b = 60;

		int sub = a - b;

		System.out.println(sub);

	}

}
