package Assignments.May4;

public class CircularSum3 {

	public static void main(String[] args) {

		int[] arr = { 10, -12, -5, 3, 11 };

		// case 1
		int nonWrappingMaxSum = kadanes(arr);

		// case 2 : sum is from wrapping elements
		int totalSum = 0;

		for (int i = 0; i < arr.length; i++) {
			totalSum += arr[i];
			arr[i] = -arr[i];
		}

		int nonContributingElementsSum = kadanes(arr);

		int wrappingMaxSum = totalSum + nonContributingElementsSum;

		int ans = Math.max(nonWrappingMaxSum, wrappingMaxSum);
		System.out.println(ans);

	}

	public static int kadanes(int[] arr) {

		int sum = arr[0];
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			// max sum which you can obtain when ur subarray ends at arr[i] value
			sum = Math.max(sum + arr[i], arr[i]);

			// you need to find max of all sum
			if (sum > max) {
				max = sum;
			}
		}

		return max;
	}

}
