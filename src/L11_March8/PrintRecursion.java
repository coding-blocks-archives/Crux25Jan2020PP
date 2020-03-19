package L11_March8;

import L10_March7.RecursionGet;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Mar-2020
 *
 */

public class PrintRecursion {

	public static void main(String[] args) {
		// printSSAscii("ab", "");
		printKPC("145", "");
	}

	public static void printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans); // no
		printSS(roq, ans + ch); // yes

	}

	public static void printSSAscii(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSSAscii(roq, ans); // no
		printSSAscii(roq, ans + ch); // yes
		printSSAscii(roq, ans + (int) ch); // ascii

	}

	public static void printKPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String code = RecursionGet.getCode(ch);

		for (int i = 0; i < code.length(); i++) {
			printKPC(roq, ans + code.charAt(i));
		}

	}

	public static void validParenthesis(int n, int open, int close, String ans) {

		// positive base case
		if (open == close && open == n) {
			System.out.println(ans);
			return;
		}

		if (open > n || close > open) {
			return;
		}

		validParenthesis(n, open + 1, close, ans + "(");
		validParenthesis(n, open, close + 1, ans + ")");

	}

	public static void lexicoCounting(int curr, int n) {

		if (curr > n) {
			return;
		}

		System.out.println(curr);

		int i = 0;
		while (i <= 9) {
			lexicoCounting(curr * 10 + i, n);
			i++;
		}

	}

	public static void palindromePartitioning(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 1; i <= ques.length(); i++) {

			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			if (isPalindrome(part))
				palindromePartitioning(roq, ans + part + " ");
		}

	}

	public static boolean isPalindrome(String str) {

		int left = 0;
		int right = str.length() - 1;

		while (left <= right) {

			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

}
