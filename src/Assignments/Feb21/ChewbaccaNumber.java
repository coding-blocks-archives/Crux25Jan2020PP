package Assignments.Feb21;

import java.util.Scanner;

public class ChewbaccaNumber {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();

		long ans = 0;
		long mult = 1;

		while (n > 0) {

			long rem = n % 10;

			if (n != 9 && rem >= 5 && rem <= 9) {
				rem = 9 - rem;
			}

			ans = ans + rem * mult;

			n = n / 10;
			mult = mult * 10;

		}

		System.out.println(ans);

	}

}
