package org.direqt.homiesapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.media.Image;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by leonk on 13/03/2016.
 */
public class ContactListAdapter extends ArrayAdapter<Contact> {

    private List<Contact> contacts;

    public ContactListAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        contacts = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Contact contact = contacts.get(position);
        TextView firstName = (TextView) convertView.findViewById(R.id.firstName);
        firstName.setText(contact.getFirstName());
        TextView lastName = (TextView) convertView.findViewById(R.id.lastName);
        lastName.setText(contact.getLastName());
        TextView phoneView = (TextView) convertView.findViewById(R.id.phone);
        phoneView.setText(contact.getPhoneNumber());
        TextView addressView = (TextView) convertView.findViewById(R.id.address);
        addressView.setText(contact.getAddress().toString());
        ImageView i = (ImageView) convertView.findViewById(R.id.imageView);
        i.setImageResource(contact.getImage());
        i.setAdjustViewBounds(true);
        ImageView call = (ImageView) convertView.findViewById(R.id.callBtn);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contacts.get(position).getPhoneNumber()));
                Log.d("Adapter", "Setting call intent");
                try {
                    getContext().startActivity(callIntent);
                } catch (SecurityException e) {
                    Log.e("Adapter", e.toString());
                }
            }
        });
        return convertView;
    }
}
