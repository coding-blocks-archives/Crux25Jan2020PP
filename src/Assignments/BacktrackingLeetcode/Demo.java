package Assignments.BacktrackingLeetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class Demo {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		ArrayList<Integer> al = new ArrayList<>();
		al.add(10);
		al.add(20);
		al.add(30);

		// new array list with excatly the same content as ur older array list
		ArrayList<Integer> alnew = new ArrayList<Integer>(al);
		System.out.println(alnew);

		ArrayList<ArrayList<Integer>> main = new ArrayList<>();

		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(10);
		temp.add(20);

		main.add(new ArrayList<Integer>(temp));

		System.out.println(main);
		
		temp.add(30) ;
		main.add(new ArrayList<Integer>(temp)) ;
		System.out.println(main);

		temp.remove(temp.size()-1) ;
		temp.remove(temp.size()-1) ;
		
		main.add(new ArrayList<Integer>(temp)) ;
		
		System.out.println(main);
		
		
	}

}








