package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectomovil.Registrar;

import java.util.ArrayList;

import entidades.Producto;
import entidades.Usuario;
import utilidades.utiles;

public class daoUsuario  {
ConexionSqlHelper  con;
ArrayList<Usuario> lsitaEcontrar;
Usuario usuario;
Context contexto;





    public daoUsuario(Context contexto) {

        this.contexto = contexto;
    }



    public boolean registrarUsuario(Usuario user){

        con=new ConexionSqlHelper(contexto,"bd_Tienda",null,1 );
        SQLiteDatabase db=con.getWritableDatabase();
        if(buscarUsuario(user.getCi(),user.getUsuario())==0) {

            ContentValues values = new ContentValues();
            values.put(utiles.USUARIO,user.getUsuario());
            values.put(utiles.IDENTIDICADOR_USUARIO,user.getCi());
            values.put(utiles.PASSWORD_USUARIO, user.getPassword());
            values.put(utiles.NOMBRE_USUARIO,user.getNombre());
            values.put(utiles.APELLIDO_USUARIO_, user.getApellido());

            Long idResultante = db.insert(utiles.TABLA_USUARIO, utiles.CAMPO_ID_USUARIO, values);

            return true;
        } else {
            return false;
        }


    }


    public int buscarUsuario(String ci,String usuario){
        int x=0;
        lsitaEcontrar=buscarUser();
String[] parametros={ci.toString()};
String[] campos={utiles.USUARIO.toString()};
        con=new ConexionSqlHelper(contexto,"bd_Tienda",null,1 );
        SQLiteDatabase db= con.getReadableDatabase();
     //  Cursor cursor=db.query(utiles.TABLA_USUARIO,campos,utiles.IDENTIDICADOR_USUARIO+"=?",parametros,null,null,null);
        Cursor cursor=db.rawQuery("SELECT "+utiles.USUARIO+" FROM "+utiles.TABLA_USUARIO +" WHERE "+utiles.IDENTIDICADOR_USUARIO+"=? OR "+utiles.USUARIO+"=?",new  String[] {ci,usuario});

        if(cursor.moveToFirst()==true){
            x++;
        }else {
            x=0;
        }
    return x;

    }


    public ArrayList<Usuario> buscarUser(){
        ArrayList<Usuario> listaUsuario= new ArrayList<Usuario>();
        con=new ConexionSqlHelper(contexto,"bd_Tienda",null,1 );
        SQLiteDatabase db= con.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ utiles.TABLA_USUARIO ,null);
        Usuario usuario= null;
        while (cursor.moveToNext())
        {
            usuario= new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setUsuario(cursor.getString(1));
            usuario.setApellido(cursor.getString(2));
            usuario.setNombre(cursor.getString(3));
            usuario.setCi(cursor.getString(4));
            usuario.setPassword(cursor.getString(5));
            listaUsuario.add(usuario);
        }
        return  listaUsuario;


    }


    public int ingresoLogin(String user,String pass){
        int i=0;
        con=new ConexionSqlHelper(contexto,"bd_Tienda",null,1 );
        SQLiteDatabase db= con.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ utiles.TABLA_USUARIO ,null);
        Usuario usuario= null;
        while (cursor.moveToNext())
        {
           if(cursor.getString(1).equals(user)&&cursor.getString(5).equals(pass)){
               return  i=i+1;

           }

        }

        return i;


    }







}
