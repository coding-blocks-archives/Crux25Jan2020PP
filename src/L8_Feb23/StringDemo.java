package L8_Feb23;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Feb-2020
 *
 */

public class StringDemo {

	public static void main(String[] args) {

		String str = "hello";

		// Part-1 : Length
		System.out.println(str.length());

		// Part-2 : CharAt
		// Range : 0 -> length-1
		char ch = str.charAt(0);
		System.out.println(ch);
		System.out.println(str.charAt(1));
		System.out.println(str.charAt(str.length() - 1));

		// Part-3 : Substring
		// Range : 0 -> length
		System.out.println(str.substring(1, 4));
		System.out.println(str.substring(0, 5)); // hello
		// System.out.println(str.substring(4,1)); // error
		System.out.println(str.substring(1, 1).length()); // ""

		String s11 = str.substring(1); // ello
		System.out.println(s11);
		System.out.println(str.substring(3)); // lo

		// Part-4 : Concatenation
		String s1 = "hi";
		String s2 = "bye";
		String s3 = s1 + s2;
		System.out.println(s1 + ", " + s2 + ", " + s3);
		String s4 = s1.concat(s2);
		System.out.println(s1 + ", " + s2 + ", " + s4);

		// Part-5 : IndexOf
		System.out.println(str.lastIndexOf('l'));
		System.out.println(str.indexOf("lo"));

		// Part-6 : StartsWith
		System.out.println(str.startsWith("He"));
		System.out.println(str.startsWith("hell"));

		// Part-7 : Equals and ==
		s1 = "Hello";
		s2 = s1;
		s3 = "Hello";
		s4 = new String("Hello");

		System.out.println((s1 == s2) + ", " + s1.equals(s2));
		System.out.println((s1 == s3) + ", " + s1.equals(s3));
		System.out.println((s1 == s4) + ", " + s1.equals(s4));

		// Part-8 : Replace
		str = str.replace('l', 'w');
		System.out.println(str);

		long start = System.currentTimeMillis();
		fun();
		long end = System.currentTimeMillis();

		System.out.println(end - start);

	}

	public static void fun() {

		int n = 100000;

		// String str = "";
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			// str += i;
			sb.append(i);
		}

	}

}
