package L16_StackQueue;

public class DynamicStack extends Stack {

	@Override
	public void push(int item) throws Exception {
		
		// work only if stack is full
		if(isFull()) {
			
			// create a new array of double size
			int[] na = new int[data.length*2] ;
			
			// copy the elements to new array
			for(int i = 0; i <= tos ; i++) {
				na[i] = data[i] ;
			}
			
			// change the reference
			data = na ;
		}
		
		super.push(item) ;
	}
	
}
