
package quarto;



/**
 * une interface pour les joueurs du Jeu Quarto
 * @author pierrecharbit
 */
public interface Joueur {

    
    /**
     * indique si le joueur est controlé par un humain ou par la machine
     * @return true si le joueur est un joueur humain, false s'il est controlé par l'ordinateur.
     */
    public boolean isHuman();

    
    /**
     * Indique le noom du joueur
     * @return le nom du joueur
     */
    public String getNom();

}
