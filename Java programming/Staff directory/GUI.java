import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.*;
/**
 * 
 * @author Daniel
 * Last-modified: April 14, 2019
 */
public class GUI {

	ListDirectory entries = new ListDirectory();

	public static void main(String[] args) throws FileNotFoundException {
		GUI gui = new GUI();

		// Read the file with entries
		String fileLocation = "Entries.txt";
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
				// initials are less than 2 characters long
				if (initials.matches(".*\\d.*") || surname.matches(".*\\d.*") || initials.length() < 2) {
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
				gui.entries.newEntry(newEntry);
			}
			inFile.close();
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Invalid entry found");
			System.exit(1);
		}

		// Create a frame
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setMinimumSize(new Dimension(400, 400));
		frame.setMaximumSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Add buttons
		JButton newEntry = new JButton("Add Entry");
		JButton delEntry = new JButton("Delete Entry");
		JButton findEntry = new JButton("Find Entry");
		JButton changeNum = new JButton("Change number");
		JButton reset = new JButton("Reset");
		frame.setLayout(new FlowLayout());
		frame.add(newEntry);
		frame.add(delEntry);
		frame.add(findEntry);
		frame.add(changeNum);
		frame.add(reset);
		// create text Fields
		JTextField tField = new JTextField(20);
		tField.setText("Type here");
		JTextArea tArea = new JTextArea();
		tArea.setText("How to use the buttons:\nAdd entry:\n<Name> <Initials> <Number>\n" +
		"Delete entry:\n<Name> or <Number>\n"+
		"Find entry:\n<Name>\n" +
		"Change number:\n<Name> <Number>\n" +
		"Press Reset to read the entries");
		frame.add(tField);
		frame.add(tArea);
		frame.setVisible(true);
		// Event listeners

		// newEntry event listener
		newEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					String line = tField.getText();
					line = line.trim().replaceAll("\\s+", " ");
					String[] contentOfLine = line.split("\\s");
					String surname = contentOfLine[0];
					String initials = contentOfLine[1];
					String number = contentOfLine[2];
					// Check if surname or initials contain numbers or if the
					// initials are less than 2 characters long
					if (initials.matches(".*\\d.*") || surname.matches(".*\\d.*") || initials.length() < 2){
						tField.setText("Invalid input");
						return;
						}
					// Check if the number is 5 digits long and only contains
					// numbers
					if (!number.matches("[0-9]+") || number.length() != 5){
						tField.setText("Invalid input");
						return;
						}
					// Create and add a new entry
					Entry newEntry = new Entry(surname, initials, number);
					gui.entries.newEntry(newEntry);	tArea.setText(gui.printData());
				} catch (ArrayIndexOutOfBoundsException ex) {
					tField.setText("Invalid input");
				}
			}

		});
		// delEntry event listener
		delEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String surname = tField.getText();
				gui.entries.delEntry(surname);
				tArea.setText(gui.printData());

			}

		});
		// findEntry event listener
		findEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					String surname = tField.getText();
					Entry match = gui.entries.findEntry(surname);
					tArea.setText(match.toString());
				} catch (NullPointerException ex) {
					tField.setText("No such entries found");
				}
			}
		});
		// changeNum event listener
		changeNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					String line = tField.getText();
					line = line.trim().replace("\\s", " ");
					String[] contentOfLine = line.split("\\s");
					String surname = contentOfLine[0];
					String newNumber = contentOfLine[1];
					// Check if the number is 5 digits long and only contains
					// numbers
					if (!newNumber.matches("[0-9]+") || newNumber.length() != 5){
						tField.setText("Invalid input");
						return;
						}
					gui.entries.changeNum(surname, newNumber);
					tArea.setText(gui.printData());
				} catch (ArrayIndexOutOfBoundsException ex) {
					tField.setText("Invalid input");
				}
			}
		});
		// Reset event listener
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				tArea.setText(gui.printData());
			}
		});

	}

	private String printData() {

		String data = "";
		for (Entry entry : entries.entries) {
			data += entry + "\n";
		}
		return data;
	}
}
