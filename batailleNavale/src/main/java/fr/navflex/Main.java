package fr.navflex;

import fr.navflex.controleur.JoueurControleur;
import fr.navflex.modele.grille.Grille;
import fr.navflex.modele.joueur.Joueur;
import fr.navflex.modele.navire.Navire;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        JoueurControleur joueurControleur = new JoueurControleur();
        Joueur joueur = new Joueur(1, "LourdJesus", 7,7);
        joueurControleur.addJoueur(joueur);

        joueurControleur.selectionnerNavireAPlacer(1);
        joueurControleur.getAffichage().afficherGrille(joueurControleur.selectionJoueur(1));

    }
}
