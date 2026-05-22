package model;

import java.io.Serial;
import java.io.Serializable;

public class Usuario implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L; //Me permite capturar el valor de una etiqueta a la hora de leer un objeto
    private String nombre, apellido, correo, dni;
    private int telefono;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String correo, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Usuario(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void mostrarDatos(){
        System.out.printf("""
                Nombre: %s
                Apellido: %s
                DNI: %s
                """, getNombre(),getApellido(), getDni());
    }

    @Override
    public String toString() {
        //Pedro,Martin,009102
        return String.format("%s,%s,%s", getNombre(), getApellido(), getDni());
    }
}
