package L16_StackQueue;

public class DynamicQueue extends Queue {

	@Override
	public void enqueue(int item) throws Exception {

		if (isFull()) {

			// create a new array of double size
			int[] na = new int[2 * data.length];

			// copy the elements
			for (int i = 0; i < size; i++) {
				int idx = (i + front) % data.length;
				na[i] = data[idx];
			}

			// data members
			data = na;
			front = 0;

		}

		super.enqueue(item);
	}
}
