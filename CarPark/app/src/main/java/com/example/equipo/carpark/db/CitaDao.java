package com.example.equipo.carpark.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.equipo.carpark.models.Actividad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 30/05/2016.
 */
public class CitaDao {

    SQLiteDatabase db;
    static final String CODIGO= "codigo";
    static final String NOMBRE= "nombre";
    static final String CEDULA= "cedula";
    static final String FECHA= "fecha";
    static final String TABLE = "cita";

    public CitaDao(Context context){
        DataBaseCita helper = new DataBaseCita(context);
        db = helper.getWritableDatabase();
    }


}
