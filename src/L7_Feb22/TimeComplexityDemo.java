package L7_Feb22;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 22-Feb-2020
 *
 */

public class TimeComplexityDemo {

	public static void main(String[] args) {

		int n = 10000;
		int m = 1000;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.println("hello");
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.println("hello");
		}

		System.out.println("hello");
	}

}
