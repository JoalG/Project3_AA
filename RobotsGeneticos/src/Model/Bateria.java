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
    private int cargaOrg;


    
    public Bateria(int tipo, int costo, int carga) {
        this.tipo = tipo;
        this.carga = carga;
        this.costo = costo;
        this.cargaOrg = carga;
    }
    
    
    public Bateria(int tipo) {
        this.tipo = tipo;

        
        switch(tipo){
            case 1:
                this.costo = 10;
                this.carga = 500;
                break;
            case 2:
                this.costo = 20;
                this.carga = 600;
                break;
            case 3:
                this.costo = 30;
                this.carga = 700;
                break;
            default:
                this.costo = 0;
                this.carga = 0;
        }
        this.cargaOrg = this.carga;
    }
    
    
    
    
    public void cargarBateria(){
        this.carga = this.cargaOrg;
    }
    
    public void ReducirCarga(){
        this.carga--;
    }
    
    public void ReducirCarga(int cantidad){
        this.carga -= cantidad;
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
    
    public double getBatteryPercLeft(){
        return (double)carga / (double)cargaOrg;
    }
    
    public double getBatteryValue(){
        // costo maximo = max int de un byte = 255
        return costo / 255;
    }
    
    public double getBatteryPuntaje(int puntajeMax){
        int puntajeMaxCosto = puntajeMax/3;
        int puntajeMaxBatteryLeft = puntajeMax - puntajeMaxCosto;
        return (puntajeMaxBatteryLeft * getBatteryPercLeft()) + (puntajeMaxCosto * (1-getBatteryValue()));
    }
}
