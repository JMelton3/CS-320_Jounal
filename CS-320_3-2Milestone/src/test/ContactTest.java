package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	// Testing valid class and getters.
	@Test
	void testContactClass() {
		Contact contact = new Contact("John", "Melton", "2051234567", "123 drive way");
		assertTrue(contact.getID().equals("0"));
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Melton"));
		assertTrue(contact.getPhone().equals("2051234567"));
		assertTrue(contact.getAddress().equals("123 drive way"));
	}
	
	//Test incrementing counter
	@Test
	void testIncrementID() {
		Contact contact = new Contact("Johnny", "Bravo", "1111234567", "123 drive st");
		assertTrue(contact.getID().equals("1"));
		assertTrue(contact.getFirstName().equals("Johnny"));
		assertTrue(contact.getLastName().equals("Bravo"));
		assertTrue(contact.getPhone().equals("1111234567"));
		assertTrue(contact.getAddress().equals("123 drive st"));
	}
	
	//Testing nulls
	@Test
	void testNullFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Young", "1234568790", "123 Jay Way");
		});
	}
	
	@Test
	void testNullLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Matthew", null, "1234568790", "123 Jay Way");
		});
	}
	
	@Test
	void testNullPhoneNumber() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Matthew", "Young", null, "123 Jay Way");
		});
	}
	
	@Test
	void testNullAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Matthew", "Young", "1234568790", null);
		});
	}
				
	//Testing length
	@Test
	void testFirstNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Matthew8911", "Young", "1234568790", "123 Jay Way");
		});
	}
	
	@Test
	void testLastNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Matthew", "YoungYoung1", "1234568790", "123 Jay Way");
		});
	}
	
	@Test
	void testPhoneNumberLengthShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Matthew", "Young", "234568790", "123 Jay Way");
		});
	}
	
	@Test
	void testPhoneNumberLengthLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Matthew", "Young", "11234568790", "123 Jay Way");
		});
	}
	
	@Test
	void testAddressLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Matthew", "Young", "1234568790", "123 Jay Way 123 Jay Way 123 Jay");
		});
	}
}
