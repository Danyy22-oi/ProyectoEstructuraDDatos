package proyectoestrudatos;

import java.util.Random;
import java.util.Scanner;

public class Combate {

    private static Scanner teclado = new Scanner(System.in);
    private static Personaje jugador; //Podrá ser un Mago o un Caballero
    private static Caballero CPU; //La CPU siempre es un Caballero
    private static boolean modoDificil = false; //Nivel de dificultad

    public static void main(String[] args) {

        crearPersonaje();

        elegirDificultad();

        //Comienza el combate...
        while (jugador.getVida() > 0 && CPU.getVida() > 0) {
            /*
			 * Las siguientes variables recogerán los valores de ataques o defensas
			 * de los combatientes, según la acción que escojan, en cada turno.
             */
            int ataqueJugador = 0, ataqueCPU = 0;
            int defensaJugador = 0, defensaCPU = 0;
            System.out.println("\n\n\t\tCOMBATIENDO...");
            System.out.println("> Jugador: " + jugador);
            System.out.println("> CPU: " + CPU);
            //Recogemos acción del jugador
            int accionJugador = menuCombateJugador();
            System.out.println(); //Salto de línea
            //Evaluamos la acción escogida
            switch (accionJugador) {
                case 1: //Ataque normal
                    ataqueJugador = jugador.atacar();
                    System.out.println("Consigues un ATAQUE de " + ataqueJugador + " pts.");
                    break;
                case 2: //Defender
                    defensaJugador = jugador.defender();
                    System.out.println("Consigues una DEFENSA de " + defensaJugador + " pts.");
                    break;
                case 3: //Ataque relámpago o hechizo ataque, según clase
                    if (jugador instanceof Caballero) {
                        ataqueJugador = ((Caballero) jugador).ataqueRelampago();
                        System.out.println("Consigues un ATAQUE de " + ataqueJugador + " pts.");
                    } else {
                        ataqueJugador = ((Mago) jugador).hechizoAtaque();
                        System.out.println("Consigues un ATAQUE de " + ataqueJugador + " pts.");
                    }
                    break;
                case 4: //Hechizo sanación 50 puntos, solo sirve para Mago
                    if (jugador instanceof Caballero) {
                        System.out.println("La acción no es válida. Pierdes tu turno");
                    } else {
                        ((Mago) jugador).curar50puntos();
                    }
                    break;
                default:
                    System.out.println("La acción no es válida. Pierdes tu turno");
            }
            pausa();
            //A continuación elige acción la CPU
            int accionCPU;
            if (modoDificil) {
                accionCPU = CPUmodoDificil(ataqueJugador, defensaJugador);
            } else {
                accionCPU = CPUmodoNormal();
            }
            //Analizamos accion de CPU
            switch (accionCPU) {
                case 1:
                    ataqueCPU = CPU.atacar();
                    break;
                case 2:
                    defensaCPU = CPU.defender();
                    break;
                case 3:
                    ataqueCPU = CPU.ataqueRelampago();
            }
            pausa();
            //Ambos Jugadores han actuado, evaluamos daños conseguidos
            int danoRecibeJugador = ataqueCPU - defensaJugador;
            int danoRecibeCPU = ataqueJugador - defensaCPU;
            //Qué ha pasaso con Jugador
            if (danoRecibeJugador > 0) {
                System.out.println("\n" + jugador.getNombre() + " recibe daños.");
                System.out.println("Pierde " + danoRecibeJugador + " puntos de vida.");
                jugador.perderVida(danoRecibeJugador);
                if (jugador.getVida() == 0) {
                    System.out.println("¡" + jugador.getNombre() + " ha muerto!");
                }
            } else {
                //No recibe daños, comunicamos que ha conseguido bloquear ataque CPU
                //Excepto si se debe a que CPU no atacó, por estar defendiendose.
                if (accionCPU != 2) {
                    System.out.println("\n" + jugador.getNombre() + " consigue bloquear ataque de "
                            + CPU.getNombre());
                }
            }
            //Qué ha pasado con CPU
            if (danoRecibeCPU > 0) {
                System.out.println("\n" + CPU.getNombre() + " recibe daños.");
                System.out.println("Pierde " + danoRecibeCPU + " puntos de vida.");
                CPU.perderVida(danoRecibeCPU);
                if (CPU.getVida() == 0) {
                    System.out.println("¡" + CPU.getNombre() + " ha muerto!");
                }
            } else {
                if (accionJugador == 1 || accionJugador == 3) {
                    System.out.println("\n" + CPU.getNombre() + " consigue bloquear ataque de "
                            + jugador.getNombre());
                }
            }
            pausa();
            /*
			 * Acciones completadas, pero aún queda la probabilidad de que
			 * si el jugador humano es Mago, pueda recuperar un punto de vida.
			 * En caso de que el Mago estuviera muerto, ¡¡esto le da la posibilidad de resucitar!!
			 * aunque solo con un miserable punto de vida.
             */
            if (jugador instanceof Mago) {
                if (((Mago) jugador).recuperarVida()) {
                    //Comprobamos si estamos ante el milagro de la resurrección xD
                    if (jugador.getVida() == 1) {
                        System.out.println("¡" + jugador.getNombre() + " ha resucitado!");
                    }

                    pausa();
                }
            }
            /*
			 * Ahora sí se ha completado el turno.
			 * El bucle de combate se repetirá, excepto si alguien ha muerto
             */
        }
        //Fin bucle combate, comprobamos quien vive y quien no
        if (jugador.getVida() > 0) {
            System.out.println("\nVictoria para:");
            System.out.println(jugador);
        } else if (CPU.getVida() > 0) {
            System.out.println("\nVictoria para:");
            System.out.println(CPU);
        } else //¡Ambos personajes han muerto!
        {
            System.out.println("\nNo hay ganador. Ambos jugadores se han destruido.");
        }

        System.out.println("\n\n\t\tFIN DE PROGRAMA");
    }

