/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Generacion;
import Model.GenesMapper;
import Model.Robot;
import Model.TableroVista;
import Model.TipoTerreno;
import View.RobotInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class RobotController implements ActionListener{
    public Robot robot;
    public RobotInfo robotInfo;
    public TableroVista tableroVista;
    public GenesMapper hardwareGenesMapper;
    public GenesMapper MovementGenesMapper;
    public ArrayList<Generacion> generaciones;
    private TipoTerreno[][] espacios;

    public RobotController(Robot robot, int generacionNum, int robotNum, TipoTerreno[][] espacios, ArrayList<Generacion> generaciones) {
        this.robot = robot;
        this.generaciones = generaciones;
        this.espacios = espacios;
        this.robotInfo = new RobotInfo();
        this.tableroVista = new TableroVista(this.robotInfo.panelTerreno, espacios);
        this.tableroVista.pintarBorde(this.robot.recorrido);
        this.hardwareGenesMapper = new GenesMapper(this.robotInfo.panelHardwareGenes, this.robot.genes.getAdn(), 24);
        this.MovementGenesMapper = new GenesMapper(this.robotInfo.panelMovementGenes, this.robot.genes.getAdn(), 32);
        this.robotInfo._init_components(robot, generacionNum, robotNum);
        showMutuaciones();
        this.robotInfo.setVisible(true);
        assignActionListener();
    }
    
    public void assignActionListener(){
        this.robotInfo.btnAntepasado1.addActionListener(this);
        this.robotInfo.btnAntepasado2.addActionListener(this);
    }
    
    private void showMutuaciones(){
        for (int i = 0; i < this.robot.mutaciones.size(); i++) {
            int mutuacion = this.robot.mutaciones.get(i);
            if(mutuacion >= 24){
                this.MovementGenesMapper.pintarBorde(mutuacion-24);
            }
            else{
                this.hardwareGenesMapper.pintarBorde(mutuacion);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
 
        if(event.getSource().equals(this.robotInfo.btnAntepasado1)){
            if(robot.padre1 != null){
                int generacionNum = robot.padre1[0];
                int robotNum = robot.padre1[1];
                System.out.println("PADRE 1: " + robot.padre1[0] + "/" + robot.padre1[1]);
                Robot searchedRobot = this.generaciones.get(generacionNum).getIndividuos().get(robotNum);
                RobotController robotController = new RobotController(searchedRobot, generacionNum+1, robotNum+1, this.espacios, this.generaciones);                
            }
        }
        if(event.getSource().equals(this.robotInfo.btnAntepasado2)){
            if(robot.padre2 != null){
                int generacionNum = robot.padre2[0];
                int robotNum = robot.padre2[1];

                Robot searchedRobot = this.generaciones.get(generacionNum).getIndividuos().get(robotNum);
                RobotController robotController = new RobotController(searchedRobot, generacionNum+1, robotNum+1, this.espacios, this.generaciones);                
            }            
        }

    }
}
