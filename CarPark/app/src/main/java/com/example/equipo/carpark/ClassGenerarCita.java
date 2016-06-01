package com.example.equipo.carpark;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ClassGenerarCita extends AppCompatActivity {
   // String milisegundos;
   // String progreso;
    EditText nombre,cedula,hora;
    Button genCod;
    public static final int NOTIFICACION_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class__generar__cita);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (EditText) findViewById(R.id.nombre);
        cedula = (EditText) findViewById(R.id.cedula);
        hora = (EditText) findViewById(R.id.hora);
        genCod = (Button) findViewById(R.id.Button1);



        genCod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = nombre.getText().toString();
                String ced = cedula.getText().toString();
                String h = hora.getText().toString();

                if (input.equals("") || ced.equals("") || h.equals("")){

                    Toast.makeText(ClassGenerarCita.this, "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
                }else {

                    Intent siguiente = new Intent(ClassGenerarCita.this, ClassCodigo.class);
                    startActivity(siguiente);
                }


            }
        });




    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    public void onClick (View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com/index.html"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        //construccion de la notificacion
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_notificacion);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_auto));
        builder.setContentTitle("Notificacion Basica");
        builder.setContentText("tu reserva en el parqueadero inicia en cinco minutos");
        builder.setSubText("toca para mirar publicacion");

        //enviar notificacion

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICACION_ID,builder.build());

    }
}
