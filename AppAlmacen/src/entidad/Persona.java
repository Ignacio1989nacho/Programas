/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.Objects;


public class Persona {
    
    private String usuario ;
    private String contra;
   
   
   

    public Persona() {
    }


    public Persona(String usuario, String contra) {
        this.usuario = usuario;
        this.contra = contra;
        
    }

    public String getContra() {
        return this.contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getUsuario() {
        return this.usuario;
    }

  



    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "usuario=" + usuario + ", contra=" + contra + '}';
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.usuario);
        hash = 43 * hash + Objects.hashCode(this.contra);
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.contra, other.contra)) {
            return false;
        }
        return true;
    }



    

    
    
    
    
}
