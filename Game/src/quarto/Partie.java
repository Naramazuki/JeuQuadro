
package quarto;


import java.util.List;

/**
 *  Interface pour une partie de Quarto
 * @author pierrecharbit
 */
public interface Partie {


    /** fixe les joueurs de la partie
    * @param tab un tableau de Joueurs de taille 2 
    */
    void setJoueurs(Joueur[] tab);
    
    /**
     * 
     * @return le Joueur courant
     */
    Joueur getJoueurCourant();
    
    /**
     * remplace le joueur courant par son adversaire
     */
    void switchJoueur();

    /**
     * 
     * @return un tableau de Piece modélisant le plateau
    * Si une case est vide, l'entrée correspondante sera égale à null
     */
    Pieces[][] getBoard();
    
    /** Donne les pièces encore disponibles
     * @return  une liste contenant la liste des pièces non encore jouées. Cette liste ne contient pas non plus la piece courante à jouer
     */
    List<Pieces> getRestantes();  

    

    /**
     * 
     * @return la piece devant être placée par le joueur courant
     */
    Pieces getCourante();
    
    /**
     * fixe la piece devant être jouée au procahin placement
     * @param p une piece
     */
    void setCourante(Pieces p);
    
    /**
     * place la piece courante à l'emplacement de coordonnées i,j sur le plateau
     * @param i l'abscisse de la case destination
     * @param j l'ordonnée de la case destination
     */
    void joueCourante(int i, int j);

    
    /**
     * evalue si la partie est gagnee et retourne 
     * 5 si la diagonale i=j est gagnante
     * -5 si l'autre diagonale est gagnante
     * 1,2,3,4 si respectivement la 1ere,2eme,3eme ou 4eme ligne est gagnante
     * -1,-2,-3,-4 si respectivement la 1ere,2eme,3eme ou 4eme colonne est gagnante
     * 0 si la parite n'est pas gagnee
     * la fonction retourne le premier entier qui correspond en cas de multiples conditions de victoire
     * @return  un entier permettant de savoir quelle ligne, colonne ou diagonale est gagnante
     */
    int isWin();
    

}
