package Assignments.May4;

public class MaxSumPath {

	public static void main(String[] args) {

		int[] one = { 2, 3, 7, 10, 12, 15, 30, 34 };
		int[] two = { 1, 5, 7, 8, 10, 15, 16, 19 };

		int sum = 0;

		int sum1 = 0;
		int sum2 = 0;

		int i = 0;
		int j = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				sum1 += one[i];
				i++;
			} else if (one[i] > two[j]) {
				sum2 += two[j];
				j++;
			} else {

				sum += Math.max(sum1, sum2) + one[i];

				sum1 = 0;
				sum2 = 0;

				i++;
				j++;

			}
		}

		if (i == one.length) {
			while (j < two.length) {
				sum2 += two[j];
				j++;
			}
		}

		if (j == two.length) {
			while (i < one.length) {
				sum1 += one[i];
				i++;
			}
		}

		sum += Math.max(sum1, sum2);

		System.out.println(sum);
	}

}
