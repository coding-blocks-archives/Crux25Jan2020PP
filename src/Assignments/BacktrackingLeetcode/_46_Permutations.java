package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class _46_Permutations {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2 };
		System.out.println(permute(arr));

	}

	public static List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> main = new ArrayList<>();

		boolean[] available = new boolean[nums.length];
		Arrays.fill(available, true);

		permute(nums, available, main, new ArrayList<>());

		return main;
	}

	public static void permute(int[] arr, boolean[] available, List<List<Integer>> main, List<Integer> temp) {

		if (temp.size() == arr.length) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < arr.length; i++) {

			if (!available[i]) {
				continue;
			}

			available[i] = false;
			temp.add(arr[i]);
			permute(arr, available, main, temp);
			temp.remove(temp.size() - 1);
			available[i] = true;
		}
	}

}
