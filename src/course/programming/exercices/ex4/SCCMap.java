package course.programming.exercices.ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SCCMap {
	private Map<String,Integer> scc = new HashMap<String, Integer>();

	public void increase(final String key) {
		if (scc.get(key) == null){
			scc.put(key, new Integer(1));
		}
		else{
			scc.put(key, scc.get(key)+1);
		}
	}

	public void printSCC() {
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(scc.entrySet());
		Collections.sort(list,new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(final Entry<String, Integer> o1,
					final Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		for (Entry<String, Integer> e : list){
			System.out.println(e.getKey() + ": " + e.getValue());
		}
	}

}
