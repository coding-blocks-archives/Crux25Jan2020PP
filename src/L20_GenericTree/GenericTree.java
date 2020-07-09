package L20_GenericTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		root = construct(null, -1);
	}

	private Node construct(Node parent, int ith) {

		// prompt
		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data + " ?");
		}

		// take input of data
		int item = scn.nextInt();

		// create a new node
		Node nn = new Node();

		// update the data
		nn.data = item;

		// prompt
		System.out.println("Enter the number of children for " + nn.data + " ?");

		// take input for children
		int noc = scn.nextInt();

		// loop
		for (int j = 0; j < noc; j++) {

			Node child = construct(nn, j);
			nn.children.add(child);
		}

		return nn;

	}

	public void display() {
		System.out.println("---------------------");
		display(root);
		System.out.println("---------------------");

	}

	private void display(Node node) {

		// self work
		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + " ";
		}

		str += ".";
		System.out.println(str);

		// smaller problem
		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}

		return ts + 1;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {
			int cm = max(child);

			if (cm > tm) {
				tm = cm;
			}
		}

		return tm;

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		int th = -1;

		for (Node child : node.children) {
			int ch = ht(child);

			if (ch > th) {
				th = ch;
			}
		}

		return th + 1;

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {

			boolean cf = find(child, item);

			if (cf)
				return true;

		}

		return false;

	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {
			mirror(child);
		}

		// self work : ArrayList Reverse
		// int i = 0;
		// int j = node.children.size() - 1;
		//
		// while (i < j) {
		//
		// Node in = node.children.get(i);
		// Node jn = node.children.get(j);
		//
		// node.children.set(i, jn);
		// node.children.set(j, in);
		//
		// i++;
		// j--;
		//
		// }

		Collections.reverse(node.children);

	}

	public void printAtLevel(int level) {
		printAtLevel(root, level, 0);
	}

	private void printAtLevel(Node node, int level, int count) {

		if (count == level) {
			System.out.println(node.data);
			return;

		}
		for (Node child : node.children) {
			printAtLevel(child, level, count + 1);
		}

	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {

		for (Node child : node.children) {
			linearize(child);
		}

		// self work

		while (node.children.size() > 1) {
			Node temp = node.children.remove(1);
			Node tail = getTail(node.children.get(0));
			tail.children.add(temp);
		}

	}

	private Node getTail(Node node) {

		if (node.children.size() == 0) {
			return node;
		}

		return getTail(node.children.get(0));

	}

	public void display2() {
		display2(root);
	}

	private void display2(Node node) {

		System.out.println("Hii " + node.data);

		for (Node child : node.children) {
			System.out.println("Going towards " + child.data);
			display2(child);
			System.out.println("Coming from " + child.data);
		}

		System.out.println("Bye " + node.data);

	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {

		System.out.println(node.data);

		for (Node child : node.children) {
			preorder(child);
		}
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {

		for (Node child : node.children) {
			postorder(child);
		}

		System.out.println(node.data);

	}

	public void levelorder() {

		LinkedList<Node> queue = new LinkedList<>();

		// add root node and start the work
		queue.addLast(root);

		// work till queue is not empty
		while (!queue.isEmpty()) {

			// remove the node
			Node rn = queue.removeFirst();

			// print
			System.out.print(rn.data + " ");

			// children
			for (Node child : rn.children) {
				queue.addLast(child);
			}

		}

		System.out.println();

	}

	public void levelorderLW1() {

		LinkedList<Node> queue = new LinkedList<>();

		// add root node and null and then start the work
		queue.addLast(root);
		queue.addLast(null);

		// work till queue is not empty
		while (!queue.isEmpty()) {

			// remove the node
			Node rn = queue.removeFirst();

			if (rn == null) {
				System.out.println();

				if (queue.isEmpty()) {
					break;
				}

				queue.addLast(null);
				continue;
			}

			// print
			System.out.print(rn.data + " ");

			// children
			for (Node child : rn.children) {
				queue.addLast(child);
			}

		}

		System.out.println();

	}

	public void levelorderLW2() {

		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		// add root node and start the work
		primary.addLast(root);

		// work till queue is not empty
		while (!primary.isEmpty()) {

			// remove the node
			Node rn = primary.removeFirst();

			// print
			System.out.print(rn.data + " ");

			// children
			for (Node child : rn.children) {
				helper.addLast(child);
			}

			// primary queue : empty
			if (primary.isEmpty()) {

				System.out.println();
				primary = helper;
				helper = new LinkedList<>();
			}

		}

	}

	public void levelorderZZ() {

		int count = 0;

		LinkedList<Node> p = new LinkedList<>();
		LinkedList<Node> h = new LinkedList<>();

		p.addFirst(root);

		while (!p.isEmpty()) {

			Node rn = p.removeFirst();

			System.out.print(rn.data + " ");

			if (count % 2 == 0) {
				for (Node child : rn.children) {
					h.addFirst(child);
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					h.addFirst(rn.children.get(i));
				}
			}

			if (p.isEmpty()) {
				System.out.println();
				count++;
				p = h;
				h = new LinkedList<Node>();
			}

		}

	}

}
