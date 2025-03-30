package org.axel.yhteystietosovellus;

public class Contact {
    String firstName;
    String lastName;
    String  number;
    String contactGroup;
    String fullName;

    public Contact(String firstName, String lastName, String number, String contactGroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.contactGroup = contactGroup;
        this.fullName = firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNumber() {
        return number;
    }

    public String getContactGroup() {
        return contactGroup;
    }
}
