package com.example.equipo.carpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.equipo.carpark.adapters.AdapterRegistro;
import com.example.equipo.carpark.db.ReservaDao;
import com.example.equipo.carpark.models.Actividad;
import com.example.equipo.carpark.util.A;
import com.example.equipo.carpark.util.C;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassCodigo extends AppCompatActivity implements View.OnClickListener {
    private TextView inputcodigo;
    private Button btnguardar;
    //List<Actividad> data;
    ListView listaA;
    ReservaDao dao;
//    AdapterRegistro adapterA;
    ListView list;
    AdapterRegistro adapterA;
    //public static final String POSICION = "pos";

   // AdapterRegistro adapterR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class__codigo);

        if(A.actividades == null)
        A.actividades= new ArrayList<>();

        //codigo bd
        /*list = (ListView) findViewById(R.id.listaRegistros);
        A.actividades = new ArrayList<>();
        adapterA = new AdapterRegistro(this, A.actividades);
        list.setAdapter(adapterA);*/

        inputcodigo = (TextView) findViewById(R.id.input_codigo);
        btnguardar=(Button) findViewById(R.id.btn_guardar);
        //ArrayList listaA = new ArrayList<>();
        btnguardar.setOnClickListener(this);
       // final int pos = getIntent().getIntExtra(POSICION, 0);
        //final String POSICION = "pos";

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //CODIGO PARA GENERAR NUMEROS ALEATORIOS
       final Random myRandom = new Random(6);



       Button buttonGenerate = (Button)findViewById(R.id.button1);
       final TextView textGenerateNumber = (TextView)findViewById(R.id.input_codigo);

        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                textGenerateNumber.setText(String.valueOf(myRandom.nextInt()));
            }
        });
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View v) {
        String nomb = inputcodigo.getText().toString();

        if (nomb.equals("")){
            Toast.makeText(this, "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
        }else {
            Actividad r = new Actividad();
            r.setCodigo(nomb);
            A.actividades.add(r);
            dao = new ReservaDao(this);
            dao.insert(r);

        }
        Intent intent = new Intent(this, ClassLista.class);
        startActivity(intent);
        finish();

        }


  }


