/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeDatos;

import Node.NodoCPU;
import personajes.Personaje;

/**
 *
 * @author burgo
 */
public class ganadorCPU {
private NodoCPU cabeza;
private NodoCPU ultimo;

    public ganadorCPU(NodoCPU cabeza, NodoCPU ultimo) {
        this.cabeza = cabeza;
        this.ultimo = ultimo;
    }
    public ganadorCPU() {
        this.cabeza = null;
        this.ultimo = null;
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
        System.out.println("La cola de jugadores de la Izquierda está vacía.");
    } else {
        NodoCPU actual = cabeza;
        System.out.println("Cola de Jugadores de la Izquierda:");
        while (actual != null) {
            System.out.println(actual.getPersonaje().toString());
            actual = actual.getSiguiente();
            }
        }
    }

    @Override
    public String toString() {
    if (cabeza == null) {
        return "La cola está vacía.";
    } else {
        return "Cabeza: " + cabeza.getPersonaje().toString() + " | Cantidad de objetos: " + contarElementos();
    }
    
}
    public int contarElementos() {
    int contador = 0;
    NodoCPU actual = cabeza;
    while (actual != null) {
        contador++;
        actual = actual.getSiguiente();
    }
    return contador;
}
    
    
}

