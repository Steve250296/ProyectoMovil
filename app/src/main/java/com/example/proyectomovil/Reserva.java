package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Reserva extends AppCompatActivity {
EditText et_ci, et_nombre, et_apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_reserva );
        et_ci=findViewById( R.id.etCedu );
        et_nombre=findViewById( R.id.etNom );
        et_apellido=findViewById( R.id.etApellido );
    }

    public void Enviar(View v){
        String cedula=et_ci.getText().toString();
        String nombre=et_nombre.getText().toString();
        String apellido=et_apellido.getText().toString();
        if(cedula.equals( "" ) || nombre.equals( "" ) || apellido.equals( "" )){
            Toast.makeText(this, "Campos Vacíos", Toast.LENGTH_SHORT).show();
        }
        else{


            Intent enviar=new Intent(Reserva.this, Reserva_Peliculas.class);
            enviar.putExtra("cedula", cedula);
            enviar.putExtra("nombre", nombre);
            enviar.putExtra("apellido", apellido);
            startActivity( enviar );
            et_ci.setText("");
            et_nombre.setText("");
            et_apellido.setText( "" );
            Toast.makeText(this, "Datos Ingresados, elija la película", Toast.LENGTH_SHORT).show();

        }
    }
}
