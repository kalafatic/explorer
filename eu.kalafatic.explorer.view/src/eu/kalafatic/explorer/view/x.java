package eu.kalafatic.explorer.view;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class x {

	public static void main(String[] args) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("a", "3");
		m.put("c", "2");
		m.put("b", "1");

		for (Map.Entry<Object, Object> entry : sort(m, false).entrySet()) {
			System.err.println(entry.getKey() + "-" + entry.getValue().toString());
		}
	}

	private static <T extends Comparable<? super T>> Map<Object, Object> sort(Map<T, T> map, final boolean sortByKeys) {
		List<Entry<T, T>> entries = new LinkedList<Entry<T, T>>(map.entrySet());
//		Collections.sort(entries, new Comparator<Entry<T, T>>() {
//			@Override
//			public int compare(Entry<T, T> entry1, Entry<T, T> entry2) {
//				if (sortByKeys) {
//					return entry1.getKey().compareTo(entry2.getKey());
//				} else {
//					return entry1.getValue().compareTo(entry2.getValue());
//				}
//			}
//		});
		Map<Object, Object> result = new LinkedHashMap<Object, Object>();
		for (Entry<T, T> entry : entries) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
