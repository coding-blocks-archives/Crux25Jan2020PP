package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class _216_CombinationSumIII {

	public static void main(String[] args) {

		System.out.println(combinationSum3(3, 9));

	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> main = new ArrayList<List<Integer>>();
		combinationSum3(1, n, k, main, new ArrayList<>());
		return main;

	}

	private static void combinationSum3(int value, int n, int k, List<List<Integer>> main, ArrayList<Integer> temp) {

		if (k == 0) {

			if (n == 0)
				main.add(new ArrayList<Integer>(temp));

			return;
		}

		if (value > n) {
			return;
		}

		for (int i = value; i <= 9; i++) {
			temp.add(i);
			combinationSum3(i + 1, n - i, k - 1, main, temp);
			temp.remove(temp.size() - 1);
		}

	}

}
