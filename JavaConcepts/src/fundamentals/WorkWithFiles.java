package fundamentals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class WorkWithFiles {
	// Define global variables or class members
	private static String theFilename = "default.txt";
	private static String theRootPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "scratch";

	/**
	 * This method creates a file
	 * @param fname
	 * 			The file name to create
	 */
	public void createFile(String fname) {
		printMsg("running createFiles() in \"" + this.getClass().getName() + "\" class.");
		
		// Check if the scratch directory exists, create it if it doesn't
		Path rootpath = Paths.get(theRootPath);
		createScratchDirectory(rootpath);

		// Check if the file name is null or empty, if it is, use default name
		Path filepath = null;
		if(fname == null || fname.isEmpty()) {
			filepath = Paths.get(rootpath + System.getProperty("file.separator") + theFilename);
		} else {
			filepath = Paths.get(rootpath + System.getProperty("file.separator") + fname);
		}
		
		// Create file
		try {
			// If file exists already, don't override it.
			if(!Files.exists(filepath)) {
				Files.createFile(filepath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method updates a file.
	 * @param fname
	 * 			The file name to update.
	 */
	public void updateFile(String fname, String content) {
		printMsg("running updateFiles() in \"" + this.getClass().getName() + "\" class.");
		String text = null;
		Path filepath = Paths.get(theRootPath + System.getProperty("file.separator") + fname);
		if(Files.exists(filepath)) {
			printMsg("File " + fname + " exists, updating...");
			
			if(content.isEmpty() || content == null) {
				text = String.format("%s, testing appending text to an empty file.\r\n", new Date());
			}
			else {
				text = content + "\r\n";
			}
			
			try {
				Files.write(filepath, text.getBytes(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * This method creates the scratch directory.
	 * @param rootpath
	 * 			  The Path object with the directory path.
	 */
	private void createScratchDirectory(Path rootpath) {
		printMsg("running createScratchDirectory() in \"" + this.getClass().getName() + "\" class.");
		
		if (Files.isDirectory(rootpath)) {
			printMsg("The " + theRootPath + " exists...");
		} else {
			printMsg("Creating " + theRootPath);
			try {
				Files.createDirectories(rootpath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * This method prints a message to the console.
	 * @param msg
	 * 			The message to print to the console.
	 */
	public void printMsg(String msg) {
		System.out.println(msg);
	}
}
