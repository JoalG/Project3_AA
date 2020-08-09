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
public class GenesMapper {
    public int CANT_COMP;
    public final int WIDTH_CUAD = 25;
    public final int HEIGHT_CUAD = 25;
    private JPanel panel;
    public JButton tableroVista[];
    private ArrayList<Integer> genes;
    
    private ImageIcon binarioUno;
    private ImageIcon binarioCero;
    
    javax.swing.border.Border borderDefault = UIManager.getBorder("Button.border");
    javax.swing.border.Border borderRed = BorderFactory.createLineBorder(Color.RED, 2);
    javax.swing.border.Border borderGreen = BorderFactory.createLineBorder(Color.GREEN, 2);

    public GenesMapper(JPanel panel, ArrayList<Integer> genes, int cantGenes) {
        this.panel = panel;
        this.CANT_COMP = cantGenes;
        loadImageIcons();
        generarTablero();
        agregarTableroVista();
        this.genes = genes;
        if(this.genes != null){
            actualizarTableroVista();
        }
    }
    
    
    
    private void generarTablero(){
        this.tableroVista = new JButton[CANT_COMP];
        
        for (int i = 0; i < CANT_COMP; i++) {
            this.tableroVista[i] = new JButton();
        }        
    }    

    private void agregarTableroVista(){
        panel.setLayout(null);
        panel.setSize(WIDTH_CUAD, HEIGHT_CUAD*CANT_COMP);        
        for (int i = 0; i < CANT_COMP; i++) {
            for (int j = 0; j < 1; j++) {
                JButton btnNew = this.tableroVista[i];
                btnNew.setBackground(Color.BLUE);
                btnNew.setSize(WIDTH_CUAD, HEIGHT_CUAD);
                btnNew.setVisible(true);
                //this.tableroVista[i][j] = btnNew;

                this.panel.add(this.tableroVista[i]);

                this.tableroVista[i].setBounds(HEIGHT_CUAD*j, HEIGHT_CUAD*i, WIDTH_CUAD, HEIGHT_CUAD);
                this.tableroVista[i].setOpaque(false);

                this.panel.validate();
                this.panel.repaint();
            }
        }
    }
    
    public void actualizarTableroVista(){
        for (int i = 0; i < CANT_COMP; i++) {
            for (int j = 0; j < CANT_COMP; j++) {
                if(CANT_COMP > 24){
                    tableroVista[i].setIcon(getIconByGen(genes.get(i+24)));
                }
                else{
                    tableroVista[i].setIcon(getIconByGen(genes.get(i)));
                }
            }
        }
    }
    
    public void loadImageIcons(){
        this.binarioUno = ImageConversion.getIconoNuevos("Images/binarioUno.png", WIDTH_CUAD, HEIGHT_CUAD);
        this.binarioCero = ImageConversion.getIconoNuevos("Images/binarioCero.png", WIDTH_CUAD, HEIGHT_CUAD);
    }
    
    
    public ImageIcon getIconByGen(int gen){
        if(gen == 1){
            return this.binarioUno;
        }
        return this.binarioCero;
    }

    public void pintarBorde(int mutuacion){
        System.out.println("MUTACION EN " + mutuacion);
        tableroVista[mutuacion].setBorder(borderGreen);
    }    
}
