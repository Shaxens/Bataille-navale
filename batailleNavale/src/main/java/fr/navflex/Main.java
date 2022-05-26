package fr.navflex;

import fr.navflex.controleur.JoueurControleur;
import fr.navflex.controleur.PartieControleur;
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
        PartieControleur partieControleur = new PartieControleur();
        partieControleur.initialiserPartie();

    }
}
