package controller;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Gestor {

    private List<Usuario> listaUsuario =  new ArrayList<>();
    private Operaciones operaciones;

    public Gestor(){

        operaciones = new Operaciones(); //Desde aqui tenemos acceso a toda la logica de Operaciones
        listaUsuario = operaciones.importarUsuarios();

    }



    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    //Funcionalidades

    public void agregarUsuario(Usuario usuario){
        this.listaUsuario.add(usuario); //Agregamos un usuario sin filtrado
        System.out.println("Usuario creado con éxito.");
    }

    public void listarUsuario(){
        this.listaUsuario.forEach(Usuario::mostrarDatos);
    }

    public void exportar(){

        //listaUsuario.forEach(System.out::println); //Realiza un sout del Objeto

        listaUsuario.forEach(usuario->operaciones.exportarUsuario(usuario)); //Recorremos lista de usuarios y exportamos el usuario que me toque
    }


    public void importar(){

        listaUsuario = operaciones.importarUsuarios();
    }
}
