package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import dao.ConexionSqlHelper;
import dao.daoUsuario;
import entidades.Usuario;
import utilidades.utiles;

public class Login extends AppCompatActivity {
    ConexionSqlHelper conn;
    EditText user,password;
    daoUsuario daoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      //  View decorView = getWindow().getDecorView();//SIRVE PARA QUITAR LA BARRA DE ABAJO DE ANDORID POR DEFECTO
        // PERO SOLO POR UN MOMENTO
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
       // int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
         //       | View.SYSTEM_UI_FLAG_FULLSCREEN;
        //decorView.setSystemUiVisibility(uiOptions);.
        user=(EditText) findViewById(R.id.editText3);
        password=(EditText)findViewById(R.id.password);
        daoUser= new daoUsuario(this);

         conn=new ConexionSqlHelper(this,"bd_Tienda",null,1 );



    }


    public void verificarUsuario(View view){
        String us=user.getText().toString();
        String pasw=password.getText().toString();
        if(us.equals("")||pasw.equals("")){
            Toast.makeText(this,"CAMPOS VACIOS!!", Toast.LENGTH_SHORT).show();

        } else if(daoUser.ingresoLogin(us,pasw)==1){
            user.setText("");
            password.setText("");
           // Intent miIntent= new Intent(Login.this,Productos.class);
            Intent miIntent= new Intent(Login.this,MenuPrincipal.class);
            startActivity(miIntent);
            } else {
            Toast.makeText(this,"Usuario o Contraseña Incorrectas", Toast.LENGTH_SHORT).show();
        }
        

    }

    public void formularioRegistrar(View view){

        Intent miIntent= new Intent(Login.this,Registrar.class);
        startActivity(miIntent);
    }


}
