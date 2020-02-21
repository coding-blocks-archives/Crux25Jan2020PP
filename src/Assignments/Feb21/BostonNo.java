package Assignments.Feb21;

import java.util.Scanner;

public class BostonNo {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int orig = n;
		int sum = 0;

		for (int i = 2; i <= Math.sqrt(n); i++) {

			if (isPrime(i)) {

				while (n % i == 0) {
					n = n / i;
					sum += sod(i);
				}
			}
		}

		if (n >= 2) {
			sum += sod(n);
		}

		if (sum == sod(orig)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	public static int sod(int n) {

		int res = 0;

		while (n > 0) {

			int rem = n % 10;
			res += rem;
			n = n / 10;
		}

		return res;

	}

	public static boolean isPrime(int n) {

		for (int i = 2; i * i <= n; i++) {

			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

}
