package contact;

import java.util.concurrent.atomic.AtomicLong;

public class Contact {
	// Used to get unique ID for each contact
	private static AtomicLong idGenerator = new AtomicLong();

	// Initializing ID with first value in idGenerator.
	public String ID;
	public String firstName;
	public String lastName;
	public String phone;
	public String address;
		
	public Contact(String firstName, String lastName, String phone, String address) {
		//Used to hold bool while we verify contact input
		boolean validContact = verifyContact(firstName, lastName, phone, address); 
		
		if (validContact) {
			// Getting new id for each contact that is added.
			String id = generateID();
			this.ID = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.address = address;
		}else {
			throw new IllegalArgumentException("Unable to create contact.");
		}
	}
	
	public String generateID() {
		String r = String.valueOf(idGenerator.getAndIncrement());
		if(!verifyID(r)) {
			throw new IllegalArgumentException("Contact ID is not valid");
		}
		return r;
	}
	
	// if any field is not valid return false and do not create the contact
	public boolean verifyContact(String firstName, String lastName, String phone, String address) {
		boolean b = true;
		if(!verifyFirstName(firstName)) {b = false;}
		if(!verifyLastName(lastName)) {b = false;}
		if(!verifyPhone(phone)) {b = false;}
		if(!verifyAddress(address)) {b = false;}		
		return b;
	}
	
	//ID
	public boolean verifyID(String ID) {
		if(ID == null || ID.length() > 10) {
			return false;
		}
		return true;
	}
	
	public String getID() {
		return ID;
	}
	
	//firstName
	public boolean verifyFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {
			return false;
		}
		return true;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		if(verifyFirstName(firstName)) {
			this.firstName = firstName;
		}
	}
		
	//lastName
	public boolean verifyLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			return false;
		}
		return true;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		if(verifyLastName(lastName)) {
			this.lastName = lastName;
		}
	}
	
	//phone
	public boolean verifyPhone(String phone) {
		if(phone == null || phone.length() != 10) {
			return false;
		}
		return true;
		
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		if(verifyPhone(phone)) {
			this.phone = phone;
		}
	}
	
	//address
	public boolean verifyAddress(String address) {
		if(address == null || address.length() > 30) {
			return false;
		}
		return true;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		if(verifyAddress(address)) {
			this.address = address;
		}
	}
}
