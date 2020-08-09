/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utility.ImageConversion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author Joaquin
 */
public class TableroVista {
    public final int CANT_COMP = 20;
    public final int WIDTH_CUAD = 30;
    public final int HEIGHT_CUAD = 30;
    private JPanel panel;
    public JButton tableroVista[][];
    private TipoTerreno tableroLogico[][];
    
    private ImageIcon caminoNormal;
    private ImageIcon caminoModerado;
    private ImageIcon caminoDificil;
    private ImageIcon caminoBloqueado;
    
    javax.swing.border.Border borderDefault = UIManager.getBorder("Button.border");
    javax.swing.border.Border borderRed = BorderFactory.createLineBorder(Color.RED, 2);
    javax.swing.border.Border borderGreen = BorderFactory.createLineBorder(Color.GREEN, 2);

    public TableroVista(JPanel panel, TipoTerreno[][] tableroL) {
        this.panel = panel;
        setEspaciosIcons();
        generarTablero();
        agregarTableroVista();
        this.tableroLogico = tableroL;
        if(tableroLogico != null){
            actualizarTableroVista();
        }
    }
    
    
    
    private void generarTablero(){
        this.tableroVista = new JButton[CANT_COMP][CANT_COMP];
        
        for (int i = 0; i < CANT_COMP; i++) {
            for (int j = 0; j < CANT_COMP; j++) {
                crearTableroVista(i, j);
            }
        }        
    }    
    
    // Funciones tablero vista
    
    private void crearTableroVista(int i, int j){
        // coloca imagen a todos vacio
        this.tableroVista[i][j] = new JButton();
    }

    private void agregarTableroVista(){
        panel.setLayout(null);
        panel.setSize(WIDTH_CUAD*CANT_COMP, HEIGHT_CUAD*CANT_COMP);        
        for (int i = 0; i < CANT_COMP; i++) {
            for (int j = 0; j < CANT_COMP; j++) {
                JButton btnNew = this.tableroVista[i][j];
                btnNew.setBackground(Color.BLUE);
                btnNew.setSize(WIDTH_CUAD, HEIGHT_CUAD);
                btnNew.setVisible(true);
                //this.tableroVista[i][j] = btnNew;

                this.panel.add(this.tableroVista[i][j]);

                this.tableroVista[i][j].setBounds(HEIGHT_CUAD*j, HEIGHT_CUAD*i, WIDTH_CUAD, HEIGHT_CUAD);
                this.tableroVista[i][j].setOpaque(false);

                this.panel.validate();
                this.panel.repaint();
            }
        }
    }
    
    public void actualizarTableroVista(){
        for (int i = 0; i < CANT_COMP; i++) {
            for (int j = 0; j < CANT_COMP; j++) {
                tableroVista[i][j].setIcon(getIconByTipoTerreno(tableroLogico[i][j]));
            }
        }
    }

    private ImageIcon getIconByTipoTerreno(TipoTerreno tipo){
        switch(tipo){
            case NORMAL:
                return this.caminoNormal;
            case MODERADO:
                return this.caminoModerado;
            case DIFICIL:
                return this.caminoDificil;
            case BLOQUEADO:
                return this.caminoBloqueado;
        }
        return this.caminoNormal;
    }
    
    private void setEspaciosIcons(){
        this.caminoNormal = ImageConversion.getIconoNuevos("Images/caminoNormal.jpg", WIDTH_CUAD, HEIGHT_CUAD);
        this.caminoModerado = ImageConversion.getIconoNuevos("Images/caminoModerado.jpg", WIDTH_CUAD, HEIGHT_CUAD);
        this.caminoDificil = ImageConversion.getIconoNuevos("Images/caminoDificil.jpg", WIDTH_CUAD, HEIGHT_CUAD);
        this.caminoBloqueado = ImageConversion.getIconoNuevos("Images/caminoBloqueado.jpg", WIDTH_CUAD, HEIGHT_CUAD);
    }
    
    
//    public void pintarConexiones(){
//        for (int i = 0; i < CANT_COMP; i++) {
//            for (int j = 0; j < CANT_COMP; j++) {
//                Vertice verTmp = this.tableroLogico[i][j];
//                Componente tmp = this.tableroLogico[i][j].getComponent();
//                if(tmp.getType() != EnumTypeComponent.CONECTOR && tmp.getType() != EnumTypeComponent.VACIO){
//                    for(int a = 0; a < verTmp.getAristas().size(); a++){
//                        Componente destino = verTmp.getAristas().get(a).getVertice().getComponent();
//                        pintarConexionAux(tmp.getPosition(), destino.getPosition());
//                        
//                    }
//                }
//            }
//        }
//    }
    
    public void pintarConexionAux(Point origen, Point destino){
        Graphics g = this.panel.getGraphics();
        g.drawLine((WIDTH_CUAD*origen.y)+(WIDTH_CUAD/2), (WIDTH_CUAD*origen.x)+(WIDTH_CUAD/2), (WIDTH_CUAD*destino.y)+(WIDTH_CUAD/2), (WIDTH_CUAD*destino.x)+(WIDTH_CUAD/2));
    }
    
    public void borrarConexiones(){
        Graphics g = this.panel.getGraphics();
        g.drawRect(700, 700, 700, 700);
    }
    
    public void pintarBorde(ArrayList<int[]> puntos){
        for (int i = 0; i < puntos.size(); i++) {
            tableroVista[puntos.get(i)[0]][puntos.get(i)[1]].setBorder(borderRed);
        }
    }
}
