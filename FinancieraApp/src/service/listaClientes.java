/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidad.Persona;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class listaClientes {

    /**
     *Metodo muestra los clientes en forma de lista
     * @param cliente recibe arraylist con objeto persona
     */
    public final static void mostrarListas(ArrayList<Persona> cliente) {

        for (Persona persona : cliente) {
            System.out.println("Apellido y Nombre: " + persona.getApellido() + " "
                    + persona.getNombre() + "\n" + "DNI: " + persona.getDni() + "\n"
                    + "Numero de cuenta: " + persona.getnCuenta() + "\n");
        }

    }

    /**
     *Metodo busca al cliente segun el dni
     * @param cliente recibe arraylist con objeto persona
     * @param dni recibe el dni del cliente
     */
    public final static void buscarClienteDni(ArrayList<Persona> cliente, Integer dni) {

        Iterator<Persona> cl = cliente.iterator();

        while (cl.hasNext()) {

            Persona p = cl.next();

            if (Objects.equals(p.getDni(), dni)) {

                System.out.println("Apellido y Nombre: " + p.getApellido() + " "
                        + p.getNombre() + "\n" + "DNI: " + p.getDni() + "\n"
                        + "Numero de cuenta: " + p.getnCuenta() + "\n");
            }
            
            else{
                
                System.out.println("El cliente inexistente");
                
            }

        }

    }
    
    /**
     *Metodo busca cliente por apellido.
     * @param cliente recibe arraylist con objeto persona
     */
    public static final void clientePorApellido(ArrayList<Persona> cliente){
    
    Collections.sort(cliente,Comparadores.porApellido);
        for (Persona persona : cliente) {
            System.out.println("Apellido : "+persona.getApellido()+" "+persona.getNombre() );
        }
    
    }

}
