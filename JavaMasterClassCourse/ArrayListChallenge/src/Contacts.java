public class Contacts {
    private String phoneNumber;
    private String contactName;

    public Contacts(String phoneNumber, String contactName) {
        this.phoneNumber = phoneNumber;
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
    return phoneNumber;
}

    public String getContactName() {
        return contactName;
    }

    public static Contacts createContact(String name, String phoneNumber) {
        return new Contacts(name, phoneNumber);
    }
}
