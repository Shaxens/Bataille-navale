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
        Joueur joueur = new Joueur(1, "LourdJesus", 6,6);
        joueurControleur.addJoueur(joueur);

        Grille grille = joueur.getGrille();
        randomizer.placementDesNaviresRandom(joueur);

        joueurControleur.getAffichage().afficherGrille(joueur);


    }
}
