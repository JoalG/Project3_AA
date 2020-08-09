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
import Model.TableroVista;
import Model.Terreno;
import View.RobotInfo;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 *
 * @author joalg
 */
public class RobotsGeneticos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
      
//        Terreno t = new Terreno(20);
        Entorno e = new Entorno();
        RobotInfo robotView = new RobotInfo();
        TableroVista tb = new TableroVista(robotView.panelTerreno, e.terreno.getEspacios());
        System.out.println(e.terreno);

        for (int i = 0; i < 15; i++) {
            e.createNewGeneration();
        }
        for (int i = 0; i <e.generaciones.get(e.generaciones.size()-1).getIndividuos().size() ; i++) {
            if(e.generaciones.get(e.generaciones.size()-1).getIndividuos().get(i).exitoso){
                tb.pintarBorde(e.generaciones.get(e.generaciones.size()-1).getIndividuos().get(i).recorrido);
                robotView._init_components(e.generaciones.get(e.generaciones.size()-1).getIndividuos().get(i), e.generaciones.size()-1, e.generaciones.get(e.generaciones.size()-1).getIndividuos().get(i).numeroRobot);
                break;
            }
        }
        robotView.setVisible(true);
        
//        
//        Generacion nueva = e.generaciones.get(0).createNuevaGeneracion();
////        System.out.println("Corridas Segunda Gen sin cruzar");
////        for (int i = 0; i < 10; i++) {
////            System.out.println("Fueron exitosos: "+ nueva.probarGen(t));
////            //Thread.sleep(100);
////        }
//        
//        nueva.cruzarIndividuos();
//        System.out.println("Corridas Segunda Gen");
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Fueron exitosos: "+ nueva.probarGen(t));
//            //Thread.sleep(100);
//        }
//        
//        
//        
//        nueva = nueva.createNuevaGeneracion();
//        nueva.Mutacion();
//        nueva.cruzarIndividuos();
//        System.out.println("Corridas Segunda Gen");
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Fueron exitosos: "+ nueva.probarGen(t));
//            //Thread.sleep(100);
//        }
//        
//               nueva = nueva.createNuevaGeneracion();
//        nueva.Mutacion();
//        nueva.cruzarIndividuos();
//        System.out.println("Corridas Segunda Gen");
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Fueron exitosos: "+ nueva.probarGen(t));
//            //Thread.sleep(100);
//        }
//
//                nueva = nueva.createNuevaGeneracion();
//        nueva.Mutacion();
//        nueva.cruzarIndividuos();
//        System.out.println("Corridas Segunda Gen");
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Fueron exitosos: "+ nueva.probarGen(t));
//            //Thread.sleep(100);
//        }
//        
//                nueva = nueva.createNuevaGeneracion();
//        nueva.Mutacion();
//        nueva.cruzarIndividuos();
//        System.out.println("Corridas Segunda Gen");
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Fueron exitosos: "+ nueva.probarGen(t));
//            //Thread.sleep(100);
//        }
        
    }    


}
