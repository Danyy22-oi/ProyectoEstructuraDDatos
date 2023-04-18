
package EstructuraDeDatos;

import personajes.*;
import Node.*;
import com.sun.tools.javac.Main;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ListaMusica {
    private NodoCancion inicio;
    private Clip clip;
    private FloatControl gainControl;

    public ListaMusica(NodoCancion actual) {
        this.inicio = actual;
    }
    public ListaMusica() {
        this.inicio = null;
    }
    
     public void agregarCancion(String nombreArchivo, String rutaArchivo) {
    URL urlArchivo = getClass().getClassLoader().getResource(rutaArchivo);
    if (urlArchivo != null) {
        NodoCancion nuevoNodo = new NodoCancion(nombreArchivo, urlArchivo.getFile());

        if (inicio == null) {
            inicio = nuevoNodo;
            inicio.siguiente = inicio;
        } else {
            NodoCancion ultimo = inicio.siguiente;
            while (ultimo.siguiente != inicio) {
                ultimo = ultimo.siguiente;
            }
            ultimo.siguiente = nuevoNodo;
            nuevoNodo.siguiente = inicio;
        }
    } else {
        System.out.println("El archivo " + rutaArchivo + " no existe en el paquete multimedia.canciones.");
    }
}
      public void reproducir() {
        if (inicio != null) {
            NodoCancion actual = inicio;
            do {
                try {
                    File archivoAudio = new File(actual.rutaArchivo);
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoAudio);
                    clip = AudioSystem.getClip();
                    clip.open(audioStream);

                    // Control de volumen
                    gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-10.0f); // Reducir el volumen en 10 decibeles

                    // Reproducir en bucle
                    clip.loop(Clip.LOOP_CONTINUOUSLY);

                    Thread.sleep(clip.getMicrosecondLength() / 1000);

                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                actual = actual.siguiente;
            } while (actual != inicio);
        }
    }
      
      
    public void insertarCanciones(ListaMusica lista){
      String rutaCancion1 = new File("src/Multimedia/canciones/y2mate.com - FAIRY TAIL.mp3").getAbsolutePath();
      lista.agregarCancion("cancion1", rutaCancion1);
      String rutaCancion2 = new File("src/Multimedia/canciones/y2mate.com - Feid  CHORRITO PA LAS ANIMAS.mp3").getAbsolutePath();
      lista.agregarCancion("cancion2", rutaCancion2);
      String rutaCancion3 = new File("src/Multimedia/canciones/y2mate.com - Gustavo Santaolalla  The Last of Us  The Last of Us Video Game Soundtrack.mp3").getAbsolutePath();
      lista.agregarCancion("cancion3", rutaCancion3);      
    }
}
