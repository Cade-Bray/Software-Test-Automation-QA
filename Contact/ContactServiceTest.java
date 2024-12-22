import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ContactServiceTest {

    @Test
    @DisplayName("addContact: contact already exist")
    void addContactFailure() {
        ContactService contactService = new ContactService();
        contactService.addContact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(AssertionError.class, () ->
            contactService.addContact("1234", "John", "Doe", "1234567890", "1234 Main St")
        );
    }
    @Test
    @DisplayName("addContact: contact does not exist")
    void addContactSuccess() {
        ContactService contactService = new ContactService();
        assertDoesNotThrow(() ->
                contactService.addContact("1234", "John", "Doe", "1234567890", "1234 Main St")
        );
    }

    @Test
    @DisplayName("removeContact: contact does not exist")
    void removeContactFailure() {
        ContactService contactService = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> contactService.findContact("1234"));
    }

    @Test
    @DisplayName("removeContact: contact does exist")
    void removeContactSuccess() {
        ContactService contactService = new ContactService();
        contactService.addContact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertDoesNotThrow(() -> contactService.removeContact("1234"));
    }

    @Test
    @DisplayName("Updating the contact without failing is the criteria for this test. We've made an assumption " +
            "that the contact exists.")
    void updateContactSuccess() {
        ContactService contactService = new ContactService();
        contactService.addContact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertDoesNotThrow(() ->
                contactService.updateContact("1234", "Jane", "Smith", "0987654321", "5678 Elm St")
        );
    }

    @Test
    @DisplayName("Updating the contact without failing is the criteria for this test. We've made an assumption " +
            "that the contact does NOT exists.")
    void updateContactFailure() {
        ContactService contactService = new ContactService();
        contactService.addContact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertThrows(IllegalArgumentException.class, () ->
                contactService.updateContact("123", "Jane", "Smith", "0987654321", "5678 Elm St")
        );
    }

    @Test
    @DisplayName("updateContact: first name change successfully")
    void updateContactFirstName() {
        ContactService contactService = new ContactService();
        contactService.addContact("1234", "John", "Doe", "1234567890", "1234 Main St");
        contactService.updateContact("1234", "Jane", "Smith", "1234567890", "1234 Main St");
        assertEquals("Jane", contactService.findContact("1234").getFirstName());
    }

    @Test
    @DisplayName("updateContact: last name change successfully")
    void updateContactLastName() {
        ContactService contactService = new ContactService();
        contactService.addContact("1234", "John", "Doe", "1234567890", "1234 Main St");
        contactService.updateContact("1234", "John", "Smith", "1234567890", "1234 Main St");
        assertEquals("Smith", contactService.findContact("1234").getLastName());
    }

    @Test
    @DisplayName("updateContact: phone number change successfully")
    void updateContactPhone() {
        ContactService contactService = new ContactService();
        contactService.addContact("1234", "John", "Doe", "1234567890", "1234 Main St");
        contactService.updateContact("1234", "John", "Doe", "0987654321", "1234 Main St");
        assertEquals("0987654321", contactService.findContact("1234").getPhone());
    }

    @Test
    @DisplayName("updateContact: address change successfully")
    void updateContactAddress() {
        ContactService contactService = new ContactService();
        contactService.addContact("1234", "John", "Doe", "1234567890", "1234 Main St");
        contactService.updateContact("1234", "John", "Doe", "1234567890", "5678 Elm St");
        assertEquals("5678 Elm St", contactService.findContact("1234").getAddress());
    }

    @Test
    @DisplayName("findContact: contact does not exist")
    void findContactFailure() {
        ContactService contactService = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> contactService.findContact("1234"));
    }

    @Test
    @DisplayName("findContact: contact does exist")
    void findContactSuccess() {
        ContactService contactService = new ContactService();
        contactService.addContact("1234", "John", "Doe", "1234567890", "1234 Main St");
        assertDoesNotThrow(() -> contactService.findContact("1234"));
    }
}