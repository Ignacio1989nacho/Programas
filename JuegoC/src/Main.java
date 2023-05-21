
import entidad.Baraja;
import entidad.Carta;
import java.util.ArrayList;

/*

 */
public class Main {

    public static void main(String[] args) {
        Baraja b = new Baraja();

        b.barajar();
        b.mostrarBaraja();
        System.out.println("=================");
        System.out.println("");
        b.cartasMonton();
        
      
        System.out.println("=================");
        System.out.println("");
        System.out.println(b.siguienteCarta());
        System.out.println("=================");
        System.out.println("");
        b.cartasDisponibles();
        System.out.println("=================");
        System.out.println("");
        ArrayList<Carta> c = b.darCartas(10);

        for (Carta carta : c) {
            System.out.println(carta);
        }
        System.out.println("=================");
        System.out.println("");
        b.cartasDisponibles();
        System.out.println("=================");
        System.out.println("");
        System.out.println(b.siguienteCarta());
        System.out.println("=================");
        System.out.println("");
        b.mostrarBaraja();
        System.out.println("=================");
        System.out.println("");
        limpiar();
        b.cartasMonton();
        

    }

    public static void limpiar() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
