import java.util.List;

import controller.CustomerHelper;
import model.Customer;
import model.HotelRoom;

/**
 * @author Dennis Bowen - dmbowen
 * CIS175 - Fall 2022
 * Oct 4, 2022
 */
public class CustomerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HotelRoom room101 = new HotelRoom(101, 1, "King", false);
		HotelRoom room102 = new HotelRoom(102, 2, "Queen", true);
		
		
		Customer bob = new Customer("Bob", "Dylan", "1-555-555-5555", "bobbydylan@bobdylan.com", room101);
		
		CustomerHelper ch = new CustomerHelper();
		
		ch.insertCustomer(bob);
		
		Customer david = new Customer("David", "Bowie", "1-555-555-9999", "davidbowie@ziggystardust.com", room102);
		
		ch.insertCustomer(david);
		
		List<Customer> allCustomers = ch.showAllCustomers();
		
		for (Customer a: allCustomers) {
			System.out.println(a.toString());
		}
		
	}

}
