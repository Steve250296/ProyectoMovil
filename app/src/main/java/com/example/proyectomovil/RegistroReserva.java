package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import dao.ConexionSqlHelper;
import entidades.Producto;
import entidades.Reserva;
import utilidades.utiles;

public class RegistroReserva extends AppCompatActivity {
    ListView reservalv;
    EditText etreserva;
    ArrayList<String> listaInformacion;
    ArrayList<Reserva> listaReserva;
     ConexionSqlHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_registro_reserva );
        reservalv=findViewById( R.id.lvReserva );
        etreserva=findViewById( R.id.etReserva );
        conn=new ConexionSqlHelper( getApplicationContext(), "bd_Tienda", null, 1 );

        try{
            consultarReservas();
            final ArrayAdapter adaptador=new ArrayAdapter( this,android.R.layout.simple_list_item_1,listaInformacion );
            reservalv.setAdapter( adaptador );
            reservalv.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String informacion=listaReserva.get(position).getNombre();
                    //Toast.makeText(getApplicationContext(), informacion, Toast.LENGTH_LONG).show();


                }
            } );

            //Filtrar Peliculas
            // adapter = new ArrayAdapter <>(this, android.R.layout.simple_list_item_1, listaInformacion);
            //filtro
            etreserva.addTextChangedListener( new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    adaptador.getFilter().filter( s );
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            } );
        }catch(Exception e){
            Toast.makeText( getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG ).show();
        }


    }

    private void consultarReservas(){
        SQLiteDatabase db=conn.getReadableDatabase();
        Reserva reserva=null;

        listaReserva=new ArrayList<Reserva>(  );
        Cursor cursor=db.rawQuery( "SELECT * FROM "+ utiles.TABLA_RESERVA, null );
        while(cursor.moveToNext()){
            reserva= new
                    Reserva(  );
            reserva.setId( cursor.getInt( 0 ) );
            reserva.setNombre( cursor.getString( 1 ) );
            reserva.setApellido( cursor.getString( 2 ) );
            reserva.setCi( cursor.getString(3  ) );
            reserva.setPelicula( cursor.getString( 4 ) );

            listaReserva.add( reserva );

        }

        obtenerLista();
    }
    private void obtenerLista(){
        listaInformacion=new ArrayList<String>(  );

        for(int i=0; i<listaReserva.size();i++){
            listaInformacion.add("CI: "+ listaReserva.get( i ).getCi()+" \n "+"Nombre: "+listaReserva.get( i ).getNombre()+"\n"+"Apellido: "+ listaReserva.get(i).getApellido()
            +"\n"+"Pelicula: "+listaReserva.get( i ).getPelicula());
        }
    }

    public void Regresar(View v){
        Intent enviar=new Intent(this, MenuPrincipal.class);
        startActivity( enviar );
    }

}
