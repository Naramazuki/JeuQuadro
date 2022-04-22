package quarto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.print.attribute.standard.JobOriginatingUserName;



public class Plateau {

    public Plateau() {
        System.out.println("plateau créé");
    }
    public static int menu() throws IOException{
        int menu=0;
        while(menu!=4){
            System.out.flush();
            System.out.println("Menu :\n1 Jouer contre un humain\n2 jouer contre un bot Bot\n3 regles du jeu\n4 fermer le jeu");
            Scanner sc= new Scanner(System.in);
            menu=sc.nextInt();
            switch (menu) {
                case 1:
                    partie(true);
                    break;
            
                case 2:
                    partie(false);
                    menu=menu();

                    break;
            
                case 3:
                    regle();
                    menu=menu();
                    break;
            
                default:
                    break;
            }
            sc.close();
        }

        return 4;
    }
    private static void regle() throws FileNotFoundException {
       

        File regle = new File("Regle2.txt");
       
        Scanner sc = new Scanner(regle);
            String ligne;
            try{
                ligne=sc.nextLine();
                while(ligne!=null){
                    System.out.println(ligne);
                    ligne=sc.nextLine();

                }
                

            }
            catch (Exception e) {
                System.out.println("fin des règles");
            }
            sc.close();
           
        }
        
         
        
        
    
    public static void affichage(Pieces[][] tab){

        for (int i = 0; i < 33; i++) {
            System.out.print("-");
            
            
        }
        for (int i = 0; i < 16; i++) {
            
            
        
        System.out.println("");
            switch (i) {
                case 2:
                    
                    for (int j = 0; j < 4; j++) {
                        if(tab[0][j]==null){
                            System.out.print("| ****  ");
                        }
                        else{
                        System.out.print("| "+tab[0][j].toString()+"  ");
                        }
                    }
                    System.out.print("|");

                    System.out.println("");
                    break;
                case 4:
                    for(int w=0; w<33; w++){
                        System.out.print("-");
                    }
                    System.out.println("");

                    break;
                case 6:
               
                    for (int j = 0; j < 4; j++) {
                        if(tab[1][j]==null){
                            System.out.print("| ****  ");
                        }
                        else{
                        System.out.print("| "+tab[1][j].toString()+"  ");
                        }
                    }
                    System.out.print("|");

                    System.out.println("");

                    break;
                case 8:
                    for(int w=0; w<33; w++){
                        System.out.print("-");
                    }
                    System.out.println("");

                    break;
                case 10:
                    for (int j = 0; j < 4; j++) {
                        if(tab[2][j]==null){
                            System.out.print("| ****  ");
                        }
                        else{
                        System.out.print("| "+tab[2][j].toString()+"  ");
                        }

                    }
                    System.out.print("|");

                    System.out.println("");

                    break;
                case 12:
                    for(int w=0; w<33; w++){
                        System.out.print("-");
                    }

                    System.out.println("");
                    break;
                case 14:
                    for (int j = 0; j < 4; j++) {
                        if(tab[3][j]==null){
                            System.out.print("| ****  ");
                        }
                        else{
                        System.out.print("| "+tab[3][j].toString()+"  ");
                        }
                    }
                    System.out.print("|");
                    System.out.println("");

                    break;

                    
                    
                default:
                    break;
            }
            System.out.print("|");

                for (int j= 0; j <=27; j++) {
                    System.out.print(" ");

                    switch (j) {
                        
                        case 27:
                            System.out.print("|");

                            break;
                        case 13:
                            System.out.print("|");
                            break;
                        case 6:
                            System.out.print("|");
                            break;
                        case 20:
                            System.out.print("|");
                            break;
                    
                        default:
                            break;
                    }
                
            }
            
        
        
    }
    System.out.println("");
    for (int z = 0; z < 33; z++) {
        System.out.print("-");
        
        
    }
    System.out.println("");
   
    
    } 

    public final static void clearConsole()  
    {  
        System.out.print("\033[H\033[2J");
    }  

