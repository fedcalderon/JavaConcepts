package fundamentals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class JavaConcepts {

	/**
	 * Main entry to JavaConcepts
	 * @param args
	 */
	public static void main(String[] args) {
		
		printMsg("Illustrating Java concepts.");
		// Run code to test file handling with Java
		//testWorkWithFilesClass();
		// Run code to test user interface
		//testWorkWithSwingClass();
		
		testStringSplitter();
		printMsg("Goodbye!");
	}
	
	/**
	 * Test the swing forms
	 */
	public static void testWorkWithSwingClass() {
		WorkWithSwing wswing = new WorkWithSwing();
		//wswing.createSimpleFrame();
		//wswing.createMoreComplexGUI();
		//printMsg(wswing.getDateTime());
		
		new RegistrationSwingExample();
		//new LoginSwingExample();
	}
	
	/**
	 * This method runs different tests for the WorkWithFiles class
	 */
	public static void testWorkWithFilesClass() {
		
		// Create object to use WorkWithFiles class
		WorkWithFiles wf = new WorkWithFiles();
		// Create an empty file
		wf.createFile("file.txt");
		// Update a file with a message passed as an argument
		wf.updateFile("file.txt", "This is a test to append data to file.");
		// Create an empty csv file
		wf.createFile("data.csv");
		// Create a StringBuilder object to build csv data
		StringBuilder dataSB = new StringBuilder();
		// Create header
		dataSB.append("Date,Name,Age,City").append("\n");
		// Add data
		dataSB.append(String.format("%s,%s,%s,%s", new Date(),"Sam","17","Indialantic")).append("\n");
		// Update csv file
		wf.updateFile("data.csv", dataSB.toString());
		// Prompt user for message and append it to a file
		wf.promptUserForInputAndUpdateFile("file.txt");
		
		String hi = "Hello Sam.";
		hi = hi + " It's a great December day!";
	}
	
	public static void testStringSplitter() {
		
		StringBuilder dataSB = new StringBuilder();
		// Create header
		dataSB.append("Date,Name,Age,City").append("\n");
		// Add data
		dataSB.append(String.format("%s,%s,%s,%s", new Date(),"Sam","17","Indialantic")).append("\n");
		// Create string object 
		String testData = dataSB.toString();
		// Split string by a comma and save each data member into an array of Strings
		List<String> testDataArray = Arrays.asList(testData.split(","));
		
		
		for(String line : testDataArray) {
			printMsg(line);
		}
		
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
