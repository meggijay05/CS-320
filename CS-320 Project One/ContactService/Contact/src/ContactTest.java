import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Test class for Contact creation
public class ContactTest {
    
    // Test method for Contact creation
    @Test
    public void testContactCreation() {
        contact contact = new contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        
        // Assert that contact is not null
        assertNotNull(contact);
        
        // Assert that contact fields match the provided values
        assertEquals("1234567890", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }
}