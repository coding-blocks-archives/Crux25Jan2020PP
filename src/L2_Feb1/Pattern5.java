package L2_Feb1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Feb-2020
 *
 */

public class Pattern5 {

	public static void main(String[] args) {

		int n = 5;

		int nsp = 0;
		int nst = n;

		int row = 1;

		while (row <= n) {

			// work
			// spaces
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			// stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			// prep
			System.out.println();
			row = row + 1;
			nsp = nsp + 1;
			nst = nst - 1;

		}

	}
}
