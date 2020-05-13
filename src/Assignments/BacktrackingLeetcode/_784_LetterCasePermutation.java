package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class _784_LetterCasePermutation {

	public static void main(String[] args) {

		System.out.println(letterCasePermutation("a1B2"));
	}

	public static List<String> letterCasePermutation(String S) {

		List<String> main = new ArrayList<String>();

		letterCasePermutation(S, 0, "", main);

		return main;
	}

	public static void letterCasePermutation(String ques, int idx, String ans, List<String> main) {

		if (ques.length() == idx) {
			main.add(ans);
			return;
		}

		char ch = ques.charAt(idx);

		if (Character.isDigit(ch)) {
			letterCasePermutation(ques, idx + 1, ans + ch, main);
		} else {
			letterCasePermutation(ques, idx + 1, ans + Character.toLowerCase(ch), main);
			letterCasePermutation(ques, idx + 1, ans + Character.toUpperCase(ch), main);
		}

	}

}
