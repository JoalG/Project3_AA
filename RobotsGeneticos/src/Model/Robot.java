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
    public Genes genes;

    public Robot() {
        this.genes = new Genes();
        this.camara = genes.getTCamara();
        this.motor = genes.getTMotor();
        this.bateria = genes.getTBateria();
    }
    
    public void cruce(Robot robot){
        this.genes.cruce(robot.genes);
    }
    
    
}
