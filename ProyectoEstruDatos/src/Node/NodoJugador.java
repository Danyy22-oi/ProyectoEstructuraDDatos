
package Node;

import personajes.Personaje;


public class NodoJugador {
    private Personaje personaje;
    private NodoJugador siguiente;

    public NodoJugador(Personaje personaje, NodoJugador siguiente) {
        this.personaje = personaje;
        this.siguiente = siguiente;
    }
    
    public NodoJugador(Personaje p) {
        this.personaje = p;
        this.siguiente = null;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public NodoJugador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoJugador siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
