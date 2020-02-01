package L2_Feb1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Feb-2020
 *
 */

public class NumberPattern {

	public static void main(String[] args) {

		int n = 5;

		int nsp = n - 1;
		int nst = 1;

		int row = 1;

		int val = 1;

		while (row <= n) {

			val = row;
			// work
			// spaces
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print("\t");
			}

			// stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val + "\t");
				
				if (cst <= nst / 2)
					val++;
				else
					val--;
			}

			// prep
			System.out.println();

			row = row + 1;
			nsp = nsp - 1;
			nst = nst + 2;

		}

	}
}
