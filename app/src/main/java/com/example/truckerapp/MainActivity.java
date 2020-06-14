package com.example.truckerapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.example.truckerapp.util.GPSTracker;

public class MainActivity extends Activity {

    private Button btnAbrirDicas;
    private Button btnAlertSOS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbrirDicas = (Button)findViewById(R.id.btnAbrirDicas);
        btnAlertSOS = (Button)findViewById(R.id.btnSOS_mainActivity);

        btnAlertSOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GPSTracker gps = new GPSTracker(MainActivity.this);

                // verifica ele
                if (gps.canGetLocation()) {
                    // passa sua latitude e longitude para duas variaveis
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    // e mostra no Toast
                    Toast.makeText(getApplicationContext(), "Alerta Enviado para a sua localização - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }
            }
        });


        btnAbrirDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irParaDicasActivity = new Intent(MainActivity.this, DicasActivity.class);
                startActivity(irParaDicasActivity);
            }
        });



    }
}
