/*
Se registrará una póliza, donde se guardará los datos tanto de un
vehículo, como los datos de un solo cliente. Los datos incluidos en ella son: número de
póliza, fecha de inicio y fin de la póliza, cantidad de cuotas, forma de pago, monto total
asegurado, incluye granizo, monto máximo granizo, tipo de cobertura (total, contra
terceros, etc.). Nota: prestar atención al principio de este enunciado y pensar en las
relaciones entre clases. Recuerden que pueden ser de uno a uno, de uno a muchos, de
muchos a uno o de muchos a muchos.
 */
package entidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;



public class GestionPoliza {
    
    private GestionIntegralCliente cliente;
    private GestionVehiculo auto;
    private Integer numeroPoliza;
    private Date fechaInicioPoliza ;
    private Date fechaFinPoliza;
    private Double montoTotalAsegurado;
    private Integer cantidadCoutas;
    private String formaPago;
    private Boolean granizo;
    private Double montoMaxGranizo;
    private String tipoCobertura;
    private GestionCuota gestionCuota;

    public GestionPoliza() {
    }

    public GestionPoliza(GestionIntegralCliente cliente, GestionVehiculo auto, Integer numeroPoliza, Date fechaInicioPoliza, Date fechaFinPoliza, Double montoTotalAsegurado, Integer cantidadCoutas, String formaPago, Boolean granizo, Double montoMaxGranizo, String tipoCobertura, GestionCuota gestionCuota) {
        this.cliente = cliente;
        this.auto = auto;
        this.numeroPoliza = numeroPoliza;
        this.fechaInicioPoliza = fechaInicioPoliza;
        this.fechaFinPoliza = fechaFinPoliza;
        this.montoTotalAsegurado = montoTotalAsegurado;
        this.cantidadCoutas = cantidadCoutas;
        this.formaPago = formaPago;
        this.granizo = granizo;
        this.montoMaxGranizo = montoMaxGranizo;
        this.tipoCobertura = tipoCobertura;
        this.gestionCuota = gestionCuota;
    }

    public GestionIntegralCliente getCliente() {
        return cliente;
    }

    public void setCliente(GestionIntegralCliente cliente) {
        this.cliente = cliente;
    }

    public GestionVehiculo getAuto() {
        return auto;
    }

    public void setAuto(GestionVehiculo auto) {
        this.auto = auto;
    }

    public Integer getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(Integer numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public Date getFechaInicioPoliza() {
        return fechaInicioPoliza;
    }

    public void setFechaInicioPoliza(Date fechaInicioPoliza) {
        this.fechaInicioPoliza = fechaInicioPoliza;
    }

    public Date getFechaFinPoliza() {
        return fechaFinPoliza;
    }

    public void setFechaFinPoliza(Date fechaFinPoliza) {
        this.fechaFinPoliza = fechaFinPoliza;
    }

    public Double getMontoTotalAsegurado() {
        return montoTotalAsegurado;
    }

    public void setMontoTotalAsegurado(Double montoTotalAsegurado) {
        this.montoTotalAsegurado = montoTotalAsegurado;
    }

    public Integer getCantidadCoutas() {
        return cantidadCoutas;
    }

    public void setCantidadCoutas(Integer cantidadCoutas) {
        this.cantidadCoutas = cantidadCoutas;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Boolean getGranizo() {
        return granizo;
    }

    public void setGranizo(Boolean granizo) {
        this.granizo = granizo;
    }

    public Double getMontoMaxGranizo() {
        return montoMaxGranizo;
    }

    public void setMontoMaxGranizo(Double montoMaxGranizo) {
        this.montoMaxGranizo = montoMaxGranizo;
    }

    public String getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(String tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    public GestionCuota getGestionCuota() {
        return gestionCuota;
    }

    public void setGestionCuota(GestionCuota gestionCuota) {
        this.gestionCuota = gestionCuota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.cliente);
        hash = 89 * hash + Objects.hashCode(this.auto);
        hash = 89 * hash + Objects.hashCode(this.numeroPoliza);
        hash = 89 * hash + Objects.hashCode(this.fechaInicioPoliza);
        hash = 89 * hash + Objects.hashCode(this.fechaFinPoliza);
        hash = 89 * hash + Objects.hashCode(this.montoTotalAsegurado);
        hash = 89 * hash + Objects.hashCode(this.cantidadCoutas);
        hash = 89 * hash + Objects.hashCode(this.formaPago);
        hash = 89 * hash + Objects.hashCode(this.granizo);
        hash = 89 * hash + Objects.hashCode(this.montoMaxGranizo);
        hash = 89 * hash + Objects.hashCode(this.tipoCobertura);
        hash = 89 * hash + Objects.hashCode(this.gestionCuota);
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
        final GestionPoliza other = (GestionPoliza) obj;
        if (!Objects.equals(this.formaPago, other.formaPago)) {
            return false;
        }
        if (!Objects.equals(this.tipoCobertura, other.tipoCobertura)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.auto, other.auto)) {
            return false;
        }
        if (!Objects.equals(this.numeroPoliza, other.numeroPoliza)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicioPoliza, other.fechaInicioPoliza)) {
            return false;
        }
        if (!Objects.equals(this.fechaFinPoliza, other.fechaFinPoliza)) {
            return false;
        }
        if (!Objects.equals(this.montoTotalAsegurado, other.montoTotalAsegurado)) {
            return false;
        }
        if (!Objects.equals(this.cantidadCoutas, other.cantidadCoutas)) {
            return false;
        }
        if (!Objects.equals(this.granizo, other.granizo)) {
            return false;
        }
        if (!Objects.equals(this.montoMaxGranizo, other.montoMaxGranizo)) {
            return false;
        }
        if (!Objects.equals(this.gestionCuota, other.gestionCuota)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "\n"+ cliente + "\n" + auto + "\nGestionPoliza{" + numeroPoliza + " ,fechaInicioPoliza=" + fechaInicioPoliza + " ,fechaFinPoliza=" + fechaFinPoliza + " ,montoTotalAsegurado=" + montoTotalAsegurado + " ,cantidadCoutas=" + cantidadCoutas + " ,formaPago=" + formaPago + " ,granizo=" + granizo + " ,montoMaxGranizo=" + montoMaxGranizo + " ,tipoCobertura=" + tipoCobertura +"\n"+ gestionCuota + '}';
    }


    


    
    
}
