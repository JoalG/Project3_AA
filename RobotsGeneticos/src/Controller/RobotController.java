/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Robot;
import Model.TableroVista;
import Model.TipoTerreno;
import View.RobotInfo;

/**
 *
 * @author Joaquin
 */
public class RobotController {
    public Robot robot;
    public RobotInfo robotInfo;
    public TableroVista tableroVista;

    public RobotController(Robot robot, int generacionNum, int robotNum, TipoTerreno[][] espacios) {
        this.robot = robot;
        this.robotInfo = new RobotInfo();
        this.tableroVista = new TableroVista(this.robotInfo.panelTerreno, espacios);
        this.tableroVista.pintarBorde(this.robot.recorrido);
        this.robotInfo._init_components(robot, generacionNum, robotNum);
        this.robotInfo.setVisible(true);
    }
}
