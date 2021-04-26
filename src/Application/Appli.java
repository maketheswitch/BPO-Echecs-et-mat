package Application;

import Jeu.Jeu;
import Joueurs.Joueur;
import Jeu.Échiquier;
import Pièces.Coordonnee;
import java.util.Scanner;

public class Appli {

    public void creationCoordCoup(){
        String coup = saisie();
        Coordonnee coordInit = new Coordonnee((Character.getNumericValue(Character.toLowerCase(coup.charAt(0))) - 10), (Character.getNumericValue(coup.charAt(1)) - 1));
        Coordonnee coordArr = new Coordonnee((Character.getNumericValue(Character.toLowerCase(coup.charAt(2))) - 10), (Character.getNumericValue(coup.charAt(3)) - 1));
    }

    public static void affichage(String output){
        System.out.println(output);
    }

    public static String saisie(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        return input;
    }

    public static void main(String[] args) {
        Joueur Blanc = new Joueur("blanc");
        Joueur Noir = new Joueur("noir");
        Échiquier Echiquier = new Échiquier();

        Jeu.Partie(Blanc, Noir, Echiquier);
    }

}