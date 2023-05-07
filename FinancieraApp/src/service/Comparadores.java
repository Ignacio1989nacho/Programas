/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidad.Persona;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class Comparadores {

    public static Comparator<Persona> porNombre = new Comparator<Persona>() {

        @Override
        public int compare(Persona p1, Persona p2) {

            return p1.getNombre().compareTo(p2.getNombre());

        }

    };
    public static Comparator<Persona> porApellido= new Comparator<Persona>() {

        @Override
        public int compare(Persona p1, Persona p2) {

            return p1.getApellido().compareTo(p2.getApellido());

        }

    };
    public static Comparator<Persona> porDni = new Comparator<Persona>() {

        @Override
        public int compare(Persona p1, Persona p2) {

            return p1.getDni().compareTo(p2.getDni());

        }

    };

}


