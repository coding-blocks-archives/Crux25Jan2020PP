package Assignments.May6;

public class SubsetArray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };
		System.out.println("\n" + subset(arr, 0, "", 0, 3));
	}

	public static int subset(int[] arr, int vidx, String ans, int sum, int target) {

		if (vidx == arr.length) {

			if (sum == target) {
				System.out.print(ans + " ");
				return 1;
			}

			return 0;
		}

		int include = subset(arr, vidx + 1, ans + arr[vidx] + " ", sum + arr[vidx], target); // include
		int exclude = subset(arr, vidx + 1, ans, sum, target); // exclude

		return include + exclude;
	}
}
