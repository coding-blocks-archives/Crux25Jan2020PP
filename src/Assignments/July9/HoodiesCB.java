package Assignments.July9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class HoodiesCB {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		ArrayList<Queue<Integer>> C = new ArrayList<>();

		for (int i = 0; i <= 4; i++) {
			C.add(new LinkedList<Integer>());
		}

		ArrayList<Integer> order = new ArrayList<>();

		int q = scn.nextInt();

		for (int i = 1; i <= q; i++) {

			char ch = scn.next().charAt(0);

			if (ch == 'E') {

				int cn = scn.nextInt();
				int rn = scn.nextInt();

				C.get(cn).add(rn);

				if (!order.contains(cn)) {
					order.add(cn);
				}

			} else {

				int removeCourseNo = order.get(0);
				int removeRollNo = C.get(removeCourseNo).remove();

				if (C.get(removeCourseNo).isEmpty()) {
					order.remove(0);
				}

				System.out.println(removeCourseNo + " " + removeRollNo);

			}

		}

	}

}
