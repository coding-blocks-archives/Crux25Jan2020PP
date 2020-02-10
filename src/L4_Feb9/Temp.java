package L4_Feb9;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Feb-2020
 *
 */

public class Temp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int minT = scn.nextInt();
		int maxT = scn.nextInt();
		int step = scn.nextInt();

		for (int f = minT; f <= maxT; f = f + step) {

			int c = (int) ((5.0 / 9) * (f - 32));
			System.out.println(f + "\t" + c);
		}

	}
}







