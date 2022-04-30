package fr.navflex;

import fr.navflex.gameplay.navire.Flotte;
import fr.navflex.gameplay.navire.Navire;
import fr.navflex.joueur.Joueur;
import fr.navflex.joueur.Score;

public class Main {
    public static void main(String[] args) throws Exception {
        Joueur joueur = new Joueur(1, "LourdJesus", 10,10);
        System.out.println(joueur.getFlotte());
        System.out.println(joueur.getGrille().getGrille().length);
        joueur.placerPorteAvion();
    }
}
