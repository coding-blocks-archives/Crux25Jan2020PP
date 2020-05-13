package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class _47_PermutationsII {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2 };
		System.out.println(permuteUnique(arr));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> main = new ArrayList<>();

		boolean[] available = new boolean[nums.length];
		Arrays.fill(available, true);

		permuteUnique(nums, available, main, new ArrayList<>());

		return main;
	}

	public static void permuteUnique(int[] arr, boolean[] available, List<List<Integer>> main, List<Integer> temp) {

		if (temp.size() == arr.length) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < arr.length; i++) {

			if (!available[i]) {
				continue;
			}

			if (i > 0 && arr[i] == arr[i - 1] && available[i] && available[i - 1]) {
				continue;
			}

			available[i] = false;
			temp.add(arr[i]);
			permuteUnique(arr, available, main, temp);
			temp.remove(temp.size() - 1);
			available[i] = true;
		}
	}

}
