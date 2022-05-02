package test.java.fr.navflex.gameplay.navire;

import main.java.fr.navflex.gameplay.grille.Coordonnee;
import main.java.fr.navflex.gameplay.navire.Navire;
import main.java.fr.navflex.gameplay.navire.TypeNavire;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class NavireTest {
    // Attribut
    private Navire navire;

    // Setup des tests
    @Before
    public void setUp()
    {
        this.navire = new Navire(1);
        // Pour la suite du test ce navire aura donc l'id 1, type porteAvions et longeur 5
    }

    @Test
    public void testConstructeurParId()
    {
        // Si le constructeur a bien fonctionner, ces test doivent etre true :
        Assert.assertEquals(navire.getId(), 1);
        Assert.assertEquals(navire.getType(), TypeNavire.PorteAvions);

        Navire navireTest = new Navire(5);
        // Ce test doit etre false
        Assert.assertNotEquals(navireTest.getType(),TypeNavire.PorteAvions);
    }

    @Test
    public void testSetPointsVie()
    {
        for (int i = 0; i < navire.getLongueur(); i++) // Boucle 5 fois du coup
        {
            navire.getPosition().add(new Coordonnee());
        }
        navire.setPointsVie();
        // On test si les points de vie sont bien égaux à 5 :
        Assert.assertEquals(navire.getPointsVie(), 5);
    }
}
