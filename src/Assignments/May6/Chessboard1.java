package Assignments.May6;

public class Chessboard1 {

	public static void main(String[] args) {

		int n = 3 ;
		System.out.println(chess1(0, 0, n-1, n-1, ""));
	}

	public static int chess1(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans + "{" + er + "-" + ec + "}");
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0 ;
		}

		int res = 0;
		
		// knight
		res += chess1(cr + 2, cc + 1, er, ec, ans + "{" + cr + "-" + cc + "}K");
		res += chess1(cr + 1, cc + 2, er, ec, ans + "{" + cr + "-" + cc + "}K");

		// rook
		if (cr == 0 || cr == er || cc == 0 || cc == ec) {

			// horizontal
			for (int step = 1; step <= ec - cc; step++) {
				res += chess1(cr, cc + step, er, ec, ans + "{" + cr + "-" + cc + "}R");
			}

			// vertical
			for (int step = 1; step <= er - cr; step++) {
				res += chess1(cr + step, cc, er, ec, ans + "{" + cr + "-" + cc + "}R");
			}

		}

		// bishop
		if (cr == cc || cr + cc == ec) {
			for (int step = 1; step <= er - cr && step <= ec - cc; step++) {
				res += chess1(cr + step, cc + step, er, ec, ans + "{" + cr + "-" + cc + "}B");
			}
		}
		
		return res ;

	}
}
