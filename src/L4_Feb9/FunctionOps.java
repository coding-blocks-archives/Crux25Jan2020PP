package L4_Feb9;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Feb-2020
 *
 */

public class FunctionOps {

	public static void main(String[] args) {

		// printPrimes(10, 100);
		printArmstrong(10, 1000);
	}

	public static void printPrimes(int lo, int hi) {

		for (int n = lo; n <= hi; n++) {

			boolean res = isPrime(n);
			if (res == true) {
				System.out.println(n);
			}
		}
	}

	public static boolean isPrime(int n) {

		int div = 2;

		while (div <= n - 1) {

			if (n % div == 0) {
				return false;
			}

			div++;
		}

		return true;
	}

	public static void printArmstrong(int lo, int hi) {

		for (int n = lo; n <= hi; n++) {

			boolean res = isArmstrong(n);
			if (res == true) {
				System.out.println(n);
			}
		}
	}

	public static boolean isArmstrong(int n) {

		int nod = countDigits(n);
		int on = n;

		int sum = 0;

		while (n > 0) {
			int rem = n % 10;
			sum += Math.pow(rem, nod);
			n = n / 10;
		}

		// if (sum == on)
		// return true;
		// else
		// return false;

		return sum == on;
	}

	public static int countDigits(int n) {

		int nod = 0;

		while (n > 0) {
			n = n / 10;
			nod++;
		}

		return nod;
	}

}
