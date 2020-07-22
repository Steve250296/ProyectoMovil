package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import dao.ConexionSqlHelper;
import dao.daoReserva;
import entidades.Reserva;
import entidades.Producto;
import utilidades.utiles;

public class Reserva_Peliculas extends AppCompatActivity {
    TextView txt1, txt2, txt3, txt4;
    ListView lvPeliculas;
    EditText filtro;
    Bundle dato;
    daoReserva daoRes;
    ArrayAdapter<String> adapter;
    ArrayList<String> listaInformacion;
    ArrayList<Producto> listaProductos;
    ConexionSqlHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_reserva__peliculas );
        dato=getIntent().getExtras();
        lvPeliculas=findViewById( R.id.ListViewDatos );

        txt1=findViewById( R.id.txtCedula );
        String datoRecibido=dato.getString("cedula");
        txt1.setText(datoRecibido);

        txt2=findViewById( R.id.txtNombre );
        String datoRecibido1=dato.getString("nombre");
        txt2.setText(datoRecibido1);

        txt3=findViewById( R.id.txtApellido );
        String datoRecibido2=dato.getString("apellido");
        txt3.setText(datoRecibido2);

        txt4=findViewById( R.id.txtPelicula );

        filtro=findViewById( R.id.ETFiltro );

        daoRes= new daoReserva(this);

        conn=new ConexionSqlHelper( getApplicationContext(), "bd_Tienda", null, 1 );

        consultarListaPeliculas();
        final ArrayAdapter adaptador=new ArrayAdapter( this,android.R.layout.simple_list_item_1,listaInformacion );
        lvPeliculas.setAdapter( adaptador );

        lvPeliculas.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String informacion= "Nombre Pelicula: "+listaProductos.get( position ).getNombre()+"\n";
                informacion += "Descripción: "+listaProductos.get(position).getDescripcion();
                Toast.makeText(getApplicationContext(), "Usted ha escogido: "+"\n"+ informacion +"\n"+" haga click en reservar", Toast.LENGTH_LONG).show();
                String dato= listaProductos.get( position ).getNombre();
                txt4.setText( dato );

            }
        } );

        //Filtrar Peliculas

                filtro.addTextChangedListener( new TextWatcher() {
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



    }

    private void consultarListaPeliculas(){
        SQLiteDatabase db=conn.getReadableDatabase();
        Producto producto=null;

        listaProductos=new ArrayList<Producto>(  );
        Cursor cursor=db.rawQuery( "SELECT * FROM "+ utiles.TABLA_PRODUCTO, null );
        while(cursor.moveToNext()){
            producto= new Producto(  );
            producto.setId( cursor.getInt( 0 ) );
            producto.setNombre( cursor.getString(1  ) );
            producto.setDescripcion( cursor.getString( 2 ) );
            listaProductos.add( producto );

        }

        obtenerLista();
    }
    private void obtenerLista(){
        listaInformacion=new ArrayList<String>(  );

        for(int i=0; i<listaProductos.size();i++){
            listaInformacion.add( listaProductos.get( i ).getNombre());
        }
    }

    public void Guardar (View v){

        /*Reserva reserva=new Reserva();
        reserva.setNombre( txt2.getText().toString() );
        reserva.setApellido( txt3.getText().toString() );
        reserva.setCi(txt1.getText().toString()  );
        reserva.setPelicula( txt4.getText().toString() );
*/
       String nombre=txt2.getText().toString();
        String apellido=txt3.getText().toString();
       String ci=txt1.getText().toString();
        String pelicula=txt4.getText().toString();
        try {
            //daoRes.registrarReserva(reserva);
            SQLiteDatabase base=  conn.getWritableDatabase();
            ContentValues values= new ContentValues();

            values.put(utiles.NOMBRE_RESERVA,nombre);
            values.put(utiles.APELLIDO_RESERVA,apellido);
            values.put(utiles.CEDULA_RESERVA,ci);
            values.put(utiles.PELICULA,pelicula);
            Long idResultante=base.insert(utiles.TABLA_RESERVA,utiles.CAMPO_ID_RESERVA,values);


            String datos= "  Reserva Guardada exitosamente: " +"\n";
            datos += "Nombre: "+txt2.getText().toString() +"\n";
            datos += "Apellido: "+txt3.getText().toString()+"\n";
            datos += "Cedula: "+txt1.getText().toString()+"\n";
            datos += "Película: "+txt4.getText().toString()+"\n";

            Intent enviar=new Intent(this, RegistroReserva.class);
            startActivity( enviar );
            Toast.makeText(getApplicationContext(), datos, Toast.LENGTH_LONG).show();
        }catch(Exception e){
            Toast.makeText( getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG ).show();
        }


    }
}
