package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

    //Identificador - id_cliente - Base de datos the_power
    private long id;
    private String nombre, apellido, correo;
    private int saldo;
    private int idPerfil;

    public Cliente(String nombre, String apellido, String correo, int saldo, int idPerfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.saldo = saldo;
        this.idPerfil = idPerfil;
    }
}
