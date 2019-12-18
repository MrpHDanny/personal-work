import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author Daniel
 * Last-modified: April 25, 2019
 */
public class HashDirectory implements Directory {
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	@SuppressWarnings("unchecked")
	LinkedList<Entry>[] entries = new LinkedList[26];

	/**
	 * Add a new Entry
	 * 
	 * @param newEntry	an Entry object
	 *            
	 * @return void
	 */
	@Override
	public void newEntry(Entry newEntry) {
		int hashCode = newEntry.hashCode(); // The hashcode of the entry
		// If a LinkedList already exists insert the entry
		if(entries[hashCode]!=null){
			LinkedList<Entry> list = entries[hashCode];
			ListIterator<Entry> iterator = list.listIterator();
			String currentName;

			while (iterator.hasNext()) {
				currentName = iterator.next().getSurname();
				if (currentName.compareTo(newEntry.getSurname()) >= 0) {
					iterator.previous();
					iterator.add(newEntry);
					return;
					}
				}
			list.addLast(newEntry);
			return;
		}
		// If a LinkedList does not exist, create a new one and insert it
		LinkedList<Entry> list = new LinkedList<Entry>();
		list.add(newEntry);
		entries[hashCode] = list;
	}

	/**
	 * Delete an entry
	 * 
	 * @param input can be either surname or the number
	 * 
	 * @return void
	 */
	@Override
	public void delEntry(String input) {
		char letter = input.charAt(0);
		int hashCode = alphabet.indexOf(letter);
		
		// Check if we are given a name
		if(hashCode!=-1)
		for(int i = 0; i < entries[hashCode].size(); i++){
			if(entries[hashCode].get(i).getSurname().equals(input)){
				entries[hashCode].remove(i);
				return;
			}
		}
		// We are given a number
		for(int i = 0; i<entries.length; i++){
			if(entries[i]!=null)
			for(int y = 0; y < entries[i].size();y++){
				if(entries[i].get(y).getNumber().equals(input)){
					entries[i].remove(y);
					return;
				}
			}
		}
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
		char letter = surname.charAt(0);
		int hashCode = alphabet.indexOf(letter);
		// Check if the surname starts with a valid character
		if(hashCode!=-1)
		for(Entry entry: entries[hashCode]){
			if(entry.getSurname().equals(surname))
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
		char letter = surname.charAt(0);
		int hashCode = alphabet.indexOf(letter);
		// Check if the surname starts with a valid character
		if(hashCode!=-1)
		for(Entry entry : entries[hashCode]){
			if(entry.getSurname().equals(surname)){
				entry.setNumber(newNumber);
				return;
			}
		}	
		System.out.println("No entry found");
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
		for(int i = 0; i < entries.length; i++){
			if(entries[i]!=null) // Check if a LinkedList exists at that index
				if(!entries[i].isEmpty())
			System.out.println(entries[i]);
		}
	}

}
