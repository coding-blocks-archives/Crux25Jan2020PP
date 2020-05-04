package Assignments.May4;

import java.util.Scanner;

public class AlexGoesShopping {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int queries = scn.nextInt();

		for (int i = 1; i <= queries; i++) {

			int amount = scn.nextInt();
			int totalItemsShopkeeper = scn.nextInt();

			int totalItemActually = 0;

			for (int j = 0; j < arr.length; j++) {
				if (amount % arr[j] == 0) {
					totalItemActually++;
				}
			}

			if (totalItemActually >= totalItemsShopkeeper) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		}
	}

}
