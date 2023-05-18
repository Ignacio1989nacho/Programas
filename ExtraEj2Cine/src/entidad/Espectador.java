
package entidad;


public class Espectador {
    
    private String nombre;
    private Integer edad;
    private Double dineroDisponible;

    public Espectador() {
    }

    public Espectador(String nombre, Integer edad, Double dineroDisponible) {
        this.nombre = nombre;
        this.edad = edad;
        this.dineroDisponible = dineroDisponible;
    }

    public Double getDineroDisponible() {
        return dineroDisponible;
    }

    public void setDineroDisponible(Double dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Espectador{" + "nombre=" + nombre + ", edad=" + edad + ", dineroDisponible=" + dineroDisponible + '}';
    }
    
    
    
}
