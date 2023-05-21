package servicio;

import Enum.TiposPerro;
import entidad.Perro;
import entidad.Persona;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ServicioMascotas {

    private ArrayList<String> perros = new ArrayList();// RECONTRA MALA PRACTICA... MALISIMA MUY MALA HORRIBLE 

    /**
     * Metodo crea la persona con sus atributos
     *
     * @return objeto de tipo persona
     */
    private Persona crearClientes() {
        int edad = 0;
        int dni = 0;
        boolean aux = false;
        Scanner Leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Nombre:");
        String nombre = Leer.next();
        System.out.println("Apellido:");
        String apellido = Leer.next();

        do {
            try {
                System.out.println("Edad:");
                edad = Leer.nextInt();
                System.out.println("DNI:");
                dni = Leer.nextInt();
                aux = true;
            } catch (Exception e) {
                System.out.println("Ingresa un valor numerico.....");
                Leer.nextLine();
            }

        } while (!aux);
        return new Persona(nombre, apellido, edad, dni);

    }

    /**
     * Metodo evalua si el perro ya fue adoptado...
     *
     * @param op tipo string de seleccion de perro
     * @return boolean si el elemento no se encuentra en el arraylist -perro-
     */
    private boolean consultaMascotasAdoptadas(String op) {
        boolean aux = false;

        for (int i = 0; i < perros.size(); i++) {
            if (perros.get(i).equalsIgnoreCase(op)) {
                aux = true;
                return aux;
            }
        }
        perros.add(op);
        return aux;
    }

    /**
     * Metodo muestra el menu de perros a elejir
     *
     * @return un int que de seleccion
     */
    private String menuPerros() {
        Scanner Leer = new Scanner(System.in).useDelimiter("\n");
        String op = "";
        System.out.println("Menu de Perros para adoptar: \n" + " - DOBERMAN\n" + " - BULLDOG\n" + " - CANICHE\n" + " - ROTWILLER\n" + " - OVEJERO\n"
                + " - BULLTERRIER\n" + " - GALGO\n" + " - DECALLE\n");
        op = Leer.next();
        return op.toUpperCase();

    }

    /**
     * Metodo crea el tipo de perro seleccionado por el usuario, tambien agrega
     * a un arraylist los perros seleccionados para que no se repitan.
     *
     * @param op int de menu de perros, sirve para elejir el perro en la
     * posicion en la que se encuentra
     * @return un objeto de tipo perro con nombre y tipo
     */
    private Perro seleccionPerro(String op) {
        boolean aux = false;
        do {
            boolean aux2 = consultaMascotasAdoptadas(op);
            if (aux2) {
                System.out.println("ESE PERRO YA TIENE DUEÑO....");
                 op = menuPerros();
            } else {
                aux = true;
            }
        } while (!aux);
        Perro p = new Perro("Fer chiquito", TiposPerro.valueOf(op));
        return p;
    }

    /**
     * Metodo para ingresar la cantidad de clientes que desean seleccionar el
     * perro
     *
     * @param cantidad de tipo int se solicita al usuario cuantos clientes
     * vienen a buscar un perro
     * @return un hashset de tipo persona. creado con sus atributos
     */
    private HashSet<Persona> cantidadUsuarios(int cantidad) {

        HashSet<Persona> p = new HashSet();
        for (int i = 0; i < cantidad; i++) {
            p.add(crearClientes());
        }
        return p;
    }

    /**
     * Metodo asigna a cada usuario el perro que desea
     *
     * @param p hasset de persona
     */
    private void asignacionDeMascota(HashSet<Persona> p) {
        Scanner Leer = new Scanner(System.in).useDelimiter("\n");
        Iterator<Persona> listaPersonas = p.iterator();
        for (int i = 0; i < p.size(); i++) {
            ArrayList<Perro> perro = new ArrayList();
            Persona per = listaPersonas.next();
            System.out.println(per.getNombre() + " Cuantos perros quieres:");
            int cantidadPerros = Leer.nextInt();
            for (int j = 0; j < cantidadPerros; j++) {
                String op = menuPerros();
                Perro pp = seleccionPerro(op);
                perro.add(pp);
            }
            per.setPerros(perro);
        }
    }

    /**
     * Muestra el cliente con la mascota seleccionada
     *
     * @param p hashset de tipo persona
     */
    private void mostrarPersonaConMascota(HashSet<Persona> p) {
        System.out.println("============================");
        for (Persona persona : p) {
            System.out.println(persona.getNombre() + " Tiene Adoptados:\n" + persona.getPerros().toString());
        }
    }

    /**
     * Metodo para ser llamado desde el main, donde en el mismo llama a los
     * demas metodos mencionados.
     */
    public void generalSeleccion() {
        boolean aux = false;
        int cantidadClientes = 0;
        Scanner Leer = new Scanner(System.in).useDelimiter("\n");
        do {
            try {
                System.out.println("Cuantos clientes quieren sus perros...");
                cantidadClientes = Leer.nextInt();
                aux = true;
            } catch (Exception e) {

                System.out.println("Ingresa un valor numerico....");
                Leer.nextLine(); // LIMPIAR BUFFER...
            }
        } while (!aux);
        HashSet<Persona> p = cantidadUsuarios(cantidadClientes);
        asignacionDeMascota(p);
        mostrarPersonaConMascota(p);

    }
}
