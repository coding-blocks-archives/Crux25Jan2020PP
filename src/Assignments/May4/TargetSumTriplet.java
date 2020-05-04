package Assignments.May4;

public class TargetSumTriplet {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int target = 10;

		for (int i = 0; i < arr.length; i++) {

			int j = i + 1;
			int k = arr.length - 1;

			while (j < k) {

				if (arr[j] + arr[k] > target - arr[i]) {
					k--;
				} else if (arr[j] + arr[k] < target - arr[i]) {
					j++;
				} else {
					System.out.println(arr[i] + ", " + arr[j] + " and " + arr[k]);
					j++;
					k--;
				}
			}
		}

	}

}
