package L7_Feb22;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 22-Feb-2020
 *
 */

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();

		System.out.println(list);

		// add
		list.add(10);
		System.out.println(list);
		list.add(20);
		System.out.println(list);
		list.add(30);
		System.out.println(list);

		// size
		System.out.println(list.size());

		// add At
		// worst case : O(n) : when added at 0th index
		// best case : O(1) : when added at size index
		// range : 0 -> size
		list.add(list.size(), 100);
		System.out.println(list);

		// get
		// time : O(1)
		// range : 0 -> size-1
		System.out.println(list.get(2));

		// set
		// time : O(1)
		// range : 0 -> size-1
		System.out.println("OV : " + list.set(2, 200));
		System.out.println(list);

		// remove
		// worst case : O(n) : when removed at 0th index
		// best case : O(1) : when removed from size-1 index
		System.out.println(list.remove(1));
		System.out.println(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		for (int val : list) {
			System.out.println(val);
		}

	}

}
