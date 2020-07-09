package Assignments.July9;

import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class StackSpan {

	public static void main(String[] args) {

		int[] arr = { 100, 80, 60, 90, 20, 30, 70, 200, 15 };
		int[] span = new int[arr.length];

		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
				s.pop();
			}

			if (s.isEmpty()) {
				span[i] = i + 1;
			} else {
				span[i] = i - s.peek();
			}

			s.push(i);

		}

		for (int val : span) {
			System.out.print(val + " ");
		}

	}

}
