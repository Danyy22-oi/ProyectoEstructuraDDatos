/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

public class Personaje {
    private String Nombre;
    private double AtaqueCastillo;
    private String tipo;

    public Personaje(String Nombre, double AtaqueCastillo, String tipo) {
        this.Nombre = Nombre;
        this.AtaqueCastillo = AtaqueCastillo;
        this.tipo = tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getAtaqueCastillo() {
        return AtaqueCastillo;
    }

    public void setAtaqueCastillo(double AtaqueCastillo) {
        this.AtaqueCastillo = AtaqueCastillo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Personaje{" + "Nombre=" + Nombre + ", AtaqueCastillo=" + AtaqueCastillo + ", tipo=" + tipo + '}';
    }
    
    

 
    
}
