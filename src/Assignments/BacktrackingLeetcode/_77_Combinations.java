package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class _77_Combinations {

	public static void main(String[] args) {

		System.out.println(combine(4, 2));
	}

	public static List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> main = new ArrayList<List<Integer>>();
		combine(1, n, k, main, new ArrayList<>());
		return main;

	}

	private static void combine(int value, int n, int k, List<List<Integer>> main, ArrayList<Integer> temp) {

		if (k == 0) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		if (value > n) {
			return;
		}

		for (int i = value; i <= n; i++) {
			temp.add(i);
			combine(i + 1, n, k - 1, main, temp);
			temp.remove(temp.size() - 1);
		}

	}

}
