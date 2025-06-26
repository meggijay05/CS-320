import java.util.HashMap;
import java.util.Map;

// Class for managing contacts
public class ContactService {
    private Map<String, contact> contacts; // Map to store contacts

    // Constructor to initialize the contacts map
    public ContactService() {
        contacts = new HashMap<>();
    }

    // Method to add a contact to the map
    public void addContact(contact contact) {
        contacts.put(contact.getContactID(), contact);
    }

    // Method to delete a contact from the map
    public void deleteContact(String contactID) {
        contacts.remove(contactID);
    }

    // Methods to update different fields of a contact
    public void updateFirstName(String contactID, String newFirstName) {
        contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.firstName = newFirstName;
        }
    }

    public void updateLastName(String contactID, String newLastName) {
        contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.lastName = newLastName;
        }
    }

    public void updatePhone(String contactID, String newPhone) {
        contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.phone = newPhone;
        }
    }

    public void updateAddress(String contactID, String newAddress) {
        contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.address = newAddress;
        }
    }

    // Method to get a contact by its ID
    public contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}