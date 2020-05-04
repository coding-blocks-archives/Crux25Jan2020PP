package Assignments.May4;

public class FormBiggestNumber {

	public static void main(String[] args) {

		int[] arr = { 54, 546, 548, 60, 5 };

		bubbleSort(arr);
		
		for(int val : arr) {
			System.out.print(val +  " ");
		}

	}

	public static void bubbleSort(int[] arr) {

		for (int count = 0; count <= arr.length - 2; count++) {

			for (int j = 0; j <= arr.length - count - 2; j++) {

				if (compare(arr[j], arr[j + 1])) {

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}
	}

	private static boolean compare(int one, int two) {

		String onetwo = one + "" + two;
		String twoone = two + "" + one;

		if (twoone.compareTo(onetwo) > 0) {
			return true;
		} else {
			return false;
		}

	}

}
