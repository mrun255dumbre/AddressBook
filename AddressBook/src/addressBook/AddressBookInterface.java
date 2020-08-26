package addressBook;

import java.util.ArrayList;
import java.util.HashMap;

public interface AddressBookInterface {
	
	public HashMap<String, ArrayList<Person>> addPerson(String fileName);
	public void editPerson(String fileName);
	public void deletePerson();
	public void searchPerson(); 
	public void sortByZip();
	public void sortByName();
	public void display();
	
}
