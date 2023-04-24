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
public class NodoTorre1 {

    private VidaTorre vidatorre;
    private NodoTorre2 siguiente;

    public NodoTorre1() {
    }

    public NodoTorre1(VidaTorre vidatorre, NodoTorre2 siguiente) {
        this.vidatorre = vidatorre;
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "NodoTorre1{" + "vidatorre=" + vidatorre + ", siguiente=" + siguiente + '}';
    }

}
