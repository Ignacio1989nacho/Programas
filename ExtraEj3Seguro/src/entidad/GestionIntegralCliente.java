
package entidad;


public class GestionIntegralCliente {

    
    private String nombre,apellido,mail,domicilio;
    private Integer tel;

    public GestionIntegralCliente() {
    }
    
    public GestionIntegralCliente(String nombre, String apellido, String mail, String domicilio, Integer tel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.domicilio = domicilio;
        this.tel = tel;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getTel() {
        return this.tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "GestionIntegralCliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", domicilio=" + domicilio + "tel=" + tel + '}';
    }
    
    
    
    
}
