package L18_StackQueueQs;

import L16_StackQueue.DynamicQueue;

public class QueueQs {

	public static void main(String[] args) throws Exception {

		DynamicQueue queue = new DynamicQueue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		System.out.println("-- Display Reverse --");
		queue.display(); // 10 20 30 40
		displayReverse(queue , 0); // 40 30 20 10
		queue.display(); // 10 20 30 40

		System.out.println("-- Actual Reverse --");
		queue.display();
		actualReverse(queue);
		queue.display(); // 40 30 20 10
	}

	public static void displayReverse(DynamicQueue q, int count) throws Exception {

		if(count == q.size()) {
			return ;
		}
		
		int temp = q.dequeue() ;
		q.enqueue(temp);
		displayReverse(q, count+1);
		System.out.println(temp);
		
	}

	public static void actualReverse(DynamicQueue q) throws Exception {

		if(q.isEmpty()) {
			return ;
		}
		
		int temp = q.dequeue() ;
		actualReverse(q);
		q.enqueue(temp);
	}

}
