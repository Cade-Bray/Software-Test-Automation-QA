import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ContactTest {

    @Test
    @DisplayName("getAddress: success")
    void getAddressSuccess() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertEquals("1234 Main St", contact.getAddress());
    }

    @Test
    @DisplayName("setAddress: null")
    void setAddress() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }

    @Test
    @DisplayName("setAddress: 31 characters")
    void setAddress31Characters() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("1234567890123456789012345678901"));
    }

    @Test
    @DisplayName("setAddress: 30 characters")
    void setAddress30Characters() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertDoesNotThrow(() -> contact.setAddress("123456789012345678901234567890"));
    }

    @Test
    @DisplayName("setAddress: empty")
    void setAddressEmpty() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertDoesNotThrow(() -> contact.setAddress(""));
    }

    @Test
    @DisplayName("getFirstName: success")
    void getFirstName() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertEquals("John", contact.getFirstName());
    }

    @Test
    @DisplayName("setFirstName: null")
    void setFirstNameNull() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    @Test
    @DisplayName("setFirstName: 11 characters")
    void setFirstName11Characters() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("ThisNameIsTooLong"));
    }

    @Test
    @DisplayName("setFirstName: 10 characters")
    void setFirstName10Characters() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertDoesNotThrow(() -> contact.setFirstName("ThisIsFine"));
    }

    @Test
    @DisplayName("setFirstName: empty")
    void setFirstNameEmpty() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(""));
    }

    @Test
    @DisplayName("getLastName: success")
    void getLastName() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertEquals("Doe", contact.getLastName());
    }

    @Test
    @DisplayName("setLastName: null")
    void setLastNameNull() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }

    @Test
    @DisplayName("setLastName: 11 characters")
    void setLastName11Characters() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("ThisNameIsT"));
    }

    @Test
    @DisplayName("setLastName: 10 characters")
    void setLastName10Characters() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertDoesNotThrow(() -> contact.setLastName("ThisIsFine"));
    }

    @Test
    @DisplayName("setLastName: empty")
    void setLastNameEmpty() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(""));
    }

    @Test
    @DisplayName("getPhone: success")
    void getPhone() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    @DisplayName("getPhone: set with dashes but returns without")
    void getPhoneSetWithDashes() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        contact.setPhone("123-456-7890");
        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    @DisplayName("getPhone: set with parentheses but returns without")
    void getPhoneSetWithParentheses() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        contact.setPhone("(123) 456-7890");
        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    @DisplayName("getPhone: set with spaces but returns without")
    void getPhoneSetWithSpaces() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        contact.setPhone("123 456 7890");
        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    @DisplayName("getPhone: set with periods but returns without")
    void getPhoneSetWithPeriods() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        contact.setPhone("123.456.7890");
        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    @DisplayName("setPhone: null")
    void setPhoneNull() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
    }

    @Test
    @DisplayName("setPhone: empty")
    void setPhoneEmpty() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(""));
    }

    @Test
    @DisplayName("setPhone: 9 characters")
    void setPhone9Characters() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123456789"));
    }

    @Test
    @DisplayName("setPhone: 10 characters")
    void setPhone10Characters() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertDoesNotThrow(() -> contact.setPhone("1234567890"));
    }

    @Test
    @DisplayName("setPhone: 11 characters")
    void setPhone11Characters() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345678901"));
    }

    @Test
    @DisplayName("setPhone: format with dashes")
    void setPhoneFormatWithDashes() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertDoesNotThrow(() -> contact.setPhone("123-456-7890"));
    }

    @Test
    @DisplayName("setPhone: format with parentheses")
    void setPhoneFormatWithParentheses() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertDoesNotThrow(() -> contact.setPhone("(123) 456-7890"));
    }

    @Test
    @DisplayName("setPhone: format with spaces")
    void setPhoneFormatWithSpaces() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertDoesNotThrow(() -> contact.setPhone("123 456 7890"));
    }

    @Test
    @DisplayName("setPhone: format with periods")
    void setPhoneFormatWithPeriods() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertDoesNotThrow(() -> contact.setPhone("123.456.7890"));
    }

    @Test
    @DisplayName("getID: success")
    void getID() {
        Contact contact = new Contact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertEquals("1234", contact.getID());
    }

    @Test
    @DisplayName("setID: null")
    // Test will need to be done through the constructor
    void setIDNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "1234 Main St"));
    }

    @Test
    @DisplayName("setID: empty")
    // Test will need to be done through the constructor
    void setIDEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("", "John", "Doe", "1234567890", "1234 Main St"));
    }

    @Test
    @DisplayName("setID: 11 characters")
    // Test will need to be done through the constructor
    void setID11Characters() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "1234 Main St"));
    }
}