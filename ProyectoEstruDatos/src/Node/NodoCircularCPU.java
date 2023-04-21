
package Node;

import personajes.Personaje;


public class NodoCircularCPU {
    private Personaje personaje;
    private NodoCircularCPU siguiente;
    private NodoCircularCPU anterior;

    public NodoCircularCPU(Personaje personaje) {
        this.personaje = personaje;
    }

    public NodoCircularCPU(NodoCircularCPU siguiente, NodoCircularCPU anterior) {
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public NodoCircularCPU getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircularCPU siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCircularCPU getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCircularCPU anterior) {
        this.anterior = anterior;
    }
    
    
    
}
