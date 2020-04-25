package Assignments.April24;

import java.util.Scanner;

public class PainterPartition {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int lo = 0;
		int hi = 0;

		int nop = scn.nextInt();
		int nob = scn.nextInt();

		int[] board = new int[nob];

		for (int i = 0; i < nob; i++) {
			board[i] = scn.nextInt();
			hi += board[i];
		}

		// logic ...
		int finalAns = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isItPossible(board, nop, nob, mid)) {
				finalAns = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}

		System.out.println(finalAns);

	}

	private static boolean isItPossible(int[] board, int nop, int nob, int mid) {

		int painters = 1;
		int time = 0;

		int i = 0;

		while (i < nob) {

			if (time + board[i] <= mid) {
				time += board[i];
				i++;
			} else {

				painters++;
				time = 0;

				if (painters > nop) {
					return false;
				}
			}

		}

		return true;

	}
}
