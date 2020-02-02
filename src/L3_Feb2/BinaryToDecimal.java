package L3_Feb2;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Feb-2020
 *
 */

public class BinaryToDecimal {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in) ;
		
		int n = scn.nextInt();
		int ans = 0 ;
		int multiplier = 1 ;

		while (n > 0) {

			int rem = n % 10;
			
			ans = ans + rem * multiplier ;
			
			n = n / 10;
			multiplier = multiplier * 2 ;

		}
		
		System.out.println(ans);
	}

}




