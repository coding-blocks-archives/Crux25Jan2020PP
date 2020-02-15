package L5_Feb15;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Feb-2020
 *
 */

public class ArrayOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[] arr = takeInput() ;
		int[] arr = { 10, 20, 30, 40 };
		display(arr);

		// System.out.println(maximum(arr));
		// System.out.println(linearSearch(arr, 80));
		// System.out.println(binarySearch(arr, 80));

		subarray(arr);
		subarraySum2Loops(arr);
		// subarraySum3Loops(arr);
	}

	public static int[] takeInput() {

		System.out.println("Size ?");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static void display(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int maximum(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	public static int linearSearch(int[] arr, int item) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == item) {
				return i;
			}
		}

		return -1;

	}

	public static int binarySearch(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (item > arr[mid]) {
				lo = mid + 1;
			} else if (item < arr[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}

		return -1;
	}

	public static void subarray(int[] arr) {

		for (int si = 0; si < arr.length; si++) {

			for (int ei = si; ei < arr.length; ei++) {

				System.out.print(si + " " + ei + " : ");

				for (int k = si; k <= ei; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}

	}

	public static void subarraySum3Loops(int[] arr) {

		for (int si = 0; si < arr.length; si++) {

			for (int ei = si; ei < arr.length; ei++) {

				System.out.print(si + " " + ei + " : ");

				int sum = 0;
				for (int k = si; k <= ei; k++) {
					sum += arr[k];
				}
				System.out.println(sum);
			}
		}
	}

	public static void subarraySum2Loops(int[] arr) {

		for (int si = 0; si < arr.length; si++) {

			int sum = 0;

			for (int ei = si; ei < arr.length; ei++) {

				sum += arr[ei];
				System.out.println(si + "-" + ei + " : " + sum);

			}
		}

	}

}
