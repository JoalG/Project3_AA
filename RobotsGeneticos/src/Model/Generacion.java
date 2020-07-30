/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author joalg
 */
public class Generacion {
    private ArrayList<Robot> individuos;
    private int indiceMutacion;

    public Generacion(int cant, int  indiceMutacion) {
        this.indiceMutacion = indiceMutacion;
        this.individuos = new ArrayList<Robot>();
        for (int i = 0; i < cant; i++) {
            this.individuos.add(new Robot());
        }
    }
    
    
    public void Mutacion(){
        for (int i = 0; i < indiceMutacion; i++) {
            Random r = new Random();
            int j = r.nextInt(individuos.size());
            int k = r.nextInt(individuos.get(0).genes.getNumOfBits());
            System.out.println("Se cambio el "+j+" "+k);
            if (individuos.get(j).genes.getAdn().get(k) == 1) {
                individuos.get(j).genes.getAdn().set(k, 0);
            }
            else{
                individuos.get(j).genes.getAdn().set(k, 1);
            }
     
        }
    }

   
    public void printGenesGen() {
        String res = "";
        for (Robot individuo : individuos) {
            res+=individuo.genes.adnToString() +"\n";
        }
        System.out.println(res);
    }
    
    
    
}
