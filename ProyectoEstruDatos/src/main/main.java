package main;

import EstructuraDeDatos.*;
import personajes.*;
import GUI.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class main {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        // Especifica la ubicación del archivo de audio en tu sistema de archivos
        File file = new File("C:\\Users\\Bryan Quiros\\Desktop\\Nueva carpeta\\ProyectoEstruDatos\\src\\Multimedia\\canciones\\fondo.wav");
        // Usa la clase AudioSystem para leer el archivo de audio
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(file));
        // Reproduce la canción automáticamente
        clip.start();
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setVisible(true);
        // Espera a que la canción termine antes de salir del programa
        Thread.sleep(clip.getMicrosecondLength() / 1000);
     Menu menu = new Menu();
      menu.setVisible(true);
    }
    
}
