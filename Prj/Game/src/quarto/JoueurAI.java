package quarto;

/**
 * classe abstraite représentant un joueur controlé par l'ordinateur
 * Il possède deux méthodes getCoup(Partie) et getNext(Partie) qui retournent respectivement le prochain coup à jouer et la prochaine pièce a donner
 * Pour créer des Joueurs AI il faut donc créer des sous classes (non asbtraites) de cette classe.
 * 
 * @author pierrecharbit
 */
public interface JoueurAI extends Joueur {

    /**
     * Demande au joueur quelle case il choisit pour poser la pièce p
     *
     * @param partie La partie en cours
     * @return La case choisie sous la forme d'un tableau de taille 2 donnant
     * les coordonées
     */
    public abstract int[] getCoup(Game partie);

    /**
     * retourne le pièce que le joueurAI veut donner a son adversaire pour le prochain tour
     *
     * @param partie la partie en cours
     * @return La pièce sélectionnée
     */
    public abstract Piece getNext(Game partie);
}
