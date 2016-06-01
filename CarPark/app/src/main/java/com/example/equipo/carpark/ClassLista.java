package com.example.equipo.carpark;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.equipo.carpark.adapters.AdapterRegistro;
import com.example.equipo.carpark.db.ReservaDao;
import com.example.equipo.carpark.models.Actividad;
import com.example.equipo.carpark.util.A;
import com.example.equipo.carpark.util.C;

import java.util.ArrayList;
import java.util.List;

public class ClassLista extends AppCompatActivity {//implements   {// DialogInterface.OnClickListener, AdapterView.OnItemClickListener {
    ListView listaA;
    AdapterRegistro adapterA;
    //private Button boton
    List<Actividad> data;
    //ListView list;
    ReservaDao dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_lista);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //base de datos
        data = new ArrayList<>();
        dao = new ReservaDao(this);


       //
        listaA = (ListView) findViewById(R.id.listaRegistros);

        //adapter = new AdapterRegistro(getLayoutInflater(), data);
        adapterA = new AdapterRegistro(this, A.actividades);
        listaA.setAdapter(adapterA);


        listaA.setAdapter(adapterA);

        // listaA.setOnItemClickListener(this);

        registerForContextMenu(listaA);
        listar();

    }

    private void listar() {
        A.actividades.clear();
        data = dao.getAll();

        if (data.size() == 0) {
            Actividad r = new Actividad();
            r.setCodigo("123");
            dao.insert(r);
            data = dao.getAll();
        }
        for(Actividad r: data){

            A.actividades.add(r);

        }

        adapterA.notifyDataSetChanged();

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        listar();
        //adapterA.notifyDataSetChanged();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    /*@Override
    public void onClick(DialogInterface dialog, int which) {

    }/*

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       /* Intent intent = new Intent(this, ClassCodigo.class);
        intent.putExtra(ClassCodigo.POSICION, position);
        startActivity(intent);

             }*/



}
