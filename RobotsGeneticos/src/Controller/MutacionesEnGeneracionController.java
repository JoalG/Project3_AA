/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Generacion;
import Model.Robot;
import Model.TipoTerreno;
import View.ExitososEnGeneracionView;
import View.MutacionesEnGeneracionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class MutacionesEnGeneracionController implements ActionListener{
    private Generacion generacion;
    private int numOfgen;
    private TipoTerreno[][] espacios;
    private ArrayList<Integer> robotsMutados;
    private MutacionesEnGeneracionView view;
    private ArrayList<Generacion> generaciones;
    
    public MutacionesEnGeneracionController(int numOfGen, TipoTerreno[][] espacios, ArrayList<Generacion> generaciones) {
        this.generacion = generaciones.get(numOfGen);
        this.numOfgen = numOfGen;
        this.espacios = espacios;
        this.generaciones = generaciones;
        this.robotsMutados = new ArrayList<Integer>();
        setRobotsMutados();
        this.view = new MutacionesEnGeneracionView();
        assignActionListener();
        this.view._init_components(numOfGen, this.robotsMutados);
        this.view.setVisible(true);
    }
    
    private void setRobotsMutados(){
        for (int i = 0; i < generacion.getIndividuos().size(); i++) {
            if(generacion.getIndividuos().get(i).mutaciones.size() > 0){
                robotsMutados.add(i);
            }
        }
    }
    
    private void assignActionListener(){
        this.view.btnMutacion.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource().equals(this.view.btnMutacion)){
            int robotNum = robotsMutados.get(this.view.cbMutaciones.getSelectedIndex());
            
            Robot searchedRobot = this.generacion.getIndividuos().get(robotNum);
            //System.out.println("DASDA " + searchedRobot.toString());
            RobotController robotController = new RobotController(searchedRobot, numOfgen+1, robotNum+1, this.espacios, this.generaciones);
        }        
    }
    
}
