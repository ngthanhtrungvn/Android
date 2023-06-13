package com.example.truyencuoi.ContentProdvider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;

public class CDProdvider extends ContentProvider {
    static final String AUTHORITY = CDProdvider.class.getCanonicalName();
    static final String CONTENT_PATH =  "backupdata";
    static final String URL = "content://" + AUTHORITY + "/" + CONTENT_PATH;
    static final Uri CONTENT_URI = Uri.parse(URL);

    private static HashMap<String, String> CD_PROJECTION_MAP;
    static final String _ID = "id";
    static final String _NAME = "name";
    static final String _IMAGE = "image";


    static final int URI_ALL_ITEMS_CODE = 1;
    static final int URI_ONE_ITEM_CODE = 2;

    static final UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, CONTENT_PATH, URI_ALL_ITEMS_CODE);
        uriMatcher.addURI(AUTHORITY, CONTENT_PATH + "/#", URI_ONE_ITEM_CODE);
    }

    /**
     * Database specific constant declarations
     */

    private SQLiteDatabase db;
    static final String DATABASE_NAME = "truyencuoi_sqlite.db";
    static final String TABLE_NAME = "tblTopics";
    static final int DATABASE_VERSION = 1;

    public class DatabaseHelper  extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "truyencuoi_sqlite.db";
        private static final String TABLE_NAME = "tblTopics";
        public DatabaseHelper (Context context) {
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

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return (db == null)? false:true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection,
                        String selection,String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLE_NAME);

        switch (uriMatcher.match(uri)) {
            case URI_ALL_ITEMS_CODE:
                qb.setProjectionMap(CD_PROJECTION_MAP);
                break;

            case URI_ONE_ITEM_CODE:
                qb.appendWhere( _ID + "=" + uri.getPathSegments().get(1));
                break;

            default:
        }

        if (sortOrder == null || sortOrder == ""){
            sortOrder = _NAME;
        }

        Cursor c = qb.query(db,	projection,	selection,
                selectionArgs,null, null, sortOrder);

        c.setNotificationUri(getContext().getContentResolver(), uri);

        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)){
            case URI_ALL_ITEMS_CODE:
                return "vnd.android.cursor.dir/vnd.example.backupdata";
            case URI_ONE_ITEM_CODE:
                return "vnd.android.cursor.item/vnd.example.backupdata";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long rowID = db.insert(TABLE_NAME, "", contentValues);

        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }

        throw new SQLException("Failed to add a record into " + uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)){
            case URI_ALL_ITEMS_CODE:
                count = db.delete(TABLE_NAME, selection, selectionArgs);
                break;

            case URI_ONE_ITEM_CODE:
                String id = uri.getPathSegments().get(1);
                count = db.delete(TABLE_NAME, _ID +  " = " + id +
                        (!TextUtils.isEmpty(selection) ? "AND (" + selection + ')' : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values,
                      String selection, String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case URI_ALL_ITEMS_CODE:
                count = db.update(TABLE_NAME, values, selection, selectionArgs);
                break;

            case URI_ONE_ITEM_CODE:
                count = db.update(TABLE_NAME, values,
                        _ID + " = " + uri.getPathSegments().get(1) +
                                (!TextUtils.isEmpty(selection) ? "AND (" +selection + ')' : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri );
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
