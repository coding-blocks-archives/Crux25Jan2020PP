package L8_Feb23;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Feb-2020
 *
 */

public class StringOps {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(str);
		// printChars(str);
		// System.out.println(isPalindrome("nitjn"));

		// substrings("code");

		// System.out.println(countPalindromicSubstrings("nitinn"));

		// System.out.println(reverse(str));
		reverse2(str);
	}

	public static void printChars(String str) {

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}

	}

	public static boolean isPalindrome(String str) {

		int left = 0;
		int right = str.length() - 1;

		while (left < right) {

			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;

		}

		return true;
	}

	public static void substrings(String str) {

		for (int si = 0; si < str.length(); si++) {

			for (int ei = si + 1; ei <= str.length(); ei++) {
				System.out.println(str.substring(si, ei));
			}
		}
	}

	public static int countPalindromicSubstrings(String str) {

		int count = 0;

		for (int si = 0; si < str.length(); si++) {

			for (int ei = si + 1; ei <= str.length(); ei++) {
				String ss = str.substring(si, ei);

				if (isPalindrome(ss)) {
					count++;
				}
			}
		}

		return count;

	}

	public static String reverse(String str) {

		String ans = "";

		while (true) {

			int idx = str.lastIndexOf(' ');
			String word = str.substring(idx + 1, str.length());
			ans += word + " ";

			if (idx == -1) {
				break;
			} else {
				str = str.substring(0, idx);
			}

		}

		return ans;

	}

	public static void reverse2(String str) {

		String[] arr = str.split(" ");

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
	}

}












