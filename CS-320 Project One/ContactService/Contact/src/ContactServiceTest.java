import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

public class ContactServiceTest {
    public static class contact {
        private String contactID;
        private String firstName;
        private String lastName;
        private String phone;
        private String address;

        public contact(String contactID, String firstName, String lastName, String phone, String address) {
            this.contactID = contactID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.address = address;
        }

        public String getContactID() {
            return contactID;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getPhone() {
            return phone;
        }

        public String getAddress() {
            return address;
        }
    }

    public static class ContactService {
        private Map<String, contact> contacts;

        public ContactService() {
            contacts = new HashMap<>();
        }

        public void addContact(contact contact) {
            contacts.put(contact.getContactID(), contact);
        }

        public void deleteContact(String contactID) {
            contacts.remove(contactID);
        }

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

        public contact getContact(String contactID) {
            return contacts.get(contactID);
        }
    }

    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService();
        contact contact = new contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        assertEquals(contact, contactService.getContact("1234567890"));
    }

    @Test
    public void testDeleteContact() {
        ContactService contactService = new ContactService();
        contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");

        assertNull(contactService.getContact("1234567890"));
    }

    @Test
    public void testUpdateFirstName() {
        ContactService contactService = new ContactService();
        contact contact = new contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateFirstName("1234567890", "Jane");

        assertEquals("Jane", contactService.getContact("1234567890").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService contactService = new ContactService();
        contact contact = new contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateLastName("1234567890", "Smith");

        assertEquals("Smith", contactService.getContact("1234567890").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        ContactService contactService = new ContactService();
        contact contact = new contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updatePhone("1234567890", "0987654321");

        assertEquals("0987654321", contactService.getContact("1234567890").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        ContactService contactService = new ContactService();
        contact contact = new contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateAddress("1234567890", "456 Elm St");

        assertEquals("456 Elm St", contactService.getContact("1234567890").getAddress());
    }
}