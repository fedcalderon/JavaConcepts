package fundamentals;

import java.util.Date;

public class JavaConcepts {

	/**
	 * Main entry to JavaConcepts
	 * @param args
	 */
	public static void main(String[] args) {
		
		printMsg("Illustrating Java concepts.");
		
		testWorkWithFilesClass();
	}
	
	/**
	 * This method runs different tests for the WorkWithFiles class
	 */
	public static void testWorkWithFilesClass() {
		WorkWithFiles wf = new WorkWithFiles();
		wf.createFile("file.txt");
		wf.updateFile("file.txt", "This is a test to append data to file.");
		
		wf.createFile("data.csv");
		StringBuilder dataSB = new StringBuilder();
		dataSB.append("Date,Name,Age,City").append("\n");
		dataSB.append(String.format("%s,%s,%s,%s", new Date(),"Sam","17","Indialantic")).append("\n");
		wf.updateFile("data.csv", dataSB.toString());
	}
	
	/**
	 * This method prints a message to the console.
	 * @param msg
	 * 			The message to print to the console.
	 */
	public static void printMsg(String msg) {
		System.out.println(msg);
	}
}
