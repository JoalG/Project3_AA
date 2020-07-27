/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author joalg
 */
public class Camara {
    
    private int tipo;
    private int costo;
    private int consumo;

    public Camara(int tipo, int costo, int consumo) {
        this.tipo = tipo;
        this.costo = costo;
        this.consumo = consumo;
    }
    
    
    public Camara(int tipo) {
        
        switch(tipo){
            case 1:
                this.costo = 0;
                this.consumo = 0;
                break;
            case 2:
                this.costo = 0;
                this.consumo = 0;
                break;
            case 3:
                this.costo = 0;
                this.consumo = 0;
                break;
            default:
                this.costo = 0;
                this.consumo = 0;
        }
    }
    
    
    

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }
}
