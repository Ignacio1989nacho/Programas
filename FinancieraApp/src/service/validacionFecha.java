/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidad.Persona;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class validacionFecha {

    /**
     *Metodo obtiene la fecha actual
     * @return retorna la fecha actual
     */
    public static final Date fecha() {
        Date fecha = new Date();
        return fecha;
    }

    /**
     *Metodo formatea la fecha para guardarse en formato actual.
     * @param cliente recibe arraylist con objeto persona
     * @param p recibe Objeto persona
     * @return retorna la fecha en formato actual.
     */
    public static final String fechaFormat(ArrayList<Persona> cliente, Persona p) {

        // Crear un formato de fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        // Formatear la fecha
        String fechaFormateada = formato.format(p.getFecha());

        return fechaFormateada;

    }

}
