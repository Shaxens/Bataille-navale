package fr.navflex.modele.utils;

import fr.navflex.modele.grille.Coordonnee;
import fr.navflex.modele.grille.Grille;
import fr.navflex.modele.joueur.Joueur;
import fr.navflex.modele.navire.Navire;

import java.util.ArrayList;
import java.util.Random;

public class RandomizerTools {
    // ATTRIBUT
    private final Random random = new Random();

    //METHODES
    public Coordonnee creerCoordonneeRandom(Grille grille) // Genere une Coordonnee random forcement valide pour la grille donnee
    {
        int valeurXRandom = random.nextInt(grille.getAxeX());
        int valeurYRandom = random.nextInt(grille.getAxeY());
        return new Coordonnee(valeurXRandom,valeurYRandom);
    }

    public Coordonnee creerCoordonneeRandomSansRepetition(Grille grille, ArrayList<Coordonnee> listeCoordonneeInvalide) throws Exception {

        Coordonnee coordonneeGenere = creerCoordonneeRandom(grille);
        while (listeCoordonneeInvalide.indexOf(coordonneeGenere) >= 0)
        {
            listeCoordonneeInvalide.add(coordonneeGenere);
            if (listeCoordonneeInvalide.size() == grille.getAxeY() * grille.getAxeY())
            {
                throw new Exception("ERREUR : Impossible de creer une nouvelle Coordonnee, la liste des Coordonnee invalide est pleine.");
            }
            coordonneeGenere = creerCoordonneeRandom(grille);
        }
        return coordonneeGenere;
    }

    public ArrayList<Coordonnee> choixDansListeRandom(ArrayList<ArrayList<Coordonnee>> liste)
    {
        return liste.get(random.nextInt(liste.size()));
    }

    public boolean placementDuNavireRandom(Grille grille, Navire navire) throws Exception {
        ArrayList<Coordonnee> listeCoordonneeInvalide = new ArrayList<>();
        ArrayList<ArrayList<Coordonnee>> positionsValide = new ArrayList<>();
        while (positionsValide.isEmpty())
        {
            try
            {
                Coordonnee coordonnee = creerCoordonneeRandomSansRepetition(grille, listeCoordonneeInvalide);
                positionsValide = grille.getListePositionPossible(coordonnee, navire);
                if (positionsValide.isEmpty())
                {
                    listeCoordonneeInvalide.add(coordonnee);
                }
            } catch (Exception e)
            {
                throw new Exception(e.getMessage());
            }
        }
        grille.placerNavireSurGrille(choixDansListeRandom(positionsValide),navire);
        return true;
    }



    public boolean placementDesNaviresRandom(Joueur joueur) throws Exception {
        Grille grille = joueur.getGrille();
        ArrayList<Navire> listeNavireAPlacer = joueur.getFlotte().getListeNavireAPlacer();

        try {
            for (Navire navire : listeNavireAPlacer) {
                placementDuNavireRandom(grille, navire);
            }
        } catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
        return true;
    }


}
