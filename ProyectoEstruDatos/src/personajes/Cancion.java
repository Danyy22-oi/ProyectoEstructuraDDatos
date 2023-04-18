
package personajes;

import java.io.File;

public class Cancion {
     private String titulo;
    private String artista;
    private String genero;
    private int duracion;
    private File archivoAudio;
    
    public Cancion(String titulo, String artista, String genero, int duracion, File archivoAudio) {
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.archivoAudio = archivoAudio;
    }
    public Cancion() {
        this.titulo = "";
        this.artista = "";
        this.genero = "";
        this.duracion = 0;
        this.archivoAudio = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public File getArchivoAudio() {
        return archivoAudio;
    }

    public void setArchivoAudio(File archivoAudio) {
        this.archivoAudio = archivoAudio;
    }
    
    // Método para reproducir la canción
    public void reproducir() {
    // Aquí puedes utilizar una biblioteca de audio, como Java Sound API o JavaFX MediaPlayer
    }
    
    
}
