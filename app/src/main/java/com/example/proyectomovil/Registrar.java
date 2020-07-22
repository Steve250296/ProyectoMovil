package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

import dao.ConexionSqlHelper;
import dao.daoUsuario;
import entidades.Usuario;
import utilidades.utiles;

public class Registrar extends AppCompatActivity {

EditText ci,password,nombre,apellido,user;
Button btnRegistrar;
daoUsuario daoUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        user=(EditText) findViewById(R.id.campoUsuario);
        password=(EditText) findViewById(R.id.campoPassword);
        ci=(EditText) findViewById(R.id.ciUsuarioCampo);
        nombre=(EditText) findViewById(R.id.campoNombreUsuario);
        apellido=(EditText) findViewById(R.id.campoApellidoUsuario);

        btnRegistrar=(Button)findViewById(R.id.btnRegistrar);
        daoUser= new daoUsuario(this);


    }




    public void registrarUsuario(View view){
        Usuario usuario=new Usuario();
        usuario.setUsuario(user.getText().toString());
        usuario.setPassword(password.getText().toString());
        usuario.setCi(ci.getText().toString());
        usuario.setNombre(nombre.getText().toString());
        usuario.setApellido(apellido.getText().toString());

        if(!usuario.isNull()){
            Toast.makeText(this,"CAMPOS VACIOS!!", Toast.LENGTH_SHORT).show();

        }else if(daoUser.registrarUsuario(usuario)){
            Toast.makeText(this,"REGISTRO EXISTOSO", Toast.LENGTH_LONG).show();
            Intent intent= new Intent(this,Login1.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);// CREA UN FLUJO CORRECTO ENTRE ACTIVIDADES

            startActivity(intent);

        }else
        {
            Toast.makeText(this,"USUARIO YA EXISTENTE", Toast.LENGTH_SHORT).show();
        }
    }





}
