/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entorno;
import Model.Generacion;
import Model.Robot;
import Model.TipoTerreno;
import View.EntornoView;
import View.ExitososEnGeneracionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class ExitososEnGeneracionController implements ActionListener{
    private Generacion generacion;
    private int numOfgen;
    private TipoTerreno[][] espacios;
    private ArrayList<Integer> robotsExitosos;
    private ExitososEnGeneracionView view;
    private ArrayList<Generacion> generaciones;
    
    public ExitososEnGeneracionController(int numOfGen, TipoTerreno[][] espacios, ArrayList<Generacion> generaciones) {
        this.generacion = generaciones.get(numOfGen);
        this.numOfgen = numOfGen;
        this.espacios = espacios;
        this.generaciones = generaciones;
        this.robotsExitosos = new ArrayList<Integer>();
        setRobotsExitosos();
        this.view = new ExitososEnGeneracionView();
        assignActionListener();
        this.view._init_components(numOfGen, this.robotsExitosos);
        this.view.setVisible(true);
    }
    
    private void setRobotsExitosos(){
        for (int i = 0; i < generacion.getIndividuos().size(); i++) {
            if(generacion.getIndividuos().get(i).exitoso){
                robotsExitosos.add(i);
            }
        }
    }
    
    private void assignActionListener(){
        this.view.btnBuscarExitoso.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource().equals(this.view.btnBuscarExitoso)){
            int robotNum = robotsExitosos.get(this.view.cbRobotsExitosos.getSelectedIndex());
            
            Robot searchedRobot = this.generacion.getIndividuos().get(robotNum);
            //System.out.println("DASDA " + searchedRobot.toString());
            RobotController robotController = new RobotController(searchedRobot, numOfgen+1, robotNum+1, this.espacios, this.generaciones);
        }        
    }

}
