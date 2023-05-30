
import java.io.*;


public class testMain {
    public static void main(String[] args) {
        
        
        crearArchivo("bbdd.txt");
        crearArchivo("C:\\Users\\Usuario\\Desktop\\BBDDclientes\\clientesBBDD.txt");
        
        }
        public static void crearArchivo(String nombreArchivo){
        
        File archivo = new File(nombreArchivo);
        
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se creo la base de datos...");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
