package L14_DC;

public class FxnOverloading {

	public static void main(String[] args) {

		sum(2, 3);
		sum(2, 5);

		sum(2,3,4,5) ;

	}

	public static void sum(int a, int b) {
		System.out.println("in sum");
		System.out.println(a + b);
	}

	public static void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}

	public static void sum(double a, int b) {
		System.out.println(a + b);
	}

	public static void sum(int a, int b , int... arr) {
		int sum = 0;

		for (int val : arr) {
			sum += val;
		}

		System.out.println(sum);
	}

}
