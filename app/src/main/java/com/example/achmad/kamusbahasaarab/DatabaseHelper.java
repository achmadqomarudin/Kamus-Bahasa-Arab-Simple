package com.example.achmad.kamusbahasaarab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "employee_directory";
    protected Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            for (int i=0; i < HelperData.getData().size(); i++) {
                sqLiteDatabase.execSQL(HelperData.data.get(i));
            }
        } catch (Throwable t) {
            Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS employees");
        onCreate(sqLiteDatabase);
    }
}
