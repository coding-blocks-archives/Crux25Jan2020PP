package Assignments.Recursion;

import java.util.Scanner;

public class MaxIntegerKSwaps {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = "4321" ;
		int k = 4;

		char[] arr = str.toCharArray();

		System.out.println(kswaps(arr, 0, k));

	}

	public static int kswaps(char[] arr, int idx, int k) {

		if (k == 0 || idx == arr.length) {
			String str = new String(arr);
			return Integer.parseInt(str);
		}

		int ans = 0;

		char max = max(arr, idx);

		if (arr[idx] == max) {
			ans = kswaps(arr, idx + 1, k);
		} else {

			for (int i = idx + 1; i < arr.length; i++) {

				if (arr[i] == max) {

					swap(arr, idx, i);

					int rr = kswaps(arr, idx + 1, k - 1);

					if (rr > ans) {
						ans = rr;
					}

					swap(arr, idx, i);

				}

			}
		}

		return ans;

	}

	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static char max(char[] arr, int idx) {

		char max = arr[idx];
		for (int i = idx + 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

}
