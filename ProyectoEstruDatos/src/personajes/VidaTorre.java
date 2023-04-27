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
    private double ValorVida;

    public VidaTorre(double ValorVida) {
        this.ValorVida = ValorVida;
    }
    
    public VidaTorre() {
        this.ValorVida = 0.0;
    }

    public double getValorVida() {
        return ValorVida;
    }

    public void setValorVida(double ValorVida) {
        this.ValorVida = ValorVida;
    }

    @Override
    public String toString() {
        return "VidaTorre{" + "ValorVida=" + ValorVida + '}';
    }
    
    
}
