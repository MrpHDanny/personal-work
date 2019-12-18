import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**
 * 
 * @author Daniel
 * Last-modified: April 25, 2019
 */
public class testBadEntries {
 public static void main(String[] args) throws FileNotFoundException{
	 /**
	  * This class contains a copy of the code from the Main class
	  * to demonstrate how it handles bad entries
	  */
	 
	 
	 
	 readFile("BadInitials_1.txt"); // Initials contain a number 
	 readFile("BadInitials_2.txt"); // Initials are too short because they lack the periods
	 readFile("BadNumber_1.txt"); // The number is too short 
	 readFile("BadNumber_2.txt"); // The number contains a letter 
	 readFile("BadSurname_1.txt"); // Surname contains a number
	 readFile("BadSurname_2.txt"); // Entry is missing a surname
		
 }
 
 	@SuppressWarnings("unused")
	private static void readFile(String fileLocation) throws FileNotFoundException{
 	// Read entries from a file
 			try {
 				Scanner inFile = new Scanner(new FileReader(fileLocation));
 				while (inFile.hasNextLine()) {
 					String line = inFile.nextLine();
 					line = line.trim().replaceAll("\\s+", " ");
 					String[] contentOfLine = line.split("\\s");
 					String surname = contentOfLine[0];
 					String initials = contentOfLine[1];
 					String number = contentOfLine[2];
 					// Check if surname or initials contain numbers or if the
 					// initials are less than 4 characters long
 					if (initials.matches(".*\\d.*") || surname.matches(".*\\d.*") || initials.length() < 4) {
 						inFile.close();
 						System.out.println("Invalid surname or initials found");
 						return;
 					}

 					// Check if the number is 5 digits long and only contains
 					// numbers
 					if (!number.matches("[0-9]+") || number.length() != 5) {
 						inFile.close();
 						System.out.println("Invalid number found");
 						return;
 					}
 					// Create and add a new entry
 					Entry newEntry = new Entry(surname, initials, number);
 				}
 				inFile.close();
 			} catch (ArrayIndexOutOfBoundsException ex) {
 				System.out.println("Invalid entry found");
 				System.exit(1);
 			}
 	}
 
}
