/**
 * 
 * @author Daniel
 * Last-modified: April 13, 2019
 */
public interface Directory {

	void newEntry(Entry newEntry);
	
	void delEntry(String input);
	
	Entry findEntry(String name);
	
	void changeNum(String name, String newNumber);
	
	void printEntries();
	
}
