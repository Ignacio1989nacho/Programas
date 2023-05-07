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

public class AlmacenServicio {

    private HashMap<String, Double> PRODUCTOMAP = new HashMap();
    private HashSet<Persona> empleadoUsuarios = new HashSet();
    private final Scanner LEER = new Scanner(System.in).useDelimiter("\n");

    /*
    *Metodo crea el producto con su nombre y valor
     */
    private void crearProducto() {
        do {
            try {
                System.out.println("Ingresa el producto:");
                String producto = LEER.next();
                System.out.println("Ingresa el precio del producto:");
                double precio = LEER.nextDouble();
                PRODUCTOMAP.put(producto, precio);
                break;
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado es incorrecto!!!!");
                LEER.next();// LIMPIAR EL BUFFER...
            }
        } while (true);
    }

    /*
    * Metodo modifica el valor del producto
     */
    private void modificarPrecio() {
        do {
            try {
                System.out.println("Introduce el producto que quieres modificar el precio:");
                String producto = LEER.next();
                double precio;
                if (PRODUCTOMAP.containsKey(producto)) {
                    System.out.println("Ingresa el nuevo valor del producto:");
                    precio = LEER.nextDouble();
                    PRODUCTOMAP.put(producto, precio);
                } else {
                    System.out.println("el producto no se encuentra en la lista...");
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado es incorrecto!!!!");
                LEER.next();// LIMPIAR EL BUFFER...
            }
        } while (true);
    }

    /*   
    *Metodo elimina el producto de la lista
     */
    private void eliminarProducto() {
        do {
            try {
                System.out.println("Introduce el producto que quieres eliminar");
                String producto = LEER.next();
                if (PRODUCTOMAP.containsKey(producto)) {
                    PRODUCTOMAP.remove(producto);
                } else {
                    System.out.println("el producto no se encuentra en la lista...");
                }
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
        System.out.println("");
        System.out.println("==========================================");
        for (Map.Entry<String, Double> object : PRODUCTOMAP.entrySet()) {
            System.out.println("Producto: " + object.getKey() + "\n" + "Valor: $" + object.getValue());
        }
        System.out.println("==========================================");
        System.out.println("");
    }

    /*
*Metodo busca producto ingresado por el usuario y si se encuentra lo muestra en la lista.
     */
    private void buscarProducto() {
        do {
            try {
                System.out.println("Ingresa el producto que deseas buscar:");
                String producto = LEER.next();
                if (PRODUCTOMAP.containsKey(producto)) {
                    System.out.println("");
                    System.out.println("==========================================");
                    for (Map.Entry<String, Double> object : PRODUCTOMAP.entrySet()) {//MODIFICAR BUCLE//
                        System.out.println("Producto: " + object.getKey() + "\n" + "Precio: $" + object.getValue());
                    }
                    System.out.println("==========================================");
                    System.out.println("");
                } else {
                    System.out.println("el producto no se encuentra en el stock!!!");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado es incorrecto!!!");
            }
        } while (true);
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
        empleadoUsuarios.add(emp);
    }

    /*
*Metodo elimina el usuario de la lista.
     */
    private void eliminarUsuario() {
        ArrayList<Persona> comp = new ArrayList<>(empleadoUsuarios);
        Collections.sort(comp, comparadorUsuarios.ordenarUsuarios);
        for (Persona empleado : comp) {
            System.out.println("Usuario: " + empleado.getUsuario());
        }
        System.out.println("Usuario que deseas eliminar:");
        String us = LEER.next();
        Iterator<Persona> it = comp.iterator();
        boolean bandera = false;
        while (it.hasNext()) {
            Persona emp = it.next();
            if (emp.getUsuario().equalsIgnoreCase(us)) {
                bandera = true;
                empleadoUsuarios.remove(emp);
            }
        }
        if (!bandera) {
            System.out.println("no se encontro el usuario...");
        }
        empleadoUsuarios.forEach((empleado) -> {
            System.out.println("Usuario: " + empleado.getUsuario());
        });
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
            System.out.println("USUARIO:");
            String us = LEER.next();
            System.out.println("CONTRASEÑA:");
            String pass = LEER.next();
            Iterator<Persona> it = empleadoUsuarios.iterator();
            while (it.hasNext()) {
                Persona emp = it.next();
                if (emp.getUsuario().equalsIgnoreCase(us) && emp.getContra().equalsIgnoreCase(pass)) {
                    aux = true;
                }
                //break;
            }
            cont++;
            if (cont == 3) {
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
