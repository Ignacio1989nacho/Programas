package servicio;

import Enumeraciones.Enum;
import entidad.Cine;
import entidad.Espectador;
import entidad.Pelicula;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ServicioCine {

    /**
     * Metodo dibuja sala vacia...
     */
    private void mostrarSalaVacia() {

        int cont = 0;
        for (int i = 8; i > 0; i--) {
            for (int j = 0; j < 6; j++) {
                System.out.print(Enum.values()[cont] + " | ");
                cont++;
            }
            System.out.println("");
        }
    }

    /**
     * Metodo crea el objeto cine con sus atributos
     *
     * @return obj cine con atributos.
     */
    private Cine cineSalas() {

        //HashMap<Integer,String> sala = 
        double precio = Math.round(Math.random() * 1000) + 1;
        return new Cine(peliculas(), precio);
    }

    /**
     * Metodo crea cada objeto espectador, con sus respectivos atributos
     *
     * @return ArrayList con el objeto espectador
     */
    private ArrayList<Espectador> crearEspectadores() {

        ArrayList<Espectador> espectadores = new ArrayList();
        for (int i = 0; i < 48; i++) {
            int edad = (int) (Math.random() * 40) + 1;
            double dinero = (Math.random() * 1500) * 1;
            double dineroRedondeado = Math.round(dinero);
            espectadores.add(new Espectador(("Espectador" + (i + 1)), edad, dineroRedondeado));
        }
        return espectadores;
    }

    /**
     * Metodo crea el objeto pelicula con sus respectivos atributos
     *
     * @return una arraylist con las peliculas
     */
    private ArrayList<Pelicula> peliculas() {
        ArrayList<Pelicula> p = new ArrayList();
        for (int i = 0; i < 6; i++) {
            int duracion = (int) (Math.random() * 120) + 60;
            int edadMin = (int) (Math.random() * 40) + 1;
            //double precio = Math.round(Math.random() * 30) + 1;
            p.add(new Pelicula(("Pelicula" + (i + 1)), duracion, edadMin));
        }
        return p;
    }

    /**
     * Metodo dibuja la sala con los asientos ocupados, dependiendo los
     * parametros para ver la pelicula
     *
     * @param op eleccion de pelicula del usuario, del menu.
     * @param p arraylist de peliculas
     * @param e arraylist de espectadores
     */
    private void matrizArrayList(int op, Pelicula p, ArrayList<Espectador> e, Cine c) {

        ArrayList<Integer> num = new ArrayList(){{add("1");add("2");add("3");add("4");add("5");add("6");add("7");add("8");}};
        ArrayList<String> letra = new ArrayList(){{add("A");add("B");add("C");add("D");add("E");add("F");}};
        System.out.println("Edad minima para ver la pelicula: " + p.getEdadMinima());
        System.out.println("Precio: $" + c.getPrecioEntrada());
        int aceptados = 0;
        int rechazados = 0;
        HashMap<Integer, String> capacidadSala = new HashMap();
        for (int i = 0; i < e.size(); i++) {
            boolean aux1 = (c.getListaPelis().get(op).getEdadMinima() > e.get(i).getEdad());
            boolean aux2 = (c.getPrecioEntrada() > e.get(i).getDineroDisponible());
            if (aux1 || aux2) {
                rechazados++;
                System.out.println("==**RECHAZADO**== - " + e.get(i) + "==**RECHAZADO**== - ");
            } else {
                e.get(i).setDineroDisponible(e.get(i).getDineroDisponible() - c.getPrecioEntrada());
                System.out.println("ACEPTADO - " + e.get(i) + " | Vuelto: $" + e.get(i).getDineroDisponible());
                aceptados++;
                capacidadSala.put(aceptados, e.get(i).getNombre());
            }
        }
        c.setSalaCapacidad(capacidadSala);
        System.out.println("");
        System.out.println("========================================================");
        System.out.println("La cantidad de espectadores aceptados son: " + aceptados);
        System.out.println("La cantidad de espectadores rechazados son: " + rechazados);
        for (int i = num.size() - 1; i > 0; i--) {
            for (int j = 0; j < letra.size(); j++) {
                if (aceptados > 0) {
                    System.out.print(letra.get(j) + num.get(i) + "X| ");
                    aceptados--;
                } else {
                    System.out.print(letra.get(j) + num.get(i) + " | ");
                }
            }
            System.out.println("");
        }
    }

    /**
     * menu general con espectadores, peliculas y dibujo de la sala.
     */
    public void cineGeneral() {

        Scanner Leer = new Scanner(System.in).useDelimiter("\n");
        Cine c = cineSalas();
        System.out.println("========================== CINE MANOLITO =====================");
        System.out.println("========================== 6 SALDAS ==========================");
        System.out.println("");
        System.out.println("====================================================");
        System.out.println("FILA DE ESPECTADORES");
        System.out.println("====================================================");
        System.out.println("");
        ArrayList<Espectador> e = crearEspectadores();
        System.out.println("| | | | | | **** | | | | | |");
        for (int i = 0; i < e.size(); i++) {
            System.out.print("NOMBRE: " + e.get(i).getNombre() + "\n" + "EDAD: " + e.get(i).getEdad() + "\n"
                    + "DINERO DISPONIBLE: $" + e.get(i).getDineroDisponible());
            System.out.println("");
            System.out.println("| | | | | | **** | | | | | |");
        }
        System.out.println("====================================================");
        System.out.println("====================================================");
        System.out.println("");
        System.out.println("====================================================");
        System.out.println("PELICULAS EN CARTELERA");
        System.out.println("====================================================");
        System.out.println("");
        System.out.println("***************---***************");
        for (int i = 0; i < c.getListaPelis().size(); i++) {
            System.out.print("TITULO: " + c.getListaPelis().get(i).getTitulo() + "\n" + "\n"
                    + "DURACION: " + c.getListaPelis().get(i).getDuracion() + "\n" + "EDAD MINIMA PARA VERLA: "
                    + c.getListaPelis().get(i).getEdadMinima());
            System.out.println("");
            System.out.println("***************---***************");
        }
        System.out.println("====================================================");
        System.out.println("TIPO DE SALA");
        System.out.println("====================================================");
        mostrarSalaVacia();
        System.out.println("====================================================");
        System.out.println("====================================================");
        System.out.println("");
        System.out.println("Selecciona la pelicula a la cual quieres que ingresen los espectadores:");
        for (int i = 0; i < c.getListaPelis().size(); i++) {
            System.out.print((i + 1) + " - " + c.getListaPelis().get(i).getTitulo());
            System.out.println("Precio: $" + c.getPrecioEntrada());
            System.out.println("");
        }
        int op = Leer.nextInt();
        Pelicula peli = c.getListaPelis().get(op - 1);
        matrizArrayList(op - 1, peli, e, c);
        System.out.println(c.toString());

    }

}
