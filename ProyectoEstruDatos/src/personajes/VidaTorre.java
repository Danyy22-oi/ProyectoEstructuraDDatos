/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

/**
 *
 * @author tdani
 */
public class VidaTorre {

    double Golpe_De_Vida_De_Mago = 1.5;
    int Golpe_De_Vida_De_Caballero = 2;
    int Golpe_De_Vida_De_Arquero = 1;

    public VidaTorre(double Golpe_De_Vida_De_Mago, int Golpe_De_Vida_De_Caballero, int Golpe_De_Vida_De_Arquero) {
        this.Golpe_De_Vida_De_Mago = Golpe_De_Vida_De_Mago;
        this.Golpe_De_Vida_De_Caballero = Golpe_De_Vida_De_Caballero;
        this.Golpe_De_Vida_De_Arquero = Golpe_De_Vida_De_Arquero;
    }

    public VidaTorre() {
    }

    public double getGolpe_De_Vida_De_Mago() {
        return Golpe_De_Vida_De_Mago;
    }

    public void setGolpe_De_Vida_De_Mago(double Golpe_De_Vida_De_Mago) {
        this.Golpe_De_Vida_De_Mago = Golpe_De_Vida_De_Mago;
    }

    public int getGolpe_De_Vida_De_Caballero() {
        return Golpe_De_Vida_De_Caballero;
    }

    public void setGolpe_De_Vida_De_Caballero(int Golpe_De_Vida_De_Caballero) {
        this.Golpe_De_Vida_De_Caballero = Golpe_De_Vida_De_Caballero;
    }

    public int getGolpe_De_Vida_De_Arquero() {
        return Golpe_De_Vida_De_Arquero;
    }

    public void setGolpe_De_Vida_De_Arquero(int Golpe_De_Vida_De_Arquero) {
        this.Golpe_De_Vida_De_Arquero = Golpe_De_Vida_De_Arquero;
    }

    @Override
    public String toString() {
        return "VidaTorre{" + "Golpe_De_Vida_De_Mago=" + Golpe_De_Vida_De_Mago + ", Golpe_De_Vida_De_Caballero=" + Golpe_De_Vida_De_Caballero + ", Golpe_De_Vida_De_Arquero=" + Golpe_De_Vida_De_Arquero + '}';
    }

}
