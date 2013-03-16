package course.programming.exercices.ex4;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Log {
	private static BufferedOutputStream bos;

	public static void initLog(){
		File f = new File("/tmp/ex4.log");
		if (!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
			}
		}
		try {
			bos = new BufferedOutputStream(new FileOutputStream(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void log(final String logString){
		try {
			bos.write(logString.getBytes());
			bos.write("\r\n".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void closeLog(){
		try {
			bos.flush();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
