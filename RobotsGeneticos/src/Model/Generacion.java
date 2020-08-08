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
    
    public Generacion(int cant, int  indiceMutacion,boolean empty) {
        this.indiceMutacion = indiceMutacion;
        this.individuos = new ArrayList<Robot>();
    }
    
    
    public void Mutacion(){
        for (int i = 0; i < indiceMutacion; i++) {
            Random r = new Random();
            int j = r.nextInt(individuos.size());
            int k = r.nextInt(individuos.get(0).genes.getNumOfBits());
            //System.out.println("Se cambio el "+j+" "+k);
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

    @Override
    public String toString() {
        return "Generacion{" + "individuos=" + individuos + ", indiceMutacion=" + indiceMutacion + '}';
    }
    
    public int probarGen(Terreno terreno){
        
        int existosos=0;
        for (int i = 0; i < this.individuos.size(); i++) {
            this.individuos.get(i).exitoso = false;
            
            this.individuos.get(i).realizarRecorrido(terreno);
            if(this.individuos.get(i).exitoso){
                existosos++;
            }
        }
        return existosos;
        
    }
    

    public ArrayList<Double> calcPuntuaciones(){
        int total = 0;
        for (int i = 0; i < this.individuos.size(); i++) {
            this.individuos.get(i).calcPuntuacion();
            total += this.individuos.get(i).puntuacion;
            //System.out.println(total);
        }
        ArrayList<Double> probabilidades = new ArrayList<>();
        
        for (int i = 0; i < this.individuos.size(); i++) {
            
            double calificacion = ((double)this.individuos.get(i).puntuacion*100)/(double)total;
            //System.out.println(calificacion);
            probabilidades.add(calificacion);
        }
        return probabilidades;

    }
    
    
    public Generacion createNuevaGeneracion(){
        Generacion nueva = new Generacion(this.individuos.size(), this.indiceMutacion, true);
        ArrayList<Double> puntuaciones = calcPuntuaciones();
//        for (int i = 0; i < puntuaciones.size(); i++) {
//            System.out.println(puntuaciones.get(i));
//        }

        ArrayList<Robot> individuosACruzar = new ArrayList<>();
        Random ran = new Random();
        for (int i = 0; i < individuos.size(); i++) {
           double val = ran.nextDouble()*100;
           individuosACruzar.add(individuos.get(getIndexRandom(puntuaciones, val)));
           
        }
        for (int i = 0; i < individuosACruzar.size(); i++) {
            Robot nuevoRobot = (Robot) CloneClass.deepCopy(individuosACruzar.get(i));
            nuevoRobot.bateria = nuevoRobot.genes.getTBateria();
            nueva.getIndividuos().add(nuevoRobot);
        }
        
        return nueva;
    }
    
    public int getIndexRandom(ArrayList<Double> probabilidades, double ran){
        //System.out.println("jdsnjsdnf: "+ran);
        double min = 0;
        double max =  0;
        for (int i = 0; i < probabilidades.size(); i++) {
            max += probabilidades.get(i);
            if( min< ran && ran<= max){
                //System.out.println(i);
                return i;
            }
            min+=probabilidades.get(i);
        }
        System.out.println("llegue");
        return -1;
    }

    public ArrayList<Robot> getIndividuos() {
        return individuos;
    }

    public void setIndividuos(ArrayList<Robot> individuos) {
        this.individuos = individuos;
    }

    public int getIndiceMutacion() {
        return indiceMutacion;
    }

    public void setIndiceMutacion(int indiceMutacion) {
        this.indiceMutacion = indiceMutacion;
    }
    
    
    public void cruzarIndividuos(){
        for (int i = 0; i < individuos.size(); i = i+2) {
            individuos.get(i).cruce(individuos.get(i+1));
            individuos.get(i).setHardwareByGenes();
            individuos.get(i+1).setHardwareByGenes();
        }
        
    }
    
    
}
