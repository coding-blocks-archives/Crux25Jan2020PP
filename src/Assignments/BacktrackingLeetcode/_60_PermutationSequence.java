package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class _60_PermutationSequence {

	public static void main(String[] args) {

		getPermutation(4, 17);
	}

	public static String getPermutation(int n, int k) {

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(i);
		}

		int[] factorial = new int[n];
		factorial[0] = 1;
		for (int i = 1; i < n; i++) {
			factorial[i] = factorial[i - 1] * i;
		}

		return getPermutation(n, k, list, factorial);

	}

	private static String getPermutation(int n, int k, ArrayList<Integer> list, int[] factorial) {

		// if (n == 0) {
		// return ans;
		// }
		//
		// int group = k / factorial[n - 1];
		//
		// if (k % factorial[n - 1] != 0)
		// group++;
		//
		// int newk = k - (group - 1) * factorial[n - 1];
		//
		// int element = list.remove(group);
		//
		// return getPermutation(n - 1, newk, list, factorial, ans + element);

		String ans = "";

		while (n != 0) {

			int group = k / factorial[n - 1];

			if (k % factorial[n - 1] != 0)
				group++;

			k = k - (group - 1) * factorial[n - 1];

			ans += list.remove(group);

			n--;

		}

		return ans;
	}

}
