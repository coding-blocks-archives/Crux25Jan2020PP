package Assignments.Feb21;

import java.util.Scanner;

public class IncreasingDecreasing {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		boolean isIncr = false;
		boolean res = true;

		int prev = scn.nextInt();

		for (int i = 1; i < n; i++) {

			int curr = scn.nextInt();

			if (curr > prev) {
				isIncr = true;
			} else if (curr < prev && isIncr) {
				res = false;
				break;
			} else if (curr == prev) {
				res = false;
				break;
			}

			prev = curr;

		}

		System.out.println(res);

	}

}
