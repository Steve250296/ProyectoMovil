package dao;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import utilidades.utiles;


public class ConexionSqlHelper extends SQLiteOpenHelper {


    public ConexionSqlHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(utiles.CreartblProductos);
        db.execSQL(utiles.CreartblUsuarios);
        db.execSQL(utiles.CreartblReserva );



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS utiles.TABLA_PRODUCTO");
        db.execSQL("DROP TABLE IF EXISTS utiles.TABLA_USUARIO");
        db.execSQL("DROP TABLE IF EXISTS utiles.TABLA_RESERVA" );
        onCreate(db);

    }


}