package Assignments.May6;

public class ViveKLovesArray {

	public static void main(String[] args) {

		int[] arr = { 3, 1, 1, 0, 1, 1, 0, 1 };
		System.out.println(maxPoints(arr, 0, arr.length-1));

	}

	public static int maxPoints(int[] arr, int lo, int hi) {

		// all possible splits
		for (int split = lo; split <= hi - 1; split++) {

			// sum of left part
			int sum1 = 0;
			for (int i = lo; i <= split; i++) {
				sum1 += arr[i];
			}

			// sum of right part
			int sum2 = 0;
			for (int i = split + 1; i <= hi; i++) {
				sum2 += arr[i];
			}

			if (sum1 == sum2) {

				int lp = maxPoints(arr, lo, split);
				int rp = maxPoints(arr, split + 1, hi);

				return Math.max(lp, rp) + 1;
			}

		}

		return 0;

	}

}
