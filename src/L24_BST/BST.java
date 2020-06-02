package L24_BST;

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int[] arr) {

		this.root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {

		if (lo > hi) {
			return null;
		}

		// mid
		int mid = (lo + hi) / 2;

		// create a new node
		Node nn = new Node();
		nn.data = arr[mid];

		nn.left = construct(arr, lo, mid - 1);
		nn.right = construct(arr, mid + 1, hi);

		return nn;
	}

	public void display() {
		System.out.println("----------");
		display(this.root);
		System.out.println("----------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		// self work
		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		// left
		display(node.left);
		// right
		display(node.right);

	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}
		if (item > node.data) {
			return find(node.right, item);
		} else if (item < node.data) {
			return find(node.left, item);
		} else {
			return true;
		}

	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node.right == null) {
			return node.data;
		}

		return max(node.right);

	}

	public void add(int item) {
		add(this.root, item);
	}

	private void add(Node node, int item) {

		if (item > node.data) {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;

				node.right = nn;
			} else {
				add(node.right, item);
			}
		} else {
			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;

				node.left = nn;
			} else {
				add(node.left, item);
			}
		}

	}

	public void remove(int item) {
		remove(this.root, null, false, item);
	}

	private void remove(Node node, Node parent, boolean ilc, int item) {

		if (node == null) {
			return;
		}

		if (item > node.data) {
			remove(node.right, node, false, item);
		} else if (item < node.data) {
			remove(node.left, node, true, item);
		} else {

			if (node.left == null && node.right == null) {
				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}

			else if (node.left == null && node.right != null) {
				if (ilc) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			}

			else if (node.left != null && node.right == null) {
				if (ilc) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			}

			else {

				int max = max(node.left);
				node.data = max;

				remove(node.left, node, true, max);
			}
		}

	}

	public void printDec() {
		printDec(root);
	}

	private void printDec(Node node) {

		if (node == null) {
			return;
		}

		// R
		printDec(node.right);

		// N
		System.out.println(node.data);

		// L
		printDec(node.left);
	}

	int sum = 0;

	public void replaceWithSumLarger() {
		replaceWithSumLarger(root);
	}

	private void replaceWithSumLarger(Node node) {

		if (node == null) {
			return;
		}

		replaceWithSumLarger(node.right);

		// node update
		int temp = node.data;
		node.data = sum;
		sum += temp;

		replaceWithSumLarger(node.left);

	}

	public void printInRange(int lo, int hi) {
		printInRange(root, lo, hi);
	}

	private void printInRange(Node node, int lo, int hi) {

		if (node == null) {
			return;
		}

		if (node.data < lo) {
			printInRange(node.right, lo, hi);
		} else if (node.data > hi) {
			printInRange(node.left, lo, hi);
		} else if (node.data >= lo && node.data <= hi) {
			printInRange(node.left, lo, hi);
			System.out.println(node.data);
			printInRange(node.right, lo, hi);
		}
	}

	public void add2(int item) {
		root = add2(root, item);
	}

	private Node add2(Node node, int item) {

		if (node == null) {
			Node nn = new Node();
			nn.data = item;
			return nn;
		}

		if (item <= node.data) {
			node.left = add2(node.left, item);
		} else {
			node.right = add2(node.right, item);
		}
		
		return node ;

	}
}
