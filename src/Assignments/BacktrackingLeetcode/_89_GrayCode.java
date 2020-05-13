package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class _89_GrayCode {

	public static void main(String[] args) {

		System.out.println(grayCode(3));

	}

	public static List<Integer> grayCode(int n) {

		if (n == 0) {

			List<Integer> br = new ArrayList<Integer>();
			br.add(0);
			return br;

		}

		List<Integer> rr = grayCode(n - 1);

		List<Integer> mr = new ArrayList<Integer>(rr);

		for (int i = rr.size() - 1; i >= 0; i--) {
			int mult = (int) Math.pow(2, n - 1);
			mr.add(mult + rr.get(i));
		}

		return mr;
	}

}
