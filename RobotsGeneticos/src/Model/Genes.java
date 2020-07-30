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
public class Genes {
    private ArrayList<Integer> adn ;

    public Genes() {
        this.adn = new ArrayList<Integer>();
        int byteLength = 8;
        int numOfBytes = 3;
        
        for (int i = 0; i < byteLength*numOfBytes; i++) {
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
        int gen = getIntByByte(0, 7);
        double normalized = (double)gen/(double)256;
        return new Camara(getTipoP(normalized));
    }
    
    public Motor getTMotor(){
        int gen = getIntByByte(8, 15);
        double normalized = (double)gen/(double)256;
        return new Motor(getTipoP(normalized));
    }
    
    public Bateria getTBateria(){
        int gen = getIntByByte(16, 23);
        double normalized = (double)gen/(double)256;
        return new Bateria(getTipoP(normalized));
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
    
    public int getIntByByte(int ini, int fin){
        int res = 0;
        for (int i = ini; i <= fin; i++) {
            if(adn.get(i)==1){
                res += Math.pow(2,(i-ini));
            }
           
        }
        return res;
    }
    
    public void cruce(Genes gen){
        //AQUI JOAQUIN 
    }
       
}
