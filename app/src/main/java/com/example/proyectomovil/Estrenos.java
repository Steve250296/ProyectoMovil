package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class Estrenos extends AppCompatActivity {

    VideoView video;
    ListView lista;
    ArrayList<String> listaVideo;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estrenos);
        init();
    }



     public void init(){
        video=(VideoView) findViewById(R.id.video);
        lista=(ListView)findViewById(R.id.lista);
// CODIGO PARA CARGAR NOMBRE DE PELICULAS
        listaVideo= new ArrayList<>();
        listaVideo.add("RESIDENT EVIL");
        listaVideo.add("DRAGON BALL SUPER");
        listaVideo.add("VIRUS");
        listaVideo.add("AVENGERS 5");
        listaVideo.add("AFTER 2");

        //ADAPTADOR DE LISTVIEW
        adapter= new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,listaVideo);
         lista.setAdapter(adapter);

         lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                 switch (position){

                     case 0:
                         video.setVideoURI(Uri.parse("android.resource://"+ getPackageName() + "/" + R.raw.residentevil));
                         break;
                     case 1:
                         video.setVideoURI(Uri.parse("android.resource://"+ getPackageName() + "/" + R.raw.dbs1));
                         break;
                     case 2:
                         video.setVideoURI(Uri.parse("android.resource://"+ getPackageName() + "/" + R.raw.virus1));
                         break;
                     case 3:
                         video.setVideoURI( Uri.parse( "android.resource://"+getPackageName()+ "/"+R.raw.avengers ) );
                         break;
                     case 4:
                         video.setVideoURI( Uri.parse( "android.resource://"+getPackageName()+ "/"+R.raw.after2 ) );
                         break;
                     default:
                         break;
                 }
                 video.setMediaController(new MediaController(Estrenos.this));
                 video.requestFocus();
                 video.start();

             }
         });




     }
}
