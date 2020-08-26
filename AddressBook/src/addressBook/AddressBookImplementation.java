package addressBook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookImplementation implements AddressBookInterface {
	
	public String firstname,lastname,city,state,phonenumber;
	public int zipcode;
	int flag = 0;
	public static File file;
	Scanner sc = new Scanner(System.in);
	
	public ArrayList<Person> personArrayList = new ArrayList<Person>(100);
	public HashMap<String, ArrayList<Person>> personHashMap = new HashMap<>(100);
	
	public String patternPhone = "^[6-9]{1}[0-9]{9}";
	
	@Override
	public HashMap<String, ArrayList<Person>> addPerson(String fileName) {
		
		System.out.println("How many Records you want to Store in " +fileName+".csv");
		int NumberOfDaTa = sc.nextInt();
		for (int i = 1; i <= NumberOfDaTa; i++) {
			
			System.out.println("Enter First Name :");
			firstname = sc.next();
			
			System.out.println("Enter Last Name :");
			lastname = sc.next();
			
			System.out.println("Enter City :");
			city = sc.next();
			
			System.out.println("Enter State :");
			state = sc.next();
			
			System.out.println("Enter Zip Code :");
			zipcode = sc.nextInt();
			
			System.out.println("Enter Phone Number :");
			phonenumber = sc.next();
			
			boolean flag1 = phonenumber.matches(patternPhone);
			
			while (flag1 == false) {
				System.out.println("Enter Phone Number with 10 digit between 0-9 :");
				phonenumber = sc.next();
				flag1 = phonenumber.matches(patternPhone);
			}
			personArrayList.add(
					new Person(firstname + ",", lastname + ",", city + ",", state + ",", zipcode, "," + phonenumber));
			personHashMap.put(fileName, personArrayList);
		}
		return personHashMap;
		
	}

	@Override
	public void editPerson(String fileName){
		
		System.out.println("Enter number for edit person data\n");
		String lineToFind = sc.next();
		
		File inFile = new File((fileName+".csv"));
		File tempFile = new File(fileName + ".tmp");
		
		BufferedReader br;
		BufferedWriter bw;
		try {
			br = new BufferedReader(new FileReader(inFile));
			bw = new BufferedWriter(new FileWriter(tempFile));
		
		
			String line = null;
			
			while ((line = br.readLine()) != null) {
				if (line.trim().contains(lineToFind)) {
					
					System.out.println("Data found for given number\n" + line);
					
					String[] persondrtails = line.split(",");
					
					String firstname = persondrtails[0];
					String lastname = persondrtails[1];
					
					System.out.println("enter the city");
					String city = sc.next();
					
					System.out.println("enter the State");
					String state = sc.next();
					
					System.out.println("enter the Zipcode");
					int zipcode = sc.nextInt();
					
					String phonenumber = persondrtails[5];
					
					bw.write(firstname);
					bw.write("," + lastname);
					bw.write("," + city);
					bw.write("," + state);
					bw.write("," + zipcode);
					bw.write("," + phonenumber);
					bw.newLine();
					flag++;
				} 
				else {
					bw.write(line);
					bw.newLine();
				}
	
				
				
			}
			bw.close();
			br.close();
			
			inFile.delete();
			tempFile.renameTo(inFile);
			
			if (flag == 0)
				System.out.println("Data not found in AddressBook :" + fileName);
			else
				System.out.println("Data Modified Successfully..");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void deletePerson() {
		
	}

	@Override
	public void searchPerson() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortByZip() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortByName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

public String access(){
		
		System.out.println("AddressBook Present in System \n");
		try 
		{
            File file = new File(".");
 
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File f, String name) {
                    return name.endsWith(".csv");
                }
            };
            
            File[] files = file.listFiles(filter);

            for (int i = 0; i < files.length; i++) 
            {
                System.out.println("\t\t"+files[i].getName());
            }
        }catch (Exception e) 
		{
            System.err.println(e.getMessage());
        }
		
		System.out.println("Please Enter Address Book name in which you want to Make Oprations On ::\n");
		String fileName = sc.next();
		file = new File(fileName+".csv");
		if (file.isFile()) {
			return fileName;
		} else

			return null;
	}
	
	
}
