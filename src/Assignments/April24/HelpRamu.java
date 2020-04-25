package Assignments.April24;

import java.util.Scanner;

public class HelpRamu {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {
			int c1 = scn.nextInt();
			int c2 = scn.nextInt();
			int c3 = scn.nextInt();
			int c4 = scn.nextInt();

			int nor = scn.nextInt();
			int noc = scn.nextInt();

			int[] rickshaw = new int[nor];
			int[] cab = new int[noc];

			for (int i = 0; i < nor; i++) {
				rickshaw[i] = scn.nextInt();
			}

			for (int i = 0; i < noc; i++) {
				cab[i] = scn.nextInt();
			}

			System.out.println(minCost(c1, c2, c3, c4, rickshaw, cab));

			tc--;
		}
	}

	private static int minCost(int c1, int c2, int c3, int c4, int[] rickshaw, int[] cab) {

		int rc = minCostTransport(c1, c2, c3, rickshaw);
		int cc = minCostTransport(c1, c2, c3, cab);

		return Math.min(c4, rc + cc);

	}

	private static int minCostTransport(int c1, int c2, int c3, int[] freq) {

		int sum = 0;

		for (int i = 0; i < freq.length; i++) {
			int min = Math.min(freq[i] * c1, c2);
			sum += min;
		}

		return Math.min(sum, c3);
	}
}
