package Assignments.Recursion;

public class TOH {

	public static void main(String[] args) {

		TOH(3, "S", "D", "H");
	}

	// bigger problem : n disk from src -> dst using helper
	public static void TOH(int n, String src, String dst, String helper) {

		if (n == 0) {
			return;
		}

		// smaller problem : n-1 disk src -> helper using dst
		TOH(n - 1, src, helper, dst);

		// sw
		System.out.println("Move " + n + " disk from " + src + " to " + dst);

		// smaller problem : n-1 disk from helper -> dst using src
		TOH(n - 1, helper, dst, src);

	}

}
