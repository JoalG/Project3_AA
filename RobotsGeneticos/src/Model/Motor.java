/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author joalg
 */
public class Motor {
    private int tipo;
    private int costo;
    private int consumo; 
    private ArrayList<TipoTerreno> tiposDeTerreno;

    public Motor(int tipo, int costo, int consumo,ArrayList<TipoTerreno> tiposDeTerreno) {
        this.tipo = tipo;
        this.costo = costo;
        this.consumo = consumo;
        this.tiposDeTerreno = tiposDeTerreno;
    }
    
    
    public Motor(int tipo) {
        this.tipo = 1;
        this.tiposDeTerreno = new ArrayList<TipoTerreno>();
        
        switch(this.tipo){
            case 1:
                this.costo = 0;
                this.consumo = 0;
                this.tiposDeTerreno.add(TipoTerreno.NORMAL);
                break;
            case 2:
                this.costo = 0;
                this.consumo = 0;
                this.tiposDeTerreno.add(TipoTerreno.NORMAL);
                this.tiposDeTerreno.add(TipoTerreno.MODERADO);
                break;
            case 3:
                this.costo = 0;
                this.consumo = 0;
                this.tiposDeTerreno.add(TipoTerreno.NORMAL);
                this.tiposDeTerreno.add(TipoTerreno.MODERADO);
                this.tiposDeTerreno.add(TipoTerreno.DIFICIL);
                break;
            default:
                this.costo = 0;
                this.consumo = 0;
                this.tiposDeTerreno = tiposDeTerreno;
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

    public ArrayList<TipoTerreno> getTiposDeTerreno() {
        return tiposDeTerreno;
    }

    public void setTiposDeTerreno(ArrayList<TipoTerreno> tiposDeTerreno) {
        this.tiposDeTerreno = tiposDeTerreno;
    }
    
    
}
