import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

    @Test
    @DisplayName("Testing to add a duplicate appointment ID to the ArrayList")
    void addDuplicateAppointment() {
        // This will test adding a duplicate appointment to the ArrayList.
        // This will test if the IllegalArgumentException is thrown.
        AppointmentService appointmentService = new AppointmentService();
        appointmentService.addAppointment("1", new Date(), "Test");
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment("1", new Date(), "Test"));
    }

    @Test
    @DisplayName("Testing to add an appointment to the ArrayList using the overloaded method")
    void addDuplicateAppointmentOverload() {
        // This will test adding a duplicate appointment to the ArrayList.
        // This will test if the IllegalArgumentException is thrown.
        AppointmentService appointmentService = new AppointmentService();
        appointmentService.addAppointment("1", new Date(), "Test");
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(new Appointment("1", new Date(), "Test")));
    }

    @Test
    @DisplayName("Testing to add an appointment to the ArrayList")
    void addAppointment() {
        // This will test adding it to the Arraylist without throwing an exception.
        // This will not test if the appointment was actually added to the ArrayList.
        AppointmentService appointmentService = new AppointmentService();
        assertDoesNotThrow(() -> appointmentService.addAppointment("1", new Date(), "Test"));
    }

    @Test
    @DisplayName("addAppointment: Testing to add an appointment to the ArrayList as the overloaded method")
    void addAppointmentOverload() {
        // This will test adding it to the Arraylist without throwing an exception.
        // This will not test if the appointment was actually added to the ArrayList.
        AppointmentService appointmentService = new AppointmentService();
        assertDoesNotThrow(() -> appointmentService.addAppointment(new Appointment("1", new Date(), "Test")));
    }

    @Test
    @DisplayName("Testing to add an appointment to the ArrayList")
    void appointmentAdded() {
        // This will test if the appointment was actually added to the ArrayList.
        AppointmentService appointmentService = new AppointmentService();
        appointmentService.addAppointment("1", new Date(), "Test");
        assertDoesNotThrow(() -> appointmentService.findAppointment("1"));
    }

    @Test
    @DisplayName("appointmentAdded: Appointment already exists")
    void appointmentAddedAlreadyExists() {
        // This will test if the appointment was actually added to the ArrayList.
        AppointmentService appointmentService = new AppointmentService();
        appointmentService.addAppointment("1", new Date(), "Test");
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment("1", new Date(), "Test"));
    }

    @Test
    @DisplayName("Testing to remove an appointment from the ArrayList")
    void removeAppointment() {
        // This will test removing an appointment from the ArrayList without throwing an exception.
        // This will not test if the appointment was actually removed from the ArrayList.
        AppointmentService appointmentService = new AppointmentService();
        appointmentService.addAppointment("1", new Date(), "Test");
        assertDoesNotThrow(() -> appointmentService.removeAppointment("1"));
    }

    @Test
    @DisplayName("Testing to remove an appointment from the ArrayList as the overloaded method")
    void removeAppointmentOverload() {
        // This will test removing an appointment from the ArrayList without throwing an exception.
        // This will not test if the appointment was actually removed from the ArrayList.
        AppointmentService appointmentService = new AppointmentService();
        appointmentService.addAppointment("1", new Date(), "Test");
        assertDoesNotThrow(() -> appointmentService.removeAppointment(new Appointment("1", new Date(), "Test")));
    }

    @Test
    @DisplayName("Testing to remove an appointment from the ArrayList")
    void appointmentRemoved() {
        // This will test if the appointment was actually removed from the ArrayList.
        AppointmentService appointmentService = new AppointmentService();
        appointmentService.addAppointment("1", new Date(), "Test");
        appointmentService.removeAppointment("1");
        assertThrows(IllegalArgumentException.class, () -> appointmentService.findAppointment("1"));
    }

    @Test
    @DisplayName("Testing to find an appointment in the ArrayList")
    void findAppointment() {
        // This will test if the appointment was actually found in the ArrayList.
        AppointmentService appointmentService = new AppointmentService();
        Date date = new Date();
        // Set the date to be 30 seconds in the future
        date.setTime(date.getTime() + 30000);
        appointmentService.addAppointment("1", date, "Test");
        assertDoesNotThrow(() -> appointmentService.findAppointment("1"));
    }

    @Test
    @DisplayName("Testing to find an appointment in the ArrayList that does not exist")
    void findAppointmentDoesNotExist() {
        // This will test if the appointment was actually found in the ArrayList.
        AppointmentService appointmentService = new AppointmentService();
        Date date = new Date();
        // Set the date to be 30 seconds in the future
        date.setTime(date.getTime() + 30000);
        appointmentService.addAppointment("1", date, "Test");
        assertThrows(IllegalArgumentException.class, () -> appointmentService.findAppointment("2"));
    }
}