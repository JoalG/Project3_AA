/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author joalg
 */
public class Bateria  implements Serializable {
    private int tipo;
    private int costo;
    private int carga;


    
    public Bateria(int tipo, int costo, int carga) {
        this.tipo = tipo;
        this.carga = carga;
        this.costo = costo;
    }
    
    
    public Bateria(int tipo) {
        this.tipo = tipo;

        
        switch(tipo){
            case 1:
                this.costo = 0;
                this.carga = 100;
                break;
            case 2:
                this.costo = 0;
                this.carga = 1000;
                break;
            case 3:
                this.costo = 0;
                this.carga = 10000;
                break;
            default:
                this.costo = 0;
                this.carga = 0;
        }
    }
    
    
    
    
    public void ReducirCarga(){
        this.carga--;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
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
    
    
    
}
