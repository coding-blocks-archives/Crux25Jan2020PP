package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class CoinChangecombinationCase2CoinRespect {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 4, 5 };

		List<List<Integer>> main = new ArrayList<>();
		coinRespect(arr, 0, 7, main, new ArrayList<Integer>());

		System.out.println(main);

	}

	public static void coinRespect(int[] arr, int idx, int amount, List<List<Integer>> main, List<Integer> temp) {

		if (amount == 0) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		if (idx == arr.length || amount < 0) {
			return;
		}

		temp.add(arr[idx]);
		coinRespect(arr, idx + 1, amount - arr[idx], main, temp); // yes
		temp.remove(temp.size() - 1);

		coinRespect(arr, idx + 1, amount, main, temp); // yes

	}

}
