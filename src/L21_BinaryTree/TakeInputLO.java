package L21_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TakeInputLO {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node root;

	public TakeInputLO() {

		Queue<Node> q = new LinkedList<>();

		int item = scn.nextInt();

		if (item == -1) {
			return;
		}

		root = new Node(item);
		q.add(root);

		while (!q.isEmpty()) {

			Node pn = q.remove();

			int ld = scn.nextInt();

			if (ld != -1) {

				Node ln = new Node(ld);
				pn.left = ln;
				q.add(ln);

			}

			int rd = scn.nextInt();

			if (rd != -1) {

				Node rn = new Node(rd);
				pn.right = rn;
				q.add(rn);

			}

		}

	}

	public void display() {
		System.out.println("----------------");
		display(root);
		System.out.println("----------------");
	}

	private void display(Node node) {

		// base case
		if (node == null) {
			return;
		}

		// self work
		String str = "";

		if (node.left == null)
			str += ".";
		else
			str += node.left.data;

		str += "->" + node.data + "<-";

		if (node.right == null)
			str += ".";
		else
			str += node.right.data;

		System.out.println(str);

		// smaller problems
		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {

		TakeInputLO tree = new TakeInputLO();
		tree.display();
	}

}
