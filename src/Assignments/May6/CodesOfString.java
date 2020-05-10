package Assignments.May6;

import java.util.ArrayList;

public class CodesOfString {

	public static void main(String[] args) {

		// codesPrint("1128", "");
		// System.out.println(codesGet("1125"));

		ArrayList<String> al = new ArrayList<String>();
		codesPrintList("1125", "", al);
		System.out.println(al);
	}

	public static void codesPrint(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		// 1 digit encode call
		char ch1 = ques.charAt(0);
		String roq1 = ques.substring(1);

		codesPrint(roq1, ans + encode1(ch1));

		// 2 digit encode call
		if (ques.length() >= 2) {
			String ch2 = ques.substring(0, 2);
			String roq2 = ques.substring(2);

			if (Integer.parseInt(ch2) <= 26)
				codesPrint(roq2, ans + encode2(ch2));
		}
	}

	public static ArrayList<String> codesGet(String ques) {

		if (ques.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<String>();

		// 1 digit encode call
		String roq1 = ques.substring(1); // "125"
		char ch1 = ques.charAt(0); // '1'

		ArrayList<String> rr1 = codesGet(roq1); // [abe, le, ay] [
		for (String val : rr1) {
			mr.add(encode1(ch1) + val); // [aabe, ale, aay]
		}

		// 2 digit encode call
		if (ques.length() >= 2) {
			String ch2 = ques.substring(0, 2); // "11"
			String roq2 = ques.substring(2); // "25"

			if (Integer.parseInt(ch2) <= 26) {
				ArrayList<String> rr2 = codesGet(roq2); // [be, y]

				for (String val : rr2) {
					mr.add(encode2(ch2) + val); // [kbe, ky]
				}
			}
		}

		return mr;

	}

	public static void codesPrintList(String ques, String ans, ArrayList<String> list) {

		if (ques.length() == 0) {
			// System.out.println(ans);
			list.add(ans);
			return;
		}

		// 1 digit encode call
		char ch1 = ques.charAt(0);
		String roq1 = ques.substring(1);

		codesPrintList(roq1, ans + encode1(ch1), list);

		// 2 digit encode call
		if (ques.length() >= 2) {
			String ch2 = ques.substring(0, 2);
			String roq2 = ques.substring(2);

			if (Integer.parseInt(ch2) <= 26)
				codesPrintList(roq2, ans + encode2(ch2), list);
		}
	}

	public static char encode1(char ch) {

		// convert from char to int
		int in = ch - '0';

		// add 96 and typecast to char
		return (char) (in + 96);

	}

	public static char encode2(String str) {

		// convert from char to int
		int in = Integer.parseInt(str);

		// add 96 and typecast to char
		return (char) (in + 96);

	}

}
