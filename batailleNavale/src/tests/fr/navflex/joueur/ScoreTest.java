package tests.fr.navflex.joueur;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

import fr.navflex.joueur.Score;
import fr.navflex.gameplay.navire.Navire;
import static fr.navflex.gameplay.navire.TypeNavire.*;


public class ScoreTest {

    private  double  porteAvions = 18.1;
    private Score score;
    private Navire navire;

    // On setup le score à 0 et on créer le navire à tester
    @Before
    public void setUp() throws Exception {
        score = new Score(0);
        navire = new Navire(1, PorteAvions, 5);
    }

    // On test le score du navire créé
    @Test
    public void testCalculInvalide() throws Exception {
        Assert.assertEquals(18.1, score.calculScoreNavire(navire));
        System.out.println("hello");
    }


}
