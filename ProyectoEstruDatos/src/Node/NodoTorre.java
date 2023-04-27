package Node;

import personajes.*;


public class NodoTorre {
    private double vida;
    private NodoTorre siguiente;

    public NodoTorre(double vida) {
        this.vida = vida;
        this.siguiente = null;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public NodoTorre getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTorre siguiente) {
        this.siguiente = siguiente;
    }

   
}


