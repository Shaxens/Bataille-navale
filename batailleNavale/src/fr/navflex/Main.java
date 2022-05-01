package fr.navflex;

import fr.navflex.gameplay.grille.Coordonnee;
import fr.navflex.gameplay.navire.Flotte;
import fr.navflex.gameplay.navire.TypeNavire;
import fr.navflex.joueur.Joueur;


public class Main {
    public static void main(String[] args) {
        Flotte flotte = new Flotte(1);
        flotte.addNavire(TypeNavire.PorteAvions);
        flotte.addNavire(TypeNavire.PorteAvions);
        flotte.addNavire(TypeNavire.Croiseur);
        flotte.addNavire(TypeNavire.ContreTorpilleur);
        flotte.addNavire(TypeNavire.ContreTorpilleur);
        flotte.addNavire(TypeNavire.ContreTorpilleur);
        flotte.addNavire(TypeNavire.Torpilleur);
    }
}
