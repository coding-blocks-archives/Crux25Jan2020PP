package L21_BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class BinaryTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		root = takeInput(null, false);
	}

	private Node takeInput(Node parent, boolean ilc) {

		// prompt
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {

			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		// take input of data from user
		int item = scn.nextInt();

		// create a new node
		Node nn = new Node();

		// update the data of node
		nn.data = item;

		// ask user if the node has left child
		System.out.println(nn.data + " has left child ?");

		// take input either true or false
		boolean hlc = scn.nextBoolean();

		// if left child exists, then create it
		if (hlc) {
			nn.left = takeInput(nn, true);
		}

		// ask user if the node has right child
		System.out.println(nn.data + " has right child ?");

		// take input either true or false
		boolean hrc = scn.nextBoolean();

		// if right child exists, then create it
		if (hrc) {
			nn.right = takeInput(nn, false);
		}

		// node is ready, now return the node
		return nn;

	}

	public BinaryTree(int[] pre, int[] in) {
		root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (ilo > ihi || plo > phi) {
			return null;
		}

		// create a new node with plo
		Node nn = new Node();
		nn.data = pre[plo];

		// search for pre[plo] in inorder
		int si = -1;
		int nel = 0;
		for (int i = ilo; i <= ihi; i++) {

			if (pre[plo] == in[i]) {
				si = i;
				break;
			}

			nel++;
		}

		// left and right child call
		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);

		return nn;

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

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

	int diameterAns = Integer.MIN_VALUE;

	public int diameter() {
		diameter(root);

		return diameterAns;

	}

	private void diameter(Node node) {

		if (node == null) {
			return;
		}

		int presentNodeRoot = ht(node.left) + ht(node.right) + 2;

		if (presentNodeRoot > diameterAns) {
			diameterAns = presentNodeRoot;
		}

		diameter(node.left);
		diameter(node.right);

	}

	public int diameter2() {
		return diameter2(root);
	}

	private int diameter2(Node node) {

		if (node == null) {
			return 0;
		}

		// max distance between 2 leaf nodes might lie in left subtree : left ka
		// diameter
		int ld = diameter2(node.left);

		// max distance between 2 leaf nodes might lie in right subtree : right ka
		// diameter
		int rd = diameter2(node.right);

		// self node might be the root node of diameter
		int sd = ht(node.left) + ht(node.right) + 2;

		return Math.max(sd, Math.max(ld, rd));
	}

	private class DiaPair {
		int dia = 0;
		int ht = -1;
	}

	public int diameter3() {
		return diameter3(root).ht;
	}

	private DiaPair diameter3(Node node) {

		if (node == null) {
			return new DiaPair();
		}

		DiaPair ldp = diameter3(node.left);
		DiaPair rdp = diameter3(node.right);

		DiaPair sdp = new DiaPair();

		int ld = ldp.dia;
		int rd = rdp.dia;
		int sd = ldp.ht + rdp.ht + 2;

		sdp.dia = Math.max(sd, Math.max(ld, rd));
		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;

		return sdp;

	}

	public boolean isBalanced2() {
		return isBalanced2(root);
	}

	private boolean isBalanced2(Node node) {

		if (node == null) {
			return true;
		}

		boolean lb = isBalanced2(node.left);
		boolean rb = isBalanced2(node.right);

		int bf = ht(node.left) - ht(node.right);

		if (lb && rb && bf >= -1 && bf <= 1) {
			return true;
		} else {
			return false;
		}

	}

	private class BalPair {
		boolean isBal = true;
		int ht = -1;
	}

	public boolean isBalanced3() {
		return isBalanced3(root).isBal;
	}

	private BalPair isBalanced3(Node node) {

		if (node == null) {
			return new BalPair();
		}

		BalPair lbp = isBalanced3(node.left);
		BalPair rbp = isBalanced3(node.right);

		BalPair sbp = new BalPair();

		boolean lb = lbp.isBal;
		boolean rb = rbp.isBal;

		int bf = lbp.ht - rbp.ht;

		if (lb && rb && bf >= -1 && bf <= 1) {
			sbp.isBal = true;
		} else {
			sbp.isBal = false;
		}

		sbp.ht = Math.max(lbp.ht, rbp.ht) + 1;

		return sbp;

	}

	public boolean flipEquivalent(BinaryTree other) {
		return flipEquivalent(root, other.root);
	}

	private boolean flipEquivalent(Node node1, Node node2) {

		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null && node2 != null) {
			return false;
		}

		if (node1 != null && node2 == null) {
			return false;
		}

		if (node1.data != node2.data) {
			return false;
		}

		boolean ll = flipEquivalent(node1.left, node2.left);
		boolean rr = flipEquivalent(node1.right, node2.right);

		if (ll && rr) {
			return true;
		}

		boolean lr = flipEquivalent(node1.left, node2.right);
		boolean rl = flipEquivalent(node1.right, node2.left);

		return (lr && rl);

	}

	// NLR : preorder
	// LNR : inorder
	// LRN : postorder
	// NRL : rev postorder
	// RNL : rev inorder
	// RLN : rev preorder
	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {

		if (node == null) {
			return;
		}

		// N
		System.out.println(node.data);

		// R
		preorder(node.right);

		// L
		preorder(node.left);

	}

	private class Pair {
		Node node;
		boolean sd;
		boolean ld;
		boolean rd;
	}

	public void preoderI() {

		// create a stack
		Stack<Pair> stack = new Stack<>();

		// create a starting pair
		Pair sp = new Pair();
		sp.node = root;

		// put the sp in stack
		stack.push(sp);

		// work till your stack is not empty
		while (!stack.isEmpty()) {

			Pair tp = stack.peek();

			if (tp.node == null) {
				stack.pop();
				continue;
			}

			if (tp.sd == false) {
				System.out.println(tp.node.data);
				tp.sd = true;
			} else if (tp.ld == false) {

				// create a new pair
				Pair np = new Pair();
				np.node = tp.node.left;

				// push the np into stack
				// if (np.node != null)
				stack.push(np);

				// put true in ld of tp
				tp.ld = true;

			} else if (tp.rd == false) {

				// create a new pair
				Pair np = new Pair();
				np.node = tp.node.right;

				// push the np into stack
				// if (np.node != null)
				stack.push(np);

				// put true in ld of tp
				tp.rd = true;

			} else {
				stack.pop();
			}

		}

	}

	public int sum() {
		return sum(root);
	}

	private int sum(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = sum(node.left);
		int rs = sum(node.right);

		return ls + rs + node.data;
	}

	// Approach 1 : using global variable
	int maxSum = Integer.MIN_VALUE;

	public int maxSubtreeSum1() {
		maxSubtreeSum1(root);

		return maxSum;
	}

	private int maxSubtreeSum1(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = maxSubtreeSum1(node.left);
		int rs = maxSubtreeSum1(node.right);

		int nodeans = ls + rs + node.data;

		if (nodeans > maxSum) {
			maxSum = nodeans;
		}

		return nodeans;

	}

	// Approach 2: recursion is returning something (something -> max subtree sum)
	public int maxSubtreeSum2() {
		return maxSubtreeSum2(root);
	}

	private int maxSubtreeSum2(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int lMaxSubtreeSum = maxSubtreeSum2(node.left);
		int rMaxSubtreeSum = maxSubtreeSum2(node.right);
		int selfSum = sum(node.left) + node.data + sum(node.right);

		return Math.max(selfSum, Math.max(lMaxSubtreeSum, rMaxSubtreeSum));
	}

	// Approach 3 : recursion will return you multiple values so that time
	// complexity can be maintained as O(n)
	private class MaxSubtreeSumPair {
		int entireSum = 0;
		int maxSubtreeSum = Integer.MIN_VALUE;
	}

	public int maxSubtreeSum3() {
		return maxSubtreeSum3(root).maxSubtreeSum;
	}

	private MaxSubtreeSumPair maxSubtreeSum3(Node node) {

		if (node == null) {
			return new MaxSubtreeSumPair();
		}
		MaxSubtreeSumPair lp = maxSubtreeSum3(node.left);
		MaxSubtreeSumPair rp = maxSubtreeSum3(node.right);

		MaxSubtreeSumPair sp = new MaxSubtreeSumPair();

		sp.entireSum = lp.entireSum + rp.entireSum + node.data;

		sp.maxSubtreeSum = Math.max(sp.entireSum, Math.max(lp.maxSubtreeSum, rp.maxSubtreeSum));

		return sp;

	}

	private class BSTPair {
		boolean isBST = true;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		int largestBSTRootNode;
		int largestBSTSize;
	}

	public void isTreeBST() {
		BSTPair ans = isTreeBST(root);

		System.out.println(ans.largestBSTRootNode + " " + ans.largestBSTSize);
	}

	private BSTPair isTreeBST(Node node) {

		if (node == null) {
			return new BSTPair();
		}

		BSTPair lbp = isTreeBST(node.left);
		BSTPair rbp = isTreeBST(node.right);

		BSTPair sbp = new BSTPair();

		sbp.max = Math.max(node.data, Math.max(lbp.max, rbp.max));
		sbp.min = Math.min(node.data, Math.min(lbp.min, rbp.min));

		if (lbp.isBST && rbp.isBST && node.data > lbp.max && node.data < rbp.min) {
			sbp.isBST = true;

			sbp.largestBSTRootNode = node.data;
			sbp.largestBSTSize = lbp.largestBSTSize + rbp.largestBSTSize + 1;

		} else {
			sbp.isBST = false;

			if (lbp.largestBSTSize > rbp.largestBSTSize) {
				sbp.largestBSTRootNode = lbp.largestBSTRootNode;
				sbp.largestBSTSize = lbp.largestBSTSize;
			} else {
				sbp.largestBSTRootNode = rbp.largestBSTRootNode;
				sbp.largestBSTSize = rbp.largestBSTSize;
			}

		}

		return sbp;

	}

	private class VOPair {
		Node node;
		int vl;

		public VOPair(Node node, int vl) {
			this.node = node;
			this.vl = vl;
		}
	}

	public void verticalOrderDisplay() {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		Queue<VOPair> q = new LinkedList<>();

		VOPair sp = new VOPair(root, 0);
		q.add(sp);

		while (!q.isEmpty()) {

			VOPair rp = q.remove();

			if (!map.containsKey(rp.vl)) {
				map.put(rp.vl, new ArrayList<>());
			}

			map.get(rp.vl).add(rp.node.data);

			if (rp.node.left != null) {
				VOPair np = new VOPair(rp.node.left, rp.vl - 1);
				q.add(np);
			}

			if (rp.node.right != null) {
				VOPair np = new VOPair(rp.node.right, rp.vl + 1);
				q.add(np);
			}

		}
		
		ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet()) ;
		
		Collections.sort(keys) ;
		
		for(int key : keys) {
			System.out.println(key + " -> " + map.get(key));
		}
	}

}
