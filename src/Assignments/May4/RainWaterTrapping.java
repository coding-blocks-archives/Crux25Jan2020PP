package Assignments.May4;

public class RainWaterTrapping {

	public static void main(String[] args) {

		int[] arr = { 30, 0, 50, 0, 20, 0, 35, 0, 70, 0, 40, 0, 10, 25, 60 };
		int sum = 0;

		// foe every building
		for (int b = 0; b < arr.length; b++) {

			// left max
			int lmax = Integer.MIN_VALUE;

			for (int l = b; l >= 0; l--) {
				if (arr[l] > lmax) {
					lmax = arr[l];
				}
			}

			// right max
			int rmax = Integer.MIN_VALUE;

			for (int r = b; r < arr.length; r++) {
				if (arr[r] > rmax) {
					rmax = arr[r];
				}
			}

			// contribution from present building
			int cpb = Math.min(lmax, rmax) - arr[b];
			sum += cpb;
		}

		System.out.println(sum);
	}

}
