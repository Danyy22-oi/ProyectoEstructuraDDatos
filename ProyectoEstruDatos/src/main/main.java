
package main;
import EstructuraDeDatos.*;
import personajes.*;
import GUI.*;

public class main {

    
    public static void main(String[] args) {
        ListaMusica lista = new ListaMusica();
        lista.insertarCanciones(lista);
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setVisible(true);
        lista.reproducir();
        
    }
    
}
