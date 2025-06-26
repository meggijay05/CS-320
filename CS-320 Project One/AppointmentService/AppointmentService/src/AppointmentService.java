import java.util.HashMap;
import java.util.Map;

/**
 * AppointmentService.java defines a class called AppointmentService, which manages appointment-related operations.
 */
public class AppointmentService {
    // Map to store appointments with their unique IDs as keys
    private Map<String, Appointment> appointments;

    /**
     * Constructor to initialize the AppointmentService with an empty map of appointments.
     */
    public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    /**
     * Method to add a new appointment to the service.
     *
     * @param appointment The appointment object to be added
     * @throws IllegalArgumentException If the appointment or appointment ID is null, or if the appointment ID is not unique
     */
    public void addAppointment(Appointment appointment) {
        // Check if the appointment or its ID is null
        if (appointment == null || appointment.getAppointmentID() == null) {
            throw new IllegalArgumentException("Appointment or Appointment ID cannot be null.");
        }

        // Check if the appointment ID is already present (must be unique)
        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID must be unique.");
        }

        // Add the appointment to the map
        appointments.put(appointment.getAppointmentID(), appointment);
    }

    /**
     * Method to delete an appointment from the service.
     *
     * @param appointmentID The ID of the appointment to be deleted
     * @throws IllegalArgumentException If the appointment ID is null or if no appointment is found with the given ID
     */
    public void deleteAppointment(String appointmentID) {
        // Check if the appointment ID is null
        if (appointmentID == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null.");
        }

        // Check if an appointment with the given ID exists
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment with the given ID not found.");
        }

        // Remove the appointment from the map
        appointments.remove(appointmentID);
    }

}