package fr.navflex;

import fr.navflex.controleur.JoueurControleur;
import fr.navflex.modele.grille.Coordonnee;
import fr.navflex.modele.grille.Grille;
import fr.navflex.modele.joueur.Joueur;
import fr.navflex.modele.navire.Navire;
import fr.navflex.vue.Moniteur;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Moniteur moniteur = new Moniteur();
        JoueurControleur joueurControleur = new JoueurControleur();
        Joueur joueur = new Joueur(1, "LourdJesus", 7,7);
        joueurControleur.addJoueur(joueur);

        Grille grille = joueur.getGrille();
        ArrayList<Navire> liste = joueur.getFlotte().getListeNavireAPlacer();

        joueurControleur.selectionnerNavireAPlacer(1);

        moniteur.afficherGrille(joueur);
    }
}
