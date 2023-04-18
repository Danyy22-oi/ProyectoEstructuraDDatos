package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import EstructuraDeDatos.ListaCircular;
import Node.NodoCircular;
import javax.sound.sampled.FloatControl;
import personajes.Personaje;

public class Principal extends JFrame {

    private NodoCircular nodoActual;
    private ListaCircular lista;
    private Clip clip;
    private FloatControl gainControl;
    Personaje caballero;
    Personaje arquero;
    Personaje mago;

    public Principal() {        
        //Se crea la lista y los personajes
        lista = new ListaCircular();
        caballero = new Personaje("Caballero", 10, 10, 100);
        arquero = new Personaje("Arquero", 10, 10, 100);
        mago = new Personaje("Mago", 10, 10, 100);

        //Crear los nodos con los personajes
        NodoCircular nodoCaballero = new NodoCircular(caballero);
        NodoCircular nodoMago = new NodoCircular(mago);
        NodoCircular nodoArquero = new NodoCircular(arquero);
        nodoCaballero.setSiguiente(nodoMago);
        nodoMago.setSiguiente(nodoArquero);
        nodoArquero.setSiguiente(nodoCaballero); // El último nodo apunta al primer nodo, formando la lista circular

        // Iniciar con el primer personaje
        nodoActual = nodoCaballero;

        // Crear el botón con la imagen del primer personaje en la lista
        ImageIcon iconoBoton = new ImageIcon(getClass().getResource("/Multimedia/" + nodoActual.getPersonaje().getNombre() + ".png"));
        JButton botonImagen = new JButton(iconoBoton);

        // Agregar ActionListener para cambiar de personaje al presionar el botón
        botonImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar al siguiente personaje en la lista circular
                nodoActual = nodoActual.getSiguiente();

                // Actualizar la imagen del botón con el nuevo personaje
                ImageIcon nuevaImagen = new ImageIcon(getClass().getResource("/Multimedia/" + nodoActual.getPersonaje().getNombre() + ".png"));
                botonImagen.setIcon(nuevaImagen);
            }
        });

        // Crear el panel principal y agregar el botón
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); // Agregar un layout al panel

        // Crear un panel vacío para agregar espacio en la parte superior
        JPanel espacioSuperior = new JPanel();
        espacioSuperior.setPreferredSize(new Dimension(0,50)); // Establecer la altura del espacio

        panel.add(espacioSuperior, BorderLayout.SOUTH); // Agregar el espacio superior al panel

        panel.add(botonImagen, BorderLayout.SOUTH); // Agregar el botón al centro del panel

        // Crear un panel vacío para agregar espacio en la parte inferior
        JPanel espacioInferior = new JPanel();
        espacioInferior.setPreferredSize(new Dimension(0, 10)); // Establecer la altura del espacio

        panel.add(espacioInferior, BorderLayout.NORTH); // Agregar el espacio inferior al panel

        // Agregar el panel a la ventana
        add(panel);

        // Configurar la ventana
        setSize(1400, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
