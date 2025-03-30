package org.axel.yhteystietosovellus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private ArrayList<Contact> contacts;

    public ContactAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contactviewholder, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);

        holder.contactNameText.setText(contact.getFullName());
        holder.contactNumberText.setText(contact.getNumber());
        holder.contactGroupText.setText(contact.getContactGroup());

        holder.contactNumberText.setVisibility(View.GONE);
        holder.contactGroupText.setVisibility(View.GONE);

        holder.contactDetailsButton.setOnClickListener(v -> {
            if (holder.contactNumberText.getVisibility() == View.VISIBLE) {
                holder.contactNumberText.setVisibility(View.GONE);
                holder.contactGroupText.setVisibility(View.GONE);
            } else {
                holder.contactNumberText.setVisibility(View.VISIBLE);
                holder.contactGroupText.setVisibility(View.VISIBLE);
            }
        });

        holder.contactDeleteButton.setOnClickListener(v -> {
            contacts.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, contacts.size());
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
