package L26_HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();

		// put
		map.put("India", 10);
		map.put("US", 20);
		System.out.println(map);
		map.put("India", 30);
		System.out.println(map);

		// get
		System.out.println(map.get("India"));
		System.out.println(map.get("UK"));

		// contains key
		System.out.println(map.containsKey("US"));
		System.out.println(map.containsKey("Italy"));

		// remove
		System.out.println(map.remove("UK"));
		System.out.println(map);

		// display
		// way 1
		Set<String> keys = map.keySet();

		for (String key : keys) {
			System.out.println(key + "->" + map.get(key));
		}

		// way 2
		for (String key : map.keySet()) {
			System.out.println(key + "->" + map.get(key));
		}

		// way 3
		ArrayList<String> list = new ArrayList<>(map.keySet());

		for (String key : list) {
			System.out.println(key + ":" + map.get(key));
		}

	}

}
