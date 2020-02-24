package L8_Feb23;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Feb-2020
 *
 */

public class StringBuilderDemo {

	public static void main(String[] args) {

		String str = "hello";
		StringBuilder sb = new StringBuilder(str);
		StringBuilder sb1 = new StringBuilder(str);

		System.out.println(sb);

		// length
		System.out.println(sb.length());

		// append
		sb.append("abc");
		System.out.println(sb);
		sb.append("def");
		System.out.println(sb);

		// insert
		// range : 0 -> length
		// worst : 0th index : O(n)
		// best : last index : O(1)
		sb.insert(sb.length(), 'z');
		System.out.println(sb);

		// setCharAt
		// range : 0 -> length-1
		sb.setCharAt(2, 'q');
		System.out.println(sb);

		// charAt
		// range : 0 -> length-1
		System.out.println(sb.charAt(2));

		// deleteCharAt
		// range : 0 -> length-1
		// worst : 0th index : O(n)
		// best : last index : O(1)
		sb.deleteCharAt(3);
		System.out.println(sb);

		// change the reference
		sb = sb1;
		System.out.println(sb);

		System.out.println(replaceAscii("cdEfG"));

	}

	public static StringBuilder replaceAscii(String str) {

		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < sb.length(); i++) {

			char ch = sb.charAt(i);

			if (i % 2 == 0) {
				// ch = (char) (ch + 1);
				// sb.setCharAt(i, ch);

				sb.setCharAt(i, ++ch);
			} else {
				ch = (char) (ch - 1);
				sb.setCharAt(i, ch);
			}

		}
		return sb;

	}

}
