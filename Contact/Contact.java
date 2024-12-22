public class Contact {
    private String ID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String ID, String firstName, String lastName, String phone, String address) {
        setID(ID);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {

        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        } else if (address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be longer than 30 characters");
        }

        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        } else if (firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be longer than 10 characters");
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        } else if (lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be longer than 10 characters");
        }

        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {

        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be null or empty");
        }

        phone = phone.replaceAll("[^0-9]", "");

        if (phone.length() != 10) {
            throw new IllegalArgumentException("Phone number must be 10 digits long");
        }

        this.phone = phone;
    }

    public String getID() {
        return ID;
    }

    private void setID(String ID) {

        if (ID == null || ID.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        } else if (ID.length() > 10) {
            throw new IllegalArgumentException("ID cannot be longer than 10 characters");
        }

        this.ID = ID;
    }
}