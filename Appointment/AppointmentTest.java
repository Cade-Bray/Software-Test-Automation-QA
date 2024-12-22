import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

class AppointmentTest {

    @Test
    @DisplayName("Testing setAppointment_id() with empty variable.")
    void setAppointment_idEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("", new Date(), "Test");
        });
    }

    @Test
    @DisplayName("Testing setAppointment_id() with variable length Greater than 10.")
    void setAppointment_idGreaterThan10() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", new Date(), "Test");
        });
    }

    @Test
    @DisplayName("Testing setAppointment_id() with variable length less than 10.")
    void setAppointment_idLessThan10() {
        assertDoesNotThrow(() -> {
            new Appointment("123456789", new Date(), "Test");
        });
    }

    @Test
    @DisplayName("Testing setAppointment_id() with variable length equal to 10.")
    void setAppointment_idEqualTo10() {
        assertDoesNotThrow(() -> {
            new Appointment("1234567890", new Date(), "Test");
        });
    }

    @Test
    @DisplayName("Testing setAppointment_id() with null variable.")
    void setAppointment_idNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(), "Test");
        });
    }

    @Test
    @DisplayName("Testing getAppointment_id() with positive test case.")
    void getAppointment_id() {
        Appointment appointment = new Appointment("1234567890", new Date(), "Test");

        assertEquals("1234567890", appointment.getAppointment_id());
    }

    @Test
    @DisplayName("Testing getAppointment_id() with positive test case.")
    void getDatePos() {
        Appointment appointment = new Appointment("1234567890", new Date(), "Test");

        assertEquals(new Date(), appointment.getDate());
    }

    @Test
    @DisplayName("Testing getDate() with negative test case.")
    void getDateNeg() {
        Date date = new Date();
        date.setTime(date.getTime() + 30000);
        Appointment appointment = new Appointment("1234567890", new Date(), "Test");

        assertNotEquals(new Date(0), appointment.getDate());
    }

    @Test
    @DisplayName("Testing setDate() with positive test case, Future Date.")
    void setDateFuture() {
        Appointment appointment = new Appointment("1234567890", new Date(), "Test");
        Date futureDate = new Date();
        // Set the date to be 1 day in the future
        futureDate.setTime(futureDate.getTime() + 1000 * 60 * 60 * 24);
        appointment.setDate(futureDate);
        assertEquals(futureDate, appointment.getDate());
    }

    @Test
    @DisplayName("Testing setDate() with Negative test case, Past Date.")
    void setDatePast() {

        Date pastDate = new Date();
        // Set the date to be 1 day in the past
        pastDate.setTime(pastDate.getTime() - 1000 * 60 * 60 * 24);

        Appointment appointment = new Appointment("1234567890", new Date(), "Test");
        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDate(pastDate);
        });
    }

    @Test
    @DisplayName("Testing setDate() with Positive test case, Today's Date.")
    void setDateToday() {
        Appointment appointment = new Appointment("1234567890", new Date(), "Test");

        appointment.setDate(new Date());

        assertEquals(new Date(), appointment.getDate());
    }

    @Test
    @DisplayName("Testing setDate() with Negative test case, Null Date.")
    void setDateNull() {
        // The handling for null date is not implemented in the setDate method but in the Date class itself.
        // Date class throws a NullPointerException if the date is null because it's annotated with @NonNull.
        Appointment appointment = new Appointment("1234567890", new Date(), "Test");
        assertThrows(NullPointerException.class, () -> {
            appointment.setDate(null);
        });
    }

    @Test
    @DisplayName("Testing getDescription() with positive test case.")
    void getDescription() {
        Appointment appointment = new Appointment("1234567890", new Date(), "Test");
        assertEquals("Test", appointment.getDescription());
    }

    @Test
    @DisplayName("setDescription: Testing setting the description with empty string")
    void setDescriptionEmpty() {
        Appointment appointment = new Appointment("1234567890", new Date(), "Test");

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription("");
        });
    }

    @Test
    @DisplayName("Testing setDescription() with Negative test case, Description greater than 50 characters.")
    void setDescriptionGreaterThan50() {
        Appointment appointment = new Appointment("1234567890", new Date(), "Test");

        String longDescription = "This is a long description that is longer than 50 characters. " +
                "This is a long description that is longer than 50 characters.";

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription(longDescription);
        });
    }

    @Test
    @DisplayName("Testing setDescription() with Negative test case, Description less than 50 characters.")
    void setDescriptionLessThan50() {
        Appointment appointment = new Appointment("1234567890", new Date(), "Test");

        String shortDescription = "Short description";

        appointment.setDescription(shortDescription);

        assertDoesNotThrow(() -> {
            appointment.setDescription(shortDescription);
        });
    }

    @Test
    @DisplayName("Testing setDescription() with Positive test case, Description exactly 50 characters.")
    void setDescriptionEqualTo50() {
        Appointment appointment = new Appointment("1234567890", new Date(), "Test");

        assertDoesNotThrow(() -> {
            appointment.setDescription("This is a description that is exactly 50 chr long.");
        });
    }

    @Test
    @DisplayName("Testing setDescription() with Negative test case, Null Description.")
    void setDescriptionNull() {
        Appointment appointment = new Appointment("1234567890", new Date(), "Test");

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription(null);
        });
    }
}