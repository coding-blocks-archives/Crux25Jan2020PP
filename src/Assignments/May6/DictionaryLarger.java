package Assignments.May6;

public class DictionaryLarger {

	public static void main(String[] args) {

		permutation("bac", "", "bac");
	}

	public static void permutation(String ques, String ans, String os) {

		if (ques.length() == 0) {

			if (ans.compareTo(os) > 0)
				System.out.println(ans);

			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		for (int i = 0; i <= ans.length(); i++) {
			permutation(roq, ans.substring(0, i) + ch + ans.substring(i), os);
		}

	}

}
