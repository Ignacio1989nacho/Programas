/*
Gestión de vehículos. Se registra la información de cada vehículo asegurado. Marca,
modelo, año, número de motor, chasis, color, tipo (camioneta, sedán, etc.).
 */
package entidad;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class GestionVehiculo {

    private String marca;
    private String modelo;
    private String color;
    private String tipo;
    private Integer numeroMotor;
    private Integer chasis;
    private Integer anio;

    public GestionVehiculo() {
    }

    public GestionVehiculo(String marca, String modelo, String color, String tipo, Integer numeroMotor, Integer chasis, Integer anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
        this.numeroMotor = numeroMotor;
        this.chasis = chasis;
        this.anio = anio;
    }

    public Integer getAnio() {
        return this.anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumeroMotor() {
        return this.numeroMotor;
    }

    public void setNumeroMotor(Integer numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public Integer getChasis() {
        return this.chasis;
    }

    public void setChasis(Integer chasis) {
        this.chasis = chasis;
    }

    @Override
    public String toString() {
        return "GestionVehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", tipo=" + tipo + ", numeroMotor=" + numeroMotor + ", chasis=" + chasis + ", anio=" + anio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.marca);
        hash = 47 * hash + Objects.hashCode(this.modelo);
        hash = 47 * hash + Objects.hashCode(this.color);
        hash = 47 * hash + Objects.hashCode(this.tipo);
        hash = 47 * hash + Objects.hashCode(this.numeroMotor);
        hash = 47 * hash + Objects.hashCode(this.chasis);
        hash = 47 * hash + Objects.hashCode(this.anio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GestionVehiculo other = (GestionVehiculo) obj;
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.numeroMotor, other.numeroMotor)) {
            return false;
        }
        if (!Objects.equals(this.chasis, other.chasis)) {
            return false;
        }
        if (!Objects.equals(this.anio, other.anio)) {
            return false;
        }
        return true;
    }
    
    

}
