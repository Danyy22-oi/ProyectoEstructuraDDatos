
package personajes;

import java.util.Random;


public class Personaje {
    
	public String nombre;
	protected int ataque;
	protected int defensa;
	protected int vida;
        
        public Personaje(String nombre, int ataque, int defensa, int vida){
		this.nombre = nombre;
		this.ataque = ataque;
		this.defensa = defensa;
		this.vida = vida;
	}

	public Personaje() {
		nombre = "Desconocido";
		ataque = 0;
		defensa = 0;
		vida = 0;
	}
	

	public String getNombre (){
		return this.nombre;
	}
	public int getAtaque (){
		return this.ataque;
	}
	public int getDefensa (){
		return this.defensa;
	}
	public int getVida (){
		return this.vida;
	}
	
	public void perderVida(int danos) {
		vida -= danos;
		if (vida < 0) //Evitamos valores negativos en nivel de vida
			vida = 0;
	}

	public int atacar() {
		System.out.println(nombre + " ataca.");
		Random azar = new Random();
		//Ataque mínimo: 1, Maximo: según nivel de ataque
		int puntosAtaque = azar.nextInt(ataque) + 1;
		
		//Damos un 10% de posibilidad de obtener un "Ataque Crítico"
		int valor = azar.nextInt(100);

		if (valor%10 == 0) { //Comprobamos si es multiplo de 10
			System.out.println("¡" + nombre + " consigue un Ataque Crítico!");
			//Un "Ataque Crítico" duplica el daño del ataque
			return puntosAtaque * 2;
		}
		else
			return puntosAtaque;
	}

	public int defender() {
		System.out.println(nombre + " se defiende.");
		Random azar = new Random();
		//Defensa mínima: 1, Maxima: según nivel de defensa
		int puntosDefensa = azar.nextInt(defensa) + 1;

		return puntosDefensa;
	}
        
        public void recibirAtaque(int puntosAtaque){
            int puntosDefensa = defender();
            int danos = puntosAtaque - puntosDefensa;
            if (danos < 0)//Evitamos valor negativos en el daño recibido
                danos = 0;
            System.out.println(nombre + "recibe" + danos + "puntos de daño.");
            perderVida(danos);
            if (vida == 0)
                System.out.println(nombre + "ha sido derrotado");
        }

}

