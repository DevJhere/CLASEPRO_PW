package org.example.tiendaapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String nombre,apellido, correo,pass,dni,perfil, genero;
    private int edad;

    @Override
    public String toString() {
        return nombre;
    }
}
