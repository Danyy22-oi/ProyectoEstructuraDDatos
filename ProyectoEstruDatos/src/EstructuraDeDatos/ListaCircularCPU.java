
package EstructuraDeDatos;

import Node.*;
import personajes.*;

public class ListaCircularCPU {
     NodoCircularCPU inicio;

    public ListaCircularCPU() {
        inicio = null;
    }

    // método para agregar un personaje a la lista
    public void agregar(Personaje personaje) {
        NodoCircularCPU nuevo = new NodoCircularCPU(personaje);

        if (inicio == null) { // si la lista está vacía
            inicio = nuevo;
            inicio.setSiguiente(inicio); // el siguiente del nuevo nodo es el inicio
        } else { // si la lista ya tiene elementos
            NodoCircularCPU actual = inicio;

            while (actual.getSiguiente() != inicio) { // buscar el último nodo
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevo); // el último nodo apunta al nuevo nodo
            nuevo.setSiguiente(inicio); // el siguiente del nuevo nodo es el inicio
        }
    }

    // método para imprimir los nombres y tipos de los personajes en la lista
    public void imprimir() {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        NodoCircularCPU actual = inicio;
        do {
            System.out.println("ListaCircularCPU"+actual.getPersonaje().getNombre());
            actual = actual.getSiguiente();
        } while (actual != inicio);
    }
}

