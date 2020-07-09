package L20_GenericTree;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class GTClient {

	// 10 3 20 2 50 0 60 1 80 0 30 0 40 1 70 0
	public static void main(String[] args) {

		GenericTree gt = new GenericTree();
		gt.display();

		// System.out.println(gt.size());
		// System.out.println(gt.max());
		// System.out.println(gt.ht());
		// System.out.println(gt.find(600));

		// gt.mirror();

		// gt.display();

		// gt.printAtLevel(4);

		// gt.linearize();
		// gt.display();
		// gt.display2();
		gt.levelorderLW2();
		gt.levelorderZZ();

	}

}
