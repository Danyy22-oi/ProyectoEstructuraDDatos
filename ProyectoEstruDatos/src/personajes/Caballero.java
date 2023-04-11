
package personajes;

import personajes.Arquero;
import java.util.Random;

public class Caballero extends Personaje{
    
    public Caballero() {
		super();
	}

	public Caballero(String nombre, int ataque, int defensa, int vida) {
		super(nombre, ataque, defensa, vida);
	}
	
	public int ataqueRelampago(Personaje enemigo) {
		/*
		 * Nivel de ataque máximo, incrementado un 50%
                 * Pero si el enemigo es un arquero, se incrementa un 100%
                 * para que sea mas efectivo
		 */
                double multiplicador = 1.5;
                if(enemigo instanceof Arquero){
                    multiplicador = 2.0;
                    System.out.println("!" + nombre + "Utilizo el hechizo especial contra" + ((Arquero) enemigo).nombre + "!");
                }
                int ataqueRelampago = (int)(ataque * multiplicador);
                enemigo.recibirAtaque(ataqueRelampago);
		System.out.println(nombre + " usa su ataque RELÁMPAGO");
		return (int)(ataque * 1.5);
	}
	
	@Override
	public String toString() {
		return String.format("Caballero: %s / Nivel de Vida: %d", nombre, vida);
	}
}
