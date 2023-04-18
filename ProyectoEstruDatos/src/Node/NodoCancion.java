
package Node;

import personajes.*;


public class NodoCancion {
    private String nombreArchivo;
    public String rutaArchivo;
    public NodoCancion siguiente;

    public NodoCancion(String nombreArchivo, String rutaArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.rutaArchivo = rutaArchivo;
        this.siguiente = null;
    }
    
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public NodoCancion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCancion siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
