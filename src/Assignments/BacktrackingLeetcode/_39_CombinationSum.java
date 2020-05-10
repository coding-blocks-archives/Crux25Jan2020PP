package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class _39_CombinationSum {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 6, 7 };

		System.out.println(combinationSum(arr, 7));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> main = new ArrayList<>();
		combinationSum(candidates, 0, target, main, new ArrayList<>());
		return main;
	}

	public static void combinationSum(int[] candidates, int idx, int target, List<List<Integer>> main,
			List<Integer> temp) {

		if (target == 0) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		if (target < 0 || idx == candidates.length) {
			return;
		}

		for (int i = idx; i < candidates.length; i++) {

			temp.add(candidates[i]);
			combinationSum(candidates, i, target - candidates[i], main, temp);
			temp.remove(temp.size() - 1);

		}

	}

}
