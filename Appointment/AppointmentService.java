import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
    private final ArrayList<Appointment> appointments = new ArrayList<>();

    /**
     * @param ID The ID of the appointment
     * @param date The date of the appointment
     * @param description The description of the appointment
     * @throws IllegalArgumentException if the appointment already exists
     * @see AppointmentServiceTest#addAppointment()
     * @see AppointmentServiceTest#appointmentAdded()
     */
    public void addAppointment(String ID, Date date, String description) {
        Appointment appointment = new Appointment(ID, date, description);
        for (Appointment a : appointments) {
            if (a.getAppointment_id().equals(appointment.getAppointment_id())) {
                throw new IllegalArgumentException("Appointment already exists");
            }
        }
        appointments.add(appointment);
    }

    /**
     * @param appointment The appointment to add
     * @throws IllegalArgumentException if the appointment already exists
     * @see AppointmentServiceTest#addAppointmentOverload()
     * @see AppointmentServiceTest#appointmentAdded()
     */
    public void addAppointment(Appointment appointment) {
        // Check to ensure the appointment does not already exist
        for (Appointment a : appointments) {
            if (a.getAppointment_id().equals(appointment.getAppointment_id())) {
                throw new IllegalArgumentException("Appointment already exists");
            }
        }
        appointments.add(appointment);
    }

    /**
     * @param ID The ID of the appointment to remove
     * @throws IllegalArgumentException if the appointment is not found
     * @see AppointmentServiceTest#removeAppointment()
     * @see AppointmentServiceTest#appointmentRemoved()
     */
    public void removeAppointment(String ID) {
        Appointment appointment = findAppointment(ID);
        appointments.remove(appointment);
    }

    /**
     * @param appointment The appointment to remove
     * @see AppointmentServiceTest#removeAppointmentOverload()
     * @see AppointmentServiceTest#appointmentRemoved()
     */
    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    /**
     * @param id The ID of the appointment to find
     * @return The appointment with the given ID
     * @throws IllegalArgumentException if the appointment is not found
     * @see AppointmentServiceTest#findAppointment()
     */
    public Appointment findAppointment(String id) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointment_id().equals(id)) {
                return appointment;
            }
        }
        throw new IllegalArgumentException("Appointment not found");
    }
}
