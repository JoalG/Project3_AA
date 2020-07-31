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
public class Entorno {
    public Terreno terreno;
    public Generacion generacion;

    public Entorno() {
        this.terreno = new Terreno(20);
        this.generacion = new Generacion(200, 4);
        
    }

}
