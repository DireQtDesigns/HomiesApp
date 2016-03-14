package org.direqt.homiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static String CONTACT_ID = "CONTACT_ID";
    public static List<Contact> contacts = DataProvider.contactList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] items = getResources().getStringArray(R.array.itemsList);
        //ArrayAdapter<String> itemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, items);
        //ListView listView = (ListView) findViewById(R.id.listView);
        //listView.setAdapter(itemAdapter);

        ContactListAdapter itemAdapter = new ContactListAdapter(this, R.layout.list_item, contacts);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                Contact contact = contacts.get(position);
                CONTACT_ID = contact.getId();
                i.putExtra(CONTACT_ID, contact.getId());
                startActivity(i);
            }
        });
    }
}
