
import entidad.Persona;
import java.util.ArrayList;
import service.ServiceFinanciera;
import service.validacionMenu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Persona> ar = new ArrayList();

        ServiceFinanciera sf = new ServiceFinanciera();
        boolean aux = true;
        do {

            switch (validacionMenu.confirmacionMenu()) {

                case 1:
                    ar.add(sf.crearPersonaBanco());

                    break;

                case 2:
                    sf.buscar(ar);
                    break;

                case 3:
                    sf.buscarPorApellido(ar);
                    break;

                case 4:
                    sf.saldoIngresar(ar);
                    break;

                case 5:
                    sf.saldoRestar(ar);
                    break;
                case 6:
                    
                    sf.creditoPersonal(ar);
                    break;

                case 7:
                    System.out.println("Cerrando programa...");
                    aux = false;
                    break;

            }
        } while (aux);

    }

}
