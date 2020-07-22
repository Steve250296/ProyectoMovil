package utilidades;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectomovil.InfoProductos;
import com.example.proyectomovil.Productos;
import com.example.proyectomovil.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import entidades.Producto;

public  class Adapter extends RecyclerView.Adapter<Adapter.ProductosViewHolder> {
    private  Context mCtx;// OJO EL CONTEXTO ES EL LAYOUT AL QUE VAMOS A MANDAR LAS CONSULTAS ESTE LLAMA AL LAYOUT CATALOGO.
    private List<Producto> productosList;


    public Adapter(Productos mCtx, ArrayList<Producto> listaProductos) {
        this.mCtx=mCtx;
        this.productosList = listaProductos;
    }

    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater inflater =LayoutInflater.from(mCtx);
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla_lista,null);
        return new  ProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductosViewHolder holder, final int position) {
        final Producto productos=productosList.get(position);

        //Caragamos Imagen
        Glide.with(mCtx).load(productos.getImagen()).into((holder.imageView));//primero se declara los tipos de dato(ver metodo ProductosViewHolder)

        //   holder.imageView.setImageURI();
        holder.txtViewNombre.setText(productos.getNombre());
        holder.txtViewDescripcion.setText(productos.getDescripcion());

        holder.btnEnviar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(mCtx,InfoProductos.class);
                Bundle bundle= new Bundle();
                bundle.putSerializable("producto",productos);
               // intent1.putExtra("textoPasado",productosList.get(position).getNombre());ESTOS 3 SON PARAMETROS PASADOS POR
                //intent1.putExtra("descripcion",productosList.get(position).getDescripcion()); EL RECYCLERVIEW
                //intent1.putExtra("imagenPuesta",productosList.get(position).getImagen()); PERO EN LUGAR DE ESO USE EL OBJETO
               // intent1.putExtra("detalleEnvia",productosList.get(position).getDetalle());
                // PRODUCTO PARA PASAR TODOS LOS PARAMETROS , SE PUEDE HACER DE LAS DOS FORMAS
                intent1.putExtras(bundle);
                mCtx.startActivity(intent1);
            }
        });

        //holder.setOnClickListener();

    }


    @Override
    public int getItemCount() {
        return productosList.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder   {//OJOOOOOO
        //declaramos los TextView de nuestra Interfaz
        TextView txtViewNombre;
        TextView txtViewDescripcion;
        ImageView imageView;
        ImageView url;
         ImageButton btnEnviar;
        int position;
        Producto productos=productosList.get(position);


        public String codifica(Bitmap img) {
            ByteArrayOutputStream  codifica= new ByteArrayOutputStream();
            img.compress(Bitmap.CompressFormat.PNG,100,codifica);
            byte[] recogeImg=codifica.toByteArray();

            return Base64.encodeToString(recogeImg,Base64.DEFAULT);
        }


        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);

            //enlazamos los controles java con los  widgets  xml
            txtViewNombre=itemView.findViewById(R.id.nombre);
            txtViewDescripcion=itemView.findViewById(R.id.descripcion);
           imageView=(ImageView) itemView.findViewById(R.id.lista);

            btnEnviar=(ImageButton)itemView.findViewById(R.id.bntEnviar);


        }





    }






}