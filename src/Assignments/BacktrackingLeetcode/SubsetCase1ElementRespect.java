package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class SubsetCase1ElementRespect {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };

		List<List<Integer>> main = new ArrayList<List<Integer>>();
		elementRespect(arr, 0, main, new ArrayList<Integer>());
		System.out.println(main);
	}

	public static void elementRespect(int[] arr, int idx, List<List<Integer>> main, List<Integer> temp) {

		if (idx == arr.length) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		temp.add(arr[idx]);
		elementRespect(arr, idx + 1, main, temp); // yes
		temp.remove(temp.size() - 1);

		elementRespect(arr, idx + 1, main, temp); // no
	}

}
