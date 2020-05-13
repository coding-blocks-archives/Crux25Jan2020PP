package Assignments.BacktrackingLeetcode;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class KnightsTour {

	public static void main(String[] args) {

		knightsPlace(new int[5][5], 0, 0, 1);
	}

	public static void knightsPlace(int[][] arr, int row, int col, int move) {

		if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || arr[row][col] != 0) {
			return;
		}

		arr[row][col] = move;

		if (move == arr.length * arr.length) {
			display(arr);
			arr[row][col] = 0;
			return;
		}

		int rowArr[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int colArr[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		for (int i = 0; i <= 7; i++) {
			knightsPlace(arr, row + rowArr[i], col + colArr[i], move + 1);
		}

		arr[row][col] = 0;

	}

	private static void display(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

}
