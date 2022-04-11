package quarto;

/**
 *  Interface d'une pièce du jeu de Quarto
 * @author pierrecharbit
 */
public interface Piece {

    /**
     * Indique si la pièce est pleine
     *
     * @return true si la pièce est creuse, false si elle est plein
     */
    public abstract boolean isCreux();

    /**
     * Indique la couleur de la pièce
     *
     * @return true si la pièce est blanche, false si elle est noire
     */
    public abstract boolean isBlanc();

    /**
     * Indique la taille de la pièce
     *
     * @return true si la pièce est grande, false si elle est petite
     */
    public abstract boolean isGrand();

    /**
     * Indique la forme de la pièce
     *
     * @return true si la pièce est ronde, false si elle est carrée
     */
    public abstract boolean isRond();

}
