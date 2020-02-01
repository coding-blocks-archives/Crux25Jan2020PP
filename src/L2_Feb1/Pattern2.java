package L2_Feb1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Feb-2020
 *
 */

public class Pattern2 {

	public static void main(String[] args) {

		int n = 3;
		int nst = 1;

		int row = 1;

		while (row <= n) {

			// work
			for (int col = 1; col <= nst; col++) {
				System.out.print("*");
			}

			// prep
			System.out.println();
			row = row + 1;
			nst = nst + 1;

		}

	}
}
