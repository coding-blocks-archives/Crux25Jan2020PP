package L19_LL;

import java.util.Scanner;

public class DeleteNode {

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

		System.out.println("-------------------");
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println(".");
		System.out.println("-------------------");
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

	public void deleteNode() {

		reversePointers();

		Node max = head;

		Node temp = head.next;

		while (temp != null) {

			if (temp.data < max.data) {
				max.next = temp.next;
			} else {
				max = temp;
			}

			temp = temp.next;
		}

		tail = max;

		reversePointers();

		display();

	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();

		DeleteNode list = new DeleteNode();

		for (int i = 0; i < N; i++) {
			list.addLast(scn.nextInt());
		}

		list.deleteNode();
	}

}
