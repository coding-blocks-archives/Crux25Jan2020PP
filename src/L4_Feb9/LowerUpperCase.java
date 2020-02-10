package L4_Feb9;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Feb-2020
 *
 */

public class LowerUpperCase {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		char ch = scn.next().charAt(0);

		if (ch >= 'a' && ch <= 'z') {
			System.out.println("Lower Case");
		} else if (ch >= 'A' && ch <= 'Z') {
			System.out.println("Upper Case");
		} else {
			System.out.println("Invalid");
		}

	}
}
