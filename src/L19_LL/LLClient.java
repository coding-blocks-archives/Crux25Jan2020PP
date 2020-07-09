package L19_LL;

public class LLClient {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);

		LinkedList list1 = new LinkedList();

		list1.addLast(5);
		list1.addLast(7);
		list1.addLast(45);
		// list.addLast(90);

		// list.display();
		// list.reversePointerRecursively();
		// list.reverseDataRecursively();

		// list.fold();

		// list.display();

		// System.out.println(list.kthFromLast(2));

		// list.kReverse(3);
		// list.createDummyList();

		// list.display();

		// list.createDummyListLoop();

		// list.oddeven();
		list.mergeTwoSortedLL(list1).display();
	}
}
