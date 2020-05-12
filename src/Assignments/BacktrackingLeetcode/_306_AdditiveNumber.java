package Assignments.BacktrackingLeetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class _306_AdditiveNumber {

	public static void main(String[] args) {

		System.out.println(isAdditiveNumber("11235"));
	}

	static boolean flag;

	public static boolean isAdditiveNumber(String num) {

		flag = false;
		isAdditiveNumber(num, new ArrayList<BigInteger>());
		return flag;
	}

	public static void isAdditiveNumber(String ques, List<BigInteger> temp) {

		if (ques.length() == 0) {

			if (temp.size() >= 3)
				flag = flag || true;

			return;
		}

		for (int i = 1; i <= ques.length(); i++) {

			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			BigInteger num = new BigInteger(part);

			if (isAdditiveSeq(temp, num) && noLeadingZeros(part)) {
				temp.add(num);
				isAdditiveNumber(roq, temp);
				temp.remove(temp.size() - 1);
			}
		}

	}

	private static boolean noLeadingZeros(String str) {

		if (str.length() <= 1) {
			return true;
		}

		return str.charAt(0) != '0';

	}

	private static boolean isAdditiveSeq(List<BigInteger> temp, BigInteger num) {

		if (temp.size() < 2) {
			return true;
		}

		BigInteger lastNum = temp.get(temp.size() - 1);
		BigInteger lastSecondNum = temp.get(temp.size() - 2);

		BigInteger sum = lastNum.add(lastSecondNum);

		return num.compareTo(sum) == 0;
	}

}
