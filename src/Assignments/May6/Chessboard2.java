package Assignments.May6;

import java.util.Arrays;

public class Chessboard2 {

	public static void main(String[] args) {

		int n = 4;
		char[] mp = createMinesPorts(SOE(n * n));

		System.out.println(chess2(0, 0, n - 1, n - 1, "", mp));
	}

	public static int chess2(int cr, int cc, int er, int ec, String ans, char[] mp) {

		if (cr == er && cc == ec) {
			System.out.println(ans + "{" + er + "-" + ec + "}");
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}
		int res = 0;

		int val = cr * (ec + 1) + cc + 1;
		if (mp[val] == 'M') {
			return 0;
		}

		if (mp[val] == 'P') {
			res += chess2(er, ec, er, ec, ans + "{" + cr + "-" + cc + "}P", mp);
		}

		// knight
		res += chess2(cr + 2, cc + 1, er, ec, ans + "{" + cr + "-" + cc + "}K", mp);
		res += chess2(cr + 1, cc + 2, er, ec, ans + "{" + cr + "-" + cc + "}K", mp);

		// rook
		if (cr == 0 || cr == er || cc == 0 || cc == ec) {

			// horizontal
			for (int step = 1; step <= ec - cc; step++) {
				res += chess2(cr, cc + step, er, ec, ans + "{" + cr + "-" + cc + "}R", mp);
			}

			// vertical
			for (int step = 1; step <= er - cr; step++) {
				res += chess2(cr + step, cc, er, ec, ans + "{" + cr + "-" + cc + "}R", mp);
			}

		}

		// bishop
		if (cr == cc || cr + cc == ec) {
			for (int step = 1; step <= er - cr && step <= ec - cc; step++) {
				res += chess2(cr + step, cc + step, er, ec, ans + "{" + cr + "-" + cc + "}B", mp);
			}
		}

		return res;

	}

	public static char[] createMinesPorts(boolean[] primes) {

		char[] mp = new char[primes.length];

		int count = 1;

		for (int i = 0; i < primes.length; i++) {

			if (primes[i] == true) {

				// odd : mine
				if (count % 2 == 1) {
					mp[i] = 'M';
				}
				// even : port
				else {
					mp[i] = 'P';
				}

				count++;

			}
		}

		return mp;

	}

	public static boolean[] SOE(int n) {

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

		return primes;

	}
}
