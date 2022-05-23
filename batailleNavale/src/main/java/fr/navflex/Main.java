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
        Joueur joueur = new Joueur(1, "LourdJesus", 5,7);
        joueurControleur.addJoueur(joueur);

        /*Grille grille = joueur.getGrille();
        ArrayList<Navire> liste = joueur.getFlotte().getListeNavireAPlacer();
        Navire navire = joueur.getFlotte().getNavireById(3, liste);


        ArrayList<ArrayList<Coordonnee>> listePosisition = grille.getListePositionPossible(new Coordonnee(3,3), navire);
        ArrayList<Coordonnee> positionNavire = listePosisition.get(3);

        System.out.println(navire);
        grille.placerNavireSurGrille(positionNavire, navire);

        moniteur.afficherGrille(joueur);
        System.out.println(navire);*/

        joueurControleur.placerNavire(1);

    }
}
