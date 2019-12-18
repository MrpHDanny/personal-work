
/**
 * @author Daniel
 * Last-modified: April 13, 2019
 */
public class ArrayDirectory implements Directory {

	private int arraySize = 10; // The starting array size
	public Entry[] entries = new Entry[arraySize]; // The array that stores the entries

	/**
	 * Add a new Entry
	 * 
	 * @param newEntry	an Entry object
	 *           
	 * @return void
	 */
	@Override
	public void newEntry(Entry newEntry) {
		int index = 0; // Index at which the new entry is meant to be inserted
		int lastIndex = 0; // The index of the last non-null entry
		
		// find lastIndex
		for (int i = entries.length - 1; i >= 0; i--) {
			if (entries[i] != null) {
				lastIndex = i;
				break;
			}
		}

		// find index
		if (entries[0] != null) {
			for (int i = 0; i <= lastIndex; i++) {
				int y = newEntry.getSurname().compareTo(entries[i].getSurname());
				if (y < 0 || y == 0) {
					index = i;
					break;
				} else
					index++;
			}
			// Check if array is full and double it if needed
			if (lastIndex + 1 == entries.length) {
				arraySize *= 2;
				Entry[] newArray = new Entry[arraySize];
				for (int i = 0; i < entries.length; i++) {
					newArray[i] = entries[i];
				}
				entries = newArray;
			}
			// Shift elements right
			for (int i = lastIndex; i >= index; i--) {
				entries[i + 1] = entries[i];
			}
			// Insert new Entry
			entries[index] = newEntry;

		} else
			entries[0] = newEntry; // if array was empty. Only executes once
									// when the first entry is added

	}

	/**
	 * Delete an entry
	 * 
	 * @param input		can be either surname oe number
	 *  
	 * @return void
	 */
	@Override
	public void delEntry(String input) {
		int index = -1; // index of the entry to be deleted
		int lastIndex = 0; // index of the last element in the array

		// find lastIndex
		for (int i = entries.length - 1; i >= 0; i--) {
			if (entries[i] != null) {
				lastIndex = i;
				break;
			}
		}

		// find index
		for (int i = 0; i <= lastIndex; i++)
			if (entries[i].getSurname().equals(input) || entries[i].getNumber().equals(input)) {
				index = i;
				break;
			}

		if (index != -1) { // Shift elements left
			for (int y = index; y < lastIndex; y++) {
				entries[y] = entries[y + 1];
			}
			entries[lastIndex] = null;
		} else
			System.out.println("Entry not found");
	}

	/**
	 * Find an entry
	 * 
	 * @param surname
	 * 
	 * @return Entry
	 */
	@Override
	public Entry findEntry(String surname) {
		for (Entry entry : entries) {
			if (entry != null)
				if (entry.getSurname().equals(surname))
					return entry;
		}
		return null;
	}

	/**
	 * Change the number of an entry
	 * 
	 * @param surname, newNumber
	 *            
	 * @return void
	 */
	@Override
	public void changeNum(String surname, String newNumber) {
		for (Entry entry : entries) {
			if (entry != null)
				if (entry.getSurname().equals(surname)) {
					entry.setNumber(newNumber);
					return;
				}
		}
		System.out.println("Entry not found");

	}

	/**
	 * Print out the existing entries
	 * 
	 * @param none
	 * 
	 * @return void
	 */
	@Override
	public void printEntries() {
		String format = "%-16s %-4s %-10s\n";
		for (Entry entry : entries) {
			if (entry != null)
				System.out.printf(format, entry.getSurname(), entry.getInitials(), entry.getNumber());
			else
				break;
		}

	};
}
