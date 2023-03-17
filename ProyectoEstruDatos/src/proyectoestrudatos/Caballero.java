
package proyectoestrudatos;

import java.util.Random;

public class Caballero extends Personaje{
    
    public Caballero() {
		super();
	}

	public Caballero(String nombre, int ataque, int defensa, int vida) {
		super(nombre, ataque, defensa, vida);
	}
	
	public int ataqueRelampago() {
		/*
		 * Nivel de ataque máximo, incrementado un 50%
		 */
		System.out.println(nombre + " usa su ataque RELÁMPAGO");
		return (int)(ataque * 1.5);
	}
	
	@Override
	public String toString() {
		return String.format("Caballero: %s / Nivel de Vida: %d", nombre, vida);
	}
}