    private static void crearPersonaje() {
        System.out.println("\t\tCREAR PERSONAJE");
        System.out.println("\t\t----- ---------");
        System.out.println("Clases disponibles:");
        System.out.println("[1] -> Caballero");
        System.out.println("[2] -> Mago");

        System.out.print("Elige clase: ");
        int clase = Integer.parseInt(teclado.nextLine());

        System.out.print("\nNombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Nivel de Ataque(min = 1/max = 10): ");
        int ataque = Integer.parseInt(teclado.nextLine());
        //Forzamos que el nivel escogido se ciña a los límites
        if (ataque < 1) {
            ataque = 1;
        } else if (ataque > 10) {
            ataque = 10;
        }

        System.out.print("Nivel de Defensa(min = 1/max = 10): ");
        int defensa = Integer.parseInt(teclado.nextLine());
        if (defensa < 1) {
            defensa = 1;
        } else if (defensa > 10) {
            defensa = 10;
        }

        System.out.print("Nivel de Vida(min = 100/max = 1000): ");
        int vida = Integer.parseInt(teclado.nextLine());
        if (vida < 100) {
            vida = 100;
        } else if (vida > 1000) {
            vida = 1000;
        }

        //Tenemos todos los atributos necesarios, creamos Personaje
        if (clase == 1) //Ha elegido Caballero
        {
            jugador = new Caballero(nombre, ataque, defensa, vida);
        } else //Mago
        {
            jugador = new Mago(nombre, ataque, defensa, vida);
        }

        System.out.println("\nEste es tu personaje:");
        System.out.println(jugador);
        pausa();

        //Ahora creamos el Caballero CPU, con doble de potencia que el Jugador
        CPU = new Caballero("Thanos", (ataque * 2), (defensa * 2), (vida * 2));

        System.out.println("Y este será tu rival:");
        System.out.println(CPU);
        System.out.println("Nivel de Ataque: " + CPU.getAtaque()
                + " / Nivel de Defensa: " + CPU.getDefensa());

        pausa();
    }

    private static void elegirDificultad() {
        System.out.println("\n\t\tNIVEL DIFICULTAD");
        System.out.println("\n\t\t----- ----------");
        System.out.println("[1] -> Modo NORMAL(Por defecto)");
        System.out.println("[2] -> Modo DIFICIL(La CPU será más inteligente)");
        System.out.print("Elige modo: ");
        int modo = Integer.parseInt(teclado.nextLine());
        //si teclea 2, pasa a modo dificil
        if (modo == 2) {
            modoDificil = true;
        }
        //Si teclea 1 o cualquier otra cosa, no se cambia el modo
    }

