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
public class Reporte  implements Serializable{
    private ArrayList<int[]> Recorrido;
    private boolean exitoso;

    
    
    public Reporte(ArrayList<int[]> pasos, boolean exitoso) {
        this.Recorrido = pasos;
        this.exitoso = exitoso;
    }
    
    
    public ArrayList<int[]> getPasos() {
        return Recorrido;
    }

    public void setPasos(ArrayList<int[]> pasos) {
        this.Recorrido = pasos;
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public void setExitoso(boolean exitoso) {
        this.exitoso = exitoso;
    }

}
