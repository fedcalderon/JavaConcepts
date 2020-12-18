package fundamentals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WorkWithFiles {
	// Define global variables or class members
	private static String theFilename = "default.txt";
	private static String theRootPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "scratch";

	
	public void createFile(String fname) {
		printMsg("running createFiles() in \"" + this.getClass().getName() + "\" class.");
		
		//Check if the scratch directory exists, create it if it doesn't
		Path rootpath = Paths.get(theRootPath);
		if(Files.isDirectory(rootpath)) {
			printMsg("The " + theRootPath + " exists...");
		}
		else {
			printMsg("Creating " + theRootPath);
			try {
				Files.createDirectories(rootpath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// create fname
		Path filepath = null;
		
		if(fname == null || fname.isEmpty()) {
			filepath = Paths.get(rootpath + System.getProperty("file.separator") + theFilename);
		} else {
			filepath = Paths.get(rootpath + System.getProperty("file.separator") + fname);
		}
		
		try {
			Files.createFile(filepath);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
}
