package org.axel.yhteystietosovellus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private RecyclerView contactRecyclerView;
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        contactRecyclerView = findViewById(R.id.ListContactsRV);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        contactAdapter = new ContactAdapter(ContactStorage.getInstance().getContacts());
        contactRecyclerView.setAdapter(contactAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        contactAdapter.notifyDataSetChanged();
    }

    public void openAddContactActivity(View view) {
        Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
        startActivity(intent);
    }

    public void sortAlphabetically(View view) {
        Collections.sort(ContactStorage.getInstance().getContacts(),
                (c1, c2) -> c1.getFullName().compareToIgnoreCase(c2.getFullName()));
        contactAdapter.notifyDataSetChanged();
    }

    public void sortByGroup(View view) {
        ArrayList<Contact> contacts = ContactStorage.getInstance().getContacts();

        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact c = iterator.next();
            if (c.getContactGroup() == null) {
                c.contactGroup = "";
            }
        }

        Collections.sort(contacts, (c1, c2) -> {
            if (c1.getContactGroup() == null) return 1;
            if (c2.getContactGroup() == null) return -1;
            return c1.getContactGroup().compareToIgnoreCase(c2.getContactGroup());
        });

        contactAdapter.notifyDataSetChanged();
    }
}
