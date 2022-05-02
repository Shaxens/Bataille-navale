package tests.fr.navflex.gameplay.navire;

import fr.navflex.gameplay.navire.Flotte;
import fr.navflex.gameplay.navire.Navire;
import fr.navflex.gameplay.navire.TypeNavire;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlotteTest {

    // Attributs
    private Navire navire;
    private Flotte flotte;

    // Setup des tests
    @Before
    public void setUp() {
        navire = new Navire(2, TypeNavire.Torpilleur, 3);
        flotte = new Flotte(1);
    }

    // Tests
    @Test
    public void ajoutPossibleNavireFlotte() {
        //flotte.ajoutPossibleById(navire.getId());
        Assert.assertTrue(flotte.ajoutPossibleById(navire.getId()));
    }

    @Test
    public void ajoutImpossibleNavireFlotte() {
        flotte.addNavire(navire.getId());
        Assert.assertFalse(flotte.ajoutPossibleById(navire.getId()));
    }


}
