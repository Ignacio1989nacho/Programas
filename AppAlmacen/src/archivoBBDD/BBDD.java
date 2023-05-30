package archivoBBDD;

import entidad.Persona;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class BBDD {

    /**
     * Metodo crea un archivo txt en el escritorio... modificar a gusto.
     */
    public void clientesAr() {
        String nombre = "C:\\Users\\Usuario\\Desktop\\BBDDclientes\\productosBBDD.txt";
        crearArchivo(nombre);
    }

    /**
     * Metodo ingresa los datos del producto, con su valor en el archivo ubicado
     * en el escritorio.
     * @param nombreArchivo ruta donde el archivo se creara.
     * @param producto nombre del producto a registrar en el txt.
     * @param precio precio del producto a registrar en el txt.
     */
    protected void ingresarDatos(String nombreArchivo, String producto, Double precio) {

        HashMap<String, Double> lista = new HashMap();
        lista.put(producto, precio);
        try {
            try (
                    PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo, true))) {
                salida.println(lista);
            }
            System.out.println("Insertar...");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    /**
     * Metodo origin para crear la BBDD de extencion txt en donde el usuario 
     * indique la ruta.
     * @param nombreArchivo ruta donde se creara el archivo. 
     */
    protected void crearArchivo(String nombreArchivo) {
        File archivoBU = new File("backup.txt");
        File archivo = new File(nombreArchivo);
        if (!archivo.exists() && !archivoBU.exists()) {
            try {
                FileWriter salida = new FileWriter(archivo, true);
                FileWriter salida2 = new FileWriter(archivoBU, true);
                salida.close();
                salida2.close();
                System.out.println("BBDD PRODUCTOS CREADA");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        } else {
            System.out.println("La base de datos ya existe...");
        }
    }

    /**
     * Metodo crea un archivo txt, donde indique el usuario, en este caso
     * como ejemplo seria en el "Escritorio", dentro de la carpeta "BBDDClientes",
     * el nombre del archivo seria "usuariosBBDD", tambien crea el usuario con su
     * contraseña.
     * @param p obtiene los datos del objeto Persona. (usuario y contraseña).
     */
    protected void crearBBDDusuarios(Persona p) {
        File archivo = new File("C:\\Users\\Usuario\\Desktop\\BBDDclientes\\usuariosBBDD.txt");
        if (!archivo.exists()) {
            try {
                FileWriter salida = new FileWriter(archivo, true);
                salida.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        } else {
            System.out.println("MODIFICACION EN BBDD USUARIOS");
        }
        try {
            try ( //FileWriter fileWriter = new FileWriter(nombreArchivo, true);
                    PrintWriter salida = new PrintWriter(new FileWriter("C:\\Users\\Usuario\\Desktop\\BBDDclientes\\usuariosBBDD.txt", true))) {
                salida.println(p);
            }
            System.out.println("Insertar...");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

    }

    /**
     * Metodo solicita al usuario un nombre a buscar en la lista de productos.
     * @param nombre indicado por el usuario, para ser buscado en la lista de la 
     * BBDD de productos.
     * @return HashMap con los datos actualizados de la lista. LISTA COMPLETA
     * SIN MODIFICACION.
     */
    protected HashMap<String, Double> leerProductos(String nombre) {
        HashMap<String, Double> comp = new HashMap();
        boolean comprobacionPedido = false;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\BBDDclientes\\productosBBDD.txt"));
            String lectura;
            while ((lectura = entrada.readLine()) != null) {
                lectura = lectura.replace("{", "").replace("}", "");
                String[] partes = lectura.split("=");
                String producto = partes[0];
                Double precio = Double.parseDouble(partes[1]);
                comp.put(producto, precio);
            }
            System.out.println("buscar...");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        int cont = 0;
        for (Map.Entry<String, Double> parte : comp.entrySet()) {
            comprobacionPedido = (parte.getKey().equalsIgnoreCase(nombre));
            if (comprobacionPedido) {
                System.out.println("Producto: " + parte.getKey() + " Precio: $" + parte.getValue());
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("El producto no se encuentra en nuestra BBDD");
        }
        return comp;
    }

    /**
     * Metodo comprueba si el usuario ingresa correctamente, tanto el User como
     * PW. Obtiene los datos desde la BBDD "usuarios", las guarda en su propio
     * HashMap y luego realiza la comprobacion, devolviendo un valor booleano,
     * respectivamente.
     * @param user parametro que se le solicita al usuario.
     * @param contra parametro que se le solicita al usuario.
     * @return boolean TRUE si es correcto, FALSE incorrecto.
     */
    protected boolean iniciarSecion(String user, String contra) {

        HashMap<String, String> comp = new HashMap();
        boolean login = false;
        boolean comprobacionUser = false;
        boolean comprobacionContra = false;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\BBDDclientes\\usuariosBBDD.txt"));
            String lectura;
            while ((lectura = entrada.readLine()) != null) {
                lectura = lectura.replace("{", "").replace("}", "").replace("Empleado", "").replace("[", "").replace("]", "").replace("contra", "").replace("usuario", "").replace("=", "").replace(" ", "");
                String[] partes = lectura.split(",");
                if (partes.length >= 2) {
                    String usuario = partes[0];
                    String contrase = partes[1];
                    comp.put(usuario, contrase);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        for (Map.Entry<String, String> parte : comp.entrySet()) {
            comprobacionUser = (parte.getKey().equals(user));
            comprobacionContra = (parte.getValue().equals(contra));
            if (comprobacionUser && comprobacionContra) {
                login = true;
            }
        }
        return login;

    }

    /**
     * Metodo captura desde la BBDD "productos" la lista completa original, la
     * guarda en un HashMap propio y comprueba las repeticiones de datos, en el
     * caso que se repita algun dato, solamente imprimira el ultimo valor agregado.
     */
    protected void mostrarListaProductos() {
        HashMap<String, Double> lista = new HashMap();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\BBDDclientes\\productosBBDD.txt"));
            String lectura;
            while ((lectura = entrada.readLine()) != null) {
                lectura = lectura.replace("{", "").replace("}", "");
                String[] partes = lectura.split("=");
                String producto = partes[0];
                Double valor = Double.parseDouble(partes[1]);
                lista.put(producto, valor);
            }
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace(System.out);
        }
        ArrayList<String> compRepeticion = new ArrayList();
        for (String object : lista.keySet()) {
            compRepeticion.add(object);
        }

        for (int i = 0; i < compRepeticion.size(); i++) {

            for (int j = 0; j < compRepeticion.size(); j++) {

                if (compRepeticion.get(i).equals(compRepeticion.get(j))) {
                    lista.remove(i);
                }
            }
        }
        System.out.println("");
        System.out.println("==========================================");
        for (Map.Entry<String, Double> object : lista.entrySet()) {
            System.out.println("Producto: " + object.getKey() + "\n" + "Valor: $" + object.getValue());
        }
        System.out.println("==========================================");
        System.out.println("");

    }

    /**
     * Metodo en proceso.... Eliminar Producto...
     * @param nombre solicitado al usuario.
     */
    protected void eliminarProducto(String nombre) {

        try {
            BufferedReader entrada = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\BBDDclientes\\productosBBDD.txt"));
            String lectura;
            while ((lectura = entrada.readLine()) != null) {
                lectura = lectura.replace("{", "").replace("}", "");
                String[] partes = lectura.split("=");
                String producto = partes[0];
                Double valor = Double.parseDouble(partes[1]);
                if (nombre.equals(partes[0])) {

                }
            }
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace(System.out);
        }

        // en proceso....
    }

    /**
     * Metodo agrega un valor nuevo a un producto ya existente, para no borrar
     * la BBDD completa y actualziarla con otro valor, se guarda los valores 
     * originales de la BBDD productos y se hace una comparacion, donde el ultimo
     * valor ingresado es el que corresponde a lo que el usuario solicita.
     * 
     * @param nombre solicitado al usuario.
     * @param valor solicitado al usuario.
     */
    protected void modificarProducto(String nombre, Double valor) {
        HashMap<String, Double> temp = new HashMap();

        try {
            BufferedReader entrada = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\BBDDclientes\\productosBBDD.txt"));
            String lectura;
            while ((lectura = entrada.readLine()) != null) {
                lectura = lectura.replace("{", "").replace("}", "");
                String[] partes = lectura.split("=");
                String producto = partes[0];
                Double v = Double.parseDouble(partes[1]);
                temp.put(producto, v);
            }
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace(System.out);
        }
        String pro = "";
        Double val = 0d;
        for (Map.Entry<String, Double> object : temp.entrySet()) {
            if (nombre.equals(object.getKey())) {
                pro = nombre;
                val = valor;
            }
        }
        ingresarDatos("C:\\Users\\Usuario\\Desktop\\BBDDclientes\\productosBBDD.txt", pro, val);
    }

}
