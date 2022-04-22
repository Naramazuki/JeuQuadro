/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarto;

import java.util.Random;

/**
 *
 * @author mivip
 */
public class JoueurOrdi implements JoueurAI{
    boolean Humain=false;
    String nom;
    private int level;

    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return this.level;
    }

    public JoueurOrdi() {
    }

    public JoueurOrdi(String nom) {
        this.nom = nom;
    }
    
    @Override
    public int[] getCoup(Game partie) {
        int[] coord=new int[2];
        Pieces[][] tab=partie.getBoard();
        if(getLevel()==2){
            Random rd= new Random();
            
            int j=rd.nextInt(4)-1;
            int i=rd.nextInt(4)-1;
            while(tab[i][j]!=null){
                j=rd.nextInt(4)-1;
                i=rd.nextInt(4)-1;
            }
            
                coord[0]=i;
                coord[1]=j;
                return coord;
        }


        
        else{
            
        for (int j=0;j<4;j++){
            for (int i=0;i<4;i++){
                if (tab[i][j]==null){
                    coord[0]=i;
                    coord[1]=j;
                    return coord;
                }
            }
        }
        }
        
        return coord;
    }

    @Override
    public Pieces getNext(Game partie) {
        if(getLevel()==2){
            Random rd= new Random();
            return partie.PiecesDispo.get(rd.nextInt(partie.PiecesDispo.size()-1));
        }
        return partie.PiecesDispo.get(0);
    }

    @Override
    public boolean isHuman() {
        return false;
    }

    @Override
    public String getNom() {
        return this.nom;
    }
    
}
