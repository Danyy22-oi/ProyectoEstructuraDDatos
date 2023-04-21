/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeDatos;

/**
 *
 * @author joseriveratencio
 */
public class Node1 {
    private int valor;
    private Node1 siguiente;
    
    //constructor para inicializar

    public Node1() {
        this.valor = 0;
        this.siguiente = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Node1 getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Node1 siguiente) {
        this.siguiente = siguiente;
    }
}
