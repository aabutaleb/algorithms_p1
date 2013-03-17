package course.programming.exercices.ex6;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import course.programming.Constants;

public class Alg2Sum {
	private static final Map<String, Integer> m = new HashMap<String, Integer>(); 
	private static final String FILE_PATH = Constants.RESOURCES_DIR	+ "\\ex6\\HashInt.txt";

	public static void main(final String[] args) {
		loadFile();

		int count = 0;
		for (int t = 2500; t <= 4000; t++){
			System.out.println("Buscando t = "+t);
			Set<Entry<String, Integer>> set = m.entrySet();
			int y = -1;
			for (Iterator<Entry<String, Integer>> i = set.iterator(); i.hasNext() && y < 0;){
				int x = i.next().getValue();
				Integer aux;
				if ((aux = m.get(String.valueOf(t-x))) != null && aux.intValue() != x){
					y = m.get(String.valueOf(t-x));
					System.out.println("Encontrados x = "+x+ " y = "+y);
				}
			}

			if (y >= 0){
				count++;
			}
		}

		System.out.println("TERMINADO: "+count);
	}

	private static void loadFile() {
		try {
			File f = new File(FILE_PATH);
			if (!f.exists()) {
				throw new FileNotFoundException();
			}
			FileInputStream fstream = new FileInputStream(f);

			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				m.put(strLine, Integer.parseInt(strLine));
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
