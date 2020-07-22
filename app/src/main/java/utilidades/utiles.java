package utilidades;

public class utiles {
    //Constantes Campo tabla prodcutos
    public static final String TABLA_PRODUCTO="productos";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_DESCRIPCION="descripcion";
    public static final String CAMPO_IMAGEN="imagen";
    public static final String CAMPO_DETALLE="detalle";


    //Constantes Usuario
    public static final String TABLA_USUARIO="usuarios";
    public static final String CAMPO_ID_USUARIO="id";
    public static final String USUARIO="usuario";
    public static final String APELLIDO_USUARIO_="apellido";
    public static final String NOMBRE_USUARIO="nombre";
    public static final String IDENTIDICADOR_USUARIO="ci";
    public static final String PASSWORD_USUARIO="password";

    //Constantes Tabla Reserva
    public static final String TABLA_RESERVA="reserva";
    public static final String CAMPO_ID_RESERVA="id";
    public static final String NOMBRE_RESERVA="nombrereserva";
    public static final String APELLIDO_RESERVA="apellido";
    public static final String CEDULA_RESERVA="ci";
    public static final String PELICULA="pelicula";

    public static final String CreartblProductos="CREATE TABLE "+TABLA_PRODUCTO+" ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_DESCRIPCION+" TEXT, "+CAMPO_IMAGEN+" BLOB,"+CAMPO_DETALLE+" TEXT)";
    public static final String CreartblUsuarios="CREATE TABLE "+TABLA_USUARIO+" ("+CAMPO_ID_USUARIO+" INTEGER PRIMARY KEY AUTOINCREMENT, "+USUARIO+" TEXT,"+APELLIDO_USUARIO_+" TEXT,"+NOMBRE_USUARIO+" TEXT, "+IDENTIDICADOR_USUARIO+" TEXT,"+PASSWORD_USUARIO+" TEXT)";
    public static final String CreartblReserva="CREATE TABLE "+TABLA_RESERVA+" ("+CAMPO_ID_RESERVA+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NOMBRE_RESERVA+" TEXT,"+APELLIDO_RESERVA+" TEXT,"+CEDULA_RESERVA+" TEXT, "+PELICULA+" TEXT)";



}
