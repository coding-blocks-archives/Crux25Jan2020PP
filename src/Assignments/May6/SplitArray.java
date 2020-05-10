package Assignments.May6;

public class SplitArray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 3, 4, 5 };
		System.out.println(split(arr, 0, "", 0, "", 0));
	}

	public static int split(int[] arr, int vidx, String ansg1, int sumg1, String ansg2, int sumg2) {

		if (vidx == arr.length) {

			if (sumg1 == sumg2) {
				System.out.println(ansg1 + "and " + ansg2);
				return 1 ;
			}
			return 0 ;
		}
		
		int g1 = split(arr, vidx + 1, ansg1 + arr[vidx] + " ", sumg1 + arr[vidx], ansg2, sumg2);
		int g2 = split(arr, vidx + 1, ansg1, sumg1, ansg2 + arr[vidx] + " ", sumg2 + arr[vidx]);

		return g1 + g2 ;
	}
}
