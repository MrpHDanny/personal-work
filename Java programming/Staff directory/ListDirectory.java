import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author Daniel
 * Last-modified: April 13, 2019
 */
public class ListDirectory implements Directory {
	LinkedList<Entry> entries = new LinkedList<>();

	/**
	 * Add a new Entry
	 * 
	 * @param newEntry	an Entry object
	 *            
	 * @return void
	 */
	@Override
	public void newEntry(Entry newEntry) {
		ListIterator<Entry> iterator = entries.listIterator();
		String currentName;
		// Iterate through existing entries
		if (!entries.isEmpty()) {
			while (iterator.hasNext()) {
				currentName = iterator.next().getSurname();
				// insert the new entry
				if (currentName.compareTo(newEntry.getSurname()) >= 0) {
					iterator.previous();
					iterator.add(newEntry);
					return;
				}
			}
			entries.addLast(newEntry); // if the entry is last in alphabetical order
		} else
			iterator.add(newEntry); // if it's the first entry
	}

	/**
	 * Delete an entry
	 * 
	 * @param input		Can be either surname or the number
	 *           
	 * @return void
	 */
	@Override
	public void delEntry(String input) {
		for(Entry entry: entries){
			if(entry.getSurname().equals(input) || entry.getNumber().equals(input)){
				entries.remove(entry);
				return;
			}
		}
		System.out.println("Entry not found	");
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
			if (entry.getSurname().equals(surname))
				return entry;
		}
		return null;
	}

	/**
	 * Print out the existing entries
	 * 
	 * @param none
	 * 
	 * @return void
	 */
	@Override
	public void changeNum(String surname, String newNumber) {
		for (Entry entry : entries) {
			if (entry.getSurname().equals(surname)) {
				entry.setNumber(newNumber);
				return;
			}
		}
		System.out.println("Entry not found");
	}

	/**
	 * Prints out the existing entries
	 * 
	 * @param none
	 * 
	 * @return void
	 */
	@Override
	public void printEntries() {
		String format = "%-16s %-4s %-10s\n";
		for (Entry entry : entries) {
			System.out.printf(format, entry.getSurname(), entry.getInitials(), entry.getNumber());

		}

	};
}
