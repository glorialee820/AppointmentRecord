package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import project.ui.MainFrame;

public class Application { // main class that is running the program

	public static void main(String[] args) {

		MainFrame mainFrame = new MainFrame(); // running the main frame which is our user interface

		mainFrame.setVisible(true);
	}

	public static void writeOutput(String fileName, String contents) { // method for writing text into a file
		try { // try/catch basically created to catch exceptions
			FileOutputStream file1 = new FileOutputStream(fileName); // creating an object whose sole purpose to store
																		// data - don't have actual data

			BufferedWriter fileWriter1 = new BufferedWriter(new OutputStreamWriter(file1)); // taking the stream to make
																							// it into something that
																							// can actually write into a
																							// file

			fileWriter1.write(contents); // if file exists, delete it (what actually is writing the data to the file -
											// telling it to write it - actual data into the actual stream)

			fileWriter1.flush(); // pause until all data is written

			file1.close();
			fileWriter1.close();

		} catch (IOException ioe) {

			System.out.println(ioe.toString()); // IOException - catch IO Exceptions (kind of exception that only deals
												// with input and output)

		}

	}

	public static void createDirectoryIfNotExist(String directoryName) { // method to create a directory if it doesn't
																			// exist
		File theDirectory = new File(directoryName); // create an object
		// System.out.println(theDirectory.getAbsolutePath()); //where directory is
		// storing files (debug in case we don't know where the file is)

		if (!theDirectory.exists()) { // if the directory doesn't exist then we have to
			System.out.println("creating directory: " + theDirectory.getName());

			try { // try/catch is basically saying that you create a directory and catching it if you can't
				theDirectory.mkdir();
				System.out.println("DIRECTORY created");
			} catch (SecurityException se) { // what to do - handle this

			}

		}

	}

	public static String readInput(String fileName) { //method to read from a file
		try {
			return new String( //String has a constructor that takes a byte array and makes it into a string 
					Files.readAllBytes( //readAllBytes reads all bytes from a file
							Paths.get(fileName) //Paths.get returns URI(uniform resource identifier) object instead of a string
					)
				); 
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return "";
	}

	public static String getFileExtension(String fullName) { //create method to find out what type of file a file is
		String fileName = new File(fullName).getName();
		int dotIndex = fileName.lastIndexOf('.'); //finding the dot in the file name
		return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1); //if there is no dot, then return an empty string, if there is a dot, then return the string after the dot
	}
}

