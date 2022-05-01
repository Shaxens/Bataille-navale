package tests.fr.navflex.joueur;

import fr.navflex.joueur.Joueur;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JoueurTest {

    private Joueur joueur;

    @Before
    public void setUp() throws Exception {
        joueur = new Joueur(1, "Goldorak", 2, 20);
    }

    @Test
    public void string() throws Exception {
        joueur.toString();
    }

    @Test(expected = Exception.class)
    public void mauvaisBuildJoueur() throws Exception {
        try {
            joueur = new Joueur(1, "Jesus", 0,18);
        } catch (Exception e) {
            Assert.assertEquals("La grille doit être au minimum de 20 cases", e.getMessage());
            throw e;
        }
    }
}
