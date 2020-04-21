package L14_DC;

public class DivideConquer {

	public static void main(String[] args) {

		int[] arr = { 90, 50, 30, 80, 60, 20, 45, 10, 70, 25 };

		// int[] ans = mergeSort(arr, 0, arr.length - 1);
		//
		// for (int val : ans) {
		// System.out.println(val);
		// }

		quickSort(arr, 0, arr.length - 1);

		for (int val : arr) {
			System.out.println(val);
		}
	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {

		int[] merged = new int[one.length + two.length];

		int i = 0;
		int j = 0;

		int k = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				merged[k] = one[i];
				k++;
				i++;
			} else {
				merged[k] = two[j];
				k++;
				j++;
			}

		}

		if (i == one.length) {

			while (j < two.length) {
				merged[k] = two[j];
				k++;
				j++;
			}

		}

		if (j == two.length) {

			while (i < one.length) {
				merged[k] = one[i];
				k++;
				i++;
			}
		}

		return merged;

	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fpres = mergeSort(arr, lo, mid);
		int[] spres = mergeSort(arr, mid + 1, hi);

		int[] ans = mergeTwoSortedArrays(fpres, spres);

		return ans;

	}

	public static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		// partitioning
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		int left = lo;
		int right = hi;

		while (left <= right) {

			// move left towards a problem
			while (arr[left] < pivot) {
				left++;
			}

			// move rights towards a problem
			while (arr[right] > pivot) {
				right--;
			}

			// swap
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}

		}

		// smaller problems : independently sort
		quickSort(arr, lo, right);
		quickSort(arr, left, hi);

	}

}
