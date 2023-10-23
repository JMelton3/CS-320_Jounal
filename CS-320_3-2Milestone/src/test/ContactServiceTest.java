package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import contact.ContactService;

class ContactServiceTest {
	
	// adding contacts
	@Test
	@Order(1)
	public void testAddContact() {
		ContactService service = new ContactService();
		service.addContact("John", "Melton", "2051234567", "123 drive way");
		service.addContact("Johnny", "Bravo", "1111234567", "123 drive st");
		assertEquals("John",service.getContact("2").getFirstName());
		assertEquals("Melton",service.getContact("2").getLastName());
		assertEquals("2051234567",service.getContact("2").getPhone());		
		assertEquals("123 drive way",service.getContact("2").getAddress());
		
		assertEquals("Johnny",service.getContact("3").getFirstName());
		assertEquals("Bravo",service.getContact("3").getLastName());
		assertEquals("1111234567",service.getContact("3").getPhone());		
		assertEquals("123 drive st",service.getContact("3").getAddress());		
	}
	
	// Update
	@Test
	@Order(2)
	void testUpdateContact() {
		ContactService service = new ContactService();
		service.addContact("John", "Melton", "2051234567", "123 drive way");
		assertEquals("John",service.getContact("1").getFirstName());
		assertEquals("Melton",service.getContact("1").getLastName());
		assertEquals("2051234567",service.getContact("1").getPhone());		
		assertEquals("123 drive way",service.getContact("1").getAddress());
		
		service.updateFirstName("1", "Joan");
		service.updateLastName("1", "Rivers");
		service.updatePhone("1", "1234567897");
		service.updateAddress("1", "123 Fancy way");

		assertEquals("Joan",service.getContact("1").getFirstName());
		assertEquals("Rivers",service.getContact("1").getLastName());
		assertEquals("1234567897",service.getContact("1").getPhone());		
		assertEquals("123 Fancy way",service.getContact("1").getAddress());
	}
	
	//delete
	@Test
	@Order(3)
	public void testDeleteContact() {
		ContactService service = new ContactService();
		service.addContact("steve", "willis", "2221234567", "123 driveon roads");
		assertEquals("steve",service.getContact("0").getFirstName());
		assertEquals("willis",service.getContact("0").getLastName());
		assertEquals("2221234567",service.getContact("0").getPhone());		
		assertEquals("123 driveon roads",service.getContact("0").getAddress());
		
		service.deleteContact("0");
		
		assertNull(service.getContact("0"));
	}
	
}
