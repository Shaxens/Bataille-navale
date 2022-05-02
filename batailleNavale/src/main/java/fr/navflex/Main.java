package main.java.fr.navflex;

import main.java.fr.navflex.joueur.Joueur;


public class Main
{
    public static void main(String[] args) throws Exception
    {

        Joueur joueur = new Joueur(1, "LourdJesus", 10, 10);
        joueur.toString();
        joueur.saisirPositionDuNavire(5);
    }
}
