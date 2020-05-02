package L18_StackQueueQs;

import L16_StackQueue.DynamicStack;

public class StackQs {

	public static void main(String[] args) throws Exception {

		DynamicStack stack = new DynamicStack();

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		stack.display(); // 50 40 30 20 10
		displayReverse(stack); // 10 20 30 40 50
		stack.display(); // 50 40 30 20 10

		stack.display(); // 50 40 30 20 10
		actualReverse(stack, new DynamicStack());
		stack.display(); // 10 20 30 40 50

	}

	public static void displayReverse(DynamicStack s) throws Exception {

		if (s.isEmpty()) {
			return;
		}

		int temp = s.pop();
		displayReverse(s);
		System.out.println(temp);
		s.push(temp);

	}

	public static void actualReverse(DynamicStack s, DynamicStack t) throws Exception {

		if (s.isEmpty()) {
			actualReverseHelper(s, t);
			return;
		}

		t.push(s.pop());
		actualReverse(s, t);

	}

	public static void actualReverseHelper(DynamicStack s, DynamicStack t) throws Exception {

		if (t.isEmpty()) {
			return;
		}

		int temp = t.pop();
		actualReverseHelper(s, t);
		s.push(temp);
	}

}
