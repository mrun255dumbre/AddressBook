package addressBook;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public interface AddressBookManagerInterface {
	
	public File newAddressBook();
	public HashMap<String, ArrayList<Person>> openAddressBook();
	public void saveAddressBook(String filename, ArrayList<Person> personArrayList);
	public void saveAsAddressBook();
	public void closeAddressBook();
	public void quit();
	
}
