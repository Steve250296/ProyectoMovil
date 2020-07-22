package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entidades.Reserva;
import entidades.Usuario;
import utilidades.utiles;

public class daoReserva  {
    ConexionSqlHelper  con;
    ArrayList<Reserva> listaEncontrar;
    Reserva reserva;
    Context contexto;


    public daoReserva(Context contexto) {

        this.contexto = contexto;
    }



    public boolean registrarReserva(Reserva res){

        con=new ConexionSqlHelper(contexto,"bd_Tienda",null,1 );
        SQLiteDatabase db=con.getWritableDatabase();
       // if(buscarReserva(res.getCi())==0) {

            ContentValues values = new ContentValues();
            values.put(utiles.NOMBRE_RESERVA,res.getNombre());
            values.put(utiles.APELLIDO_RESERVA, res.getApellido());
            values.put(utiles.CEDULA_RESERVA,res.getCi());
            values.put(utiles.PELICULA, res.getPelicula());



            db.insert(utiles.TABLA_RESERVA
                    , utiles.CAMPO_ID_RESERVA, values);

            return true;
      //  } else {
      //      return false;
     //   }


    }


    public int buscarReserva(String ci){
        int x=0;
        listaEncontrar=buscarRes();
        String[] parametros={ci.toString()};
       //String[] campos={utiles.USUARIO.toString()};
        con=new ConexionSqlHelper(contexto,"bd_Tienda",null,1 );
        SQLiteDatabase db= con.getReadableDatabase();
        //  Cursor cursor=db.query(utiles.TABLA_USUARIO,campos,utiles.IDENTIDICADOR_USUARIO+"=?",parametros,null,null,null);
        Cursor cursor=db.rawQuery("SELECT "+utiles.NOMBRE_RESERVA+" FROM "+utiles.APELLIDO_RESERVA +" WHERE "+utiles.CEDULA_RESERVA+"=? ",new  String[] {ci});

        if(cursor.moveToFirst()==true){
            x++;
        }else {
            x=0;
        }
        return x;

    }
    public ArrayList<Reserva> buscarRes(){
        ArrayList<Reserva> listaReserva= new ArrayList<Reserva>();
        con=new ConexionSqlHelper(contexto,"bd_Tienda",null,1 );
        SQLiteDatabase db= con.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ utiles.TABLA_RESERVA ,null);
        Reserva reserva= null;
        while (cursor.moveToNext())
        {
            reserva= new Reserva();
            reserva.setId(cursor.getInt(0));
            reserva.setNombre(cursor.getString(1));
            reserva.setApellido(cursor.getString(2));
            reserva.setCi(cursor.getString(3));
            reserva.setPelicula(cursor.getString(4));
            listaReserva.add(reserva);
        }
        return  listaReserva;


    }
}
