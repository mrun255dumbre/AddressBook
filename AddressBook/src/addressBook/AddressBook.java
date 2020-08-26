package addressBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {

	public static final int NEW_ADDRESS_BOOK=1;
	public static final int OPEN_ADDRESS_BOOK=2;
	public static final int SAVE_ADDRESS_BOOK=3;
	public static final int SAVE_AS_ADDRESS_BOOK=4;
	public static final int CLOSE_ADDRESS_BOOK=5;
	public static final int QUIT=6;
	public static final int ADD_PERSON=1;
	public static final int EDIT_PERSON=2;
	public static final int DELETE_PERSON=3;
	public static final int SEARCH_PERSON=4;
	public static final int SORT_BY_ZIP=5;
	public static final int SORT_BY_NAME=6;
	public static final int DISPLAY=7;
	public static String filename;
	
	public void userChoice() {
		AddressBookImplementation addressBookImplementation = new AddressBookImplementation();
		AddressBookManagerImplementation addressBookManagerImplementation = new AddressBookManagerImplementation();
		
		ArrayList<Person> personArrayList = new ArrayList<Person>(100);
		HashMap<String, ArrayList<Person>> personHashMap = new HashMap<>(100);
		
		Scanner sc= new Scanner(System.in);
		
		while(true) {
				System.out.println("Address Book Application- ");
				System.out.println("1.Add new address Book \n"+"2.Open address Book \n"+"3.Save Address Book \n"
						+ "4.Save As Adress Book \n"+"5.Close Address Book\n"+"6.Quit");
				System.out.println("Enter your choice - ");  
				int ch= sc.nextInt();
				
				switch(ch) {
				case NEW_ADDRESS_BOOK:
					addressBookManagerImplementation.newAddressBook();
					break;
				
				case OPEN_ADDRESS_BOOK:
					personHashMap = addressBookManagerImplementation.openAddressBook();
					@SuppressWarnings("rawtypes") 
					Iterator it = personHashMap.entrySet().iterator();
					
					while (it.hasNext()) {
						
						@SuppressWarnings("rawtypes")
						Map.Entry pair = (Map.Entry) it.next();
						filename=(String) pair.getKey();
						personArrayList=(ArrayList<Person>) pair.getValue();
					}
					break;
					
				case SAVE_ADDRESS_BOOK:
					addressBookManagerImplementation.saveAddressBook(filename,personArrayList);
					break;
				
				case SAVE_AS_ADDRESS_BOOK:
					addressBookManagerImplementation.saveAsAddressBook();
					break;
				
				case CLOSE_ADDRESS_BOOK:
					addressBookManagerImplementation.closeAddressBook();
					break;
				
				case QUIT:
					System.out.println("Do you want to Quit?(y/n)");
					String exit=sc.next();
					if(exit.equalsIgnoreCase("Y"))
						return;
					break;
				
				default:
					System.out.println("Wrong choice! Please select from the above option");
					break;
				}
		}
	}
	

	public static void main(String[] args) {
		AddressBook addressBookObj = new AddressBook();
		try {
			addressBookObj.userChoice();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
