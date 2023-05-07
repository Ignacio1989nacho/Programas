/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class validacionMenu {

    /**
     *Metodo muestra el menu de opciones.
     * @return retorna entero correspondiente al menu
     */
    public static final int confirmacionMenu() {
        int op = 0;
        Scanner LEER = new Scanner(System.in).useDelimiter("\n");
       do{
        try {

            while (op != 1 && op != 2 && op != 3 && op != 4 && op != 5 && op != 6) {

                System.out.println("MENU\n" + "1 - INGRESAR NUEVO CLIENTE\n" + "2 - BUSCAR CLIENTE\n" +"3 - LISTA CLIENTES POR APELLIDO\n"+ 
                        "4 - INGRESAR SALDO CLIENTE\n" + "5 - RESTAR SALDO CLIENTE\n" + "6 - PROCESO CREDITO\n" + "7 - SALIR");
                op = LEER.nextInt();
                System.out.println("");
                
            }
            break;
        } catch (InputMismatchException e) {
            System.out.println("");


            LEER.nextLine(); // Limpiar el buffer del scanner}
        } catch (NumberFormatException e) {
            System.out.println("");


            LEER.nextLine(); // Limpiar el buffer del scanner}

        }
       }while(true);
        return op;

    }

}
