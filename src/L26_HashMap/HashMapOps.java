package L26_HashMap;

import java.util.HashMap;

public class HashMapOps {

	public static void main(String[] args) {

		// System.out.println(highstFreqChar("abcbbca"));

		// int[] one = { 10, 20, 10, 30, 30, 40, 50 };
		// int[] two = { 30, 30, 30, 50, 60, 70 };
		//
		// intersection(one, two);

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 , 4 };
		longestConsecutiveSeq(arr);
	}

	public static char highstFreqChar(String str) {

		HashMap<Character, Integer> map = new HashMap<>();

		// create a frequency map
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// if (map.containsKey(ch)) {
			// int of = map.get(ch);
			// int nf = of + 1;
			// map.put(ch, nf);
			// } else {
			// map.put(ch, 1);
			// }

			int of = map.getOrDefault(ch, 0);
			map.put(ch, of + 1);
		}

		// traverse over map and find the char with highest freq
		int maxFreq = 0;
		char maxFreqChar = ' ';

		for (char key : map.keySet()) {

			int freq = map.get(key);

			if (freq > maxFreq) {
				maxFreq = freq;
				maxFreqChar = key;
			}

		}

		return maxFreqChar;

	}

	public static void intersection(int[] one, int[] two) {

		HashMap<Integer, Integer> map = new HashMap<>();

		// freq map using one array
		for (int key : one) {
			int of = map.getOrDefault(key, 0);
			map.put(key, of + 1);
		}

		// traverse over 2nd array
		for (int key : two) {

			if (map.containsKey(key) && map.get(key) > 0) {
				System.out.println(key);
				map.put(key, map.get(key) - 1);
			}

		}

	}

	public static void longestConsecutiveSeq(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int key : arr) {

			if (map.containsKey(key - 1)) {
				map.put(key, false);
			} else {
				map.put(key, true);
			}

			if (map.containsKey(key + 1)) {
				map.put(key + 1, false);
			}

		}

		int maxLength = 0;
		int seqStart = 0;

		for (int key : map.keySet()) {

			if (map.get(key)) {

				int count = 0;
				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > maxLength) {
					maxLength = count;
					seqStart = key;
				}

			}

		}

		for (int i = 0; i < maxLength; i++) {
			System.out.println(seqStart + i);
		}

	}

}
