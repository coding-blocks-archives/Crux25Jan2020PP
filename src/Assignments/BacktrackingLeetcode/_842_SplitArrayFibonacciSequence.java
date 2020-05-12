package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class _842_SplitArrayFibonacciSequence {

	public static void main(String[] args) {

		// System.out.println(splitIntoFibonacci("0123"));

		// System.out.println(Math.pow(2, 31) - 1);

		System.out.println(Integer.parseInt("5511816597"));

	}

	public static List<Integer> splitIntoFibonacci(String S) {

		List<Integer> main = new ArrayList<Integer>();
		splitIntoFibonacci(S, main, new ArrayList<>());
		return main;
	}

	public static void splitIntoFibonacci(String ques, List<Integer> main, List<Integer> temp) {

		if (ques.length() == 0) {

			if (temp.size() >= 3 && main.size() == 0) {
				main.addAll(temp);
			}

			return;
		}

		for (int i = 1; i <= ques.length() && i <= 10; i++) {

			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			if (inRange(part)) {

				int num = Integer.parseInt(part);

				if (isFibonacciSeq(temp, num) && noLeadingZeros(part)) {
					temp.add(num);
					splitIntoFibonacci(roq, main, temp);
					temp.remove(temp.size() - 1);
				}
			}
		}

	}

	private static boolean inRange(String part) {

		if (part.length() >= 11) {
			return false;
		}

		return Long.parseLong(part) <= Math.pow(2, 31) - 1;

	}

	private static boolean noLeadingZeros(String str) {

		if (str.length() <= 1) {
			return true;
		}

		return str.charAt(0) != '0';

	}

	private static boolean isFibonacciSeq(List<Integer> temp, int num) {

		if (temp.size() < 2) {
			return true;
		}

		int lastNum = temp.get(temp.size() - 1);
		int lastSecondNum = temp.get(temp.size() - 2);

		return num == lastNum + lastSecondNum;
	}

}
