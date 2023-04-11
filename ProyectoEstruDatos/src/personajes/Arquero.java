/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

/**
 *
 * @author tdani
 */
public class Arquero extends Personaje {
    public Arquero() {
		super();
	}

	public Arquero(String nombre, int ataque, int defensa, int vida) {
		super(nombre, ataque, defensa, vida);
	}
	
	public int ataqueFlecha() {
		/*
		 * Nivel de ataque máximo
		 */
		System.out.println(nombre + " usa su ataque de flechas");
		return (int)(ataque * 1);
	}
	
	@Override
	public String toString() {
		return String.format("Arquero: %s / Nivel de Vida: %d", nombre, vida);
	}
    
}
