/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidad.Persona;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ServiceFinanciera {

    private final Scanner LEER = new Scanner(System.in).useDelimiter("\n");

    /**
     * Metodo crea la persona con sus atributos
     *
     * @return Objeto de tipo Persona
     */
    public final Persona crearPersonaBanco() {
        boolean aux = true;
        String nombre = "";
        String apellido = "";
        int edad = 0;
        int dni = 0;
        String numeroCuenta = "";
        int saldo = 0;

        do {

            try {
                System.out.println("Ingresa el nombre");
                nombre = LEER.next();
                System.out.println("Ingresa el apellido:");
                apellido = LEER.next();
                System.out.println("Ingresa la edad:");
                edad = LEER.nextInt();
                System.out.println("Ingresa el DNI");
                dni = LEER.nextInt();

                String random = String.valueOf((int) (Math.random() * 1000));

                numeroCuenta = random + String.valueOf(dni);
                saldo = 0;

                aux = false;

            } catch (InputMismatchException e) {

                System.out.println("Error: entrada inválida. Por favor ingrese valores...");
                LEER.nextLine(); // Limpiar el buffer del scanner}
                break;
            } catch (NumberFormatException e) {

                System.out.println("Error: entrada inválida. Por favor ingrese valores!!!!...");
                LEER.nextLine(); // Limpiar el buffer del scanner}
                break;
            }

        } while (aux);

        return new Persona(nombre, apellido, edad, dni, numeroCuenta, saldo);
    }

    /**
     * metodo ingresa saldo a la cuenta
     *
     * @param cliente recibe un arraylist con objeto de tipo persona
     */
    public final void saldoIngresar(ArrayList<Persona> cliente) {

        Scanner Leer = new Scanner(System.in).useDelimiter("\n");
        boolean aux = true;
        do {
            listaClientes.mostrarListas(cliente);
            System.out.println("Seleccione el numero de cuenta para sumarle saldo:");
            try {

                String nCuenta = Leer.next();

                int a = Integer.parseInt(nCuenta);

                Iterator<Persona> cl = cliente.iterator();

                int nuevoSaldo = 0;

                while (cl.hasNext()) {
                    Persona p = cl.next();

                    if (p.getnCuenta().equals(nCuenta)) {

                        aux = validacionSaldos.sumar(cliente, p);
                    }
                }

            } catch (InputMismatchException e) {

                System.out.println("Error: entrada inválida. Por favor ingrese valores...");
                Leer.nextLine(); // Limpiar el buffer del scanner}
                break;
            } catch (NumberFormatException e) {

                System.out.println("Error: entrada inválida. Por favor ingrese valores!!!!...");
                Leer.nextLine(); // Limpiar el buffer del scanner}
                break;
            }

        } while (aux);

    }

    /**
     * Metodo asigna credito para el cliente
     *
     * @param cliente recibe arraylist con objeto persona
     */
    public final void creditoPersonal(ArrayList<Persona> cliente) {

        Scanner Leer = new Scanner(System.in).useDelimiter("\n");

        boolean aux = true;
        do {
            listaClientes.mostrarListas(cliente);
            System.out.println("Seleccione el numero de cuenta del cliente para solicitar credito:");
            try {
                String nCuenta = "";

                nCuenta = Leer.next();

                int a = Integer.parseInt(nCuenta);

                Iterator<Persona> cl = cliente.iterator();

                int nuevoSaldo = 0;

                while (cl.hasNext()) {
                    Persona p = cl.next();

                    if (p.getnCuenta().equals(nCuenta)) {
                        double porcentajeCredido = (p.getSaldo() * 30 / 100);
                        if (p.isCredito() == true) {
                            System.out.println("Ya posee un credito en su cuenta.... otorgado el dia: " + validacionFecha.fechaFormat(cliente, p));
                            aux = false;
                        } else {
                            if (porcentajeCredido >= 100000) {

                                creditoCuotas.cuotasCantidad(p);

                                aux = false;

                            } else {

                                System.out.println("No califica para el credito, necesita tener mas saldo en su cuenta.");
                                Leer.nextLine();

                            }
                        }

                    }
                }
            } catch (InputMismatchException e) {

                System.out.println("Error: entrada inválida. Por favor ingrese valores...");
                Leer.nextLine(); // Limpiar el buffer del scanner}
                break;
            } catch (NumberFormatException e) {

                System.out.println("Error: entrada inválida. Por favor ingrese valores!!!!...");
                Leer.nextLine(); // Limpiar el buffer del scanner}
                break;
            }

        } while (aux);
    }

    /**
     * Metodo resta saldo en la cuenta del cliente
     *
     * @param cliente recibe arraylist con objeto persona
     */
    public final void saldoRestar(ArrayList<Persona> cliente) {

        Scanner Leer = new Scanner(System.in).useDelimiter("\n");

        boolean aux = true;
        do {
            listaClientes.mostrarListas(cliente);
            System.out.println("Seleccione el numero de cuenta para restarle el saldo:");
            try {
                String nCuenta = Leer.next();
                int a = Integer.parseInt(nCuenta);

                Iterator<Persona> cl = cliente.iterator();
                int nuevoSaldo = 0;
                while (cl.hasNext()) {
                    Persona p = cl.next();

                    if (p.getnCuenta().equals(nCuenta)) {

                        aux = validacionSaldos.restar(cliente, p);

                    }
                }

            } catch (InputMismatchException e) {

                System.out.println("Error: entrada inválida. Por favor ingrese valores...");
                Leer.nextLine(); // Limpiar el buffer del scanner}
                break;
            } catch (NumberFormatException e) {

                System.out.println("Error: entrada inválida. Por favor ingrese valores!!!!...");
                Leer.nextLine(); // Limpiar el buffer del scanner}
                break;
            }

        } while (aux);

    }

    /**
     * Metodo muestra lista del cliente segun el dni
     *
     * @param cliente recibe arraylist con objeto persona
     */
    public final void buscar(ArrayList<Persona> cliente) {

        Scanner Leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresa el DNI del cliente:");
        int dni = Leer.nextInt();
        listaClientes.buscarClienteDni(cliente, dni);
        System.out.println("======================");
       

    }

    /**
     * Metodo muestra lista del cliente por apellido.
     *
     * @param cliente recibe arraylist con objeto persona.
     */
    public final void buscarPorApellido(ArrayList<Persona> cliente) {

        listaClientes.clientePorApellido(cliente);

    }

}
