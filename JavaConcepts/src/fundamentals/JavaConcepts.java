package fundamentals;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class JavaConcepts {

	/**
	 * Main entry to JavaConcepts
	 * @param args
	 */
	public static void main(String[] args) {
		
		printMsg("Illustrating Java concepts.");
		// Run code to test file handling with Java
		//testWorkWithFilesClass();
		//manageUsers();
		// Run code to test user interface
		//testWorkWithSwingClass();
		//printMsg("Goodbye!");
		
		explainMaps();
	}
	
	public static void testWorkWithSwingClass() {
		WorkWithSwing wswing = new WorkWithSwing();
		//wswing.createSimpleFrame();
		wswing.createMoreComplexGUI();
		//printMsg(wswing.getDateTime());
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

		// Prompt user for message and append it to a file
		//wf.promptUserForInputAndUpdateFile("file.txt");
	}
	
	public static void manageUsers() {
		
		// Create object to use WorkWithFiles class
		WorkWithFiles wf = new WorkWithFiles();
		// User account
		// Create a StringBuilder object to build csv data
		StringBuilder dataSB = new StringBuilder();
		String fname = "data.csv";
		boolean fileExists = wf.doesFileExit(fname);
		if (!fileExists) {
			// Create an empty csv file
			wf.createFile("data.csv");
			// Create header
			dataSB.append("UserID,Date,Name,Age,City,Username,Password").append("\n");
		}

		// Add data
		Random rand = new Random();
		int randomNo = (int) (rand.nextDouble() * 10000);
		dataSB.append(String.format("%s,%s,%s,%s,%s,%s,%s", randomNo, new Date(), "Sam", "17", "Indialantic",
				"User" + randomNo, "Password1")).append("\n");

		// Update csv file
		wf.updateFile(fname, dataSB.toString());
	}
	
	public static void explainMaps() {
		//   key      value 
		Map<Integer, String> userMap = new HashMap<Integer, String>();
		/*
		 * A map has a unique key that cannot be repeated
		 */
		
		for(int i=0; i < 10; i++) {
			Random rand = new Random();
			int randomNo = (int) (rand.nextDouble() * 10000);
			userMap.put(randomNo, String.valueOf(randomNo/4));
		}
		
		printMsg(userMap.toString());
		
		// Extract info from map
		for(Entry<Integer, String> entry : userMap.entrySet()) {
			printMsg("userMap key: " + entry.getKey());
			printMsg("userMap Value: " + entry.getValue());
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i < 10; i++) {
			Random rand = new Random();
			int randomNo = (int) (rand.nextDouble() * 10000);
			list.add(randomNo);
		}
		printMsg(list.toString());
		
		// Extract data from list
		for(Integer i : list) {
			printMsg("list value: " + i.toString());
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
