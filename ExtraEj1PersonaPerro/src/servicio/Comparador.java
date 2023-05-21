/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Perro;
import java.util.Comparator;


public class Comparador {
    
        public static Comparator<Perro> consultarPerro = new Comparator<Perro>() {

        @Override
        public int compare(Perro p1, Perro p2) {

            return p1.getTiposPerro().toString().compareTo(p2.getTiposPerro().toString());

        }

    };
    
}
