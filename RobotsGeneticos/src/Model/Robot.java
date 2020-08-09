/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static com.oracle.jrockit.jfr.DataType.INTEGER;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author joalg
 */
public class Robot implements Serializable{
    
    public Camara camara;
    public Motor motor;
    public Bateria bateria;
    public Genes genes;
    public CadenaDeMarkov cadena;
    public ArrayList<int[]> recorrido;
    public boolean exitoso;
    public int[] posActual;
    public int puntuacion;
    public int[] padre1;
    public int[] padre2;
    public int numeroRobot;

    

    public Robot(int numerRobot) {
        this.genes = new Genes();
        this.camara = genes.getTCamara();
        this.motor = genes.getTMotor();
        this.bateria = genes.getTBateria();
        this.cadena = new CadenaDeMarkov(this.genes);
        this.recorrido = new ArrayList<>();
        this.posActual = new int[2];
        this.posActual[0] = 19;
        this.posActual[1] = 0;
        this.exitoso = false;
        this.puntuacion = 0;
        this.padre1 = null;
        this.padre2 = null;
        this.numeroRobot = numerRobot;
    }
    
    public void cruce(Robot robot){
        this.genes.cruce(robot.genes);
    }

    @Override
    public String toString() {
        
        String robotS = "Camara: " + Integer.toString(this.camara.getTipo()) + "\n";
        robotS += "Motor: " + Integer.toString(this.motor.getTipo()) + "\n";
        robotS += "Bateria: " + Integer.toString(this.bateria.getTipo()) + "\n";
        robotS += this.genes.adnToString();
        
        return  robotS; 
    }
    
    
    public void calcPuntuacion(){ //Se debe hacer esta funcion , ahorito no es la correcta
        int puntajeExitoso = 70;
        int puntajeBateria = (int) this.bateria.getBatteryPuntaje(10);
        int puntajeMotor = (int) this.motor.getMotorPuntaje(10);
        int puntajeCamara = (int) this.camara.getCamaraPuntaje(10);        
        int puntajesHardware = puntajeBateria + puntajeMotor + puntajeCamara;

        if(this.exitoso){
            this.puntuacion = puntajeExitoso + puntajesHardware;
        }
        else{
            int x2 = 0;
            int y2 = 19;
            double posActualDistance = Math.hypot(x2 - posActual[0], y2 - posActual[1]);
            double maxDistance = Math.hypot(x2 - 19, y2 - 0);
            this.puntuacion = (int)(puntajeExitoso * (1-(posActualDistance/maxDistance))) + puntajesHardware;
            //System.out.println(posActual[0] + "/" + posActual[1] + "-----------------------------------------------------------------------" + this.puntuacion);            
        }  
    }
    
    public int getActualAdaptabilidad(){
        int puntajeExitoso = 70;
        int puntajeBateria = (int) this.bateria.getBatteryPuntaje(10);
        int puntajeMotor = (int) this.motor.getMotorPuntaje(10);
        int puntajeCamara = (int) this.camara.getCamaraPuntaje(10);        
        int puntajesHardware = puntajeBateria + puntajeMotor + puntajeCamara;

        if(this.exitoso){
            return puntajeExitoso + puntajesHardware;
        }
        else{
            int x2 = 0;
            int y2 = 19;
            double posActualDistance = Math.hypot(x2 - posActual[0], y2 - posActual[1]);
            double maxDistance = Math.hypot(x2 - 19, y2 - 0);
            return (int)(puntajeExitoso * (1-(posActualDistance/maxDistance))) + puntajesHardware;
        }      
    }
    
    
    
    public void realizarRecorrido(Terreno terreno){
        this.recorrido = new ArrayList<>();
        this.posActual[0] = 19;
        this.posActual[1] = 0;
        this.bateria.cargarBateria();
        while(this.bateria.getCarga()>0){
            if(moverPosicion(terreno)){
                break;
            }
           
        }
    }
    
