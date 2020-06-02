package L19_March18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class LinkedList {

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

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
	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.head.data;
	}

	// O(1)
	public int getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.tail.data;
	}

	// O(n)
	public int getAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	// O(n)
	private Node getNodeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;
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

	// O(n)
	public void addAt(int item, int idx) throws Exception {

		if (idx < 0 || idx > size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size) {
			addLast(item);
		} else {

			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// attach
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;

			nm1.next = nn;
			nn.next = np1;

			// summary update
			this.size++;
		}
	}

	// O(1)
	public int removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		int rv = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return rv;

	}

	// O(n)
	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		int rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node sizem2 = getNodeAt(this.size - 2);
			this.tail = sizem2;
			this.tail.next = null;
			this.size--;
		}

		return rv;
	}

	// O(n)
	public int removeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;

			this.size--;

			return n.data;
		}
	}

	public void reverseData() throws Exception {

		int left = 0;
		int right = this.size - 1;

		while (left < right) {

			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;

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

	public int mid() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;

	}

	public void reversePointerRecursively() {
		reversePointerRecursively(null, head);

		// swap head and tail
		Node temp = head;
		head = tail;
		tail = temp;
	}

	private void reversePointerRecursively(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		Node ahead = curr.next;
		curr.next = prev;
		reversePointerRecursively(curr, ahead);

	}

	private class HeapMover {
		Node left;
	}

	public void reverseDataRecursively() {

		// HeapMover mover = new HeapMover();
		// mover.left = head;
		//
		// reverseDataRecursively(mover, head, 0);

		System.out.println(reverseDataRecursively(head, head, 0));
	}

	private void reverseDataRecursively(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		reverseDataRecursively(mover, right.next, count + 1);

		// swap the data of left and right node
		if (count >= size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}

		mover.left = mover.left.next;

	}

	private Node reverseDataRecursively(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}

		Node cl = reverseDataRecursively(left, right.next, count + 1);

		// swap the data of left and right node
		if (count >= size / 2) {
			int temp = cl.data;
			cl.data = right.data;
			right.data = temp;
		}

		return cl.next;

	}

	public void fold() {
		HeapMover mover = new HeapMover();
		mover.left = head;
		fold(mover, head, 0);
	}

	private void fold(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		fold(mover, right.next, count + 1);

		// make links
		if (count > size / 2) {

			Node ahead = mover.left.next;
			mover.left.next = right;
			right.next = ahead;

			// mover update
			mover.left = ahead;

		}

		if (count == size / 2) {
			tail = right;
			tail.next = null;
		}

	}

	public int kthFromLast(int k) {

		Node slow = head;
		Node fast = head;

		// create a gap of k b/w slow and fast
		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}

		// move both the pointers with uniform speed
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow.data;
	}

	public void kReverse(int k) {
		head = kReverse(head, k);
	}

	private Node kReverse(Node node, int k) {

		if (node == null) {
			return null;
		}

		// to identify the argument of smaller problem
		Node temp = node;
		for (int i = 1; i <= k && temp != null; i++) {
			temp = temp.next;
		}

		// smaller problem : s2 and s3 reverse
		Node prev = kReverse(temp, k);

		// self work : reverse s1
		// reverse pointer iteratively
		Node curr = node;

		while (curr != temp) {

			Node ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead;
		}

		return prev;

	}

	public void createDummyList() {

		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		Node n9 = new Node(90);
		Node n10 = new Node(100);
		Node n11 = new Node(110);
		Node n12 = new Node(120);
		Node n13 = new Node(130);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n13.next = n12;
		n12.next = n11;
		n11.next = n7;

		Node h1 = n1;
		Node h2 = n13;

		// logic ....
		intersection(h1, h2);

	}

	private void intersection(Node h1, Node h2) {

		Node fp = h1;
		Node sp = h2;

		while (fp != sp) {

			if (fp == null)
				fp = h2;
			else
				fp = fp.next;

			if (sp == null)
				sp = h1;
			else
				sp = sp.next;

		}

		System.out.println(fp.data);

	}

	public void createDummyListLoop() {

		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n3;

		// logic ....
		System.out.println(detectLoop(n1));

	}

	public boolean detectLoop(Node h1) {

		Node slow = h1;
		Node fast = h1;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				removeLoop2(slow, h1);
				return true;
			}

		}

		return false;

	}

	public void removeLoop(Node meet, Node h) {

		// no. of nodes in loop
		int count = 1;
		Node temp = meet;
		while (temp.next != meet) {
			count++;
			temp = temp.next;
		}

		// move a pointer count no. of steps ahead
		Node fast = h;
		for (int i = 1; i <= count; i++) {
			fast = fast.next;
		}

		// make slow and fast move at same speed
		Node slow = h;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}

		fast.next = null;

		// print ll
		// Node t = h ;
		// while(t!= null) {
		// System.out.print(t.data + " ");
		// t = t.next ;
		// }
		// System.out.println();

	}

	public void removeLoop2(Node meet, Node h) {

		Node start = h;
		Node loop = meet;

		while (start.next != loop.next) {
			start = start.next;
			loop = loop.next;
		}

		loop.next = null;

		// print ll
		Node t = h;
		while (t != null) {
			System.out.print(t.data + " ");
			t = t.next;
		}
		System.out.println();

	}

}
