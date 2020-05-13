package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class _401_BinaryWatch {

	public static void main(String[] args) {

		System.out.println(readBinaryWatch(1));
	}

	public static List<String> readBinaryWatch(int num) {

		int[] arr = { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };

		List<String> main = new ArrayList<String>();

		readBinaryWatch(num, arr, 0, 0, 0, main);

		return main;
	}

	private static void readBinaryWatch(int n, int[] arr, int idx, int hr, int min, List<String> main) {

		if (hr >= 12 || min >= 60) {
			return;
		}

		if (n == 0) {
			String fmin = min + "";

			if (fmin.length() == 1) {
				fmin = "0" + min;
			}

			main.add(hr + ":" + fmin);
			return;
		}

		if (idx == arr.length) {
			return;
		}

		// yes
		if (idx <= 3) {
			readBinaryWatch(n - 1, arr, idx + 1, hr + arr[idx], min, main);
		} else {
			readBinaryWatch(n - 1, arr, idx + 1, hr, min + arr[idx], main);
		}

		// no
		readBinaryWatch(n, arr, idx + 1, hr, min, main);

	}

}
