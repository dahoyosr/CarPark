package com.example.equipo.carpark.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.equipo.carpark.models.Actividad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 28/05/2016.
 */
public class ReservaDao {

    SQLiteDatabase db;
    static final String CODIGO= "codigo";
    static final String TABLE = "reserva";
    static final String C_ID = "_id";
    public ReservaDao(Context context){
       DataBaseHelper helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
       }

    public  void  insert(Actividad actividad){
        ContentValues cv = new ContentValues();
         cv.put(CODIGO, actividad.getCodigo());
         long id = db.insert(TABLE, null, cv);
         actividad.setId(id);

    }

    public  void  update(Actividad actividad){
        ContentValues cv = new ContentValues();
        cv.put(CODIGO, actividad.getCodigo());
        db.update(TABLE, cv, "_id = ?", new String[]{actividad.getId() + ""});

    }

    public  void  delete(long id){
        db.delete(TABLE, "_id = " + id, null);

    }

    public  Actividad  getById(long id){
        Cursor c = db.rawQuery("SELECT * FROM actividad WHERE _id="+id, null);
        return cursorToActividad(c);

    }
    public List<Actividad> getAll(){
        Cursor c = db.rawQuery("SELECT * FROM reserva",null);
        return cursorToList(c);
    }

    private Actividad cursorToActividad(Cursor c) {
        Actividad actividad = null;
        if (c.moveToNext()) {
            actividad = new Actividad();
            actividad.setId(c.getLong(0));
            actividad.setCodigo(c.getString(1));
           }
         return actividad;
      }

    private List<Actividad> cursorToList(Cursor c){
        List<Actividad> data = new ArrayList<>();
        for ( int i = 0; i< c.getCount(); i++){
            Actividad a = cursorToActividad(c);
            data.add(a);

        }
        return  data;
    }
 }
