package Assignments.Feb21;

import java.util.Scanner;

public class ShoppingGame {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while (t > 0) {
			int AyushLimit = scn.nextInt();
			int HarshitLimit = scn.nextInt();

			int AyushPhones = 0;
			int HarshitPhones = 0;

			int nextBuyingNo = 1;

			while (true) {

				AyushPhones += nextBuyingNo;
				nextBuyingNo++;
				HarshitPhones += nextBuyingNo;
				nextBuyingNo++;

				if (AyushPhones > AyushLimit) {
					System.out.println("Harshit");
					break;
				}

				if (HarshitPhones > HarshitLimit) {
					System.out.println("Aayush");
					break;
				}

			}

		}

		t--;
	}

}