    public void setHardwareByGenes(){
        this.camara = genes.getTCamara();
        this.motor = genes.getTMotor();
        this.bateria = genes.getTBateria();
        this.cadena = new CadenaDeMarkov(this.genes);
        this.recorrido = new ArrayList<>();

    }
    
    
    
    
    public boolean moverPosicion(Terreno terreno){
        calcBetterOptions(posActual, terreno);
        TipoEstado estado = cadena.obtenerEstado();
        //System.out.println("Seleccione la: " + estado);
        int[] posTemp = new int[2];
        posTemp[0] = posActual[0];
        posTemp[1] = posActual[1];
        switch(estado){
            case ARRIBA:
                if(posTemp[0]>0){
                    posTemp[0] = posTemp[0]-1; 
                }
                break;
            case ABAJO:
                if(posTemp[0]<19){
                    posTemp[0] = posTemp[0]+1; 
                }                
                break;
            case IZQUIERDA:
                 if(posTemp[1] > 0){
                    posTemp[1] = posTemp[1]-1; 
                }     
                break;
            case DERECHA:
                if(posTemp[1] < 19){
                    posTemp[1] = posTemp[1]+1; 
                }    
                break;
        }
        
        TipoTerreno casilla = terreno.getEspacios()[posActual[0]][posActual[1]];
        TipoTerreno casillaSig = terreno.getEspacios()[posTemp[0]][posTemp[1]];
//        System.out.println("Estaba en: "+posActual[0]+","+posActual[1]);
        int consumo = 1;
        if(motor.getTiposDeTerreno().indexOf(casilla) != -1 && casillaSig != TipoTerreno.BLOQUEADO ){
//            if(motor.getTiposDeTerreno().indexOf(casilla) != -1){
//                System.out.println("jnwjcdjn");
//            }
            this.posActual = posTemp;
            consumo =  calcConsumo(casilla);
            
        }
        this.recorrido.add(posActual);
        
        if(posActual[0]==0 && posActual[1]==19){
            this.exitoso = true;
            return true;
        }
        
        this.bateria.ReducirCarga(consumo);
        //System.out.println("Me reduzo :'v"+this.bateria.getCarga());//// Si no me muevo deberia terminar 
        


        return false;
    }
    
    
    public int calcConsumo(TipoTerreno casilla){
        int res = this.camara.getConsumo();
        res += this.motor.calConsumo(casilla);
        return res;
    }
    
    
    public void calcBetterOptions(int[] pos, Terreno terreno){
        int[] res = new int[4];
        // pos 0-3: ARRIBA, ABAJO , IZQ , DER  
        TipoEstado[] posEstados = new TipoEstado[4];
        posEstados[0] = TipoEstado.ARRIBA;
        posEstados[1] = TipoEstado.ABAJO;
        posEstados[2] = TipoEstado.IZQUIERDA;
        posEstados[3] = TipoEstado.DERECHA; 
        
        calcPuntuaciones(camara.getTipo(), res ,pos , terreno);
        
        ArrayList<Integer> disponibles = new ArrayList<>();
        
        for (int i = 0; i < res.length; i++) {
            if (res[i] != Integer.MIN_VALUE) {
                disponibles.add(i);
            }
        }
//        
//        for (int i = 0; i < res.length; i++) {
//            if(res[i] == Integer.MIN_VALUE){
//                posEstados[i] = TipoEstado.getByPosition(getRandomElement(disponibles));
//            }
//        }
        
        sortResultados(res, posEstados);
        
        cadena.setEstado1(posEstados[0]);
        cadena.setEstado2(posEstados[1]);
        cadena.setEstado3(posEstados[2]);
        cadena.setEstado4(posEstados[3]);
        
//        for (int i = 0; i < res.length; i++) {
//            System.out.println("Con : "+res[i]+" El "+i+" es: "+ posEstados[i]);
//        }
        
    }
    
    public int getRandomElement(ArrayList<Integer> list) 
    { 
        Random rand = new Random(); 
        return list.get(rand.nextInt(list.size())); 
    }
    
