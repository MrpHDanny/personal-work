import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 
 * @author Daniel 
 * Last-modified: April 13, 2019
 */
public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException {
		String fileLocation = "Entries.txt";
		ArrayDirectory array = new ArrayDirectory();
		ListDirectory list = new ListDirectory();
		HashDirectory hash = new HashDirectory();
		/**
		 * Choose any implementation to test by changing "testImplementation" to
		 * be equal to either array/list/hash
		 */
		Directory testImplementation = array;
		
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
				testImplementation.newEntry(newEntry);
			}
			inFile.close();
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Invalid entry found");
			System.exit(1);
		}

		Entry testEntry = new Entry("Harry", "H.P.", "00001");

		testImplementation.printEntries();
		System.out.println("_______________________");

		System.out.println("Testing newEntry | Added Harry H.P. 00001");
		testImplementation.newEntry(testEntry);
		testImplementation.printEntries();
		System.out.println("_______________________");

		System.out.println("Testing delEntry | Deleting Harry");
		testImplementation.delEntry("Harry");
		testImplementation.printEntries();
		System.out.println("_______________________");

		System.out.println("Testing deletion with number | Stanley S.H. 55555");
		testImplementation.delEntry("55555");
		testImplementation.printEntries();
		System.out.println("_______________________");

		System.out.println("Testing findEntry | Looking up Michael");
		System.out.println(testImplementation.findEntry("Michael"));
		System.out.println("_______________________");

		System.out.println("Testing changeNum | Michael 00000");
		testImplementation.changeNum("Michael", "00000");
		testImplementation.printEntries();
		System.out.println("_______________________");

		System.out.println("Testing delEntry with non-existent Entry");
		testImplementation.delEntry("????");
		System.out.println("_______________________");

		System.out.println("Testing findEntry with non-existent Entry");
		System.out.println(testImplementation.findEntry("?????"));
		System.out.println("_______________________");

		System.out.println("Testing changeNum with non-existent Entry");
		testImplementation.changeNum("????", "123");
		System.out.println("_______________________");

	}
}
