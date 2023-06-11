package com.example.tuan8;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DemoContentProdvider extends ContentProvider {

    private static final String AUTHORITY = DemoContentProdvider.class.getCanonicalName();

    private static final UriMatcher URI_MATCHER  = new UriMatcher(UriMatcher.NO_MATCH);
    static {

        URI_MATCHER.addURI(AUTHORITY, "demo", 1);

    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int code = URI_MATCHER.match(uri);
        switch (code) {
            case 1:
                MatrixCursor cursor = new MatrixCursor(new String[] {"ID", "Name"});
                cursor.addRow(new Object[] {1, "Trung"});
                cursor.addRow(new Object[] {2, "Huy"});
                return cursor;
        }

        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