    public void sortResultados(int[] res, TipoEstado[] posEstados) 
    { 
        int n = res.length; 
        for (int i = 1; i < n; ++i) { 
            int key = res[i];
            TipoEstado keyEstado = posEstados[i];
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && res[j] < key) { 
                res[j + 1] = res[j]; 
                posEstados[j + 1] = posEstados[j];
                
                j = j - 1; 
            } 
            res[j + 1] = key;
            posEstados[j + 1] = keyEstado;
        } 
    }
    
    public int evaluarCasilla(int[] pos, Terreno terreno){
        
        TipoTerreno casilla = terreno.getEspacios()[pos[0]][pos[1]];
        
        
        if(casilla == TipoTerreno.BLOQUEADO){
            return -120;
        }
        else if(motor.getTiposDeTerreno().indexOf(casilla) == -1){
            return -60;
        }
        else if(casilla == TipoTerreno.NORMAL){
            return 60;
        }
        else if(casilla == TipoTerreno.MODERADO){
            return 60;
        }
        else if(casilla == TipoTerreno.DIFICIL){
            return 60;
        }

        return 0;

        

    }
    
    
    public int evaluarDireccion(int profundidad , int res, int[] pos, Terreno terreno, ArrayList<int[]> visited ){
        res += evaluarCasilla(pos, terreno);
        if(profundidad == 1){
            return res ;
        }
        
        int[] parciales = new int[4];
        
        for (int i = 0; i < 4; i++) {
            int[] posTemp = new int[2];
            posTemp[0] = pos[0];
            posTemp[1] = pos[1];
            
            switch(i){
                case 0:
                    if(posTemp[0]>0){
                        posTemp[0] = posTemp[0]-1;
                        
                    }
                    

                    break;
                case 1:
                    if(posTemp[0]<19){
                        posTemp[0] = posTemp[0]+1;
                    }
                    
                    break;
                case 2:
                    if(posTemp[1]>0){
                        posTemp[1] = posTemp[1]-1;
                    }
                    
                    
                    break;
                case 3:
                    if(posTemp[1]<19){
                        posTemp[1] = posTemp[1]+1;
                    }
                    
                    break;
                
            }
            
            if(pos[0] == posTemp[0] && pos[1]==posTemp[1]){
                parciales[i] = Integer.MIN_VALUE;
                continue;
            }
            
            boolean visitado = false;
            for (int j = 0; j < visited.size(); j++) {
                if(visited.get(j)[0]==posTemp[0] && visited.get(j)[1]==posTemp[1]){
                    visitado = true;
                }
            }            
            if(!visitado){                
                ArrayList<int[]> visitedTemp = (ArrayList<int[]>) visited.clone();
                visitedTemp.add(posTemp);         
                parciales[i] = evaluarDireccion( profundidad-1 , 0,  posTemp,  terreno,visitedTemp);  
            }
            else{
                parciales[i] = Integer.MIN_VALUE;
            }


        }
        
        boolean visitadoRecorrido = false;
        for (int j = 0; j < this.recorrido.size(); j++) {
            if(this.recorrido.get(j)[0]==pos[0] && this.recorrido.get(j)[1]==pos[1]){
                visitadoRecorrido = true;
            }
        }
        if (visitadoRecorrido) {
            res = res -60;
        }
        
        return res+Math.max(parciales[0],Math.max(parciales[1],Math.max(parciales[2],parciales[3])) );
        
    }
    
    
    public void calcPuntuaciones(int profundidad , int[] res, int[] pos, Terreno terreno){
          
        for (int i = 0; i < 4; i++) {
            int[] posTemp = new int[2];
            posTemp[0] = pos[0];
            posTemp[1] = pos[1];
            ArrayList<int[]> visited = new ArrayList<int[]>();
            visited.add(pos);
            switch(i){
                //ARRIBA, ABAJO , IZQ , DER 
                
                case 0:
                    if(posTemp[0]>0){
                        posTemp[0] = posTemp[0]-1;
                        res[i] = evaluarDireccion(profundidad, 0, posTemp, terreno,visited)+40;
                    }
                    else{
                        res[i] = Integer.MIN_VALUE;
                    }

                    break;
                case 1:
                    if(posTemp[0]<19){
                        posTemp[0] = posTemp[0]+1;
                        res[i] = evaluarDireccion(profundidad, 0, posTemp, terreno, visited);
                    }
                    else{
                        
                        res[i] = Integer.MIN_VALUE;
                    }
                    break;
                case 2:
                    if(posTemp[1]>0){
                        posTemp[1] = posTemp[1]-1;
                        res[i] = evaluarDireccion(profundidad, 0, posTemp, terreno, visited);
                    }
                    else{
                        res[i] = Integer.MIN_VALUE;
                    }
                    
                    break;
                case 3:
                    if(posTemp[1]<19){
                        posTemp[1] = posTemp[1]+1;
                        res[i] = evaluarDireccion(profundidad, 0, posTemp, terreno,visited)+40;
                    }
                    else{
                        res[i] = Integer.MIN_VALUE;
                    }
                    
                    break;
            }
            
        }
        
        
    }


    

 
}
