package addressBook;

import java.util.Comparator;

public class SortByZip implements  Comparator<Person> {
	
	@Override
	public int compare(Person o1, Person o2) {
	
		return o1.getZipcode() - o2.getZipcode();
		
	}
	
}
