import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for the Appointment class.
 */
class AppointmentTest {
    private String description; // Description for testing
    private String tooLongID; // ID longer than allowed length for testing
    private String tooLongDescription; // Description longer than allowed length for testing
    private Date date; // Valid date for testing
    private Date pastDate; // Past date for testing

    /**
     * Set up method to initialize test data before each test case.
     */
    @BeforeEach
    void setUp() {
        description = "The appt object shall have a required description."; // Initialize description
        tooLongID = "111222333444555666777888999"; // Initialize too long ID
        tooLongDescription = "This description is too long for the appointment requirements but good for testing."; // Initialize too long description
        date = new Date(2021 - 1900, Calendar.JANUARY, 1); // Initialize valid date
        pastDate = new Date(0); // Initialize past date
    }

    /**
     * Test case to verify the functionality of updating appointment ID.
     */
    @Test
    void testUpdateAppointmentID() {
        Appointment appointment = new Appointment(); // Create new appointment
        assertThrows(IllegalArgumentException.class, () -> appointment.updateAppointmentID(null)); // Test updating with null ID
        assertThrows(IllegalArgumentException.class, () -> appointment.updateAppointmentID(tooLongID)); // Test updating with too long ID
        appointment.updateAppointmentID("1234567890"); // Update ID
        assertEquals("1234567890", appointment.getAppointmentID()); // Check if ID is updated correctly
    }

    /**
     * Test case to verify the functionality of getting appointment ID.
     */
    @Test
    void testGetAppointmentID() {
        Appointment appointment = new Appointment("1234567890", date, description); // Create appointment with ID
        assertNotNull(appointment.getAppointmentID()); // Check if ID is not null
        assertEquals(10, appointment.getAppointmentID().length()); // Check if ID length is correct
        assertEquals("1234567890", appointment.getAppointmentID()); // Check if ID is correct
    }

    /**
     * Test case to verify the functionality of updating appointment date.
     */
    @Test
    void testUpdateDate() {
        Appointment appointment = new Appointment(); // Create new appointment
        assertThrows(IllegalArgumentException.class, () -> appointment.updateDate(pastDate)); // Test updating with past date
        appointment.updateDate(null); // Test updating with null date
        appointment.updateDate(date); // Update date
        assertEquals(date, appointment.getAppointmentDate()); // Check if date is updated correctly
    }

    /**
     * Test case to verify the functionality of getting appointment date.
     */
    @Test
    void testGetAppointmentDate() {
        Appointment appointment = new Appointment("1234567890", date, description); // Create appointment with date
        assertNotNull(appointment.getAppointmentDate()); // Check if date is not null
        assertEquals(date, appointment.getAppointmentDate()); // Check if date is correct
    }

    /**
     * Test case to verify the functionality of updating appointment description.
     */
    @Test
    void testUpdateDescription() {
        Appointment appointment = new Appointment(); // Create new appointment
        assertThrows(IllegalArgumentException.class, () -> appointment.updateDescription(null)); // Test updating with null description
        assertThrows(IllegalArgumentException.class, () -> appointment.updateDescription(tooLongDescription)); // Test updating with too long description
        appointment.updateDescription(description); // Update description
        assertEquals(description, appointment.getDescription()); // Check if description is updated correctly
    }

    /**
     * Test case to verify the functionality of getting appointment description.
     */
    @Test
    void testGetDescription() {
        Appointment appointment = new Appointment("1234567890", date, description); // Create appointment with description
        assertNotNull(appointment.getDescription()); // Check if description is not null
        assertTrue(appointment.getDescription().length() < 59); // Check if description length is within limit
        assertEquals(description, appointment.getDescription()); // Check if description is correct
    }
}