package L31_Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import L27_Heap.HeapGeneric;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vtces;

	public Graph() {
		vtces = new HashMap<>();
	}

	public int numVetex() {
		return this.vtces.size();
	}

	public boolean containsVertex(String vname) {
		return this.vtces.containsKey(vname);
	}

	public void addVertex(String vname) {

		if (vtces.containsKey(vname))
			return;

		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		Vertex vtx = vtces.get(vname);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : keys) {

			Vertex nbrVtx = vtces.get(key);
			nbrVtx.nbrs.remove(vname);
		}

		vtces.remove(vname);

	}

	public int numEdges() {

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		int count = 0;

		for (String key : keys) {

			Vertex vtx = vtces.get(key);
			count = count + vtx.nbrs.size();
		}

		return count / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vtces.get(vname1); // 2k
		Vertex vtx2 = vtces.get(vname2); // 4k

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		// vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {

		System.out.println("------------------");
		ArrayList<String> vnames = new ArrayList<>(vtces.keySet());

		for (String vname : vnames) {

			String str = vname + " => ";

			Vertex vtx = vtces.get(vname);
			str += vtx.nbrs;

			System.out.println(str);
		}
		System.out.println("------------------");

	}

	public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed) {

		// direct edge
		if (containsEdge(vname1, vname2)) {
			return true;
		}

		processed.put(vname1, true);

		Vertex vtx = vtces.get(vname1);
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

		for (String nbr : nbrs) {

			if (!processed.containsKey(nbr) && hasPath(nbr, vname2, processed))
				return true;
		}

		return false;
	}

	private class Pair {

		String vname;
		String psf;
	}

	public boolean bfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		// create a new pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		// put the new pair in queue
		queue.addLast(sp);

		// while queue is not empty keep on doing the work
		while (!queue.isEmpty()) {

			// remove a pair from queue
			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// processed put
			processed.put(rp.vname, true);

			// de
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs
			Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			// loop on nbrs
			for (String nbr : nbrs) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make a new pair of nbr and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					queue.addLast(np);
				}
			}

		}

		return false;

	}

	public boolean dfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		// create a new pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		// put the new pair in queue
		stack.addFirst(sp);

		// while queue is not empty keep on doing the work
		while (!stack.isEmpty()) {

			// remove a pair from queue
			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// processed put
			processed.put(rp.vname, true);

			// de
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs
			Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			// loop on nbrs
			for (String nbr : nbrs) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make a new pair of nbr and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					stack.addFirst(np);
				}
			}

		}

		return false;

	}

	public void bft() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in queue
			queue.addLast(sp);

			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {

				// remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processed put
				processed.put(rp.vname, true);

				// syso
				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				// loop on nbrs
				for (String nbr : nbrs) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}

	}

	public void dft() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in queue
			stack.addFirst(sp);

			// while queue is not empty keep on doing the work
			while (!stack.isEmpty()) {

				// remove a pair from queue
				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processed put
				processed.put(rp.vname, true);

				// syso
				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				// loop on nbrs
				for (String nbr : nbrs) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						stack.addFirst(np);
					}
				}

			}

		}

	}

	public boolean isCyclic() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in queue
			queue.addLast(sp);

			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {

				// remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					return true;
				}

				// processed put
				processed.put(rp.vname, true);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				// loop on nbrs
				for (String nbr : nbrs) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}

		return false;

	}

	public boolean isConnected() {

		int flag = 0;

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			flag++;

			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in queue
			queue.addLast(sp);

			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {

				// remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processed put
				processed.put(rp.vname, true);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				// loop on nbrs
				for (String nbr : nbrs) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}

		if (flag >= 2) {
			return false;
		} else {
			return true;
		}

	}

	public boolean isTree() {
		return !isCyclic() && isConnected();
	}

	public ArrayList<ArrayList<String>> getCC() {

		ArrayList<ArrayList<String>> ans = new ArrayList<>();

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			// for new component create a new arrayList
			ArrayList<String> subans = new ArrayList<>();

			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in queue
			queue.addLast(sp);

			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {

				// remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processed put
				processed.put(rp.vname, true);

				// put in subans arraylist
				subans.add(rp.vname);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				// loop on nbrs
				for (String nbr : nbrs) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

			// put subans in final ans
			ans.add(subans);

		}

		return ans;

	}

	private class PrimsPair implements Comparable<PrimsPair> {
		String vname;
		String acqvname;
		int cost;

		@Override
		public int compareTo(PrimsPair o) {
			return o.cost - this.cost;
		}

	}

	public Graph prims() {

		Graph mst = new Graph();
		HashMap<String, PrimsPair> map = new HashMap<>();

		HeapGeneric<PrimsPair> heap = new HeapGeneric<>();

		// make a pair and put in heap and map
		for (String key : vtces.keySet()) {

			PrimsPair np = new PrimsPair();
			np.vname = key;
			np.acqvname = null;
			np.cost = Integer.MAX_VALUE;

			heap.add(np);
			map.put(key, np);
		}

		// till the heap is not empty keep on removing the pairs
		while (!heap.isEmpty()) {

			// remove a pair
			PrimsPair rp = heap.remove();
			map.remove(rp.vname);

			// add to mst
			if (rp.acqvname == null) {
				mst.addVertex(rp.vname);
			} else {
				mst.addVertex(rp.vname);
				mst.addEdge(rp.vname, rp.acqvname, rp.cost);
			}

			// nbrs
			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {

				// work for nbrs which are in heap
				if (map.containsKey(nbr)) {

					// get the oc and nc
					int oc = map.get(nbr).cost;
					int nc = vtces.get(rp.vname).nbrs.get(nbr);

					// update the pair only when nc < oc
					if (nc < oc) {

						PrimsPair gp = map.get(nbr);
						gp.acqvname = rp.vname;
						gp.cost = nc;

						heap.updatePriority(gp);
					}
				}

			}

		}

		return mst;

	}

	private class DijkstraPair implements Comparable<DijkstraPair> {
		String vname;
		String psf;
		int cost;

		@Override
		public int compareTo(DijkstraPair o) {
			return o.cost - this.cost;
		}

	}

	public HashMap<String, Integer> dijkstra(String src) {

		HashMap<String, Integer> ans = new HashMap<>();
		HashMap<String, DijkstraPair> map = new HashMap<>();

		HeapGeneric<DijkstraPair> heap = new HeapGeneric<>();

		// make a pair and put in heap and map
		for (String key : vtces.keySet()) {

			DijkstraPair np = new DijkstraPair();
			np.vname = key;
			np.psf = "";
			np.cost = Integer.MAX_VALUE;

			if (key.equals(src)) {
				np.cost = 0;
				np.psf = key;
			}

			heap.add(np);
			map.put(key, np);
		}

		// till the heap is not empty keep on removing the pairs
		while (!heap.isEmpty()) {

			// remove a pair
			DijkstraPair rp = heap.remove();
			map.remove(rp.vname);

			// add to ans
			ans.put(rp.vname, rp.cost);

			// nbrs
			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {

				// work for nbrs which are in heap
				if (map.containsKey(nbr)) {

					// get the oc and nc
					int oc = map.get(nbr).cost;
					int nc = rp.cost + vtces.get(rp.vname).nbrs.get(nbr);

					// update the pair only when nc < oc
					if (nc < oc) {

						DijkstraPair gp = map.get(nbr);
						gp.psf = rp.psf + nbr;
						gp.cost = nc;

						heap.updatePriority(gp);
					}
				}

			}

		}

		return ans;

	}

	public class DisjointSet {

		HashMap<String, Node> map = new HashMap<>();

		private class Node {
			String data;
			Node parent;
			int rank;
		}

		public void create(String value) {

			Node nn = new Node();
			nn.data = value;
			nn.parent = nn;
			nn.rank = 0;

			map.put(value, nn);

		}

		public void union(String value1, String value2) {

			Node n1 = map.get(value1);
			Node n2 = map.get(value2);

			Node re1 = find(n1);
			Node re2 = find(n2);

			if (re1.data.equals(re2.data)) {
				return;
			} else {

				if (re1.rank == re2.rank) {
					re2.parent = re1;
					re1.rank = re1.rank + 1;
				} else if (re1.rank > re2.rank) {
					re2.parent = re1;
				} else {
					re1.parent = re2;
				}

			}

		}

		public String find(String value) {
			return find(map.get(value)).data;
		}

		private Node find(Node node) {

			if (node == node.parent) {
				return node;
			}

			Node rr = find(node.parent);
			node.parent = rr; // path compression
			return rr;

		}

	}

	private class EdgePair implements Comparable<EdgePair> {

		String v1;
		String v2;

		int cost;

		@Override
		public int compareTo(EdgePair o) {
			return this.cost - o.cost;
		}

		public String toString() {
			return v1 + "-" + v2 + " : " + cost;
		}
	}

	public ArrayList<EdgePair> getAllEdges() {

		ArrayList<EdgePair> edges = new ArrayList<>();

		for (String vname : vtces.keySet()) {

			Vertex vtx = vtces.get(vname);

			for (String nbr : vtx.nbrs.keySet()) {

				EdgePair ep = new EdgePair();
				ep.v1 = vname;
				ep.v2 = nbr;
				ep.cost = vtx.nbrs.get(nbr);

				edges.add(ep);
			}

		}

		return edges;

	}

	public void kruskal() {

		// sort the edges in increasing order of weight
		ArrayList<EdgePair> edges = getAllEdges();
		Collections.sort(edges);

		DisjointSet set = new DisjointSet();

		// create vertices no. of sets
		for (String vname : vtces.keySet()) {
			set.create(vname);
		}

		// traverse over the edges
		for (EdgePair edge : edges) {

			String re1 = set.find(edge.v1);
			String re2 = set.find(edge.v2);

			// re same : ignore
			if (re1.equals(re2)) {
				continue;
			} else {
				System.out.println(edge);
				set.union(edge.v1, edge.v2);
			}

		}

	}

	public HashMap<String, Integer> bellmanFord(String src) throws Exception {

		ArrayList<EdgePair> edges = getAllEdges();

		HashMap<String, Integer> map = new HashMap<>();

		// fill hashmap with infinity and zero
		for (String vname : vtces.keySet()) {
			map.put(vname, 100000);

			if (src.equals(vname)) {
				map.put(vname, 0);
			}
		}

		int V = vtces.size();

		// relax every edge V-1 times
		for (int i = 1; i <= V; i++) {

			// loop on edges
			for (EdgePair edge : edges) {

				int oc = map.get(edge.v2);
				int nc = map.get(edge.v1) + edge.cost;

				if (oc > nc) {

					if (i <= V - 1)
						map.put(edge.v2, nc);
					else
						throw new Exception("-ve wt cycle present");
				}

			}

		}

		return map;

	}

}
