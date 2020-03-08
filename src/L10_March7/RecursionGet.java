package L10_March7;

import java.util.ArrayList;

import L6_Feb16.Array2DDemo;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Mar-2020
 *
 */

public class RecursionGet {

	public static void main(String[] args) {

		// System.out.println(getSSAscii("ab"));
		// System.out.println(getKPC("145"));

		// System.out.println(coinToss(3));

		// System.out.println(getPermutation("abcd").size());

		// System.out.println(getMazePathD(0, 0, 2, 2));

		System.out.println(getBoardPath(0, 10));

	}

	public static ArrayList<String> getSS(String str) {

		// base case
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		// smaller problem
		ArrayList<String> rr = getSS(ros);

		// self work
		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add(val); // no
			mr.add(ch + val); // yes
		}

		return mr;

	}

	public static ArrayList<String> getSSAscii(String str) {

		// base case
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		// smaller problem
		ArrayList<String> rr = getSSAscii(ros);

		// self work
		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add(val); // no
			mr.add(ch + val); // yes
			mr.add((int) ch + val); // ascii
		}

		return mr;
	}

	public static String getCode(char ch) {
		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static ArrayList<String> getKPC(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getKPC(ros);

		ArrayList<String> mr = new ArrayList<>();

		String code = getCode(ch);

		for (int i = 0; i < code.length(); i++) { // abc

			for (String val : rr) {
				mr.add(code.charAt(i) + val);
			}
		}

		return mr;

	}

	public static ArrayList<String> coinToss(int n) {

		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> rr = coinToss(n - 1);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add("H" + val);
			mr.add("T" + val);
		}

		return mr;
	}

	public static ArrayList<String> getPermutation(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getPermutation(ros); // [ bc, cb]

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {

			for (int i = 0; i <= val.length(); i++) {
				mr.add(val.substring(0, i) + ch + val.substring(i));
			}
		}

		return mr;
	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		// if (cc + 1 <= ec) {
		ArrayList<String> rrh = getMazePath(cr, cc + 1, er, ec); // H
		for (String val : rrh) {
			mr.add("H" + val);
		}
		// }

		// if (cr + 1 <= er) {
		ArrayList<String> rrv = getMazePath(cr + 1, cc, er, ec); // V
		for (String val : rrv) {
			mr.add("V" + val);
		}
		// }

		return mr;
	}

	public static ArrayList<String> getMazePathD(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = getMazePathD(cr, cc + 1, er, ec); // H
		for (String val : rrh) {
			mr.add("H" + val);
		}

		ArrayList<String> rrv = getMazePathD(cr + 1, cc, er, ec); // V
		for (String val : rrv) {
			mr.add("V" + val);
		}

		ArrayList<String> rrd = getMazePathD(cr + 1, cc + 1, er, ec); // D
		for (String val : rrd) {
			mr.add("D" + val);
		}

		return mr;
	}

	public static ArrayList<String> getBoardPath(int curr, int end) {

		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {

			ArrayList<String> rr = getBoardPath(curr + dice, end);

			for (String val : rr) {
				mr.add(dice + val);
			}
		}

		return mr;

	}

}
