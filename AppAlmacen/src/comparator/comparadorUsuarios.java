/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import entidad.Empleado;
import java.util.Comparator;


public class comparadorUsuarios {

    public static Comparator<Empleado> ordenarUsuarios = new Comparator<Empleado>() {

        @Override
        public int compare(Empleado p1, Empleado p2) {

            return p1.getUsuario().compareTo(p2.getUsuario());

        }

    };

}
