package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SipnosisPeliculas extends AppCompatActivity {
TextView detalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sipnosis_peliculas);

        String sipnosis="";

        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            sipnosis=extras.getString("sipnosis");
        }


        detalle=(TextView)findViewById(R.id.sipnosis);
        detalle.setText(sipnosis);

    }
}
