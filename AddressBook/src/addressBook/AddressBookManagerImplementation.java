package addressBook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class AddressBookManagerImplementation implements AddressBookManagerInterface {

	public String newfileName,fileName;
	public static File file;
	public FileWriter fileWriter;
	Scanner sc = new Scanner(System.in);
	public BufferedWriter bw;
	
	public ArrayList<Person> personArrayList = new ArrayList<Person>(100);
	public HashMap<String, ArrayList<Person>> personHashMap = new HashMap<>(100);
	
	@Override
	public File newAddressBook() {
		
		System.out.print("Enter Name for Address Book: ");
		newfileName = sc.next();
		
		newfileName = newfileName+".csv";
		file = new File(newfileName);
		
		System.out.println("Press Y For Confirm");
		String op = sc.next();
		
		if (op.equalsIgnoreCase("Y")) 
		{
			
			try {
				
				file.createNewFile();
			
				fileWriter = new FileWriter(file);
				
				bw = new BufferedWriter(fileWriter);
				bw.write("First_Name");
				bw.write(",Last_name");
				bw.write(",City");
				bw.write(",State");
				bw.write(",Zipcode");
				bw.write(",Phone_Number");
				bw.newLine();
			
				System.out.println("Address Book Is Succesfully Created ");
				} 
			catch (IOException e) 
			{
				System.out.println("Some Error Occure During the input");	
				e.printStackTrace();
			}
		}
		else 
		{
			System.out.println("Unable to create An AdressBook");
		}
		
		try {
			bw.close();
			fileWriter.close();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return file;
		
	}

	@Override
	public HashMap<String, ArrayList<Person>> openAddressBook() {
		AddressBookImplementation addressBookImplementation = new AddressBookImplementation();
		fileName = addressBookImplementation.access();
		
		if (fileName != null) 
		{
		
			System.out.println("Please Enter What opration you want to do on above file ::");
			System.out.println("\t\t 1) Add Data into the file\n"
					+ "\t\t 2) Edit Data From the File\n "
					+ "\t\t 3) Delete Data From the File\n"
					+ "\t\t 4) Search Data From the file\n"
					+ "\t\t 5) Sort Data By their Zip Code\n"
					+ "\t\t 6) Sort Data By their Name\n"
					+ "\t\t 7) Display");
			int ch = sc.nextInt();
			
			switch (ch) {
			
			case 1:
				personHashMap = addressBookImplementation.addPerson(fileName);
				Iterator it = personHashMap.entrySet().iterator();
				
				while (it.hasNext()) 
				{
					Map.Entry pair = (Map.Entry) it.next();
					System.out.println(pair.getKey() + " = " + pair.getValue());
				}
				
				System.out.println("If you want to store this Data Use Save Option From Options");
				
				break;
				
			case 2:
				addressBookImplementation.editPerson(fileName);
				break;
			case 3:
				addressBookImplementation.deletePerson(fileName);
				break;
			case 4:
				addressBookImplementation.searchPerson(fileName);
				break;
			case 5:
				addressBookImplementation.sortByZip(fileName);
				break;
			case 6:
				addressBookImplementation.sortByName(fileName);
				break;
			case 7:
				addressBookImplementation.display(fileName);
				break;
			default:
				System.out.println("Wrong Choice. Please Check Your Choice");
				
		}
			
	}
			
	return personHashMap;
	}

	@Override
	public void saveAddressBook(String filename, ArrayList<Person> personArrayList) {
		
		try {
			fileWriter = new FileWriter(fileName+".csv",true);
			bw = new BufferedWriter(fileWriter);
			
			for (int J = 0; J < personArrayList.size(); J++) {
				bw.write(personArrayList.get(J).toString() + "\n");
			}
			bw.close();
			fileWriter.close();
			
		} 
		catch (IOException e) {
						e.printStackTrace();
		}
		
		System.out.println("Data Saved in AddressBook :"+fileName+".csv");
		
	}

	@Override
	public void saveAsAddressBook() {
		
		System.out.println("AddressBook Present in System \n");
		File f = new File(".");
		String[] s = f.list();
		
		for (String s1 : s) {
			System.out.println(s1);
		}
		
		System.out.println("Please enter name which book want to rename");
		String filename = sc.next();
		
		System.out.println("please enter new name of book");
		String newname = sc.next();
		
		File oldFile = new File((filename + ".csv"));
		File newFile = new File(newname + ".csv");
		
		boolean b = oldFile.renameTo(newFile);
		
		if (b==true) {
			System.out.println("You have changed the "+oldFile+" to the "+newFile);
		} 
		else
		{
			System.out.println("Please Check Opration failed.");

		}

		
	}

	@Override
	public void closeAddressBook() {
		
		try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("AddressBook Closed");
		
	}

	@Override
	public void quit() {
		
		System.exit(0);
		
	}
	
}
