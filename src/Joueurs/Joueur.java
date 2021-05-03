package Joueurs;

import Exceptions.Coordonnees.*;
import Jeu.IPiece;
import Pièces.Coordonnee;

import java.util.LinkedList;
import java.util.Locale;

public class Joueur implements Jeu.IJoueur {
    private final LinkedList<IPiece> listePieces;
    private final String nomJoueur  ;

    public Joueur(String couleur, String nomJoueur){
        listePieces = new LinkedList<>();
        this.nomJoueur = nomJoueur;
        if(couleur.equals("blanc")){
            listePieces.add(IPiece.getPiece('r', new Coordonnee(2,4), couleur));
            listePieces.add(IPiece.getPiece('t', new Coordonnee(1,1), couleur));
        }
        else if (couleur.equals("noir")){
            listePieces.add(IPiece.getPiece('r', new Coordonnee(0,4), couleur));
        }
    }

    public void dessinerPositions(char[][] Plateau){
        for(IPiece p : listePieces)
            Plateau[p.getCoord().getLigne()][p.getCoord().getColonne()] = p.dessiner();
    }

    public boolean deplacerPiece(Coordonnee coordInit, Coordonnee coordArr) throws CoupHorsZoneDepException {
        int pieceJouee = this.detientPiece(coordInit);
        return listePieces.get(pieceJouee).move(coordArr);
    }

    public int detientPiece(Coordonnee coord) {
        for(IPiece p : listePieces){
            if(p.getCoord().equals(coord))
                return listePieces.indexOf(p);
        }
        return -1;
    }

    @Override
    public String toString() {
        return nomJoueur.toUpperCase(Locale.ROOT);
    }

    private void listerCoupsPossibles(char[][] Plateau, Coordonnee coordInit){
        // Implémentation à préparer pour l'IA
    }

}
