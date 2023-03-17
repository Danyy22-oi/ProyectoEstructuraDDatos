
package proyectoestrudatos;

import java.util.Random;

public class Mago extends Personaje{
    
    private final int VIDA_MAX; //Los hechizos de curación no pueden rebasar este límite

	public Mago() {
		super();
		VIDA_MAX = vida; //Vida inicial es el límite máximo
	}

	public Mago(String nombre, int ataque, int defensa, int vida) {
		super(nombre, ataque, defensa, vida);
		VIDA_MAX = vida; //Vida inicial es el límite máximo
	}
	
	public void recuperarVida() {
		/*
		 * 20% posibilidad de recuperar 1 punto de vida
		 * en cada turno de juego.
		 * Pero solo sí no se tiene ya la vida al máximo
		 */
		if (vida < VIDA_MAX) {
			Random azar = new Random();
			int valor = azar.nextInt(100);
			if (valor%5 == 0) {//Comprobamos si es múltiplo de 5
				System.out.println("¡" + nombre + " recupera 1 punto de vida!");
				vida++;
			}
		}
	}
	
	public void curar50puntos() {
		
		if (vida == VIDA_MAX)//No se puede recuperar vida porque ya está en su límite
			System.out.println("El hechizo de curación no tiene ningún efecto");
		else {
			/*
			 * Calculamos diferencia entre vica actual y vida maxima
			 * para saber si podemos recuperar 50 puntos o menos.
			 */
			int diferencia = VIDA_MAX - vida;
			if (diferencia >= 50) {
				vida += 50;
				System.out.println("¡" + nombre + " recupera 50 puntos de vida!");
			}
			else {
				vida += diferencia;
				System.out.println("¡" + nombre + " recupera " + diferencia + " puntos de vida!");
			}
		}
	}
	
	public int hechizoAtaque() {
		/*
		 * Nivel de ataque máximo, incrementado un 50%
		 */
		return (int)(ataque * 1.5);
	}
	
	@Override
	public String toString() {
		return String.format("Mago: %s / Nivel de Vida: %d", nombre, vida);
	}
    
}
