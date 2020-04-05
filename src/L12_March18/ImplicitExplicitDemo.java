package L12_March18;

public class ImplicitExplicitDemo {

	public static void main(String[] args) {

		// implicit undo
		int n = 4;
		fun(n);
		System.out.println(n);

		// explicit undo
		boolean[] arr = new boolean[3];

		fun(arr, 0);

		for (boolean val : arr) {
			System.out.println(val);
		}

	}

	public static void fun(boolean[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		// prep
		arr[vidx] = true;

		// traverse
		fun(arr, vidx + 1);

		// undo
		arr[vidx] = false;
	}

	public static void fun(int n) {

		if (n == 0)
			return;

		fun(n - 1);
		System.out.println(n);
	}

}
