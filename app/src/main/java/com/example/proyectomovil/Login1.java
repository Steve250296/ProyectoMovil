package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import dao.ConexionSqlHelper;
import dao.daoUsuario;

public class Login1 extends AppCompatActivity {
    ConexionSqlHelper conn;
    EditText user,password;
    daoUsuario daoUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login1 );
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
            Intent miIntent= new Intent(Login1.this,MenuPrincipal.class);
            startActivity(miIntent);
        } else {
            Toast.makeText(this,"Usuario o Contraseña Incorrectas", Toast.LENGTH_SHORT).show();
        }


    }

    public void formularioRegistrar(View view){

        Intent miIntent= new Intent(Login1.this,Registrar.class);
        startActivity(miIntent);
    }

}
