/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarto;

/**
 *
 * @author mivip
 */
public class JoueurHumain implements Joueur{
    boolean Humain=true;
    String nom;

    public JoueurHumain() {
    }

    public JoueurHumain(String n){
        this.nom=n;
    }
    
    @Override
    public boolean isHuman() {
        return true;
    }

    @Override
    public String getNom() {
        return this.nom;
        }
    
}
