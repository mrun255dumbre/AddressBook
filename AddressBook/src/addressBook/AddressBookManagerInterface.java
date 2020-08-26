package addressBook;

import java.io.File;

public interface AddressBookManagerInterface {
	
	public File newAddressBook();
	public void openAddressBook();
	public void saveAddressBook();
	public void saveAsAddressBook();
	public void closeAddressBook();
	public void quit();
	
}
