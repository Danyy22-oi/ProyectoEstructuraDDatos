package Node;
import personajes.*;


public class NodoCircular {
    public Personaje personaje;
    public NodoCircular siguiente;

    public NodoCircular(Personaje personaje) {
        this.personaje = personaje;
        this.siguiente = null;
    }

    // getters y setters para personaje y siguiente
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
}
 
