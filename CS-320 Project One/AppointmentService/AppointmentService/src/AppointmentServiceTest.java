import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * JUnit test class for the AppointmentService class.
 */
class AppointmentServiceTest {
    private AppointmentService appointmentService; // Instance of the AppointmentService class
    private Date validDate; // Valid date for testing
    private Appointment validAppointment; // Valid appointment object for testing

    /**
     * Set up method to initialize test data before each test case.
     */
    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService(); // Initialize AppointmentService
        validDate = new Date(System.currentTimeMillis() + 3600000); // Set to valid date (1 hour from now)
        validAppointment = new Appointment("1234567890", validDate, "Valid description"); // Create valid appointment
    }

    /**
     * Test case to verify the functionality of adding an appointment.
     */
    @Test
    void testAddAppointment() {
        appointmentService.addAppointment(validAppointment);
        assertEquals(validAppointment, appointmentService.getAppointments().get("1234567890"));
    }

    /**
     * Test case to verify handling of adding an appointment with a duplicate ID.
     */
    @Test
    void testAddAppointmentDuplicateID() {
        appointmentService.addAppointment(validAppointment);

        // Adding an appointment with the same ID should throw an exception
        assertThrows(IllegalArgumentException.class, () ->
                appointmentService.addAppointment(new Appointment("1234567890", validDate, "Duplicate ID")));
    }

    /**
     * Test case to verify handling of adding a null appointment.
     */
    @Test
    void testAddAppointmentNullAppointment() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(null));
    }

    /**
     * Test case to verify handling of adding an appointment with a null ID.
     */
    @Test
    void testAddAppointmentNullID() {
        assertThrows(IllegalArgumentException.class, () ->
                appointmentService.addAppointment(new Appointment(null, validDate, "Null ID")));
    }

    /**
     * Test case to verify the functionality of deleting an appointment.
     */
    @Test
    void testDeleteAppointment() {
        appointmentService.addAppointment(validAppointment);
        appointmentService.deleteAppointment("1234567890");
        assertNull(appointmentService.getAppointments().get("1234567890"));
    }

    /**
     * Test case to verify handling of deleting a nonexistent appointment.
     */
    @Test
    void testDeleteNonexistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("NonexistentID"));
    }
}