package service;

import entidad.Administrador;
import entidad.GestionCuota;
import entidad.GestionIntegralCliente;
import entidad.GestionPoliza;
import entidad.GestionVehiculo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import enumeraciones.*;

public class ServicioPoliza {

    private final Scanner LEER = new Scanner(System.in).useDelimiter("\n");

    /**
     * Metodo genera un objeto de tipo cliente
     *
     * @return devuelve objeto tipo cliente
     */
    private GestionIntegralCliente cliente() {
        boolean aux = true;
        int tel = 0;

        System.out.println("Ingresa el nombre del cliente:");
        String nombre = LEER.next();
        System.out.println("Ingresa el apellido del cliente:");
        String apellido = LEER.next();
        System.out.println("Ingresa el email del cliente:");
        String email = LEER.next();
        System.out.println("Ingresa el domicilio del cliente:");
        String dom = LEER.next();
        do {
            try {
                System.out.println("Ingresa el telefono del cliente:");
                tel = LEER.nextInt();
                aux = false;
            } catch (Exception e) {
                System.out.println("El numero de telefono es incorrecto... ingrese uno valido porfavor..");
                LEER.nextLine();// LIMPIAR BUFFER
            }
        } while (aux);
        return new GestionIntegralCliente(nombre, apellido, email, dom, tel);
    }

    /**
     * Metodo genera un objeto de tipo vehiculo
     *
     * @return devuelve objeto tipo vehiculo
     */
    private GestionVehiculo vehiculo() {
        int numeroDelMotor = 0;
        int numeroChasis = 0;
        int anio = 0;
        boolean aux = true;
        System.out.println("Marca del coche:");
        String marca = LEER.next();
        System.out.println("Modelo del coche:");
        String modelo = LEER.next();
        System.out.println("Color del coche:");
        String color = LEER.next();
        System.out.println("Tipo del coche:");
        String tipo = LEER.next();
        do {
            try {
                System.out.println("Numero del motor del coche:");
                numeroDelMotor = LEER.nextInt();
                System.out.println("Numero del chasis del coche:");
                numeroChasis = LEER.nextInt();
                System.out.println("Año del coche:");
                anio = LEER.nextInt();
                aux = false;
            } catch (Exception e) {
                System.out.println("Ingresa un valor correcto..");
                LEER.nextLine();// LIMPIAR BUFFER...
            }
        } while (aux);
        return (new GestionVehiculo(marca, modelo, color, tipo, numeroDelMotor, numeroChasis, anio));
    }

    /**
     * Metodo genera un objeto de tipo gestioncuota
     *
     * @return devuelve objeto tipo gestioncuota
     */
    private GestionCuota gestionCuota() {
        String tipoPago = "";
        double montoCuota = 0;
        boolean aux = false;
        int tipoCobertura = 0;
        boolean aux2 = true;
        do {
            System.out.println("EFECTIVO \nCREDITO \nTRANSFERENCIA ");
            tipoPago = LEER.next().toUpperCase();
            boolean comprobacion1 = tipoPago.equals(enumeraciones.FormaPago.values()[0].toString());
            boolean comprobacion2 = tipoPago.equals(enumeraciones.FormaPago.values()[1].toString());
            boolean comprobacion3 = tipoPago.equals(enumeraciones.FormaPago.values()[2].toString());
            if (comprobacion1 || comprobacion2 || comprobacion3) {
                aux2 = false;
            }
        } while (aux2);

        do {
            try {
                System.out.println("Elija la categoria de su coche:\n1 - Total \n2 - Contra terceros\n3 - Parcial");
                tipoCobertura = LEER.nextInt();
                switch (tipoCobertura) {
                    case 1:
                        montoCuota = 15000.00;
                        aux = true;
                        break;
                    case 2:
                        montoCuota = 5000.00;
                        aux = true;
                        break;
                    case 3:
                        montoCuota = 8000.00;
                        aux = true;
                        break;

                    default:
                        System.out.println("SELECCION INCORRECTA...");
                        aux = false;
                }
            } catch (Exception e) {
                System.out.println("VALOR INGRESADO INCORRECTO!! ingresa un valor valido...");
                LEER.nextLine();/// LIMPIAR BUFFER}
            }
        } while (!aux);
        Date fecha = new Date();
        return (new GestionCuota(tipoCobertura, montoCuota, true, fecha, tipoPago));
    }

