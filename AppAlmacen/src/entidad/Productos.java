package entidad;
// en lo conveniente cambiar instanciar productos con sus atributos. y modificar el
// tipo de lista creado en AlmacenServicio.
public class Productos {

    private Double precio;
    private String producto;

    public Productos() {
    }

    public Productos(Double precio, String producto) {
        this.precio = precio;
        this.producto = producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Productos{" + "precio=" + precio + ", producto=" + producto + '}';
    }

}
