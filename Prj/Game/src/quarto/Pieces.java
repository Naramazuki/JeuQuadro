/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarto;

/**
 *
 * @author mivip
 */
public class Pieces implements Piece{
    boolean Creux;
    boolean Blanc;
    boolean Grand;
    boolean Rond;
    boolean Disponible=true;


    public Pieces(boolean C,boolean B, boolean G, boolean R){
        this.Creux=C;
        this.Blanc=B;
        this.Grand=G;
        this.Rond=R;
    }
    @Override
    public String toString() {
        String s="";
        for (int i = 0; i < 4; i++) {
            if(this.isCarac(i)){
                s+=1;
            }
            else{
                s+=0;
            }
            
        }
        return s;
    }
    
    @Override
    public boolean isCreux() {
        return this.Creux;
    }

    @Override
    public boolean isBlanc() {
        return this.Blanc;
    }

    @Override
    public boolean isGrand() {
        return this.Grand;
    }

    @Override
    public boolean isRond() {
        return this.Rond;
    }
    public boolean isCarac(int n){
        if (n==0){
            return this.isCreux();
        }
        else if(n==1){
            return this.isBlanc();
        }
        else if(n==2){
            return this.isGrand();
        }
        else if(n==3){
            return this.isRond();
        }
        return false;
    }
}