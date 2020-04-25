package Assignments.April24;

import java.util.Scanner;

public class BookAllocation {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {
			int lo = 0;
			int hi = 0;

			int nob = scn.nextInt();
			int nos = scn.nextInt();

			int[] pages = new int[nob];

			for (int i = 0; i < nob; i++) {
				pages[i] = scn.nextInt();
				hi += pages[i];
			}

			// logic ...
			int finalAns = 0;

			while (lo <= hi) {

				int mid = (lo + hi) / 2;

				if (isItPossible(pages, nob, nos, mid)) {
					finalAns = mid;
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}

			}

			System.out.println(finalAns);

			tc--;
		}
	}

	private static boolean isItPossible(int[] pages, int nob, int nos, int mid) {

		int students = 1;
		int pagesRead = 0;

		int i = 0;

		while (i < nob) {

			if (pagesRead + pages[i] <= mid) {
				pagesRead += pages[i];
				i++;
			} else {

				students++;
				pagesRead = 0;

				if (students > nos) {
					return false;
				}
			}

		}

		return true;

	}
}
