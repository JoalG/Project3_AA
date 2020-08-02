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
                String str = this.espacios[i][j].toString();
                while(str.length()<10){
                    str+="+";
                }
                    
                row += "\t"+str;
                
            }
            res = res+row+"\n";
        }
        return res;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public TipoTerreno[][] getEspacios() {
        return espacios;
    }

    public void setEspacios(TipoTerreno[][] espacios) {
        this.espacios = espacios;
    }

    
    
    
}
