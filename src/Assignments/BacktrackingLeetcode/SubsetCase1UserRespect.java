package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class SubsetCase1UserRespect {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };

		List<List<Integer>> main = new ArrayList<List<Integer>>();
		userRespect(arr, 0, main, new ArrayList<Integer>());

		System.out.println(main);
	}

	public static void userRespect(int[] arr, int idx, List<List<Integer>> main, List<Integer> temp) {

		main.add(new ArrayList<Integer>(temp));

		for (int i = idx; i < arr.length; i++) {
			temp.add(arr[i]);
			userRespect(arr, i + 1, main, temp);
			temp.remove(temp.size() - 1);
		}
	}

}
