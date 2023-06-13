package com.example.truyencuoi.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.truyencuoi.model.topics;

public class dpHelper_Topic extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "truyencuoi_sqlite.db";
    private static final String TABLE_NAME = "tblTopics";
    public dpHelper_Topic(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    public void QueryData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public void deleteTopic(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,  "id = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "create table if not exists "+TABLE_NAME+"(id integer PRIMARY KEY autoincrement, name text, image blob);";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(sqLiteDatabase);
    }
}
