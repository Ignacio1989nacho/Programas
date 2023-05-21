/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import enumeraciones.Palo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Baraja {

    private ArrayList<Carta> cartas;
    private ArrayList<Carta> cartasOut = new ArrayList();

    public Baraja() {
        cartas = new ArrayList();

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 13; j++) {
                if (j != 8 && j != 9) {
                    cartas.add(new Carta(j, Palo.values()[i]));
                }
            }
        }
    }

    public Baraja(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public void barajar() {

        Collections.shuffle(cartas);

    }

    public Carta siguienteCarta() {
        Carta c = null;
        if (cartas.isEmpty()) {
            System.out.println("No hay mas cartas en el mazo...");
            return c;
        } else {
            c = cartas.get(0);
            cartasOut.add(c);
            cartas.remove(0);
            return c;
        }
    }

    public void cartasDisponibles() {

        System.out.println("cartas disponibles: " + cartas.size());

    }

    public ArrayList<Carta> darCartas(int num) {
        ArrayList<Carta> c = new ArrayList();
        if (num > cartas.size()) {

            System.out.println("No hay tantas cartas en la baraja...");

            return c;
        } else {
            for (int i = 0; i < num; i++) {
                c.add(cartas.get(0));
                cartasOut.add(cartas.get(0));
                cartas.remove(0);
            }
            return c;
        }

    }

    public void mostrarBaraja() {

        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }

    public void cartasMonton() {

        if (cartasOut.isEmpty()) {
            System.out.println("Todavia no se repartieron cartas...");

        } else {
            for (Carta carta : cartasOut) {
                System.out.println(carta);
            }
        }

    }

}
