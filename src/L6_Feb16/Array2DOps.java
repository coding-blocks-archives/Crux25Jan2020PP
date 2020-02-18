package L6_Feb16;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Feb-2020
 *
 */

public class Array2DOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[][] arr = takeInput() ;
		int[][] arr = { { 10, 20, 30, 40 }, { 50, 60, 70, 80 }, { 90, 100, 110, 120 }, { 130, 140, 150, 160 } };
		display(arr);

		System.out.println("WAVE DISPLAY");
		waveDisplay(arr);
		System.out.println();

		System.out.println("SPIRAL DISPLAY");
		spiralDisplay(arr);

	}

	public static int[][] takeInput() {

		System.out.println("Rows ?");
		int rows = scn.nextInt();

		System.out.println("Cols ?");
		int cols = scn.nextInt();

		int[][] arr = new int[rows][cols];

		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				System.out.println("[" + r + "-" + c + "] ?");
				arr[r][c] = scn.nextInt();
			}
		}

		return arr;
	}

	public static void display(int[][] arr) {

		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}

	}

	public static void waveDisplay(int[][] arr) {

		for (int c = 0; c < arr[0].length; c++) {

			if (c % 2 == 0) {

				for (int r = 0; r < arr.length; r++) {
					System.out.print(arr[r][c] + " ");
				}

			} else {

				for (int r = arr.length - 1; r >= 0; r--) {
					System.out.print(arr[r][c] + " ");
				}

			}

		}

	}

	public static void spiralDisplay(int[][] arr) {

		int minRow = 0;
		int maxRow = arr.length - 1;
		int minCol = 0;
		int maxCol = arr[0].length - 1;

		int nel = arr.length * arr[0].length;

		int count = 0;

		while (count < nel) {

			// first Col
			for (int r = minRow; r <= maxRow && count < nel; r++) {
				System.out.print(arr[r][minCol] + " ");
				count++;
			}
			minCol++;

			// lastRow
			for (int c = minCol; c <= maxCol && count < nel; c++) {
				System.out.print(arr[maxRow][c] + " ");
				count++;
			}
			maxRow--;

			// lastCol
			for (int r = maxRow; r >= minRow && count < nel; r--) {
				System.out.print(arr[r][maxCol] + " ");
				count++;
			}
			maxCol--;

			// firstRow
			for (int c = maxCol; c >= minCol && count < nel; c--) {
				System.out.print(arr[minRow][c] + " ");
				count++;
			}
			minRow++;

		}
	}

}
