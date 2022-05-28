package fr.navflex.vue;

import fr.navflex.modele.grille.Grille;
import fr.navflex.modele.joueur.Joueur;
import fr.navflex.modele.navire.Navire;

import java.util.ArrayList;

public class Moniteur {
    public void creerMessage(String message)
    {
        System.out.println(message);
    }

    public void afficherListeNavire(ArrayList<Navire> listeNavire)
    {
        for (Navire navire : listeNavire)
        {
            System.out.println(navire);
        }
    }

    public void afficherListeObjetSansId(ArrayList liste)
    {
        int compteur = 0;
        for (Object objet : liste) {
            compteur += 1;
            System.out.println("[" + compteur + "] -> " + objet);
        }
    }

    public void afficherGrille(Joueur joueur)
    {
        // METHODES
        Grille grille = joueur.getGrille();
        StringBuilder ligne = new StringBuilder().append("   ");
        for (int i = 0; i < grille.getAxeY(); i++) {
            ligne.append(i).append("__");
        }
        ligne.delete((grille.getAxeY()*3)+1, ((grille.getAxeY()*3)+3));
        ligne.append(" Y");
        System.out.println("\n| Grille de " + joueur.getNom() + " |");
        System.out.println(ligne);

        for (int i = 0; i < grille.getAxeX(); i++)
        {
            StringBuilder colonne = new StringBuilder();
            colonne.append(i).append("| ");
            for (int j = 0; j < grille.getAxeY(); j++) {
                colonne.append(grille.getGrille()[i][j]).append("  ");
            }
            System.out.println(colonne);
        }
        System.out.println("X");
    }


}
