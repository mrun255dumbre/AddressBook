package addressBook;

import java.util.ArrayList;
import java.util.HashMap;

public interface AddressBookInterface {
	
	public HashMap<String, ArrayList<Person>> addPerson(String fileName);
	public void editPerson(String fileName);
	public void deletePerson(String fileName);
	public void searchPerson(String fileName); 
	public void sortByZip(String fileName);
	public void sortByName(String fileName);
	public void display();
	
}
