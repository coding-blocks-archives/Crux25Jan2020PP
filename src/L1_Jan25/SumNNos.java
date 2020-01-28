package L1_Jan25;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jan-2020
 *
 */

public class SumNNos {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int sum = 0;

		int count = 1;

		while (count <= n) {
			sum = sum + count;
			count = count + 1;
		}

		System.out.println(sum);

	}
}
