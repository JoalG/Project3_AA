/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import javax.swing.ImageIcon;

/**
 *
 * @author Joaquin
 */
public class ImageConversion {
    
    public static ImageIcon getIconoNuevos (String string, int width, int height){
        ImageIcon imagen = new ImageIcon(ImageConversion.class.getClassLoader().getResource(string));
        ImageIcon img = new ImageIcon(imagen.getImage().getScaledInstance(width, height, width));
        return img;
    }
    
   // public static ImageIcon getIcono(EnumTypeComponent tipo)
}
