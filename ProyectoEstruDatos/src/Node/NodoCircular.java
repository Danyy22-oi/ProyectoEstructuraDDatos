package Node;
import personajes.*;


public class NodoCircular {
    private Personaje personaje;
    private NodoCircular siguiente;
    private NodoCircular anterior;

    public NodoCircular(Personaje personaje) {
        this.personaje = personaje;
    } 

    public NodoCircular(NodoCircular siguiente, NodoCircular anterior) {      
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    
    public NodoCircular() {
        this.siguiente = null;
        this.anterior = null;
    }
    
    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public NodoCircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircular siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCircular getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCircular anterior) {
        this.anterior = anterior;
    }

    
}
 
