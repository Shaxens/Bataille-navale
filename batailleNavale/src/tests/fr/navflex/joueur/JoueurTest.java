package tests.fr.navflex.joueur;

import fr.navflex.gameplay.grille.Coordonnee;
import fr.navflex.gameplay.grille.Grille;
import fr.navflex.gameplay.navire.Flotte;
import fr.navflex.gameplay.navire.Navire;
import fr.navflex.gameplay.navire.TypeNavire;
import fr.navflex.joueur.Joueur;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JoueurTest {

    private Joueur joueur;
    private Flotte flotte;
    private Navire navire;
    private Coordonnee coordonnee;
    private Grille grille;

    @Before
    public void setUp() throws Exception {
        joueur = new Joueur(1, "Goldorak", 2, 20);
        grille = new Grille(5, 18);
        navire = new Navire(1, TypeNavire.PorteAvions, 5);
        flotte = new Flotte(1);
        coordonnee = new Coordonnee();
    }

    @Test
    public void string() throws Exception {
        joueur.toString();
    }

    @Test(expected = Exception.class)
    public void positionNavireCorrect() throws Exception {
        try {
            joueur = new Joueur(1, "Jesus", 0,18);
        } catch (Exception e) {
            Assert.assertEquals("La grille doit être au minimum de 20 cases", e.getMessage());
            throw e;
        }
    }

    /*@Test
    public void positionNavireIncorrect() throws Exception {
        try {
            Joueur.saisirPositionDuNavire(navire.getId());
        } catch (Exception e) {
            throw e;
        }
    }*/
}
