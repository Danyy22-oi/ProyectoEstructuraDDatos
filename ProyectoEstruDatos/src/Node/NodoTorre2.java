/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Node;

import personajes.VidaTorre;

/**
 *
 * @author tdani
 */
public class NodoTorre2 {
    private VidaTorre vidatorre;
    private NodoTorre2 siguiente;

    public NodoTorre2() {
    }

    public NodoTorre2(VidaTorre vidatorre, NodoTorre2 siguiente) {
        this.vidatorre = vidatorre;
        this.siguiente = siguiente;
    }

    public VidaTorre getVidatorre() {
        return vidatorre;
    }

    public void setVidatorre(VidaTorre vidatorre) {
        this.vidatorre = vidatorre;
    }

    public NodoTorre2 getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTorre2 siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "NodoTorre2{" + "vidatorre=" + vidatorre + ", siguiente=" + siguiente + '}';
    }
   
    
}
