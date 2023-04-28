
package EstructuraDeDatos;

import Node.*;
import personajes.VidaTorre;


public class PilaUsuario {
    
    private NodoTorre cabeza; // apunta a la parte superior de la pila

    public PilaUsuario() {
        this.cabeza = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int tam() {
        int tam = 0;
        NodoTorre aux = cabeza;
        while (aux != null) {
            tam++;
            aux = aux.getSiguiente();
        }
        return tam;
    }

    // Inserta
    public void push(double vida) {
        VidaTorre torre = new VidaTorre();
        NodoTorre nuevoN = new NodoTorre(vida);
        nuevoN.setSiguiente(cabeza);
        cabeza = nuevoN;
    }

    public void imprimirCima() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("La vida del esta torre es: " + cabeza.getVida());
        }
    }


    public NodoTorre pop() {
        if (estaVacia()) {
            return null; // Retorna null si la pila está vacía
        } else {
            NodoTorre temp = cabeza;
            cabeza = cabeza.getSiguiente(); // El siguiente elemento en la pila se convierte en el nuevo último
            return temp; // Retorna el Nodo que fue eliminado
        }
    }
}
