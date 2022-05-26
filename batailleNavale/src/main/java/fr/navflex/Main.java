package fr.navflex;

import fr.navflex.controleur.JoueurControleur;
import fr.navflex.modele.grille.Coordonnee;
import fr.navflex.modele.grille.Grille;
import fr.navflex.modele.joueur.Joueur;
import fr.navflex.modele.navire.Navire;
import fr.navflex.modele.utils.RandomizerTools;
import fr.navflex.vue.Moniteur;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Moniteur moniteur = new Moniteur();
        JoueurControleur joueurControleur = new JoueurControleur();
        RandomizerTools randomizer = new RandomizerTools();
        Joueur joueur1 = new Joueur(1, "LourdJesus", 6,6);
        Joueur joueur2 = new Joueur(2, "InfameJuda", 6, 6);
        joueurControleur.addJoueur(joueur1);
        joueurControleur.addJoueur(joueur2);

        Grille grille = joueur1.getGrille();

        randomizer.placementDesNaviresRandom(joueur1);
        randomizer.placementDesNaviresRandom(joueur2);

    }
}
