package Assignments.Feb21;

public class PascalTriangle {

	public static void main(String[] args) {
	
		int n = 6;
		int nst = 1;
		int rows = 1;

		while (rows <= n) {

			int cst = 1;
			while (cst <= nst) {
				System.out.print(nCr(rows - 1, cst - 1) + " ");
				cst++;
			}

			System.out.println();
			rows++;
			nst++;

		}

	}

	public static int nCr(int n, int r) {

		int res = 1;

		for (int i = 0; i < r; i++) {

			res *= (n - i);
			res /= (i + 1);
		}

		return res;

	}

}
