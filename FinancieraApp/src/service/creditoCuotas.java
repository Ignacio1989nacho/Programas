/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidad.Persona;
import java.util.Scanner;

public class creditoCuotas {

    public static final void cuotasCantidad(Persona p) {
        Scanner Leer = new Scanner(System.in).useDelimiter("\n");

        int coutas;
        do {
            System.out.println("Credito Aprobado - Puede acceder hasta $50000");
            System.out.println("3 Cuotas de $20000");
            System.out.println("6 Cuotas de $25000");
            System.out.println("12 Cuotas de $30000");

            System.out.println("Cantidad de coutas:");
            coutas = Leer.nextInt();
        } while (coutas != 3 && coutas != 6 && coutas != 12);
        int nuevoSaldo = 0;
        boolean aux = false;
        do {
            System.out.println("Ingresa el valor del credito:");
            nuevoSaldo = Leer.nextInt();
            if (nuevoSaldo < 50000) {
                aux = true;

            }
        } while (!aux);

        p.setFecha(validacionFecha.fecha());
        p.setCredito(true);

        p.setSaldo((p.getSaldo() + nuevoSaldo));

    }

}
