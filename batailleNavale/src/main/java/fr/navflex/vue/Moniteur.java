package fr.navflex.vue;

import fr.navflex.modele.grille.Grille;
import fr.navflex.modele.joueur.Joueur;
import fr.navflex.modele.navire.Navire;

import java.util.ArrayList;

public class Moniteur {
    public void afficherListeNavire(ArrayList<Navire> listeNavire)
    {
        for (Navire navire : listeNavire)
        {
            System.out.println(navire);
        }
    }

    public void afficherGrille(Joueur joueur)
    {
        // METHODES
        Grille grille = joueur.getGrille();
        StringBuilder colonne = new StringBuilder().append("   ");
        for (int i = 0; i < grille.getAxeY(); i++) {
            colonne.append(i).append("__");
        }
        colonne.delete((grille.getAxeY()*3)+1, ((grille.getAxeY()*3)+3));
        System.out.println(colonne);

        for (int i = 0; i < grille.getAxeX(); i++)
        {
            StringBuilder ligne = new StringBuilder();
            ligne.append(i).append("| ");
            for (int j = 0; j < grille.getAxeY(); j++) {
                ligne.append(grille.getGrille()[i][j]).append("  ");
            }
            System.out.println(ligne);
        }
        System.out.println(" [ Grille de " + joueur.getNom() + " ]");
    }
}
