package Assignments.July9;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class Histogram {

	public static void main(String[] args) {

		long max = Integer.MIN_VALUE;

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		long[] arr = new long[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextLong();
		}

		Stack<Integer> s = new Stack<>();

		int i = 0;

		while (i < arr.length) {

			if (s.isEmpty() || arr[i] > arr[s.peek()]) {
				s.push(i);
				i++;
			} else {

				long pb = arr[s.pop()];

				int r = i;

				if (s.isEmpty()) {
					long area = r * pb;

					if (area > max) {
						max = area;
					}

				} else {
					int l = s.peek();
					long area = (r - l - 1) * pb;

					if (area > max) {
						max = area;
					}
				}

			}

		}

		while (!s.isEmpty()) {
			long pb = arr[s.pop()];

			int r = i;

			if (s.isEmpty()) {
				long area = r * pb;

				if (area > max) {
					max = area;
				}
			} else {
				int l = s.peek();
				long area = (r - l - 1) * pb;

				if (area > max) {
					max = area;
				}
			}
		}
		
		System.out.println(max);

	}

}
