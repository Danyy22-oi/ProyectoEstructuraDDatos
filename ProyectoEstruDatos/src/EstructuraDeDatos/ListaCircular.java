package EstructuraDeDatos;

import Node.*;
import personajes.*;

public class ListaCircular {
    NodoCircular inicio;

    public ListaCircular() {
        inicio = null;
    }

    // método para agregar un personaje a la lista
    public void agregar(Personaje personaje) {
        NodoCircular nuevo = new NodoCircular(personaje);

        if (inicio == null) { // si la lista está vacía
            inicio = nuevo;
            inicio.setSiguiente(inicio); // el siguiente del nuevo nodo es el inicio
        } else { // si la lista ya tiene elementos
            NodoCircular actual = inicio;

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
        NodoCircular actual = inicio;
        do {
            System.out.println(actual.getPersonaje().getNombre());
            actual = actual.getSiguiente();
        } while (actual != inicio);
    }
}
