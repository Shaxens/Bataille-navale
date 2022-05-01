package fr.navflex;

import fr.navflex.gameplay.grille.Coordonnee;
import fr.navflex.gameplay.navire.Flotte;
import fr.navflex.gameplay.navire.TypeNavire;
import fr.navflex.joueur.Joueur;


public class Main {
    public static void main(String[] args) {
        Flotte flotte = new Flotte(1);
        flotte.addNavire(1);
        flotte.addNavire(2);
        flotte.addNavire(3);
        flotte.addNavire(4);
        flotte.addNavire(5);
        flotte.addNavire(5);
        flotte.addNavire(1);
    }
}
