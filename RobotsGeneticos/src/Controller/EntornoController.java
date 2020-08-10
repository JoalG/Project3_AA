/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entorno;
import Model.Generacion;
import Model.Robot;
import View.EntornoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class EntornoController implements ActionListener{
    public Entorno entorno;
    public EntornoView entornoView;

    public EntornoController() {
        this.entorno  = new Entorno();
        this.entornoView = new EntornoView();
        this.assignActionListener();
    }
    
    private void assignActionListener(){
        this.entornoView.btnBuscarRobot.addActionListener(this);
        this.entornoView.btnExitososEnGeneracion.addActionListener(this);
        this.entornoView.btnMutacionesPorGeneracion.addActionListener(this);
    }
    
    public static void main(String[] args) throws InterruptedException {
        EntornoController entornoC = new EntornoController();
        System.out.println("WAITING...");
        entornoC.entorno.generaciones.get(0).probarGen(entornoC.entorno.terreno);
        entornoC.entorno.algoritmoGenetico();
        ArrayList<Integer> exitososGeneraciones = new ArrayList<Integer>();
        ArrayList<Integer> mutadosGeneraciones = new ArrayList<Integer>();
        entornoC.entorno.generaciones.forEach((generacion) -> {
            exitososGeneraciones.add(generacion.getNumOfRobotsExitosos());
            mutadosGeneraciones.add(generacion.getNumOfRobotsMutados());
        });
        
        entornoC.entornoView._init_components(entornoC.entorno.generaciones.size(), entornoC.entorno.generaciones.get(0).getIndividuos().size(), exitososGeneraciones, mutadosGeneraciones);
        entornoC.entornoView.setVisible(true);
        entornoC.mostrarMutaciones();
    }
    
    private void mostrarMutaciones(){
        for (int i = 0; i < this.entorno.generaciones.size(); i++) {
            for (int j = 0; j < this.entorno.generaciones.get(i).getIndividuos().size(); j++) {
                if(this.entorno.generaciones.get(i).getIndividuos().get(j).mutaciones.size() > 0){
                    System.out.println("-----muta----- GENERACION: " + (i+1) + " ROBOT: " + (j+1));                                   
                }
            }
            
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource().equals(this.entornoView.btnBuscarRobot)){
            int generacionNum = this.entornoView.cbGeneraciones.getSelectedIndex();
            int robotNum = this.entornoView.cbRobots.getSelectedIndex();
            
            Robot searchedRobot = this.entorno.generaciones.get(generacionNum).getIndividuos().get(robotNum);
            //System.out.println("DASDA " + searchedRobot.toString());
            RobotController robotController = new RobotController(searchedRobot, generacionNum+1, robotNum+1, this.entorno.terreno.getEspacios(), this.entorno.generaciones);
        }
        if(event.getSource().equals(this.entornoView.btnExitososEnGeneracion)){
            int generacionNum = this.entornoView.cbExitososPorGeneracion.getSelectedIndex();
            ExitososEnGeneracionController exEnGen = new ExitososEnGeneracionController(generacionNum, this.entorno.terreno.getEspacios(), this.entorno.generaciones); 
        }
        if(event.getSource().equals(this.entornoView.btnMutacionesPorGeneracion)){
            int generacionNum = this.entornoView.cbMutacionesPorGeneracion.getSelectedIndex();
            MutacionesEnGeneracionController mutEnGen = new MutacionesEnGeneracionController(generacionNum, this.entorno.terreno.getEspacios(), this.entorno.generaciones); 
        }
    }
}
