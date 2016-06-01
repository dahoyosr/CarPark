package com.example.equipo.carpark.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 28/05/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="reserva.db";
    public static int VERSION = 1;
    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("CREATE TABLE reserva(_id INTEGER  PRIMARY KEY AUTOINCREMENT"+", codigo VARCHAR"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE reserva");
        onCreate(db);

    }
}
