package L9_Feb29;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Feb-2020
 *
 */

public class Recursion {

	public static void main(String[] args) {

		// PD(5);
		// PDI(3);
		// PID(5, 1);
		// System.out.println("hello");

		// System.out.println(factorial(4));

		// System.out.println(power(2, 10));

		// System.out.println(fibonacci(8));

		int[] arr = { 10, 30, 30, 40, 30, 80 };

		// printArray(arr, 0);
		// System.out.println();
		// reverseArray(arr, 0);
		// System.out.println();

		System.out.println(maximum(arr, 0));
		System.out.println(firstIndex(arr, 0, 30));
		System.out.println(lastIndex(arr, 0, 30));
		
		int[] ans = allIndexes(arr, 0, 30, 0);
		
		for(int val : ans) {
			System.out.println(val);
		}
	}

	public static void PD(int n) {

		// base case
		if (n == 0) {
			return;
		}

		// self work
		System.out.println(n);

		// smaller problem
		PD(n - 1);
	}

	public static void PI(int n) {

		if (n == 0) {
			return;
		}

		// smaller problem
		PI(n - 1);

		// self work
		System.out.println(n);
	}

	public static void PDI(int n) {

		if (n == 0) {
			return;
		}

		System.out.println("hi " + n);

		PDI(n - 1);

		System.out.println("bye " + n);

	}

	public static void PID(int n, int present) {

		if (present == n + 1) {
			return;
		}

		System.out.println(present);

		PID(n, present + 1);

		System.out.println(present);
	}

	public static int factorial(int n) {

		if (n == 1) {
			return 1;
		}

		int fnm1 = factorial(n - 1);
		int fn = fnm1 * n;

		return fn;

	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int sp = power(x, n - 1);
		int sw = sp * x;

		return sw;

	}

	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		// 2 smaller problems
		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		// self work
		int fn = fnm1 + fnm2;

		return fn;
	}

	public static void printArray(int[] arr, int idx) {

		if (idx == arr.length) {
			return;
		}

		System.out.print(arr[idx] + " ");
		printArray(arr, idx + 1);

	}

	public static void reverseArray(int[] arr, int idx) {

		if (idx == arr.length) {
			return;
		}

		reverseArray(arr, idx + 1);
		System.out.print(arr[idx] + " ");
	}

	public static int maximum(int[] arr, int idx) {

		// if (idx == arr.length) {
		// return Integer.MIN_VALUE;
		// }

		if (idx == arr.length - 1) {
			return arr[idx];
		}

		int rr = maximum(arr, idx + 1);

		// if(arr[idx] > rr) {
		// return arr[idx] ;
		// }else {
		// return rr ;
		// }

		return Math.max(arr[idx], rr);

	}

	public static int firstIndex(int[] arr, int idx, int item) {

		if (idx == arr.length) {
			return -1;
		}

		if (arr[idx] == item) {
			return idx;
		}

		int rr = firstIndex(arr, idx + 1, item);
		return rr;

	}

	public static int lastIndex(int[] arr, int idx, int item) {

		if (idx == arr.length) {
			return -1;
		}

		int rr = lastIndex(arr, idx + 1, item);

		if (arr[idx] == item && rr == -1) {
			return idx;
		}

		return rr;
	}

	public static int lastIndex1(int[] arr, int idx, int item, int pos) {

		if (idx == arr.length) {
			return pos;
		}

		if (arr[idx] == item) {
			pos = idx;
		}

		return lastIndex1(arr, idx + 1, item, pos);

	}

	public static int[] allIndexes(int[] arr, int idx, int item, int count) {

		if (idx == arr.length) {
			int[] br = new int[count];
			return br;
		}

		if (arr[idx] == item) {
			int[] rr = allIndexes(arr, idx + 1, item, count + 1);
			rr[count] = idx;
			return rr;
		} else {
			int[] rr = allIndexes(arr, idx + 1, item, count);
			return rr;
		}

	}

}





