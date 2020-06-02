package L27_Heap;

import java.util.ArrayList;

public class HeapQs {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

		lists.add(new ArrayList<Integer>());
		lists.add(new ArrayList<Integer>());
		lists.add(new ArrayList<Integer>());
		lists.add(new ArrayList<Integer>());

		lists.get(0).add(10);
		lists.get(0).add(20);
		lists.get(0).add(30);
		lists.get(0).add(40);

		lists.get(1).add(5);
		lists.get(1).add(15);
		lists.get(1).add(50);

		lists.get(2).add(3);
		lists.get(2).add(7);

		lists.get(3).add(4);
		lists.get(3).add(8);
		lists.get(3).add(35);

		mergeKSortedLists(lists);

		int[] arr = { 10, 20, 3, 4, 6, 15, 30 };

		kLargestElements(arr, 3);
	}

	public static class Pair implements Comparable<Pair> {
		int data;
		int listNo;
		int idxNo;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}
	}

	public static void mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < lists.size(); i++) {

			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.listNo = i;
			np.idxNo = 0;

			heap.add(np);
		}

		while (!heap.isEmpty()) {

			Pair rp = heap.remove();

			System.out.println(rp.data);

			rp.idxNo++;

			if (rp.idxNo < lists.get(rp.listNo).size()) {
				rp.data = lists.get(rp.listNo).get(rp.idxNo);
				heap.add(rp);
			}

		}

	}

	public static void kLargestElements(int[] arr, int k) {

		Heap heap = new Heap();

		for (int i = 0; i < k; i++) {
			heap.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {

			int weaker = heap.get();

			if (arr[i] > weaker) {
				heap.remove();
				heap.add(arr[i]);
			}

		}

		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
		}

	}

}
