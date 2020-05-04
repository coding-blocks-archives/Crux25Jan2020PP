package Assignments.May4;

public class CircularSum {

	public static void main(String[] args) {

		int[] arr = { 10, -12, -5, 3 };

		int max = Integer.MIN_VALUE;

		for (int si = 0; si < arr.length; si++) {

			for (int ei = si; ei < si + arr.length; ei++) {

				int sum = 0;
				for (int k = si; k <= ei; k++) {
					sum += arr[k % arr.length];
				}
				if (sum > max) {
					max = sum;
				}

			}
		}
		System.out.println(max);
	}

}
