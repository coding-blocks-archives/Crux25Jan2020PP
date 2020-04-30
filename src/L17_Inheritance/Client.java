package L17_Inheritance;

public class Client {

	public static void main(String[] args) {

		// Case 1
		P obj1 = new P();
		System.out.println(obj1.d);
		System.out.println(obj1.d1);
		// System.out.println(obj1.d2);
		obj1.fun();
		obj1.fun1();
		// obj1.fun2();

		// Case 2
		P obj2 = new C();
		System.out.println(obj2.d); // 10
		System.out.println(((C) obj2).d); // 20
		System.out.println(obj2.d1); // 100
		System.out.println(((C) obj2).d2); // 200

		obj2.fun(); // C fun // overiding
		((P) obj2).fun(); // C fun
		obj2.fun1(); // P fun 1
		((C) obj2).fun2(); // C fun 2

		// Case 3
		// C obj3 = new P();

		// Case 4
		C obj4 = new C();
		System.out.println(obj4.d);
		System.out.println(((P) obj4).d);
		System.out.println(obj4.d1);
		System.out.println(obj4.d2);
		obj4.fun(); // overiding
		obj4.fun1();
		obj4.fun2();

	}
}
