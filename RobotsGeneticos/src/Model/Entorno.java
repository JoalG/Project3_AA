/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    }

    @Override
    public String toString() {
        return "Entorno{" + "generaciones=" + generaciones + '}';
    }
    
    public void createNewGeneration(){
        Generacion nueva = this.generaciones.get(this.generaciones.size()-1).createNuevaGeneracion();
        nueva.Mutacion();
        nueva.cruzarIndividuos();
        this.generaciones.add(nueva);
        System.out.println("Corrida------------------------------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("Fueron exitosos: "+ nueva.probarGen(this.terreno));
            //Thread.sleep(100);
        }
    }
    

}
