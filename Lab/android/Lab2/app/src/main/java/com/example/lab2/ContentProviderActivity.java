package com.example.lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class ContentProviderActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CONTACT = 717;
    ArrayList<Contact> arrayList;
    RecyclerView recyclerViewContact;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        setControl();
        loadAdapter();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE_CONTACT);
        else
            loadContact();
    }

    private void loadAdapter() {
        arrayList=new ArrayList<>();

        contactAdapter = new ContactAdapter(this, R.layout.item_contact, arrayList);
        recyclerViewContact.setAdapter(contactAdapter);
        recyclerViewContact.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

    private void setControl() {
        recyclerViewContact = findViewById(R.id.recylclerviewContact);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_CONTACT && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            loadContact();
    }

    @SuppressLint("Range")
    private void loadContact() {
        Uri uri = Uri.parse("content://contacts/people");
        //hoặc uri là ContactsContract.Contacts.CONTENT_URI
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        while (cursor.moveToNext()) {
            Contact contact = new Contact();
            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            contact.setName(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)) + ", ID=" + id);

            //read phone
            Cursor cursorPhone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null
                    , ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + id
                    , null, null);
            String phone = "";
            while (cursorPhone.moveToNext()) {
                int phoneType = cursorPhone.getInt(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
                switch (phoneType) {
                    case ContactsContract.CommonDataKinds.Phone
                            .TYPE_MOBILE:
                        phone += "Mobile: " + cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        break;
                    case ContactsContract.CommonDataKinds.Phone
                            .TYPE_HOME:
                        phone += "\nHome: " + cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        break;

                }
            }
            contact.setPhone(phone);
            cursorPhone.close();
            arrayList.add(contact);

        }
        cursor.close();
        contactAdapter.notifyDataSetChanged();
    }
}