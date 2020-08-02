/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author joalg
 */
public class Genes implements Serializable{
    private ArrayList<Integer> adn ;
    private int numOfBits;

    public Genes() {
        this.adn = new ArrayList<Integer>();
        this.numOfBits = 56;
        
        for (int i = 0; i < this.numOfBits; i++) {
            double prob = Math.random();
            if(prob > 0.5){
                adn.add(1);
            }
            else{
                adn.add(0);
            }
        }
    }   

    public ArrayList<Integer> getAdn() {
        return adn;
    }
    
    public Camara getTCamara(){
        int gen = getIntByByte(0);
        double normalized = (double)gen/(double)256;
        return new Camara(getTipoP(normalized));
    }
    
    public Motor getTMotor(){
        int gen = getIntByByte(1);
        double normalized = (double)gen/(double)256;
        return new Motor(getTipoP(normalized));
    }
    
    public Bateria getTBateria(){
        int gen = getIntByByte(2);
        double normalized = (double)gen/(double)256;
        return new Bateria(getTipoP(normalized));
    }
    public double getProb1(){
        return ((double)getIntByByte(3) * 100)/ (double)getCantProb();
    }
    public double getProb2(){
        return ((double)getIntByByte(4) * 100)/ (double)getCantProb();
    }
    public double getProb3(){
        return ((double)getIntByByte(5) * 100)/ (double)getCantProb();
    }
    public double getProb4(){
        return ((double)getIntByByte(6) * 100)/ (double)getCantProb();
    }
   
    public int getCantProb(){
        int res = 0;
        res += getIntByByte(3);
        res += getIntByByte(4);
        res += getIntByByte(5);
        res += getIntByByte(6);
        return res;
    }
    
    
    public int getTipoP(double n){
        if(n<0.33){
            return 1;
        }
        else if(n>=0.33 && n<=0.66){
            return 2;
        }
        else{
            return 3;
        }
    }
    
    public int getIntByByte(int nByte){
        int[] rango = getRangoByte(nByte);
        int res = 0;
            
        for (int i = rango[1]; i >= rango[0]; i--) {
            if(adn.get(i)==1){
                res += Math.pow(2,(i-rango[0]));
            }
           
        }
        return res;
    }
    
    
    public int[] getRangoByte(int nByte){
        int[] res = new int[2];
        res[0] = 8*nByte;
        res[1] = res[0]+7;
        return res;
    }
    
    public void cruce(Genes gen){
        
        Random r = new Random();
        int pos = r.nextInt(gen.numOfBits);
        
        System.out.println("Pos: " + pos);
        
        for (int i = 0; i <= pos; i++) {
            int temp = gen.adn.get(i);
            gen.adn.set(i, this.adn.get(i));
            this.adn.set(i, temp);
        }
    }
    
    public String adnToString(){
        String adnString = "";
        
        for (int i = 0; i < this.numOfBits; i++) {
            adnString += Integer.toString(this.adn.get(i)) + "-"; 
        }
        
        return adnString;
    }

    public int getNumOfBits() {
        return numOfBits;
    }

    public void setNumOfBits(int numOfBits) {
        this.numOfBits = numOfBits;
    }
       
}
