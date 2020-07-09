package L19_LL;

import java.util.Scanner;

public class SumTWoLL {

	private class Node {
		int data;
		Node next;

		public Node() {

		}

	}

	private Node head;
	private Node tail;
	private int size;

	// O(n)
	public void display() {

		// System.out.println("-------------------");
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("");
		// System.out.println("-------------------");
	}

	// O(1)
	public void addFirst(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size >= 1) {
			nn.next = head;
		}

		// summary object update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}

	}

	// O(1)
	public void addLast(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size >= 1) {
			this.tail.next = nn;
		}

		// summary object
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}
	}

	public void reversePointers() {

		Node prev = this.head;
		Node curr = prev.next;

		while (curr != null) {

			Node ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead;
		}

		// swap
		Node t = this.head;
		this.head = this.tail;
		this.tail = t;

		this.tail.next = null;

	}

	public void sum(SumTWoLL o) {

		SumTWoLL ans = new SumTWoLL();

		reversePointers();
		o.reversePointers();

		int carry = 0;

		Node one = head;
		Node two = o.head;

		while (one != null || two != null) {

			int sum = carry;

			if (one != null) {
				sum += one.data;
				one = one.next;
			}

			if (two != null) {
				sum += two.data;
				two = two.next;
			}

			// ans.addLast(sum % 10);
			ans.addFirst(sum % 10);
			carry = sum / 10;

		}

		if (carry != 0)
			ans.addFirst(carry);

		// ans.reversePointers();

		ans.display();
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int N1 = scn.nextInt();
		int N2 = scn.nextInt();

		SumTWoLL list = new SumTWoLL();

		for (int i = 0; i < N1; i++) {
			list.addLast(scn.nextInt());
		}

		SumTWoLL list1 = new SumTWoLL();

		for (int i = 0; i < N2; i++) {
			list1.addLast(scn.nextInt());
		}

		list.sum(list1);
	}

}
