 package EstructuraDeDatos;

import Node.*;
import personajes.VidaTorre;


public class PilaTorre1 {
    private NodoTorre cabeza; //apunta a la parte superior de la pila

    public PilaTorre1(NodoTorre cabeza) {
        this.cabeza = cabeza;
    }
    
    public PilaTorre1() {
        this.cabeza = null; //se inicia la pila vacia
    }
    
    //Inserta
    
    public void push(double vida){
        VidaTorre torre = new VidaTorre();
        NodoTorre nuevoN = new NodoTorre(vida);
        nuevoN.setSiguiente(cabeza);
        cabeza = nuevoN;
    }
    public void imprimir() {
        NodoTorre temp = cabeza;
        while (temp != null) {
            System.out.println(temp.getVida());
            temp = temp.getSiguiente();
        }
    }
} 


