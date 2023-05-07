/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import entidad.Persona;
import java.util.Comparator;


public class comparadorUsuarios {

    public static Comparator<Persona> ordenarUsuarios = new Comparator<Persona>() {

        @Override
        public int compare(Persona p1, Persona p2) {

            return p1.getUsuario().compareTo(p2.getUsuario());

        }

    };

}
