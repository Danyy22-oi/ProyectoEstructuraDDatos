
package Node;

import personajes.*;


public class NodoCPU {
    private Personaje personaje;
    private NodoCPU siguiente;

    public NodoCPU(Personaje personaje, NodoCPU siguiente) {
        this.personaje = personaje;
        this.siguiente = siguiente;
    }
    
    public NodoCPU(Personaje p){
        personaje = p;
        siguiente = null;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public NodoCPU getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCPU siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "NodoCPU{" + "personaje=" + personaje + ", siguiente=" + siguiente + '}';
    }
    
    
  
}
