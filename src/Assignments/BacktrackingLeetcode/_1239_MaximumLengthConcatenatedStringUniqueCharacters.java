package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class _1239_MaximumLengthConcatenatedStringUniqueCharacters {

	public static void main(String[] args) {

		List<String> arr = new ArrayList<String>();
		arr.add("un");
		arr.add("iq");
		arr.add("ue");

		System.out.println(maxLength(arr));

	}

	static int count;

	public static int maxLength(List<String> arr) {

		count = 0;

		maxLength(arr, 0, "");

		return count;
	}

	public static void maxLength(List<String> arr, int idx, String ans) {

		if (isDistinct(ans)) {

			System.out.println(ans);
			if (ans.length() > count) {
				count = ans.length();
			}
		}

		for (int i = idx; i < arr.size(); i++) {
			maxLength(arr, i + 1, ans + arr.get(i));
		}

	}

	public static boolean isDistinct(String ans) {

		int[] freq = new int[26];

		for (int i = 0; i < ans.length(); i++) {

			char ch = ans.charAt(i);

			if (freq[ch - 'a'] > 0) {
				return false;
			}

			freq[ch - 'a']++;
		}

		return true;
	}

}
