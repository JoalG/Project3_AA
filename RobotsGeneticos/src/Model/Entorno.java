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
        this.generaciones.add(new Generacion(200, 4));
    }

    @Override
    public String toString() {
        return "Entorno{" + "generaciones=" + generaciones + '}';
    }
    

}
