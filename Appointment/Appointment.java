import java.util.Date;

public class Appointment {
    private String appointment_id;
    private Date date;
    private String description;

    public Appointment(String appointment_id, Date date, String description) {
        this.setAppointment_id(appointment_id);
        this.setDate(date);
        this.setDescription(description);
    }

    /**
     * @return Unique identifier for the appointment that is 10 characters or fewer and cannot be empty or null.
     * @see AppointmentTest#getAppointment_id()
     */
    public String getAppointment_id() {
        return appointment_id;
    }

    /**
     * @param appointment_id Unique identifier for the appointment that is 10 characters or fewer and cannot be empty or
     *                       null.
     *
     * @throws IllegalArgumentException if appointment_id is null or empty
     * @throws IllegalArgumentException if appointment_id is longer than 10 characters
     * @see AppointmentTest#setAppointment_idGreaterThan10()
     * @see AppointmentTest#setAppointment_idLessThan10()
     * @see AppointmentTest#setAppointment_idEqualTo10()
     * @see AppointmentTest#setAppointment_idNull()
     */
    private void setAppointment_id(String appointment_id) {

        if (appointment_id == null || appointment_id.isEmpty()) {
            // Check if appointment_id is null or empty
            throw new IllegalArgumentException("Appointment ID cannot be empty");
        } else if (appointment_id.length() > 10) {
            // Check if appointment_id is longer than 10 characters
            throw new IllegalArgumentException("Appointment ID cannot be longer than 10 characters");
        }

        // At this point, we can safely set the appointment_id
        this.appointment_id = appointment_id;
    }

    /**
     * @return Date of the appointment date variable
     * @see AppointmentTest#getDatePos() for positive test case
     * @see AppointmentTest#getDateNeg() for negative test case
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date Date of the appointment
     *
     * @throws NullPointerException if date is null
     * @throws IllegalArgumentException if date is in the past
     * @see AppointmentTest#setDateFuture()
     * @see AppointmentTest#setDatePast()
     * @see AppointmentTest#setDateToday()
     * @see AppointmentTest#setDateNull()
     */
    public void setDate(Date date) {
        if (date.before(new Date())) {
            throw new IllegalArgumentException("Date cannot be in the past");
        }
        // At this point, we can safely set the date
        this.date = date;
    }

    /**
     * @return Description of the appointment that is 50 characters or fewer and cannot be empty or null.
     * @see AppointmentTest#getDescription()
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description Description of the appointment that is 50 characters or fewer and cannot be empty or null.
     * @throws IllegalArgumentException if description is null or empty
     * @throws IllegalArgumentException if description is longer than 50 characters
     * @see AppointmentTest#setDescriptionGreaterThan50()
     * @see AppointmentTest#setDescriptionLessThan50()
     * @see AppointmentTest#setDescriptionEqualTo50()
     * @see AppointmentTest#setDescriptionNull()
     */
    public void setDescription(String description) {

        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty or null");
        } else if (description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be longer than 50 characters");
        }

        // At this point, we can safely set the description
        this.description = description;
    }
}
