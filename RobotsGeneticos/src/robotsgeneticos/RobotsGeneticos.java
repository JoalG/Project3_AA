/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsgeneticos;

import Model.Genes;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 *
 * @author joalg
 */
public class RobotsGeneticos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Genes genes = new Genes();
        System.out.println("Camara t: "+genes.getTCamara().getTipo());
        System.out.println("Motor t: "+genes.getTMotor().getTipo());
        System.out.println("Bateria t: "+genes.getTBateria().getTipo());
    }
    
}
