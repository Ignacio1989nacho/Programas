/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.HashMap;


public class Administrador {
    
    private HashMap<String,String> adm = new HashMap(){{put("jose","perez");put("ignacio","dipardo");}};

    public HashMap<String,String> getAdm() {
        return adm;
    }

    @Override
    public String toString() {
        return "Administrador{" + "adm=" + adm + '}';
    }
    
    
    
}
