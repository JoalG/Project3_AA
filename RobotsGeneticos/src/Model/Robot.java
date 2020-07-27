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
public class Robot {
    
    public Camara camara;
    public Motor motor;
    public Bateria bateria;

    public Robot(Camara camara, Motor motor, Bateria bateria) {
        this.camara = camara;
        this.motor = motor;
        this.bateria = bateria;
    }
    
    
    
}
