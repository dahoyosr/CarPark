package com.example.equipo.carpark;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.equipo.carpark.adapters.carparkadapters;
import com.example.equipo.carpark.models.parqueaderos;
import com.example.equipo.carpark.util.C;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener{//,AdapterView.OnItemClickListener{

    ListView list;
    carparkadapters adapter;
    //List<parqueaderos> data;
    //String milisegundos;
    //String progreso;
    SharedPreferences preferences;
    SharedPreferences colores;
    private Button miboton;

    //public static final String POSICION="pos";
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list);
        C.data = new ArrayList<>();
        adapter = new carparkadapters(this, C.data);


        list.setAdapter(adapter);

        registerForContextMenu(list);

        loadparqueaderos();
        preferences =  getSharedPreferences("preferencias", MODE_PRIVATE);

        colores = getSharedPreferences("prefere",MODE_PRIVATE);
        boolean prefe = preferences.getBoolean("prefe",false);
        //boolean color = preferences.getBoolean("color",false);
       /* findViewById(R.id.list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ClassGenerarCita.class));
            }
        });*/

         miboton = (Button) findViewById(R.id.colores);

    }




    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
    }
    //CREACION DE LA LISTA DE PARQUEDEROS
    private void loadparqueaderos() {

        parqueaderos p1 = new parqueaderos();
        p1.setNombre("parqueadero radio super");
        p1.setDireccion("calle 22#10b77");
        //p1.setPrecio("Hora: 2000$");

        p1.setImgUrl("http://radiosuperpopayan.com/content/wp-content/uploads/2015/06/PARQUEADERO.jpg");

        parqueaderos p2 = new parqueaderos();
        p2.setNombre("universidad autonoma ");
        p2.setDireccion("calle 5#03-44");
        //p2.setPrecio("Hora: 3000$");

        p2.setImgUrl("http://www.periodicolacampana.com/wp-content/uploads/2015/12/foto-2-2.jpg");

        parqueaderos p3 = new parqueaderos();
        p3.setNombre("exito vecino");
        p3.setDireccion("calle 4#5-66");
        //p1.setPrecio("Hora: 2500$");

        p3.setImgUrl("http://www.hotelesdann.com/avenida19/wp-content/uploads/sites/2/2014/02/parqueadero1.jpg");

        C.data.add(p1);
        C.data.add(p2);
        C.data.add(p3);

        adapter.notifyDataSetChanged();
    }
    //CODIGO PARA EL MENU DE AGREGAR Y AYUDA
   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opc, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //CODIGO PARA CERRAR SECION
      @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        switch (item.getItemId()){
            /*case R.id.action_add:
                Intent intent = new Intent(this,AddPark.class);
                startActivity(intent);
                break;*/

            case R.id.cerrarsecion:
                SharedPreferences.Editor editor =  preferences.edit();
                editor.putBoolean("login", false);
                editor.commit();

                Intent intent = new Intent(this, ClassLogueo.class);
                startActivity(intent);
                finish();

        }
        return super.onOptionsItemSelected(item);
    }

    public void pasarlista(View v){
        Intent siguiente=new Intent(this,ClassLista.class);
        startActivity(siguiente);
    }

   public void colors(View v){
       SharedPreferences.Editor edit = colores.edit();
       edit.putBoolean("color", true);
       edit.commit();
   }

    public void pasarActividad(View v){

        Intent siguiente=new Intent(this,ClassGenerarCita.class);
         startActivity(siguiente);
    }


     //CODIGO PARA EL MENU DE ELIMINAR Y EDITAR
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_ctx, menu);
        super.onCreateContextMenu(menu, v, menuInfo);

        //final int pos= getIntent().getIntExtra(POSICION,0);
        //final String POSICION = "pos";


    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        pos = info.position;


        switch (item.getItemId()){

            case R.id.action_delete:
                showAlerteDelete();

                break;
            case R.id.action_edit:

                break;
        }
        return super.onContextItemSelected(item);


    }
 public void showAlerteDelete() {
        AlertDialog alert = new AlertDialog.Builder(this)
                .setTitle("Eliminar")
                .setMessage("Esta seguro de Eliminar")

                .setPositiveButton("Aceptar", this)
                .setNegativeButton("Cancelar",this)
                .create();
        alert.show();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which == DialogInterface.BUTTON_POSITIVE){
            C.data.remove(pos);
            adapter.notifyDataSetChanged();

        }

    }

    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //if(which == DialogInterface.BUTTON_POSITIVE){
            final parqueaderos par= C.data.remove(position);
            adapter.notifyDataSetChanged();

        //}
    }*/


}
