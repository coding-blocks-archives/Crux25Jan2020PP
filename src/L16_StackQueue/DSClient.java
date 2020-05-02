package L16_StackQueue;

public class DSClient {

	public static void main(String[] args) throws Exception {

		DynamicStack stack = new DynamicStack();

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);


		stack.display(); // 70 60 50 40 30 20 10
		displayReverse(stack) ; // 10 20 30 40 50 60 70
		stack.display(); // 70 60 50 40 30 20 10
	}
	
	public static void displayReverse(DynamicStack s) {
		
		
	}
}





