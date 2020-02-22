package L7_Feb22;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 22-Feb-2020
 *
 */

public class ArrayListOps {

	public static void main(String[] args) {

		int[] one = { 10, 19, 20, 30, 40, 40, 40, 50 };
		int[] two = { 15, 16, 17, 18, 20, 25, 30, 30, 40 };

		System.out.println(intersection(one, two));

		// int[] one = { 9, 9, 5, 8 };
		// int[] two = { 6, 7 };
		//
		// System.out.println(sumOfTwoArray(one, two));
	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {

		ArrayList<Integer> ans = new ArrayList<>();

		int i = 0;
		int j = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				i++;
			} else if (one[i] > two[j]) {
				j++;
			} else {
				ans.add(one[i]);
				i++;
				j++;
			}

		}

		return ans;
	}

	public static ArrayList<Integer> sumOfTwoArray(int[] one, int[] two) {

		ArrayList<Integer> ans = new ArrayList<>();

		return ans;
	}

}
