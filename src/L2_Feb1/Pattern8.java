package L2_Feb1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Feb-2020
 *
 */

public class Pattern8 {

	public static void main(String[] args) {

		int n = 7;

		int row = 1;

		// rows
		while (row <= n) {

			// work
			for (int col = 1; col <= n; col = col + 1) {

				if (row == col || row + col == n + 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}

			// prep
			System.out.println();
			row = row + 1;

		}

	}

}
