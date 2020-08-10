/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author joalg
 */
public class Entorno {
    public Terreno terreno;
    public ArrayList<Generacion> generaciones;

    public Entorno() {
        this.terreno = new Terreno(20);
        this.generaciones = new ArrayList<Generacion>();
        this.generaciones.add(new Generacion(200, 20));
        //System.out.println("Fueron exitosos: "+ this.generaciones.get(0).probarGen(this.terreno));
    }

    @Override
    public String toString() {
        return "Entorno{" + "generaciones=" + generaciones + '}';
    }
    
    public double createNewGeneration(){
        Generacion vieja = this.generaciones.get(this.generaciones.size()-1);
        Generacion nueva = this.generaciones.get(this.generaciones.size()-1).createNuevaGeneracion();
        nueva.cruzarIndividuos();
        nueva.Mutacion();
        nueva.setNumGen(this.generaciones.get(this.generaciones.size()-1).getNumGen()+1);
        nueva.setPuntuaciones(new ArrayList<>());
        this.generaciones.add(nueva);
        //System.out.println("Corrida------------------------------------");
        for (int i = 0; i < 1; i++) {
            nueva.probarGen(this.terreno);
            //Thread.sleep(100);
        }
        return vieja.calcVarianza();
        
    }
    
    
    public void algoritmoGenetico() throws InterruptedException{
        double pasado = 0.0;
        while(true) {
            double actual = createNewGeneration();
            //System.out.println(actual-pasado);
            if (actual-pasado >-0.3 && actual-pasado<0.3) {
                break;
            }
            pasado = actual;
            Thread.sleep(100);
        }
        
    }

}
