
package main;
import EstructuraDeDatos.*;
import personajes.*;
import GUI.*;

public class main {

    
    public static void main(String[] args) {
      PilaTorre1 pila1 = new PilaTorre1();
      PilaTorre2 pila2 = new PilaTorre2();
      pila1.push(1.0);
      pila1.push(1.5);
      pila1.push(2.0);
      pila1.push(2.5);
      pila1.push(3.0);
      pila1.push(3.5);
      pila1.push(4.0);
      pila1.push(4.5);
      pila1.push(5.0);
      pila1.push(5.5);
      pila1.push(6.5);
      pila1.push(7.5);
      pila1.push(8.0);
      pila1.push(8.5);
      pila1.push(9.0);
      pila1.push(9.5);
      pila1.push(10.0);     
      pila1.imprimir();
      pila2.push(1.0);
      pila2.push(1.5);
      pila2.push(2.0);
      pila2.push(2.5);
      pila2.push(3.0);
      pila2.push(3.5);
      pila2.push(4.0);
      pila2.push(4.5);
      pila2.push(5.0);
      pila2.push(5.5);
      pila2.push(6.5);
      pila2.push(7.5);
      pila2.push(8.0);
      pila2.push(8.5);
      pila2.push(9.0);
      pila2.push(9.5);
      pila2.push(10.0);
      pila2.imprimir();
      Menu menu = new Menu();
      menu.setVisible(true);
    }
    
}
