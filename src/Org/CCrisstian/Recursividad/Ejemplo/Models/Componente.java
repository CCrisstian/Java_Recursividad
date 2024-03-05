package Org.CCrisstian.Recursividad.Ejemplo.Models;

import java.util.ArrayList;
import java.util.List;

public class Componente {
/*-------------------ATRIBUTOS-------------------*/
    private String nombre;
    private List<Componente> hijos;
    public int nivel;
/*-------------------GETTER-SETTER-------------------*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Componente> getHijos() {
        return hijos;
    }

    public void setHijos(List<Componente> hijos) {
        this.hijos = hijos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
/*-------------------CONSTRUCTOR-------------------*/
    public Componente(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList<>();
    }
/*-------------------MÉTODOS-------------------*/
    public Componente addComponente (Componente componente){
        this.hijos.add(componente);
        return this;
    }

    public boolean tieneHijos (){
        return !this.hijos.isEmpty();
    }
}