    private static int menuCombateJugador() {
        System.out.println("\nTurno de " + jugador.getNombre());
        //Opciones comunes a todos los jugadores
        System.out.println("[1] -> Atacar");
        System.out.println("[2] -> Defender");
        //Opciones según la clase de Jugador
        if (jugador instanceof Caballero) {
            System.out.println("[3] -> Ataque RELÁMPAGO");
        } else {
            System.out.println("[3] -> Hechizo de ATAQUE");
            System.out.println("[4] -> Hechizo de SANACIÓN");
        }
        System.out.print("Elige acción: ");
        return Integer.parseInt(teclado.nextLine());
    }

    private static int CPUmodoNormal() {
        /*
		 * En el modo normal las acciones de la CPU
		 * se eligen completamente por azar.
         */
        Random azar = new Random();
        //Al ser un Caballero, solo tiene 3 posibles acciones, entre 1 y 3
        //Si retorna 1, atacará
        //Si es 2, se defenderá
        //3, ¡¡Ataque Relámpago!!
        return azar.nextInt(3) + 1;
    }

    private static int CPUmodoDificil(int ataqueJugador, int defensaJugador) {
        /*
		 * En el modo difícil, las acciones van a depender menos del azar.
		 * La CPU evaluará si el jugador ataca o se defiende,
		 * y con que intensidad, para favorecer más unas acciones u otras.
         */
        int[] arrayAcciones = new int[10];
        /*
		 * Las acciones de la CPU se escogerán al azar desde un array de int.
		 * Este array tendrá varios valores entre 1 y 3, que son las posibles acciones a escoger.
		 * (1 = ataque; 2 = defender; 3 = ataque Relámpago)
		 *
		 * Este array se fabricará según el analisis de la jugada del Jugador Humano.
		 * Si por ejemplo el humano está defendiendo, el array no tendrá valor 2(defensa)
		 * porque la CPU no querrá defenderse, querrá atacar.
		 * En cambio, si detecta que el humano ha conseguido un ataque muy fuerte, si habrá más
		 * cantidad de valores 2 en el array, para favorecer que la CPU se defienda en lugar de atacar
         */

        //Evaluamos acciones del Jugador
        if (defensaJugador > 0) {
            /*
			 * Jugador se está defendiendo, así que la CPU
			 * NO se va a defender ya que sería desperdiciar este turno.
			 * 
			 * Atacará al jugador, y además favorecerá un "Ataque Relámpago"
			 * si detecta que la defensa del Jugador es muy alta.
             */
            if (defensaJugador >= 9) //Defensa muy alta, mayor probabilidad de ataque relámpago
            {
                arrayAcciones = new int[]{1, 3, 3, 1, 3, 3, 1, 3, 3, 3};
            } else if (defensaJugador >= 5) //Defensa media, ataque relámpago un poco más probable
            {
                arrayAcciones = new int[]{1, 3, 1, 1, 3, 3, 1, 3, 3, 1};
            } else //Defensa baja, menos probabilidad de ataque Relámpago
            {
                arrayAcciones = new int[]{1, 3, 1, 1, 3, 1, 1, 3, 1, 1};
            }
        } else { //Jugador no se defiende, está atacando o usando hechizo curación (si es un Mago)
            //Según la fuerza de ataque, se favorecerá más o menos la defensa.
            if (ataqueJugador >= 9) //Ataque fuerte, mucha defensa
            {
                arrayAcciones = new int[]{1, 2, 2, 3, 2, 2, 3, 2, 2, 3};
            } else if (ataqueJugador >= 5) //Ataque medio
            {
                arrayAcciones = new int[]{1, 1, 2, 3, 2, 2, 1, 2, 2, 3};
            } else if (ataqueJugador > 0) //Ataque bajo
            {
                arrayAcciones = new int[]{1, 1, 2, 3, 2, 3, 1, 1, 2, 3};
            } else if (ataqueJugador == 0) //Ataque es 0,.. ¡¡y defensa también es 0!!
            //Esto solo ocurre cuando el jugador es un Mago usando hechizo de sanacion
            //En este caso, CPU no se defiende, y además se favorece el ataque Relámpago
            {
                arrayAcciones = new int[]{1, 3, 3, 1, 3, 3, 1, 3, 3, 3};
            }
        }
        /*
		 * Ya se ha conformado un array de acciones acorde
		 * según el análisis de la jugada del humano.
		 * Ahora retornaremos una accion al azar de este array
         */
        Random azar = new Random();
        return arrayAcciones[azar.nextInt(10)];
    }

    private static void pausa() {
        System.out.println("\n\t\tPULSA ENTER PARA SEGUIR\n");
        teclado.nextLine();
    }

}
