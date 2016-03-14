package org.direqt.homiesapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String contactId = getIntent().getStringExtra(MainActivity.CONTACT_ID);
        final Contact c = DataProvider.contactMap.get(contactId);
        Log.d("onCreate", "rofltest");

        TextView firstNameView = (TextView) findViewById(R.id.firstNameView);
        TextView lastNameView = (TextView) findViewById(R.id.lastNameView);
        final EditText addressField = (EditText) findViewById(R.id.addressField);
        EditText phoneField = (EditText) findViewById(R.id.phoneField);
        ImageView image = (ImageView) findViewById(R.id.imageView2);
        firstNameView.setText(c.getFirstName());
        lastNameView.setText(c.getLastName());
        addressField.setText(c.getAddress());
        phoneField.setText(c.getPhoneNumber());
        image.setImageResource(c.getImage());
        addressField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                c.setAddress(s.toString());
                Log.d("AboutActivity", "Setting address to " + s.toString());
            }
        });

        phoneField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                c.setPhoneNumber(s.toString());
                Log.d("AboutActivity", "Setting address to "+s.toString());
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
