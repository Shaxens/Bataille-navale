package fr.navflex.modele;

import fr.navflex.modele.grille.Coordonnee;
import fr.navflex.modele.grille.Grille;
import fr.navflex.modele.navire.Flotte;
import fr.navflex.modele.navire.Navire;
import fr.navflex.modele.joueur.Joueur;

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
        Grille grille = new Grille(2,20);
        joueur = new Joueur(1, "Goldorak", grille);
    }

    @Test
    public void string() throws Exception {
        joueur.toString();
    }

    @Test
    public void testConstructeur()
    {
        // On test si la flotte du joueur se créé bien avec le meme id que lui dans le constructeur
        Assert.assertEquals(joueur.getId(),joueur.getFlotte().getId());
    }

    /*@Test
    public void positionNavireCorrect() throws Exception {
        joueur.saisirPositionDuNavire(navire.getId());
    }*/

    /*@Test
    public void positionNavireIncorrect() throws Exception {
        try {
            Joueur.saisirPositionDuNavire(navire.getId());
        } catch (Exception e) {
            throw e;
        }
    }*/
}