    /**
     * deroulement de la partie 
     * @throws IOException */
    public static void partie(Boolean hum) throws IOException{
        Game jeu= new Game();
        System.out.println("Joueur 1 donnez votre prénom");
        Scanner sc=new Scanner(System.in);
        JoueurHumain j1 =new JoueurHumain(sc.next());
        

                                                
        Random rd= new Random();
        int rnd=rd.nextInt(2);
        int numeropiece;
        int i;
        int j;
        Pieces[][] lp= jeu.getBoard();
        if(!hum){
            System.out.println("donner nom ordinateur: ");
            JoueurOrdi j2 =new JoueurOrdi(sc.next());
            System.out.println("Donner niveau du bot: 1,2 ");
            int level=sc.nextInt();
            while(level<1 || level>2){
                System.out.println("Donner niveau du bot: 1,2 ");
                level=sc.nextInt();
            }
            j2.setLevel(level=sc.nextInt());
            System.out.println("efgh"+j2.getLevel());
            Joueur[] tab = new Joueur[2];
            tab[0]=j1;
            tab[1]=j2;   
            jeu.setIndexJoueur(rnd);
            jeu.setJoueurs(tab);
            
           
            
            
                jeu.JoueurCourant=jeu.Gamers[rnd];
                System.out.println(jeu.getJoueurCourant().getNom()+" commence");
                while(jeu.isWin()==0 && !jeu.getRestantes().isEmpty()){
                    
                    for (Pieces p : jeu.getRestantes()) {
                        System.out.print(p.toString());
                        System.out.print(" ");
                    }
                    System.out.println("");
                    System.out.println("L'autre joueur choisi la pièce");
                    System.out.println("choisi entre 0 et "+(jeu.getRestantes().size()-1));
                    if(jeu.getJoueurCourant()==j2){
                        numeropiece=sc.nextInt();
                        while(numeropiece<0 && numeropiece>jeu.getRestantes().size()){
                            System.out.println("choisi entre 0 et "+(jeu.getRestantes().size()-1));
                            numeropiece=sc.nextInt();
                        }
                        jeu.setCourante(jeu.getRestantes().get(numeropiece));
                        
                    }
                    else{

                       jeu.setCourante(j2.getNext(jeu));
                    }
                    
                    
                    // choix de la piece parmis les pieces restantes
                    clearConsole();
                    System.out.println("Joues la pièces: "+jeu.getCourante().toString());

                    Plateau.affichage(jeu.getBoard());  
                    if(jeu.getJoueurCourant()==j2){
                        System.out.println("le bot choisi ses positions");
                        int[] tab2=j2.getCoup(jeu);
                       
                        
                        jeu.joueCourante(tab2[0], tab2[1]);
                    }
                    else{

                        System.out.println("entrer une position disponible dans le plateau");     
                        i=sc.nextInt();
                        j=sc.nextInt();
                        while(i<0 || i>3 || j<0 || j>3 || lp[i][j]!=null){
                            System.out.println("entrer une position disponible dans le plateau");     
                            i=sc.nextInt();
                            j=sc.nextInt();
    
                        } 
                        jeu.joueCourante(i, j);
                    
                    }
                    
                    
                    
                    jeu.PiecesDispo.remove(jeu.getCourante()); 
                    // piece entrée dans la position demandée
                    clearConsole();
    
                    Plateau.affichage(jeu.getBoard()); 
                    // selection de la pièce  
                    if(jeu.isWin()!=0){
                        System.out.println("le Joueur "+jeu.JoueurCourant.getNom()+" a gagné");
                        System.exit(1);
                        sc.close();
    
    
                    }
    
                    jeu.switchJoueur();
                        
                    
                }
            }    
            
                if(jeu.getRestantes().isEmpty()){
                    System.out.println("Egalité");
                    System.exit(3);
                    sc.close();
    
                }
    
            
        
        else if(hum==true){

        System.out.println("Joueur 2 donnez votre prénom");
        JoueurHumain j2 =new JoueurHumain(sc.next());
        Joueur[] tab = new Joueur[2];
        tab[0]=j1;
        tab[1]=j2;   
        jeu.setIndexJoueur(1);
        jeu.setJoueurs(tab);
        
        
        
    
            jeu.JoueurCourant=jeu.Gamers[rnd];
            System.out.println(jeu.getJoueurCourant().getNom()+" commence");
            while(jeu.isWin()==0 && !jeu.getRestantes().isEmpty()){
                
                for (Pieces p : jeu.getRestantes()) {
                    System.out.print(p.toString());
                    System.out.print(" ");
                }
                System.out.println("");
                System.out.println("L'autre joueur choisi la pièce");
                System.out.println("choisi entre 0 et "+(jeu.getRestantes().size()-1));
                numeropiece=sc.nextInt();
                while(numeropiece<0 && numeropiece>jeu.getRestantes().size()){
                    System.out.println("choisi entre 0 et "+(jeu.getRestantes().size()-1));
                    numeropiece=sc.nextInt();
                }
                jeu.setCourante(jeu.getRestantes().get(numeropiece));
                // choix de la piece parmis les pieces restantes
                clearConsole();
                System.out.println("Joues la pièces: "+jeu.getCourante().toString());
                
                Plateau.affichage(jeu.getBoard());  
                System.out.println("entrer une position disponible dans le plateau");     
                    i=sc.nextInt();
                    j=sc.nextInt();
                while(i<0 || i>3 || j<0 || j>3 || lp[i][j]!=null){
                    System.out.println("entrer une position disponible dans le plateau");     
                    i=sc.nextInt();
                    j=sc.nextInt();

                } 
                
                jeu.joueCourante(i, j);
                jeu.PiecesDispo.remove(jeu.getCourante()); 
                // piece entrée dans la position demandée
                clearConsole();

                Plateau.affichage(jeu.getBoard()); 
                // selection de la pièce  
                if(jeu.isWin()!=0){
                    System.out.println("le Joueur "+jeu.JoueurCourant.getNom()+" a gagné");
                    System.exit(1);
                    sc.close();


                }

                jeu.switchJoueur();
                    
                
            }
        }    
          
        } 
    

    public static void main(String[] args) throws IOException  {
    
       
        menu();
        
        
    }
}
