
package main;


public class Nivel {
    
    protected String nombre;
    protected int ataque;
    protected int defensa;
    protected int vida;
    
    
    public Nivel (String nombre, int ataque, int defensa, int vida){
       this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
    }
    
    public Nivel (){
           nombre = "Desconocido";
           ataque = 0;
           defensa = 0;
           vida = 0;
    }
   
    public void setnombre (String nom){
        this.nombre = nom;
    }
    public void setataque (String atac){
        this.nombre = atac;
    }
    public void setdefensa (String defn){
        this.nombre = defn;
    }
    public void setvida (String pv){
        this.nombre = pv;
    }
   
    public String getnombre (){
        return this.nombre;
    }
    public int getataque (){
        return this.ataque;
    }
    public int getdefensa (){
        return this.defensa;
    }
    public int getvida (){
        return this.vida;
    }
   
}
