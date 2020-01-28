package L1_Jan25;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jan-2020
 *
 */

public class Fibonacci {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int count = 1;

		int a = 0;
		int b = 1;

		while (count <= n + 1) {

			System.out.println(a);

			int sum = a + b;

			a = b;
			b = sum;

			count = count + 1;

		}

		// for (int count = 1; count <= n + 1; count = count + 1) {
		// System.out.println(a);
		//
		// int sum = a + b;
		//
		// a = b;
		// b = sum;
		//
		// }

	}
}
