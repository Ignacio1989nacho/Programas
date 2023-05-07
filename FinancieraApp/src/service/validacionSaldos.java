/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidad.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class validacionSaldos {

    /**
     * Metodo resta saldo en la cuenta del cliente. 
     * @param cliente recibe arraylist con objeto persona
     * @param p recibe objeto persona
     * @return retorna boolean
     */
    public static final boolean restar(ArrayList<Persona> cliente, Persona p) {
        Scanner Leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresa el saldo a restar:");
        int nuevoSaldo = Leer.nextInt();

        p.setSaldo((p.getSaldo() - nuevoSaldo));

        return false;

    }
   /**
     * Metodo suma saldo en la cuenta del cliente. 
     * @param cliente recibe arraylist con objeto persona
     * @param p recibe objeto persona
     * @return retorna boolean
     */
    public static final boolean sumar(ArrayList<Persona> cliente, Persona p) {
        Scanner Leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresa el saldo:");
        int nuevoSaldo = Leer.nextInt();

        p.setSaldo((p.getSaldo() + nuevoSaldo));
        
        return false;

    }

}
