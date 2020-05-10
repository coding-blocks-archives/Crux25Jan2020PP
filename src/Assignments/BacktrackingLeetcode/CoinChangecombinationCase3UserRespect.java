package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class CoinChangecombinationCase3UserRespect {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 2, 1 };
		Arrays.sort(arr);
		List<List<Integer>> main = new ArrayList<>();
		userRespect(arr, 0, 3, main, new ArrayList<Integer>());

		System.out.println(main);

	}

	public static void userRespect(int[] arr, int idx, int amount, List<List<Integer>> main, List<Integer> temp) {

		if (amount == 0) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		if (idx == arr.length || amount < 0) {
			return;
		}

		for (int i = idx; i < arr.length; i++) {

			if (i > idx && arr[i] == arr[i - 1]) {
				continue;
			}

			temp.add(arr[i]);
			userRespect(arr, i + 1, amount - arr[i], main, temp);
			temp.remove(temp.size() - 1);

		}

	}

}
