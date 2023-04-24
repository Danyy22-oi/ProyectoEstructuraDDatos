/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeDatos;

import Node.NodoTorre1;

/**
 *
 * @author tdani
 */
public class PilaTorre1 {

    private NodoTorre1 cabeza;

    public PilaTorre1() {
        cabeza = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void agregar(int valor) {
        NodoTorre1 nuevoNodo = new NodoTorre1(valor);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            nuevoNodo.establecerSiguiente(cabeza);
            cabeza = nuevoNodo;
        }
    }

    public int eliminar() {
        if (estaVacia()) {
            return -1; // Por ejemplo, se podría retornar -1 para indicar que la pila está vacía.
        } else {
            int valorEliminado = cabeza.obtenerValor();
            cabeza = cabeza.obtenerSiguiente();
            return valorEliminado;
        }
    }
}


