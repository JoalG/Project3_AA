/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author joalg
 */
public class CadenaDeMarkov implements Serializable{
    private TipoEstado estado1;
    private TipoEstado estado2;
    private TipoEstado estado3;
    private TipoEstado estado4;
    private double prob1;
    private double prob2;
    private double prob3;
    private double prob4;
    
    

    public CadenaDeMarkov(Genes gen) {
        estado1 = TipoEstado.ARRIBA;
        estado2 = TipoEstado.ABAJO;
        estado3 = TipoEstado.DERECHA;
        estado4 = TipoEstado.IZQUIERDA;
        prob1 = gen.getProb1();
        prob2 = gen.getProb2();
        prob3 = gen.getProb3();
        prob4 = gen.getProb4();
    }
    
    
    public TipoEstado obtenerEstado(){
        Random ran = new Random();
        double select = ran.nextDouble()*100;
        
        if (select < prob1) {
            return estado1;
        }
        else if (select >= prob1 && select < prob1+prob2) {
            return  estado2;
        }
        else if (select >= prob1+prob2 && select < prob1+prob2 +prob3) {
            return  estado3;
        }
        else {
            return  estado4;
        }
    }

    public TipoEstado getEstado1() {
        return estado1;
    }

    public void setEstado1(TipoEstado estado1) {
        this.estado1 = estado1;
    }

    public TipoEstado getEstado2() {
        return estado2;
    }

    public void setEstado2(TipoEstado estado2) {
        this.estado2 = estado2;
    }

    public TipoEstado getEstado3() {
        return estado3;
    }

    public void setEstado3(TipoEstado estado3) {
        this.estado3 = estado3;
    }

    public TipoEstado getEstado4() {
        return estado4;
    }

    public void setEstado4(TipoEstado estado4) {
        this.estado4 = estado4;
    }

    public double getProb1() {
        return prob1;
    }

    public void setProb1(double prob1) {
        this.prob1 = prob1;
    }

    public double getProb2() {
        return prob2;
    }

    public void setProb2(double prob2) {
        this.prob2 = prob2;
    }

    public double getProb3() {
        return prob3;
    }

    public void setProb3(double prob3) {
        this.prob3 = prob3;
    }

    public double getProb4() {
        return prob4;
    }

    public void setProb4(double prob4) {
        this.prob4 = prob4;
    }
    
    
    
    
    
        
}
