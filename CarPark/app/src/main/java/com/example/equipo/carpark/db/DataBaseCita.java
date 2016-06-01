package com.example.equipo.carpark.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 30/05/2016.
 */
public class DataBaseCita extends SQLiteOpenHelper {
    public static final String DB_NAME="cita.db";
    public static int VERSION = 1;
    public DataBaseCita(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE reserva(codigo STRING AUTOINCREMET PRIMARY KEY"
                + ",nombre VARCHAR"
                +",cedula STRING"
                +",hora DATE"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE cita");
        onCreate(db);

    }
}
