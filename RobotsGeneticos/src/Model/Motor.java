/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author joalg
 */
public class Motor implements Serializable {
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
        this.tipo = tipo;
        this.tiposDeTerreno = new ArrayList<TipoTerreno>();
        
        switch(this.tipo){
            case 1:
                this.costo = 10;
                this.consumo = 0;
                this.tiposDeTerreno.add(TipoTerreno.NORMAL);
                break;
            case 2:
                this.costo = 20;
                this.consumo = 1;
                this.tiposDeTerreno.add(TipoTerreno.NORMAL);
                this.tiposDeTerreno.add(TipoTerreno.MODERADO);
                break;
            case 3:
                this.costo = 30;
                this.consumo = 2;
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

    public int calConsumo(TipoTerreno terreno){
        if(this.tipo == 1){
            return 1;
        }
        else if(this.tipo == 2){
            if(terreno == TipoTerreno.NORMAL){
                return 1;
            }
            else{
                return 2;
            }
        }
        else{
            if(terreno == TipoTerreno.NORMAL){
                return 1;
            }
            else if(terreno == TipoTerreno.MODERADO){
                return 2;
            }
            else{
                return 3;
            }
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
    
    public double getMotorPuntaje(int puntajeMax){
        return puntajeMax * (1-(costo/40));
    }
    
}
