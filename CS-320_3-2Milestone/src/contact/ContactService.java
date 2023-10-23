package contact;

import java.util.ArrayList;


public class ContactService {
	// Creates list to hold contacts.
	private ArrayList<Contact> contactList = new ArrayList<Contact>();
	
		
	
	public Contact getContact(String id) {
		Contact r = null;
		
		// searching list for contact with given id
		for (Contact c : contactList) {
            if (c.getID().equals(id)) {
                r = c;
                break;
            }
		}
		return r;
	}
	
	// adds new contact. If contact is not valid an error will be shown and it will not be added to the list 
	// and error will be thrown from the Contact class.
	public void addContact(String firstName, String lastName, String phone, String address) {
		Contact contact = new Contact(firstName, lastName, phone, address);
		
		if (contact != null) {contactList.add(contact);}
	}
		
	
	public void deleteContact(String id) {
		Contact c = getContact(id);
		if (c != null) {contactList.remove(c);}
	}
	
	// The logic is the updates is essentially the same.
	// We essentially search for the object in our list and if we find it we alter the specified fields.
	// The verification is done in the Contact class when we attempt to add the contact.
	// If this were an app in production we could also utilize the front end to catch some validation steps in addition to the backend.
		
	public void updateFirstName(String id, String firstName) {
		Contact c = getContact(id);
		if (c != null) {
			c.setFirstName(firstName);
		}
	}
	
	public void updateLastName(String id, String lastName) {
		Contact c = getContact(id);
		if (c != null) {
			c.setLastName(lastName);
		}
	}
	
	public void updatePhone(String id, String phone) {
		Contact c = getContact(id);
		if (c != null) {
			c.setPhone(phone);
		}
	}
	
	public void updateAddress(String id, String address) {
		Contact c = getContact(id);
		if (c != null) {
			c.setAddress(address);
		}
	}	
}