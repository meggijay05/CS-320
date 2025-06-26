import java.util.Date;

/**
 * Appointment.java defines a class called Appointment, which represents an appointment object in the appointment scheduling system.
 */
public class Appointment {
    // Private fields to store appointment information
    private String appointmentID; // Unique identifier for the appointment
    private Date appointmentDate; // Date and time of the appointment
    private String description; // Description or details of the appointment

    /**
     * Constructor to initialize an Appointment object with provided parameters.
     *
     * @param appointmentID    Unique identifier for the appointment
     * @param appointmentDate  Date and time of the appointment
     * @param description      Description or details of the appointment
     */
    public Appointment(String appointmentID, Date appointmentDate, String description) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    /**
     * Getter method to retrieve the appointment's unique identifier.
     *
     * @return The appointment's unique identifier
     */
    public String getAppointmentID() {
        return appointmentID;
    }

    /**
     * Getter method to retrieve the appointment's date and time.
     *
     * @return The appointment's date and time
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * Getter method to retrieve the appointment's description.
     *
     * @return The appointment's description
     */
    public String getDescription() {
        return description;
    }
}
