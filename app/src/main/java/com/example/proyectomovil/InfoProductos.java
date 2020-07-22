package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import entidades.Producto;
import entidades.Usuario;

public class InfoProductos extends AppCompatActivity {
      Button btnSipnosis;
    private List<Producto> productosList;
    ImageView imagen;
    private TextView texto;
    private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_productos);
        Button sipnosis=(Button)findViewById(R.id.btnSipnosis);
 // ESTA ES LA FORMA DE PASAR DATOS PERO CON EL OBJETO , USO BUNDLE PARA RECIBIR
 // EL OBJETO COMPLETO DE LA BASE Y CARGO EN LOS CONTROLES

        TextView textoRecibe =(TextView) findViewById(R.id.textoRecibe);
        TextView descripcion =(TextView) findViewById(R.id.descripcion);
        ImageView  imagen1=(ImageView) findViewById(R.id.imagenRecibe);


        Bundle extras=getIntent().getExtras();
        Producto prd=null;
        String detalle="";
        if(extras!=null){

            prd=(Producto)extras.getSerializable("producto");
            textoRecibe.setText(prd.getNombre().toString());
            descripcion.setText(prd.getDescripcion());
           Glide.with(this).asBitmap().load(prd.getImagen()).into(imagen1);
          //detalle=extras.getString("detalleEnvia");

                    }

      //  enviaSipnosis((android.view.View) View,detalle);


    }


    public void  enviaSipnosis(View view){
        Bundle extras=getIntent().getExtras();
        Producto prd=null;
        String  detalle="";
     //   detalle=extras.getString("detalleEnvia");

        prd=(Producto)extras.getSerializable("producto");
        Intent intent1= new Intent(getApplicationContext(),SipnosisPeliculas.class);
        intent1.putExtra("sipnosis", prd.getDetalle().toString());
        startActivity(intent1);

    }


    // ESTE OTRO METODO ES PARA RECIBIR VARIABLE POR VARIABLE

   // String nombre="";
    //String descripcionInfo="";
    //String urlImagen = null;

    //Bundle extras=getIntent().getExtras();

      //  if(extras!=null){

        //nombre=extras.getString("textoPasado");
        //descripcionInfo=extras.getString("descripcion");
        //urlImagen=extras.getString("imagenPuesta");
    //}

    //TextView textoRecibe =(TextView) findViewById(R.id.textoRecibe);
    //TextView descripcion =(TextView) findViewById(R.id.descripcion);
    //ImageView  imagen1=(ImageView) findViewById(R.id.imagenRecibe);
      // Glide.with(this).asBitmap().load(urlImagen).into(imagen1);
//        textoRecibe.setText(nombre);
  //      descripcion.setText(descripcionInfo);



}
