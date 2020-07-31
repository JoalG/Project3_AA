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
public enum TipoTerreno {
   
    NORMAL,
    MODERADO,
    DIFICIL,
    BLOQUEADO;
    
    public static TipoTerreno randomChoice() {

        int pick = new Random().nextInt(TipoTerreno.values().length);

        return TipoTerreno.values()[pick];

    }
    
}
