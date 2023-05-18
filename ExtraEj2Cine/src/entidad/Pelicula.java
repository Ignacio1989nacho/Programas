package entidad;

public class Pelicula {

    private String titulo;
    private Integer duracion;
    private Integer edadMinima;

    public Pelicula() {
    }

    public Pelicula(String titulo, Integer duracion, Integer edadMinima) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }



    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", duracion=" + duracion +  ", edadMinima=" + edadMinima + '}';
    }

}
