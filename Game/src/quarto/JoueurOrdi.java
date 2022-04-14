/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarto;

/**
 *
 * @author mivip
 */
public class JoueurOrdi implements JoueurAI{
    boolean Humain=false;
    String nom;

    public JoueurOrdi() {
    }

    public JoueurOrdi(String nom) {
        this.nom = nom;
    }
    
    @Override
    public int[] getCoup(Game partie) {
        int[] coord=new int[2];
        Pieces[][] tab=partie.getBoard();
        for (int j=0;j<4;j++){
            for (int i=0;i<4;i++){
                if (tab[i][j]==null){
                    coord[0]=i;
                    coord[1]=j;
                    return coord;
                }
            }
        }
        return coord;
    }

    @Override
    public Pieces getNext(Game partie) {
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
