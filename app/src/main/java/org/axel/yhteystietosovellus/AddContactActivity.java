package org.axel.yhteystietosovellus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {
    private EditText firstNameInput, lastNameInput, numberInput;
    private RadioGroup groupInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        firstNameInput = findViewById(R.id.FirstNameEdit);
        lastNameInput = findViewById(R.id.LastNameEdit);
        numberInput = findViewById(R.id.PhoneNumberEdit);
        groupInput = findViewById(R.id.ContactTypeRadioGroup);
    }

    public void addContact(View view) {
        String firstName = firstNameInput.getText().toString();
        String lastName = lastNameInput.getText().toString();
        String number = numberInput.getText().toString();

        int selectedID = groupInput.getCheckedRadioButtonId();
        String group = null;
        if (selectedID != -1) {
            RadioButton selectedRadioButton = findViewById(selectedID);
            group = selectedRadioButton.getText().toString();
        }

        Contact newContact = new Contact(firstName, lastName, number, group);
        ContactStorage.getInstance().addContact(newContact);

        finish();
    }

    public void goBack(View view) {
        finish();
    }
}
