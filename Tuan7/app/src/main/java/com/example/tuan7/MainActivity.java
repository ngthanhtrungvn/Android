package com.example.tuan7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import org.bson.types.ObjectId;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createPhoneTable();

        Log.e("Main Activity", "On Create");
        Realm r = Realm.getDefaultInstance();

        write(this, "demo_file.txt", "demo_text");
//        requestPermissions(
//                new String[]{
//                        Manifest.permission.READ_EXTERNAL_STORAGE,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE
//                },
//                123
//        );


        r.beginTransaction();

        SinhVienModel sv1 = r.createObject(SinhVienModel.class, new ObjectId());
        sv1.setName("PHUC");
        r.commitTransaction();

        SinhVienModel sv2 = r.createObject(SinhVienModel.class, new ObjectId());
        sv2.setName("Trung");
        r.commitTransaction();

        SinhVienModel sv = r.createObject(SinhVienModel.class, new ObjectId());
        sv.setName("PHUC");
        r.commitTransaction();

        RealmResults<SinhVienModel> svs = r.where(SinhVienModel.class).findAll();
        for (SinhVienModel sv3 :svs) {
            Log.e(getClass().getCanonicalName(), "ID: " + sv.getId().toString());
            Log.e(getClass().getCanonicalName(), "ID: " + sv.getName());
        }

//        RealmResults<SinhVienModel> svs = r.where(SinhVienModel.class)
//                .containsValue("name", "Hung")
//                .findAll();
//        for (SinhVienModel sv :svs) {
//            Log.e(getClass().getCanonicalName(), "ID: " + sv.getId().toString());
//            Log.e(getClass().getCanonicalName(), "ID: " + sv.getName());
//        }


        SharedPreferences sr = getSharedPreferences("demo_sr", MODE_PRIVATE);
        SharedPreferences.Editor editor = sr.edit();
        editor.putString("demo_string", "text");
        HashSet<String> setString = new HashSet<>();
        setString.add("One");
        setString.add("Two");
        setString.add("Three");
        editor.putStringSet("demo_set", setString);
        editor.commit();

        Log.e("Doc tu Sr", sr.getString("demo_string", "default_value"));

    }

    private SQLiteDatabase openExternalDB() {
        String dbName = "phonebook.edb";
        String path = Environment.getExternalStorageDirectory().getPath()
                + "/" + dbName;
        return SQLiteDatabase.openDatabase(
                path,
                null,
                SQLiteDatabase.CREATE_IF_NECESSARY
        );
    }
        private void createPhoneTable() {
            SQLiteDatabase db = openOrCreateDatabase("demo_sqlite.db", MODE_PRIVATE, null);
            String sql = "create table if not exists tblPhonebook(id integer PRIMARY KEY autoincrement, name text, phone text);";
            db.execSQL(sql);
            db.close();
        }
    private void insert(String name, String phone) {
        SQLiteDatabase db = openOrCreateDatabase("demo_db.db", MODE_PRIVATE, null);
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("phone", phone);
        db.insert("tblPhonebook", null, cv);
        db.close();
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 123) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                writeExternalFile("demo_external.txt", "demo_external value");
            }
        }
    }

    public static void writeExternalFile(String fileName, String message) {
        String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath() + "/" + fileName;
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filePath));
            writer.println(message);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(Context context, String fileName, String message) {
        File file = new File(context.getFilesDir(), fileName);
        try {
            PrintWriter pw = new PrintWriter(
                    new FileWriter(file)
            );
            pw.println(message);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
