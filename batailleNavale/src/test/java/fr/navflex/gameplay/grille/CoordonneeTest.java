package test.java.fr.navflex.gameplay.grille;

import main.java.fr.navflex.gameplay.grille.Coordonnee;
import main.java.fr.navflex.gameplay.grille.Grille;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoordonneeTest {

    private Grille grille;
    private Coordonnee coordonnee;

    @Before
    public void setUp() throws Exception {
        grille = new Grille(5,18);
    }

    @Test
    public void coordonneeCorrects() {
        coordonnee = new Coordonnee(2,8);
        coordonnee.saisirCoordonnee();
    }


    @Test
    public void saisieCoordCorrect() throws Exception {
        try {
            coordonnee.saisirCoordonnee();
        } catch (Exception e) {
            Assert.assertEquals("Erreur : " + e, e.getMessage());
            throw e;
        }

    }
}
