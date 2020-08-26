package addressBook;

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
					addressBookManagerImplementation.openAddressBook();
					break;
					
				case SAVE_ADDRESS_BOOK:
					addressBookManagerImplementation.saveAddressBook();
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
