package test.java.fr.navflex.joueur;

import main.java.fr.navflex.gameplay.grille.Coordonnee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import main.java.fr.navflex.joueur.Score;
import main.java.fr.navflex.gameplay.navire.Navire;

import java.util.ArrayList;


public class ScoreTest {

    private Score score;
    private Navire navire;
    private Coordonnee coordonnee1, coordonnee2, coordonnee3, coordonnee4, coordonnee5;
    private ArrayList<Coordonnee> coordListe;

    // On setup le score à 0 et on créé le navire à tester
    @Before
    public void setUp() throws Exception {
        score = new Score(1);
        navire = new Navire(1);

        coordonnee1 = new Coordonnee(0,0);
        coordonnee2 = new Coordonnee(1,0);
        coordonnee3 = new Coordonnee(2,0);
        coordonnee4 = new Coordonnee(3,0);
        coordonnee5 = new Coordonnee(4,0);

        coordListe = new ArrayList<Coordonnee>();

        coordListe.add(coordonnee1);
        coordListe.add(coordonnee2);
        coordListe.add(coordonnee3);
        coordListe.add(coordonnee4);
        coordListe.add(coordonnee5);
        navire.setPosition(coordListe);
    }

    // On test le score du navire créé
    @Test
    public void testCalculValide() throws Exception {
        Assert.assertEquals(18.1, score.calculScoreNavire(navire), 2);
    }

    @Test
    public void testCalculInvalide() throws Exception {
        coordListe.remove(coordonnee5);
        Assert.assertNotEquals(18.1, score.calculScoreNavire(navire), 2);
    }

}
