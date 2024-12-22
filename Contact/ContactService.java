import java.util.ArrayList;

public class ContactService {
    private final ArrayList<Contact> contacts = new ArrayList<>();

    /**
     * Add a new contact to the list of contacts.
     * <p>
     * Time complexity: O(n)
     * @param ID        The ID of the contact.
     * @param firstName The first name of the contact.
     * @param lastName  The last name of the contact.
     * @param phone     The phone number of the contact.
     * @param address   The address of the contact.
     * @see ContactServiceTest#addContactFailure()
     * @see ContactServiceTest#addContactSuccess()
     */
    public void addContact(String ID, String firstName, String lastName, String phone, String address) {
        Contact contact = new Contact(ID, firstName, lastName, phone, address);

        // Check if contact already exists by ID using the stream method and noneMatch method.
        assert contacts.stream().noneMatch(c -> c.getID().equals(ID)) : "Contact already exists";

        contacts.add(contact);
    }

    /**
     * Remove a contact from the list of contacts.
     * <p>
     * Time complexity: O(n)
     * @param ID The ID of the contact.
     * @see ContactServiceTest#removeContactFailure()
     * @see ContactServiceTest#removeContactSuccess()
     */
    public void removeContact(String ID) {
        Contact contact = findContact(ID);
        contacts.remove(contact);
    }

    /**
     * Find a contact by ID. This will NOT match by object reference.
     * <p>
     * Time complexity: O(n)
     * @param id The ID of the contact.
     * @return The contact with the given ID.
     * @see ContactServiceTest#findContactFailure()
     * @see ContactServiceTest#findContactSuccess()
     */
    public Contact findContact(String id) {
        for (Contact contact : contacts) {
            if (contact.getID().equals(id)) {
                return contact;
            }
        }
        throw new IllegalArgumentException("Contact not found");
    }

    /**
     * Update a contact with new information.
     * <p>
     * Time complexity: O(n)
     * @param ID        The ID of the contact.
     * @param firstName The first name of the contact.
     * @param lastName  The last name of the contact.
     * @param phone     The phone number of the contact.
     * @param address   The address of the contact.
     * @see ContactServiceTest#updateContactSuccess()
     * @see ContactServiceTest#updateContactFailure()
     */
    public void updateContact(String ID, String firstName, String lastName, String phone, String address) {
        Contact contact = findContact(ID);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }
}