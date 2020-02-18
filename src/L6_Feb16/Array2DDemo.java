package L6_Feb16;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Feb-2020
 *
 */

public class Array2DDemo {

	public static void main(String[] args) {

		int[][] arr = new int[3][4];
		System.out.println(arr);

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		System.out.println(arr.length); // rows
		System.out.println(arr[0].length); // cols

		System.out.println(arr[1][2]);
		arr[1][2] = 100;
		System.out.println(arr[1][2]);
		int lr = arr.length - 1;
		int lc = arr[0].length - 1;

		System.out.println(arr[lr][lc]);

		for (int[] val : arr) { // 2k 3k 4k

			for (int temp : val) {

				System.out.print(temp + " ");

			}
			System.out.println();
		}

	}
}
