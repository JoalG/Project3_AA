/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entorno;
import Model.Robot;
import View.EntornoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }
    
    public static void main(String[] args) {
        EntornoController entornoC = new EntornoController();
        System.out.println("WAITING...");
        for (int i = 0; i < 10; i++) {
            entornoC.entorno.createNewGeneration();
        }
        entornoC.entornoView._init_components(entornoC.entorno.generaciones.size(), entornoC.entorno.generaciones.get(0).getIndividuos().size());
        entornoC.entornoView.setVisible(true);
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
    }
}
