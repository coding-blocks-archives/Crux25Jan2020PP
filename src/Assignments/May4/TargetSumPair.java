package Assignments.May4;

public class TargetSumPair {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 5, 8, 9, 10, 12, 15 };
		int target = 18;

		int start = 0;
		int end = 0;

		int i = 0;
		int j = arr.length - 1;

		while (i < j) {

			if (arr[i] + arr[j] < target) {
				i++;
			} else if (arr[i] + arr[j] > target) {
				j--;
			} else {
				start = arr[i];
				end = arr[j];
				i++;
				j--;
			}

		}

		System.out.println(start + " " + end);

	}

}
