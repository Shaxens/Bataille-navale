package fr.navflex;

import fr.navflex.controleur.PartieControleur;
import fr.navflex.modele.partie.Partie;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        PartieControleur partieControleur = new PartieControleur();
        Partie partie = partieControleur.configurerPartie();

    }
}
