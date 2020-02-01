package L2_Feb1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Feb-2020
 *
 */

public class Pattern17 {

	public static void main(String[] args) {

		int n = 25;

		int nst = n / 2;
		int nsp = 1;

		int row = 1;

		while (row <= n) {

			// work
			// stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

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

			if (row <= n / 2) {
				nst--;
				nsp += 2;
			} else {
				nst++;
				nsp -= 2;
			}
			
			row++ ;

		}

	}
}
