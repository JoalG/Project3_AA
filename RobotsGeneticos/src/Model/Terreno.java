/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author joalg
 */
public class Terreno {
    private int dimension;
    private TipoTerreno[][] espacios;

    public  Terreno(int dimension) {
        this.dimension = dimension;
        this.espacios = new TipoTerreno[20][20];
      
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                this.espacios[i][j] = TipoTerreno.randomChoice();
            }
        }
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.dimension; i++) {
            String row = "";
            for (int j = 0; j < this.dimension; j++) {
                
                row += "\t"+this.espacios[i][j]+"\t";
                
            }
            res = res+row+"\n";
        }
        return res;
    }

    
    
    
}
