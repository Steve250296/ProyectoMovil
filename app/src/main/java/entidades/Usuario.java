package entidades;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id;
    private String nombre,apellido,usuario,password,ci;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, String usuario, String password, String ci) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.ci = ci;
    }

    public boolean isNull(){
        if(nombre.equals("")|| apellido.equals("")||usuario.equals("")||password.equals("")||ci.equals("")){
            return false;
        }else{
            return true;
        }


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", ci='" + ci + '\'' +
                '}';
    }
}

