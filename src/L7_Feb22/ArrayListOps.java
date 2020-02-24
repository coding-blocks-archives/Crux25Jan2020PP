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

		// int[] one = { 10, 19, 20, 30, 40, 40, 40, 50 };
		// int[] two = { 15, 16, 17, 18, 20, 25, 30, 30, 40 };
		//
		// System.out.println(intersection(one, two));

		int[] one = { 9, 9, 5, 8 };
		int[] two = { 6, 7 };

		long start = System.currentTimeMillis();
		System.out.println(sumOfTwoArray(one, two));
		long end = System.currentTimeMillis();

		System.out.println(end - start);
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

		int carry = 0;

		int i = one.length - 1;
		int j = two.length - 1;

		while (i >= 0 || j >= 0) {

			int sum = carry;

			if (i >= 0) {
				sum += one[i];
			}

			if (j >= 0) {
				sum += two[j];
			}

			int rem = sum % 10;
			carry = sum / 10;

			ans.add(0, rem);

			i--;
			j--;

		}

		if (carry != 0) {
			ans.add(0, carry);
		}

		return ans;
	}

}
