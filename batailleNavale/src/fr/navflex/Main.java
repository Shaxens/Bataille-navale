package fr.navflex;

import fr.navflex.gameplay.grille.Coordonnee;
import fr.navflex.gameplay.grille.Grille;
import fr.navflex.gameplay.navire.Flotte;
import fr.navflex.gameplay.navire.TypeNavire;
import fr.navflex.joueur.Joueur;


public class Main
{
    public static void main(String[] args) throws Exception
    {

        Joueur joueur = new Joueur(1, "LourdJesus", 10, 10);
        joueur.toString();
        joueur.saisirPositionDuNavire(5);
    }
}
