/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author joalg
 */
public enum TipoEstado {
    ARRIBA,
    ABAJO,
    IZQUIERDA,
    DERECHA;

    
    public static TipoEstado randomChoice() {

        int pick = new Random().nextInt(TipoEstado.values().length);

        return TipoEstado.values()[pick];

    }
    
    public static TipoEstado getByPosition(int i){
        
        return TipoEstado.values()[i];
        
    }

}