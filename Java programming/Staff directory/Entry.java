/**
 * 
 * @author Daniel
 * Last-modified: April 13, 2019
 */
public class Entry {
	private String surname;
	private String initials;
	private String number;
	
	public Entry(){
		
	}
	
	public Entry(String surname,String initials,String number){
		this.surname=surname;
		this.initials=initials;
		this.number=number;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String toString(){
		return surname + " " + initials + " " + number;
	}
	@Override
	public boolean equals(Object rhs) {
		// reflexivity
		if (this == rhs) return true;
		// non0nullity
		if (!(rhs instanceof Entry)) return false;
		// consistency
		Entry e = (Entry) rhs;
		return surname.equals(e.surname);	
	}
	@Override
	public int hashCode() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char letter = surname.charAt(0);
		return alphabet.indexOf(letter);		
	}
	
}


