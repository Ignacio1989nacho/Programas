
package entidad;

import enumeraciones.Palo;


public class Carta {
    
    private int numero;
    private Palo tipoPalo;

    public Carta() {
    }

    public Carta(int numero, Palo tipoPalo) {
        this.numero = numero;
        this.tipoPalo = tipoPalo;
    }

    public Palo getTipoPalo() {
        return tipoPalo;
    }

    public void setTipoPalo(Palo tipoPalo) {
        this.tipoPalo = tipoPalo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Carta{" + "numero=" + numero + ", tipoPalo=" + tipoPalo + '}';
    }
    
    
    
    
}
