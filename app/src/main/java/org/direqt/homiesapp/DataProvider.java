package org.direqt.homiesapp;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Location;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by leonk on 13/03/2016.
 */
public final class DataProvider {
    public static List<Contact> contactList = new ArrayList<>();
    public static Map<String, Contact> contactMap = new HashMap<>();


    static {
        addContact("trump", new Contact("trump", "Donald", "Trump", "0618886777"
                , "Not Washington DC", R.drawable.trump));
        addContact("bush", new Contact("bush", "George W.", "Bush", "0618886777"
                , "Not the White House anymore", R.drawable.bush));
        addContact("washington", new Contact("washington", "George", "Washington", "0618886777"
                , "Coffin", R.drawable.washington));
        addContact("kennedy", new Contact("kennedy", "John F.", "Kennedy", "0618886777"
                , "Different coffin", R.drawable.kennedy));
        addContact("obama", new Contact("obama", "Barack", "Obama", "0618886777"
                , "Sort of in the White House", R.drawable.obama));
    }

    private static void addContact(String key, Contact c) {
        contactList.add(c);
        contactMap.put(key, c);
    }
}
