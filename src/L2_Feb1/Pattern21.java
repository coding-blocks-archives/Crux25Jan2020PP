package L2_Feb1;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Feb-2020
 *
 */

public class Pattern21 {

	public static void main(String[] args) {

		int n = 11;

		int nst = 1;
		int nsp = 2 * n - 3;

		int row = 1;

		while (row <= n) {

			// work
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			int cst = 1;

			if (row == n)
				cst = 2;

			for (; cst <= nst; cst++) {
				System.out.print("*");
			}

			// prep
			System.out.println();
			nst++;
			nsp -= 2;

			row++;

		}

	}
}
