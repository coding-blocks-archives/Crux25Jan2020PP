package L2_Feb1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Feb-2020
 *
 */

public class Pattern16 {

	public static void main(String[] args) {

		int n = 5;
		int nsp = n - 1;
		int nst = n;

		int row = 1;

		while (row <= 2 * n - 1) {

			// work
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			// prep
			System.out.println();

			if (row <= n - 1) {
				nsp = nsp - 1;
				nst = nst - 1;
			} else {
				nsp = nsp + 1;
				nst = nst + 1;
			}

			row = row + 1;
		}

	}
}
