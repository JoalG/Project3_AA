/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsgeneticos;

import Model.CadenaDeMarkov;
import Model.CloneClass;
import Model.Entorno;
import Model.Generacion;
import Model.Genes;
import Model.Robot;
import Model.Terreno;
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
        /*Genes genes = new Genes();
        
        System.out.println("Camara t: "+genes.getTCamara().getTipo());
        System.out.println("Motor t: "+genes.getTMotor().getTipo());
        System.out.println("Bateria t: "+genes.getTBateria().getTipo());

        Robot robot1 = new Robot();
        Robot robot2 = new Robot();
        
        System.out.println(robot1.toString());
        System.out.println(robot2.toString());
        
        robot1.cruce(robot2);
        
        System.out.println(robot1.toString());
        System.out.println(robot2.toString()); */
       
       /*Generacion generacion = new Generacion(20, 8);
       generacion.printGenesGen();
       System.out.println("#############################################");
       generacion.Mutacion();
       System.out.println("#############################################");
       generacion.printGenesGen();*/
      
       Terreno t = new Terreno(20);
       System.out.println(t);
       
       
        Robot robot1 = new Robot();

        System.out.println(robot1);

        int[] pos = new int[2];
        pos[0] = 19;
        pos[1] = 0;
        for (int i = 0; i < 1000; i++) {
            System.out.println("------------------------------------------------------------------------------");
            robot1.moverPosicion(t);
            System.out.println("------------------------------------------------------------------------------");
        }
        
        
//        
//        Genes gen = robot1.genes; 
//        double total = 0;
//        total += gen.getProb1();
//        System.out.println(gen.getProb1());
//        total += gen.getProb2();
//        System.out.println(gen.getProb2());
//        total += gen.getProb3();
//        System.out.println(gen.getProb3());
//        total += gen.getProb4();
//        System.out.println(gen.getProb4());
//        
//        System.out.println("Total: "+total);
       
       
       
       /*
        Genes gen = new Genes(); 
        double total = 0;
        total += gen.getProb1();
        System.out.println(gen.getProb1());
        total += gen.getProb2();
        System.out.println(gen.getProb2());
        total += gen.getProb3();
        System.out.println(gen.getProb3());
        total += gen.getProb4();
        System.out.println(gen.getProb4());
        
        System.out.println("Total: "+total);
        
        CadenaDeMarkov cadena = new CadenaDeMarkov(gen);
        
        for (int i = 0; i < 10; i++) {
            System.out.println(cadena.obtenerEstado());        
        }
//*/
//        Entorno entorno = new Entorno();
//        System.out.println(entorno);

       
    }
    
}
