import L10_March7.RecursionGet;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Mar-2020
 *
 */

public class L11_March8 {

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
}
