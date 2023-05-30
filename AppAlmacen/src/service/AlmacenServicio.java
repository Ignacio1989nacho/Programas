/*
Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
productos que venderemos y el precio que tendrán. Además, se necesita que la
aplicación cuente con las funciones básicas.
Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas.

 */
package service;

import archivoBBDD.BBDD;
import comparator.comparadorUsuarios;
import entidad.Persona;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class AlmacenServicio extends BBDD {
    private final Scanner LEER = new Scanner(System.in).useDelimiter("\n");
    
    /*
    *Metodo crea el producto con su nombre y valor
     */
    private void crearProducto() {     
        String producto = "";
        double precio = 0d;
        do {
            try {
                System.out.println("Ingresa el producto:");
                producto = LEER.next();
                System.out.println("Ingresa el precio del producto:");
                precio = LEER.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado es incorrecto!!!!");
                LEER.next();// LIMPIAR EL BUFFER...
            }
        } while (true);
        String ruta = "C:\\Users\\Usuario\\Desktop\\BBDDclientes\\productosBBDD.txt";
        super.ingresarDatos(ruta, producto, precio);
    }

    /*
    * Metodo modifica el valor del producto
     */
    private void modificarPrecio() {

        System.out.println("Introduce el producto que quieres modificar el precio:");
        String producto = LEER.next();
        System.out.println("Ingresa el precio nuevo:");
        double precio;
        precio = LEER.nextDouble();
        super.modificarProducto(producto, precio);
    }

    /*   
    *Metodo elimina el producto de la lista
     */
    private void eliminarProducto() {
        do {
            try {
                System.out.println("Introduce el producto que quieres eliminar");
                String producto = LEER.next();
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado es incorrecto!!!!");
                LEER.next();// LIMPIAR EL BUFFER...
            }
        } while (true);    
    }
    
    /*
 *Metodo muestra la lista de productos
     */
    private void mostrarProductos() {
        super.mostrarListaProductos();
    }

    /*
*Metodo busca producto ingresado por el usuario y si se encuentra lo muestra en la lista.
     */
    private void buscarProducto() {

        System.out.println("Ingresa el producto que deseas buscar:");
        String producto = LEER.next();
        super.leerProductos(producto);

    }

    /*
 * Metodo crea el usuario y lo guarda en el hashset
     */
    private void crearUsuario() {
        System.out.println("Usuario");
        String us = LEER.next();
        System.out.println("Contraseña");
        String pass = LEER.next();
        Persona emp = new Persona(us, pass);
        super.crearBBDDusuarios(emp);
    }

    /*
*Metodo elimina el usuario de la lista.
     */
    private void eliminarUsuario() {
        
        System.out.println("Ingresa el usuario que deseas eliminar:");
        String nombre = LEER.next();   
    }

    /*
*Metodo muestra el menu al administrador. con sus opciones
     */
    private void menuAdministrador() {
        int op = 0;
        op = opMenuAdm();
        switch (op) {
            case 1:
                crearUsuario();
                break;
            case 2:
                eliminarUsuario();
                break;
            case 3:
                crearProducto();
                break;
            case 4:
                modificarPrecio();
                break;
            case 5:
                eliminarProducto();
                break;
            case 6:
                mostrarProductos();
                break;
            case 7:
                buscarProducto();
                break;
            case 8:
                System.out.println("saliendo del menu....");
                break;
        }
    }

    /*
* Metodo para logear usuario
     */
    private boolean ingresoUsuarioEmpleado() {
        boolean aux = false;
        int cont = 0;
        do {
            cont++;
            System.out.println("USUARIO:");
            String us = LEER.next();
            System.out.println("CONTRASEÑA:");
            String pass = LEER.next();
            aux = super.iniciarSecion(us, pass);

            if (cont >= 4) {
                menu();
            }
        } while (!aux);
        return aux;
    }

    /*
* Metodo muestra las opciones del administrador.
     */
    private int opMenuAdm() {
        int op = 0;
        do {
            try {
                System.out.println("1 - Crear usuario\n" + "2 - Eliminar usuario\n" + "3 - Ingresar producto\n" + "4 - Modificar producto\n"
                        + "5 - Eliminar producto\n" + "6 - Mostrar Lista\n" + "7 - Buscar producto\n" + "8 - Salir");
                op = LEER.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Seleccion incorrecta...");
                LEER.next();
            }
            break;
        } while (true);
        return op;
    }

    /*
*Metodo para menu de seleccion, empleado o administrador
     */
    private int opMenuAdmEmp() {
        int op = 0;
        while (op != 1 && op != 2) {
            System.out.println("1 - Administrador\n" + "2 - Empleado");
            op = LEER.nextInt();
        }
        return op;
    }

    /**
     * Metodo de menu y seleccion para el empleado
     *
     * @return retorna un entero
     */
    private int menuEmpleado() {
        int op = 0;
        while (op != 1 && op != 2 && op != 3) {
            System.out.println("Ingresa la opcion que deseas:\n"
                    + "1 - Mostrar Lista\n" + "2 - Buscar producto\n" + "3 - Salir");
            op = LEER.nextInt();
        }
        return op;
    }

    /*
 *Metodo menu general, con opciones llamando a los distintos metodos del servicio.
     */
    public void menu() {

        do {
            try {

                switch (opMenuAdmEmp()) {

                    case 1:
                        menuAdministrador();
                        menu();
                        break;
                    case 2:
                        boolean aux = false;
                        do {
                            aux = ingresoUsuarioEmpleado();
                        } while (!aux);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado es incorrecto!!!!");
                LEER.next();// LIMPIAR EL BUFFER...
            }
        } while (true);
        do {
            try {
                switch (menuEmpleado()) {
                    case 1:
                        mostrarProductos();
                        break;
                    case 2:
                        buscarProducto();
                        break;
                    case 3:
                        System.out.println("SALIENDO AL MENU LOGIN....");
                        menu();
                        break;
                }
                //break;
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado es incorrecto");
                LEER.next();// LIMPIAR EL BUFFER... }
            }
        } while (true);
    }
}
