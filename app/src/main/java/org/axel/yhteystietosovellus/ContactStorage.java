package org.axel.yhteystietosovellus;

import java.util.ArrayList;

public class ContactStorage {
    private static ContactStorage instance;
    private ArrayList<Contact> contacts = new ArrayList<>();
    private ContactStorage() {}
    public static ContactStorage getInstance() {
        if (instance == null) {
            instance = new ContactStorage();
        }
        return instance;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(int contactID) {
        contacts.remove(contactID);
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
