
package EstructuraDeDatos;

import Node.*;
import personajes.*;


public class ColaCPUDerecha {
    private NodoCPU cabeza;
    private NodoCPU ultimo;

    public ColaCPUDerecha() {
        cabeza = null;
        ultimo = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void encolar(Personaje p) {
        NodoCPU nuevoNodo = new NodoCPU(p);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }

    public Personaje desencolar() {
        if (estaVacia()) {
            return null;
        } else {
            Personaje personaje = cabeza.getPersonaje();
            cabeza = cabeza.getSiguiente();
            if (cabeza == null) {
                ultimo = null;
            }
            return personaje;
        }
    }

    public Personaje frente() {
        if (estaVacia()) {
            return null;
        } else {
            return cabeza.getPersonaje();
        }
    }
    
    public void imprimir() {
    if (estaVacia()) {
        System.out.println("La cola de jugadores de la derecha está vacía.");
    } else {
        NodoCPU actual = cabeza;
        System.out.println("Cola de Jugadores de la Derecha:");
        while (actual != null) {
            System.out.println(actual.getPersonaje().toString());
            actual = actual.getSiguiente();
            }
        }
    }
  
}
    

