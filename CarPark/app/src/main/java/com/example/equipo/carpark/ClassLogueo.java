package com.example.equipo.carpark;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ClassLogueo extends AppCompatActivity implements View.OnClickListener {

    Button btnEntrar;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_logueo);

        preferences = getSharedPreferences("preferencias",MODE_PRIVATE);

        boolean login = preferences.getBoolean("login",false);
        if(login){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        setContentView(R.layout.activity_class_logueo);

         btnEntrar = (Button) findViewById(R.id.ingresar);
       btnEntrar.setOnClickListener(this);




       }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean("login", true);
        edit.commit();
        finish();

    }
}
