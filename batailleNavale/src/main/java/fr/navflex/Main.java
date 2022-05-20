package fr.navflex;

import fr.navflex.modele.joueur.Joueur;


public class Main
{
    public static void main(String[] args) throws Exception
    {

        Joueur joueur = new Joueur(1, "LourdJesus", 10, 10);
        joueur.toString();
        joueur.saisirPositionDuNavire(5);
    }
}