    /**
     * Metodo genera la poliza
     *
     * @param v objeto tipo vehiculo
     * @param c objeto de tipo cliente
     * @param g objeto de tipo cuota
     * @return Retorna un hashset con objeto gestionpoliza.
     */
    private HashSet<GestionPoliza> gestionPoliza(GestionVehiculo v, GestionIntegralCliente c, GestionCuota g) {

        String tipoPago = g.getTipoPago();
        boolean granizo = false;
        String tipoCobertura = "";
        if (g.getMontoCuota() == 15000.00) {
            tipoCobertura = "Total";
        } else if (g.getMontoCuota() == 5000.00) {
            tipoCobertura = "Contra terceros";
        } else {
            tipoCobertura = "Parcial";
        }
        if (g.getnCuota().equals(1)) {
            granizo = true;
        }
        HashSet<GestionPoliza> cocheDatosGenerales = new HashSet();
        int numPoliza = (int) (Math.random() * 10000) + 1;
        Date fecha = new Date();

//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//
//        // Formatear la fecha
//        String fechaFormateada = formato.format(fecha);
        Date fecha2 = new Date(fecha.getYear() - 1900, fecha.getDate(), fecha.getMonth() + 1);
        cocheDatosGenerales.add(new GestionPoliza(c, v, numPoliza, fecha, fecha2, 150000.00, 6, tipoPago, granizo, 15000.00, tipoCobertura, g));
        return cocheDatosGenerales;
    }
/**
 * Metodo para logear un usuario con su respectiva contraseña
 * @return boolean en caso de que los datos ingresados sean correctos....
 */
    private boolean login() {
        boolean aux = false;
        Administrador adm = new Administrador();
        HashMap<String, String> a = adm.getAdm();
        System.out.println("Ingresa el usuario: ");
        String user = LEER.next();
        System.out.println("Ingresa la contraseña: ");
        String contra = LEER.next();
        for (Map.Entry<String, String> object : a.entrySet()) {
            if (object.getKey().equals(user) && object.getValue().equals(contra)) {
                aux = true;
            }
        }
        return aux;

    }

    /**
     * Metodo genera completamente la poliza con los datos del cliente.
     */
    public void general() {
        boolean log = false;
        boolean aux = false;
        boolean aux2 = false;
        int numeroCliente = 0;
        HashMap<Integer, HashSet<GestionPoliza>> clienteListas = new HashMap();
        ArrayList<GestionVehiculo> gs = new ArrayList();

        while (!login());

        do {
            aux2 = false;
            aux = false;
            GestionIntegralCliente c = cliente();
            GestionVehiculo v = vehiculo();
            Iterator<GestionVehiculo> comp = gs.iterator();
            while (comp.hasNext()) {
                GestionVehiculo vehiculo = comp.next();
                boolean aux1 = vehiculo.getNumeroMotor().equals(v.getNumeroMotor());
                boolean aux3 = vehiculo.getChasis().equals(v.getChasis());
                if (aux1 || aux3) {
                    System.out.println("YA EXISTE EL VEHICULO...");
                    aux2 = true;
                }
            }
            if (aux2) {
                System.out.println("lo sentimos el coche ya existe... ");
            } else {
                numeroCliente++;
                gs.add(v);
                GestionCuota g = gestionCuota();
                clienteListas.put(numeroCliente, gestionPoliza(v, c, g));
            }
            System.out.println("Crear nueva poliza: S/N");
            String op = LEER.next();
            if (!op.substring(0, 1).equalsIgnoreCase("n")) {
                aux = true;
            }
        } while (aux);
        System.out.println("MOSTRAR");
        for (Map.Entry<Integer, HashSet<GestionPoliza>> object : clienteListas.entrySet()) {
            System.out.println("================================================");
            System.out.println("Numero de cliente: " + object.getKey());
            System.out.println("Datos del la poliza: " + object.getValue());
            System.out.println("================================================");
            System.out.println("");

        }

    }

}
