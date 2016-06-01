package com.example.equipo.carpark;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.equipo.carpark.adapters.carparkadapters;
import com.example.equipo.carpark.models.parqueaderos;
import com.example.equipo.carpark.util.C;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;

public class AddPark extends AppCompatActivity {//implements //View.OnClickListener {


    private static final int REQUEST_IMAGE_CAPTURE = 1;

    public  void dispatchTakePictureIntent ()  {
        Intent takePictureIntent =  new  Intent ( MediaStore . ACTION_IMAGE_CAPTURE );
        if  ( takePictureIntent . resolveActivity ( getPackageManager ())  !=  null )  {
            startActivityForResult ( takePictureIntent , REQUEST_IMAGE_CAPTURE );
        }
    }
    //CODIGO PARA CAPTURAR Y GUARDAR LOS NUEVOS PARQUEADEROS

    private EditText nombre, direccion;
    private ImageView  mImageView;
    private Button save;
    //String foto;
    // carparkadapters adapter;
    // ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_add_park);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (EditText) findViewById(R.id.nombre);
        direccion = (EditText) findViewById(R.id.direccion);
         mImageView = (ImageView) findViewById(R.id.mImageView);
        save = (Button) findViewById(R.id.abtnsave);

       // save.setOnClickListener(this);
    }

    public void AgregarFoto(View v){
        Intent galeria = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(galeria, 2);

    }

   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       
       if  ( requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK )  {
           Bundle extras = data . getExtras ();
           Bitmap imageBitmap =  ( Bitmap ) extras . get ( "data" );
           mImageView.setImageBitmap ( imageBitmap );
       }
   }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    public void salvar(View v) {
        String n = nombre.getText().toString();
        String d = direccion.getText().toString();


        parqueaderos p = new parqueaderos();
        p.setNombre(n);
        p.setDireccion(d);

        C.data.add(p);
        finish();

    }




   /* @Override
    public void onClick(View v) {


        String n = nombre.getText().toString();
        String d = direccion.getText().toString();


        parqueaderos p = new parqueaderos();
        p.setNombre(n);
        p.setDireccion(d);

        C.data.add(p);
        finish();
    }*/
}
