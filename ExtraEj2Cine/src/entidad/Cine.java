/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.ArrayList;
import java.util.HashMap;


public class Cine {
    private ArrayList<Pelicula> listaPelis;
    private HashMap<Integer,String> salaCapacidad;
    private Double precioEntrada;
    

    public Cine() {
    }

    public Cine(ArrayList<Pelicula> listaPelis, Double precioEntrada) {
        this.listaPelis = listaPelis;
        this.precioEntrada = precioEntrada;
    }

    
    public Cine(ArrayList<Pelicula> listaPelis, HashMap<Integer, String> salaCapacidad, Double precioEntrada) {
        this.listaPelis = listaPelis;
        this.salaCapacidad = salaCapacidad;
        this.precioEntrada = precioEntrada;
    }

    public Double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(Double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public ArrayList<Pelicula> getListaPelis() {
        return listaPelis;
    }

    public void setListaPelis(ArrayList<Pelicula> listaPelis) {
        this.listaPelis = listaPelis;
    }

    public HashMap<Integer,String> getSalaCapacidad() {
        return salaCapacidad;
    }

    public void setSalaCapacidad(HashMap<Integer,String> salaCapacidad) {
        this.salaCapacidad = salaCapacidad;
    }

    @Override
    public String toString() {
        return "Cine{" + "listaPelis=" + listaPelis + ", salaCapacidad=" + salaCapacidad + ", precioEntrada=" + precioEntrada + '}';
    }
    
    
    
}
