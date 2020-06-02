package L24_BST;

public class BSTClient {

	public static void main(String[] args) {

		int[] in = {};

		BST bst = new BST(in);
		bst.display();

		// System.out.println(bst.find(10));
		// System.out.println(bst.max());
		// bst.add(55);
		// bst.display();
		//
		// bst.remove(55);
		// bst.display();
		//
		// bst.remove(80);
		// bst.display();

		// bst.printDec();
		// bst.replaceWithSumLarger();
		// bst.display();

		// bst.printInRange(25, 55);

		bst.add2(10);
		bst.add2(20);
		bst.add2(30);
		bst.add2(3);
		bst.add2(5);
		bst.display();

	}

}