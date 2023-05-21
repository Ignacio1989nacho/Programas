/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import Enum.TiposPerro;


public class Perro {

    private String nombre;
    private String tam;
    private Integer edad;
    private TiposPerro tiposPerro;
    

    public Perro() {
    }

    public Perro(String nombre, TiposPerro tiposPerro) {
        this.nombre = nombre;
        this.tiposPerro = tiposPerro;
    }
    
    

    public Perro(String nombre, String tam, Integer edad, TiposPerro tiposPerro) {
        this.nombre = nombre;
        this.tam = tam;
        this.edad = edad;
        this.tiposPerro = tiposPerro;
    }

    public TiposPerro getTiposPerro() {
        return tiposPerro;
    }

    public void setTiposPerro(TiposPerro tiposPerro) {
        this.tiposPerro = tiposPerro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTam() {
        return tam;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Perro{" + "nombre=" + nombre + ", tam=" + tam + ", edad=" + edad + ", tiposPerro=" + tiposPerro + '}';
    }

}
