/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.Date;

public class Persona {

    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer dni;
    private String nCuenta;
    private Integer saldo;
    private Date fecha;
    private boolean credito;
   

    public Persona() {
    }

    public Persona(String nombre, String apellido, Integer edad, Integer dni, String nCuenta, Integer saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.nCuenta = nCuenta;
        this.saldo = saldo;
    }
    

    public Persona(String nombre, String apellido, Integer edad, Integer dni, String nCuenta, Integer saldo, Date fecha, boolean credito) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.nCuenta = nCuenta;
        this.saldo = saldo;
        this.fecha = fecha;
        this.credito = credito;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isCredito() {
        return credito;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getDni() {
        return this.dni;
    }

    public Integer getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getnCuenta() {
        return this.nCuenta;
    }

    public void setnCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni + ", nCuenta=" + nCuenta + ", saldo=" + saldo + ", fecha=" + fecha + ", credito=" + credito + '}';
    }

  

}
