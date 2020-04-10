package L13_TC;

import java.util.Arrays;

public class TimeSpace {

	public static void main(String[] args) {

		// System.out.println(power(2, 11));
		// System.out.println(polynomial(3, 5));

		// SOE(100);
		
		System.out.println(countPalindromicSS("nitinn"));
	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int sp = power(x, n / 2);
		if (n % 2 == 0) {
			return sp * sp;
		} else {
			return sp * sp * x;
		}
	}

	public static int polynomial(int x, int n) {

		int sum = 0;
		int mult = x;

		for (int coeff = n; coeff >= 1; coeff--) {

			int term = coeff * mult;
			sum += term;
			mult = mult * x;

		}

		return sum;

	}

	public static void SOE(int n) {

		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table] == false) {
				continue;
			}

			for (int mult = 2; table * mult <= n; mult++) {

				primes[table * mult] = false;

			}

		}

		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.println(i);
			}
		}

	}

	public static int countPalindromicSS(String str) {

		int count = 0;

		// odd length palindromic ss
		for (int axis = 0; axis < str.length(); axis++) {

			int orbit = 0;
			while (axis - orbit >= 0 && axis + orbit < str.length()) {

				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else {
					break;
				}

				orbit++;

			}

		}

		// even length palindromic ss
		for (double axis = 0.5; axis < str.length(); axis++) {

			double orbit = 0.5;
			while (axis - orbit >= 0 && axis + orbit < str.length()) {

				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
					count++;
				} else {
					break;
				}

				orbit++;

			}

		}

		return count;

	}

}
