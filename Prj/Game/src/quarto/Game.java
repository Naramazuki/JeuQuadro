/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mivip
 */
public class Game implements Partie{
    Joueur JoueurCourant;
    Joueur[] Gamers;
    int indexJoueur;
    List<Pieces>PiecesDispo;
    List<Pieces> PiecesPlace;
    Pieces PieceCourante;
    Pieces[][] Plateau;
    public  Game() {
        this.Plateau= new Pieces[4][4];
        this.PiecesDispo=new ArrayList<Pieces>();
        this.PiecesPlace= new ArrayList<Pieces>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int j2 = 0; j2 < 2; j2++) {
                    for (int k = 0; k < 2; k++) {
                        Pieces p = new Pieces(i==1, j==1, j2==1, k==1);
                        this.PiecesDispo.add(p);

                    }
                }
            }
        }
        
    }
    
    //set les joueurs de la partie
    @Override
    public void setJoueurs(Joueur[] tab) {
        this.Gamers=tab;
    }
    //renvoi le joueur courant
    @Override
    public Joueur getJoueurCourant() {
        return JoueurCourant;
    }
    public void setIndexJoueur(int indexJoueur) {
        this.indexJoueur = indexJoueur;
    }
    //change de joueur
    @Override
    public void switchJoueur() {
        this.JoueurCourant=this.Gamers[(this.indexJoueur+1)%2];
        this.indexJoueur=(this.indexJoueur+1)%2;
        System.out.println("Au tour de "+this.JoueurCourant.getNom());
    }
    //renvoi le plateau
    @Override
    public Pieces[][] getBoard() {
        return Plateau;
    }
    //renvoi la liste des pieces restantes
    @Override
    public List<Pieces> getRestantes() {
        return PiecesDispo;
    }
    //renvoi la piece actuellement selectionnee
    @Override
    public Pieces getCourante() {
        return PieceCourante;
    }
    //set la piece actuellement jouee
    @Override
    public void setCourante(Pieces p) {
        this.PieceCourante=p;
    }
    //joue la piece sur le plateau
    @Override
    public void joueCourante(int i, int j) {
        this.Plateau[i][j]=PieceCourante;
    }
   /**
     * evalue si la partie est gagnee et retourne 
     * 5 si la diagonale i=j est gagnante
     * -5 si l'autre diagonale est gagnante
     * 1,2,3,4 si respectivement la 1ere,2eme,3eme ou 4eme ligne est gagnante
     * -1,-2,-3,-4 si respectivement la 1ere,2eme,3eme ou 4eme colonne est gagnante
     * 0 si la partie n'est pas gagnee
     * la fonction retourne le premier entier qui correspond en cas de multiples conditions de victoire
     * @return  un entier permettant de savoir quelle ligne, colonne ou diagonale est gagnante
     */
    @Override
    public int isWin() {
        //test gagnant sur ligne
        for (int C=0;C<4;C++){
            for (int i=0;i<4;i++){
                if (!(Plateau[0][i]==null || Plateau[1][i]==null || Plateau[2][i]==null || Plateau[3][i]==null)){
                    if (Plateau[0][i].isCarac(C)==Plateau[1][i].isCarac(C) && Plateau[1][i].isCarac(C)==Plateau[2][i].isCarac(C) && Plateau[2][i].isCarac(C)==Plateau[3][i].isCarac(C)){
                        return i+1;
                    }
                }
                
            }
        }
        //test gagnant sur colonne
        for (int C=0;C<4;C++){
            for (int j=0;j<4;j++){
                if (!(Plateau[j][0]==null || Plateau[j][1]==null || Plateau[j][2]==null || Plateau[j][3]==null)){
                    if (Plateau[j][0].isCarac(C)==Plateau[j][1].isCarac(C) && Plateau[j][1].isCarac(C)==Plateau[j][2].isCarac(C) && Plateau[j][2].isCarac(C)==Plateau[j][3].isCarac(C)){
                        return -j-1;
                    }
                }
                
            }
        }
        //test gagnant sur diagonale
        for (int C=0;C<4;C++){
            if (!(Plateau[0][0]==null || Plateau[1][1]==null || Plateau[2][2]==null || Plateau[3][3]==null)){
                if (Plateau[0][0].isCarac(C)==Plateau[1][1].isCarac(C) && Plateau[1][1].isCarac(C)==Plateau[2][2].isCarac(C) && Plateau[2][2].isCarac(C)==Plateau[3][3].isCarac(C)){
                    return 5;
                }
            }
            
        }
        //test gagnant sur diagonale inverse
        for (int C=0;C<4;C++){
            if (!(Plateau[3][0]==null || Plateau[2][1]==null || Plateau[1][2]==null || Plateau[0][3]==null)){
                if (Plateau[3][0].isCarac(C)==Plateau[2][1].isCarac(C) && Plateau[2][1].isCarac(C)==Plateau[1][2].isCarac(C) && Plateau[1][2].isCarac(C)==Plateau[0][3].isCarac(C)){
                    return -5;
                }
            }            
            
        }
        //si personne ne gagne
        return 0;
    }   
}