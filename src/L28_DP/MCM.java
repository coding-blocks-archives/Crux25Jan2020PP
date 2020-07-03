package L28_DP;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class MCM {

	public static void main(String[] args) {

		// int[] arr = { 4, 2, 3, 5, 1 };
		int[] arr = new int[1000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		// System.out.println(MCMRecursion(arr, 0, arr.length - 1));
		System.out.println(MCMTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
	}

	public static int MCMRecursion(int[] arr, int si, int ei) {

		if (si + 1 == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		// k : splits
		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCMRecursion(arr, si, k); // arr[si] * arr[k]
			int sp = MCMRecursion(arr, k, ei); // arr[k] * arr[ei]

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}

		}

		return min;

	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {

		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) { // re-use
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		// k : splits
		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCMTD(arr, si, k, strg); // arr[si] * arr[k]
			int sp = MCMTD(arr, k, ei, strg); // arr[k] * arr[ei]

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}

		}

		strg[si][ei] = min; // storage

		return min;

	}

}
